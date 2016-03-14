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


public class NmeaSentenceMesg extends Mesg {

   protected static final  Mesg nmeaSentenceMesg;
   static {
      // nmea_sentence
      nmeaSentenceMesg = new Mesg("nmea_sentence", MesgNum.NMEA_SENTENCE);
      nmeaSentenceMesg.addField(new Field("timestamp", 253, 134, 1, 0, "s", false));
      
      nmeaSentenceMesg.addField(new Field("timestamp_ms", 0, 132, 1, 0, "ms", false));
      
      nmeaSentenceMesg.addField(new Field("sentence", 1, 7, 1, 0, "", false));
      
   }

   public NmeaSentenceMesg() {
      super(Factory.createMesg(MesgNum.NMEA_SENTENCE));
   }

   public NmeaSentenceMesg(final Mesg mesg) {
      super(mesg);
   }


   /**
    * Get timestamp field
    * Units: s
    * Comment: Timestamp message was output
    *
    * @return timestamp
    */
   public DateTime getTimestamp() {
      return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
   }

   /**
    * Set timestamp field
    * Units: s
    * Comment: Timestamp message was output
    *
    * @param timestamp
    */
   public void setTimestamp(DateTime timestamp) {
      setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get timestamp_ms field
    * Units: ms
    * Comment: Fractional part of timestamp, added to timestamp
    *
    * @return timestamp_ms
    */
   public Integer getTimestampMs() {
      return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set timestamp_ms field
    * Units: ms
    * Comment: Fractional part of timestamp, added to timestamp
    *
    * @param timestampMs
    */
   public void setTimestampMs(Integer timestampMs) {
      setFieldValue(0, 0, timestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get sentence field
    * Comment: NMEA sentence
    *
    * @return sentence
    */
   public String getSentence() {
      return getFieldStringValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set sentence field
    * Comment: NMEA sentence
    *
    * @param sentence
    */
   public void setSentence(String sentence) {
      setFieldValue(1, 0, sentence, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

}