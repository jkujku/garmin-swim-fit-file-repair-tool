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


public class HrMesg extends Mesg {

   protected static final  Mesg hrMesg;
   static {int field_index = 0;
      // hr
      hrMesg = new Mesg("hr", MesgNum.HR);
      hrMesg.addField(new Field("timestamp", 253, 134, 1, 0, "", false));
      field_index++;
      hrMesg.addField(new Field("fractional_timestamp", 0, 132, 32768, 0, "s", false));
      field_index++;
      hrMesg.addField(new Field("time256", 1, 2, 256, 0, "s", false));
      hrMesg.fields.get(field_index).components.add(new FieldComponent(0, false, 8, 256, 0)); // fractional_timestamp
      field_index++;
      hrMesg.addField(new Field("filtered_bpm", 6, 2, 1, 0, "bpm", false));
      field_index++;
      hrMesg.addField(new Field("event_timestamp", 9, 134, 1024, 0, "s", true));
      field_index++;
      hrMesg.addField(new Field("event_timestamp_12", 10, 13, 1, 0, "", false));
      hrMesg.fields.get(field_index).components.add(new FieldComponent(9, true, 12, 1024, 0)); // event_timestamp
      hrMesg.fields.get(field_index).components.add(new FieldComponent(9, true, 12, 1024, 0)); // event_timestamp
      hrMesg.fields.get(field_index).components.add(new FieldComponent(9, true, 12, 1024, 0)); // event_timestamp
      hrMesg.fields.get(field_index).components.add(new FieldComponent(9, true, 12, 1024, 0)); // event_timestamp
      hrMesg.fields.get(field_index).components.add(new FieldComponent(9, true, 12, 1024, 0)); // event_timestamp
      hrMesg.fields.get(field_index).components.add(new FieldComponent(9, true, 12, 1024, 0)); // event_timestamp
      hrMesg.fields.get(field_index).components.add(new FieldComponent(9, true, 12, 1024, 0)); // event_timestamp
      hrMesg.fields.get(field_index).components.add(new FieldComponent(9, true, 12, 1024, 0)); // event_timestamp
      hrMesg.fields.get(field_index).components.add(new FieldComponent(9, true, 12, 1024, 0)); // event_timestamp
      hrMesg.fields.get(field_index).components.add(new FieldComponent(9, true, 12, 1024, 0)); // event_timestamp
      field_index++;
   }

   public HrMesg() {
      super(Factory.createMesg(MesgNum.HR));
   }

   public HrMesg(final Mesg mesg) {
      super(mesg);
   }


   /**
    * Get timestamp field
    *
    * @return timestamp
    */
   public DateTime getTimestamp() {
      return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
   }

   /**
    * Set timestamp field
    *
    * @param timestamp
    */
   public void setTimestamp(DateTime timestamp) {
      setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get fractional_timestamp field
    * Units: s
    *
    * @return fractional_timestamp
    */
   public Float getFractionalTimestamp() {
      return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set fractional_timestamp field
    * Units: s
    *
    * @param fractionalTimestamp
    */
   public void setFractionalTimestamp(Float fractionalTimestamp) {
      setFieldValue(0, 0, fractionalTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get time256 field
    * Units: s
    *
    * @return time256
    */
   public Float getTime256() {
      return getFieldFloatValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set time256 field
    * Units: s
    *
    * @param time256
    */
   public void setTime256(Float time256) {
      setFieldValue(1, 0, time256, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * @return number of filtered_bpm
    */
   public int getNumFilteredBpm() {
      return getNumFieldValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get filtered_bpm field
    * Units: bpm
    *
    * @param index of filtered_bpm
    * @return filtered_bpm
    */
   public Short getFilteredBpm(int index) {
      return getFieldShortValue(6, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set filtered_bpm field
    * Units: bpm
    *
    * @param index of filtered_bpm
    * @param filteredBpm
    */
   public void setFilteredBpm(int index, Short filteredBpm) {
      setFieldValue(6, index, filteredBpm, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * @return number of event_timestamp
    */
   public int getNumEventTimestamp() {
      return getNumFieldValues(9, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get event_timestamp field
    * Units: s
    *
    * @param index of event_timestamp
    * @return event_timestamp
    */
   public Float getEventTimestamp(int index) {
      return getFieldFloatValue(9, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set event_timestamp field
    * Units: s
    *
    * @param index of event_timestamp
    * @param eventTimestamp
    */
   public void setEventTimestamp(int index, Float eventTimestamp) {
      setFieldValue(9, index, eventTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * @return number of event_timestamp_12
    */
   public int getNumEventTimestamp12() {
      return getNumFieldValues(10, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get event_timestamp_12 field
    *
    * @param index of event_timestamp_12
    * @return event_timestamp_12
    */
   public Byte getEventTimestamp12(int index) {
      return getFieldByteValue(10, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set event_timestamp_12 field
    *
    * @param index of event_timestamp_12
    * @param eventTimestamp12
    */
   public void setEventTimestamp12(int index, Byte eventTimestamp12) {
      setFieldValue(10, index, eventTimestamp12, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

}
