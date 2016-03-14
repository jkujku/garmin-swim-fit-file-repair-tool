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


public class DeviceSettingsMesg extends Mesg {

   protected static final  Mesg deviceSettingsMesg;
   static {
      // device_settings
      deviceSettingsMesg = new Mesg("device_settings", MesgNum.DEVICE_SETTINGS);
      deviceSettingsMesg.addField(new Field("active_time_zone", 0, 2, 1, 0, "", false));
      
      deviceSettingsMesg.addField(new Field("utc_offset", 1, 134, 1, 0, "", false));
      
      deviceSettingsMesg.addField(new Field("time_offset", 2, 134, 1, 0, "s", false));
      
      deviceSettingsMesg.addField(new Field("time_zone_offset", 5, 1, 4, 0, "hr", false));
      
   }

   public DeviceSettingsMesg() {
      super(Factory.createMesg(MesgNum.DEVICE_SETTINGS));
   }

   public DeviceSettingsMesg(final Mesg mesg) {
      super(mesg);
   }


   /**
    * Get active_time_zone field
    * Comment: Index into time zone arrays.
    *
    * @return active_time_zone
    */
   public Short getActiveTimeZone() {
      return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set active_time_zone field
    * Comment: Index into time zone arrays.
    *
    * @param activeTimeZone
    */
   public void setActiveTimeZone(Short activeTimeZone) {
      setFieldValue(0, 0, activeTimeZone, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get utc_offset field
    * Comment: Offset from system time. Required to convert timestamp from system time to UTC.
    *
    * @return utc_offset
    */
   public Long getUtcOffset() {
      return getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set utc_offset field
    * Comment: Offset from system time. Required to convert timestamp from system time to UTC.
    *
    * @param utcOffset
    */
   public void setUtcOffset(Long utcOffset) {
      setFieldValue(1, 0, utcOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * @return number of time_offset
    */
   public int getNumTimeOffset() {
      return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get time_offset field
    * Units: s
    * Comment: Offset from system time.
    *
    * @param index of time_offset
    * @return time_offset
    */
   public Long getTimeOffset(int index) {
      return getFieldLongValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set time_offset field
    * Units: s
    * Comment: Offset from system time.
    *
    * @param index of time_offset
    * @param timeOffset
    */
   public void setTimeOffset(int index, Long timeOffset) {
      setFieldValue(2, index, timeOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * @return number of time_zone_offset
    */
   public int getNumTimeZoneOffset() {
      return getNumFieldValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get time_zone_offset field
    * Units: hr
    * Comment: timezone offset in 1/4 hour increments
    *
    * @param index of time_zone_offset
    * @return time_zone_offset
    */
   public Float getTimeZoneOffset(int index) {
      return getFieldFloatValue(5, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set time_zone_offset field
    * Units: hr
    * Comment: timezone offset in 1/4 hour increments
    *
    * @param index of time_zone_offset
    * @param timeZoneOffset
    */
   public void setTimeZoneOffset(int index, Float timeZoneOffset) {
      setFieldValue(5, index, timeZoneOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

}
