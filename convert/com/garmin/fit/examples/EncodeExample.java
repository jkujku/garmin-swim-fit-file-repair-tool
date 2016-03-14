////////////////////////////////////////////////////////////////////////////////
// The following FIT Protocol software provided may be used with FIT protocol
// devices only and remains the copyrighted property of Dynastream Innovations Inc.
// The software is being provided on an "as-is" basis and as an accommodation,
// and therefore all warranties, representations, or guarantees of any kind
// (whether express, implied or statutory) including, without limitation,
// warranties of merchantability, non-infringement, or fitness for a particular
// purpose, are specifically disclaimed.
//
// Copyright 2016 Dynastream Innovations Inc.
////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 16.50Release
// Tag = production-akw-16.50.00-0-gdbb4e14
////////////////////////////////////////////////////////////////////////////////



package com.garmin.fit.examples;

import java.util.Calendar;
import java.util.Random;

import com.garmin.fit.*;

/**
 * Example demonstrating how to encode FIT files.
 * <p>
 * The example creates 2 sample FIT files.
 */
public class EncodeExample {
   public static void main(String[] args) {
      encodeExampleSettings();
      encodeExampleMonitoring();
   }

   private static void encodeExampleSettings() {
      System.out.printf("FIT Encode Example Application - Protocol %d.%d Profile %.2f %s\n", Fit.PROTOCOL_VERSION_MAJOR, Fit.PROTOCOL_VERSION_MINOR, Fit.PROFILE_VERSION / 100.0, Fit.PROFILE_TYPE);

      FileEncoder encode;

      try {
         encode = new FileEncoder(new java.io.File("ExampleSettings.fit"));
      } catch (FitRuntimeException e) {
         System.err.println("Error opening file ExampleSettings.fit");
         return;
      }

      //Generate FileIdMessage
      FileIdMesg fileIdMesg = new FileIdMesg(); // Every FIT file MUST contain a 'File ID' message as the first message
      fileIdMesg.setManufacturer(Manufacturer.DYNASTREAM);
      fileIdMesg.setType(File.SETTINGS);
      fileIdMesg.setProduct(1000);
      fileIdMesg.setSerialNumber(12345L);

      encode.write(fileIdMesg); // Encode the FileIDMesg

      //Generate UserProfileMesg
      UserProfileMesg userProfileMesg = new UserProfileMesg();
      userProfileMesg.setGender(Gender.FEMALE);
      userProfileMesg.setWeight(63.1F);
      userProfileMesg.setAge((short)99);
      userProfileMesg.setFriendlyName("TestUser");

      encode.write(userProfileMesg); // Encode the UserProfileMesg

      try {
         encode.close();
      } catch(FitRuntimeException e) {
         System.err.println("Error closing encode.");
         return;
      }

      System.out.println("Encoded FIT file ExampleSettings.fit.");
   }

   private static void encodeExampleMonitoring() {
      System.out.println("Encode Example Monitoring FIT File");

      // Dates to be used to generate some sample data
      java.util.Calendar systemStartTime = Calendar.getInstance();
      java.util.Calendar systemCurrentTime = Calendar.getInstance();

      FileEncoder encode;

      try {
         encode = new FileEncoder(new java.io.File("ExampleMonitoring.fit"));
      } catch (FitRuntimeException e) {
         System.err.println("Error opening file ExampleMonitoring.fit");
         return;
      }

      FileIdMesg fileIdMesg = new FileIdMesg(); // Every FIT file MUST contain a 'File ID' message as the first message
      fileIdMesg.setTimeCreated(new DateTime(systemStartTime.getTime()));
      fileIdMesg.setType(File.MONITORING_B);
      fileIdMesg.setManufacturer(Manufacturer.DYNASTREAM);
      fileIdMesg.setProduct(1001);
      fileIdMesg.setSerialNumber(54321L);
      fileIdMesg.setNumber(0);

      encode.write(fileIdMesg); // Encode the FileIDMesg

      DeviceInfoMesg deviceInfoMesg = new DeviceInfoMesg();
      deviceInfoMesg.setTimestamp(new DateTime(systemCurrentTime.getTime()));
      deviceInfoMesg.setBatteryStatus(BatteryStatus.GOOD);

      encode.write(deviceInfoMesg); // Encode the DeviceInfoMesg

      MonitoringMesg monitoringMesg = new MonitoringMesg();

      // By default, each time a new message is written the Local Message Type 0 will be redefined to match the new message.
      // In this case,to avoid having a definition message each time there is a DeviceInfoMesg, we can manually set the Local Message Type of the MonitoringMessage to '1'.
      // By doing this we avoid an additional 7 definition messages in our FIT file.
      monitoringMesg.setLocalNum(1);

      monitoringMesg.setTimestamp((new DateTime(systemCurrentTime.getTime()))); // Initialise Timestamp to current time
      monitoringMesg.setCycles(0F); //Initialise Cycles to 0

      Random numberOfCycles = new Random(); // Random number of cycles for example data
      for(int i = 0; i < 4; i++ ){ // Each of these loops represent a quarter of a day

         for(int j = 0; j < 6; j++){ // Each of these loops represent 1 hour
            monitoringMesg.setTimestamp(new DateTime(systemCurrentTime.getTime()));
            monitoringMesg.setActivityType(ActivityType.WALKING); // Setting this to WALKING will cause Cycles to be interpreted as steps
            monitoringMesg.setCycles(monitoringMesg.getCycles() + (numberOfCycles.nextFloat()*1000)); // Cycles are accumulated (i.e. must be increasing)

            encode.write(monitoringMesg); // Encode the MonitoringMesg

            systemCurrentTime.add(Calendar.HOUR, 1); // Add an hour to our contrived timestamp
         }

         deviceInfoMesg.setTimestamp((new DateTime(systemCurrentTime.getTime())));
         deviceInfoMesg.setBatteryStatus(BatteryStatus.GOOD);

         encode.write(deviceInfoMesg); // Encode the DeviceInfoMesg
      }

      try {
         encode.close();
      } catch(FitRuntimeException e) {
         System.err.println("Error closing encode.");
         return;
      }

      System.out.println("Encoded FIT file ExampleMonitoring.fit.");
   }
}