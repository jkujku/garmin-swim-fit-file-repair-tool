package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;

import com.garmin.fit.Decode;
import com.garmin.fit.FitRuntimeException;
import com.garmin.fit.MesgDefinitionListener;
import com.garmin.fit.MesgListener;
import com.garmin.fit.csv.MesgCSVWriter;
import com.garmin.fit.csv.MesgFilter;

@WebServlet("/FitToCSVServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
// 50MB
public class FitToCSVServlet extends HttpServlet {

	/**
	 * Name of the directory where uploaded files will be saved, relative to the
	 * web application directory.
	 */
	private static final String SAVE_DIR = "uploadFiles";

	private static final long serialVersionUID = -8411169728084686143L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String result = "GET requests not supported.";
		writeMessage(response, result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		processRequest(request, response);
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response) {
		String savePath = getSavePath(request.getServletContext().getRealPath(""));
		String result = "";

		try {
			for (Part part : request.getParts()) {
				String fitFileName = extractFileName(part);
				checkFileName(fitFileName, "fit");

				// save
				String uniqueFileName = generateUniqueFileName(fitFileName);
				String fitFilePath = savePath + File.separator + uniqueFileName;
				part.write(fitFilePath);

				// convert
				String csvFilePath = generateCsvFilePath(fitFilePath);
				convert(fitFilePath, csvFilePath);

				// send back				
				redirectToFile(csvFilePath, request, response);
			}
		} catch (ServletException e) {
			result = e.getMessage();
		} catch (IOException e) {
			result = e.getMessage();
		}
		
		if(!result.isEmpty()){
			writeMessage(response, result);
		}		
	}
	
    protected void redirectToFile(String filePath, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/csv");
        response.setHeader("Content-disposition","attachment; filename=" + getOriginalFileName(filePath));

        File file = new File(filePath);
        OutputStream out = response.getOutputStream();
        FileInputStream in = new FileInputStream(file);
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) > 0){
           out.write(buffer, 0, length);
        }
        in.close();
        out.flush();
   }

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				String fileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
				return fileName.isEmpty() ? null : fileName;
			}
		}
		return null;
	}
	
	private void checkFileName(String fileName, String expectedExtension) throws IOException{
		checkFileName(fileName);
		if (expectedExtension != null && !fileName.endsWith("." + expectedExtension)) {
			throw new IOException("File extension is not ." + expectedExtension);
		}
	}
	
	private void checkFileName(String fileName) throws IOException{
		if(fileName == null || fileName.isEmpty()){
			throw new IOException("File name is empty.");
		}
	}

	private String generateUniqueFileName(String originalFilename) {
		return System.currentTimeMillis() + "-" + originalFilename;
	}
	
	private String getOriginalFileName(String internalFilePath) throws IOException {
		checkFileName(internalFilePath, "csv");
		File file = new File(internalFilePath);
		String originalName = file.getName().split("-")[0];
		return originalName + ".csv";
	}
	
	private String generateCsvFilePath(String fitFilePath) throws IOException{
		checkFileName(fitFilePath, "fit");
		String csvFilePath = fitFilePath.substring(0, fitFilePath.length()-4) + ".csv";
		return csvFilePath;
	}

	private String getSavePath(String webAppPath) {
		String savePath = webAppPath + File.separator + SAVE_DIR;
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		return savePath;
	}

	private void writeMessage(HttpServletResponse response, String message) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		try {
			response.getWriter().write(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void convert(String fitFilePath, String csvFilePath) throws IOException{
		// Taken from garmin CSVTool.main()
        MesgCSVWriter mesgWriter = new MesgCSVWriter(csvFilePath);
        FileInputStream fileInputStream = new FileInputStream(fitFilePath);
        Decode decode = new Decode();
        decode.showInvalidValues();
        ArrayList<String> mesgDefinitionsToOutput = new ArrayList<String>();
        ArrayList<String> dataMessagesToOutput = new ArrayList<String>();

        MesgFilter mesgFilter = new MesgFilter();
        mesgFilter.setMesgDefinitionsToOutput(mesgDefinitionsToOutput);
        mesgFilter.setDataMessagesToOutput(dataMessagesToOutput);
        mesgFilter.addListener((MesgDefinitionListener) mesgWriter);
        mesgFilter.addListener((MesgListener) mesgWriter);

        decode.addListener((MesgDefinitionListener) mesgFilter);
        decode.addListener((MesgListener) mesgFilter);
        		
        while (decode.bytesAvailable((InputStream) fileInputStream)) {
           try {
              decode.read((InputStream) fileInputStream);
              decode.nextFile(); 
           } catch (FitRuntimeException e) {
        	  System.out.print("fit error");
              if (decode.getInvalidFileDataSize()) {
                 decode.nextFile();
                 continue;
              }
           }
        }
        mesgWriter.close();
        fileInputStream.close();
	}
	
}