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


package com.garmin.fit;


public class GyroscopeDataMesg extends Mesg {

   protected static final  Mesg gyroscopeDataMesg;
   static {
      // gyroscope_data
      gyroscopeDataMesg = new Mesg("gyroscope_data", MesgNum.GYROSCOPE_DATA);
      gyroscopeDataMesg.addField(new Field("timestamp", 253, 134, 1, 0, "s", false));
      
      gyroscopeDataMesg.addField(new Field("timestamp_ms", 0, 132, 1, 0, "ms", false));
      
      gyroscopeDataMesg.addField(new Field("sample_time_offset", 1, 132, 1, 0, "ms", false));
      
      gyroscopeDataMesg.addField(new Field("gyro_x", 2, 132, 1, 0, "counts", false));
      
      gyroscopeDataMesg.addField(new Field("gyro_y", 3, 132, 1, 0, "counts", false));
      
      gyroscopeDataMesg.addField(new Field("gyro_z", 4, 132, 1, 0, "counts", false));
      
      gyroscopeDataMesg.addField(new Field("calibrated_gyro_x", 5, 136, 1, 0, "deg/s", false));
      
      gyroscopeDataMesg.addField(new Field("calibrated_gyro_y", 6, 136, 1, 0, "deg/s", false));
      
      gyroscopeDataMesg.addField(new Field("calibrated_gyro_z", 7, 136, 1, 0, "deg/s", false));
      
   }

   public GyroscopeDataMesg() {
      super(Factory.createMesg(MesgNum.GYROSCOPE_DATA));
   }

   public GyroscopeDataMesg(final Mesg mesg) {
      super(mesg);
   }


   /**
    * Get timestamp field
    * Units: s
    * Comment: Whole second part of the timestamp
    *
    * @return timestamp
    */
   public DateTime getTimestamp() {
      return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
   }

   /**
    * Set timestamp field
    * Units: s
    * Comment: Whole second part of the timestamp
    *
    * @param timestamp
    */
   public void setTimestamp(DateTime timestamp) {
      setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get timestamp_ms field
    * Units: ms
    * Comment: Millisecond part of the timestamp.
    *
    * @return timestamp_ms
    */
   public Integer getTimestampMs() {
      return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set timestamp_ms field
    * Units: ms
    * Comment: Millisecond part of the timestamp.
    *
    * @param timestampMs
    */
   public void setTimestampMs(Integer timestampMs) {
      setFieldValue(0, 0, timestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * @return number of sample_time_offset
    */
   public int getNumSampleTimeOffset() {
      return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get sample_time_offset field
    * Units: ms
    * Comment: Each time in the array describes the time at which the gyro sample with the corrosponding index was taken. Limited to 30 samples in each message. The samples may span across seconds. Array size must match the number of samples in gyro_x and gyro_y and gyro_z
    *
    * @param index of sample_time_offset
    * @return sample_time_offset
    */
   public Integer getSampleTimeOffset(int index) {
      return getFieldIntegerValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set sample_time_offset field
    * Units: ms
    * Comment: Each time in the array describes the time at which the gyro sample with the corrosponding index was taken. Limited to 30 samples in each message. The samples may span across seconds. Array size must match the number of samples in gyro_x and gyro_y and gyro_z
    *
    * @param index of sample_time_offset
    * @param sampleTimeOffset
    */
   public void setSampleTimeOffset(int index, Integer sampleTimeOffset) {
      setFieldValue(1, index, sampleTimeOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * @return number of gyro_x
    */
   public int getNumGyroX() {
      return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get gyro_x field
    * Units: counts
    * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
    *
    * @param index of gyro_x
    * @return gyro_x
    */
   public Integer getGyroX(int index) {
      return getFieldIntegerValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set gyro_x field
    * Units: counts
    * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
    *
    * @param index of gyro_x
    * @param gyroX
    */
   public void setGyroX(int index, Integer gyroX) {
      setFieldValue(2, index, gyroX, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * @return number of gyro_y
    */
   public int getNumGyroY() {
      return getNumFieldValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get gyro_y field
    * Units: counts
    * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
    *
    * @param index of gyro_y
    * @return gyro_y
    */
   public Integer getGyroY(int index) {
      return getFieldIntegerValue(3, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set gyro_y field
    * Units: counts
    * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
    *
    * @param index of gyro_y
    * @param gyroY
    */
   public void setGyroY(int index, Integer gyroY) {
      setFieldValue(3, index, gyroY, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * @return number of gyro_z
    */
   public int getNumGyroZ() {
      return getNumFieldValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get gyro_z field
    * Units: counts
    * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
    *
    * @param index of gyro_z
    * @return gyro_z
    */
   public Integer getGyroZ(int index) {
      return getFieldIntegerValue(4, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set gyro_z field
    * Units: counts
    * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
    *
    * @param index of gyro_z
    * @param gyroZ
    */
   public void setGyroZ(int index, Integer gyroZ) {
      setFieldValue(4, index, gyroZ, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * @return number of calibrated_gyro_x
    */
   public int getNumCalibratedGyroX() {
      return getNumFieldValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get calibrated_gyro_x field
    * Units: deg/s
    * Comment: Calibrated gyro reading
    *
    * @param index of calibrated_gyro_x
    * @return calibrated_gyro_x
    */
   public Float getCalibratedGyroX(int index) {
      return getFieldFloatValue(5, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set calibrated_gyro_x field
    * Units: deg/s
    * Comment: Calibrated gyro reading
    *
    * @param index of calibrated_gyro_x
    * @param calibratedGyroX
    */
   public void setCalibratedGyroX(int index, Float calibratedGyroX) {
      setFieldValue(5, index, calibratedGyroX, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * @return number of calibrated_gyro_y
    */
   public int getNumCalibratedGyroY() {
      return getNumFieldValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get calibrated_gyro_y field
    * Units: deg/s
    * Comment: Calibrated gyro reading
    *
    * @param index of calibrated_gyro_y
    * @return calibrated_gyro_y
    */
   public Float getCalibratedGyroY(int index) {
      return getFieldFloatValue(6, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set calibrated_gyro_y field
    * Units: deg/s
    * Comment: Calibrated gyro reading
    *
    * @param index of calibrated_gyro_y
    * @param calibratedGyroY
    */
   public void setCalibratedGyroY(int index, Float calibratedGyroY) {
      setFieldValue(6, index, calibratedGyroY, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * @return number of calibrated_gyro_z
    */
   public int getNumCalibratedGyroZ() {
      return getNumFieldValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get calibrated_gyro_z field
    * Units: deg/s
    * Comment: Calibrated gyro reading
    *
    * @param index of calibrated_gyro_z
    * @return calibrated_gyro_z
    */
   public Float getCalibratedGyroZ(int index) {
      return getFieldFloatValue(7, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set calibrated_gyro_z field
    * Units: deg/s
    * Comment: Calibrated gyro reading
    *
    * @param index of calibrated_gyro_z
    * @param calibratedGyroZ
    */
   public void setCalibratedGyroZ(int index, Float calibratedGyroZ) {
      setFieldValue(7, index, calibratedGyroZ, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

}