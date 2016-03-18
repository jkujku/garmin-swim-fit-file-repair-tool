package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Part;
 
@WebServlet("/FitToCSVServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class FitToCSVServlet extends HttpServlet {

	/**
     * Name of the directory where uploaded files will be saved, relative to
     * the web application directory.
     */
    private static final String SAVE_DIR = "uploadFiles";
    
	private static final long serialVersionUID = -8411169728084686143L;

     
	public void processRequest(HttpServletRequest request, HttpServletResponse response){
		// gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;
        // Message
        String result = "";
         
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
         
        try {
			for (Part part : request.getParts()) {
			    String fileName = extractFileName(part);
			    if(fileName != null && !fileName.isEmpty()){
			    	String uniqueFileName = generateUniqueFileName(fileName);
			    	part.write(savePath + File.separator + uniqueFileName);
			    	result += " Uploaded: " + uniqueFileName;
			    }else{
			    	result += " Not uploaded";
			    }
			}
		} catch (ServletException e) {
			result = e.getMessage();
			e.printStackTrace();
		} catch (IOException e) {
			result = e.getMessage();
			e.printStackTrace();
		}

        response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response){
		String result = "GET requests not supported.";
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
    	processRequest(request, response);
    }
 
    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
	}

	private String generateUniqueFileName(String originalFilename) {
		return System.currentTimeMillis() + "-" + originalFilename;
	}
    
}