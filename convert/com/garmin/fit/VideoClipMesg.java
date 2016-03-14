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


public class VideoClipMesg extends Mesg {

   protected static final  Mesg videoClipMesg;
   static {
      // video_clip
      videoClipMesg = new Mesg("video_clip", MesgNum.VIDEO_CLIP);
      videoClipMesg.addField(new Field("clip_number", 0, 132, 1, 0, "", false));
      
      videoClipMesg.addField(new Field("start_timestamp", 1, 134, 1, 0, "", false));
      
      videoClipMesg.addField(new Field("start_timestamp_ms", 2, 132, 1, 0, "", false));
      
      videoClipMesg.addField(new Field("end_timestamp", 3, 134, 1, 0, "", false));
      
      videoClipMesg.addField(new Field("end_timestamp_ms", 4, 132, 1, 0, "", false));
      
      videoClipMesg.addField(new Field("clip_start", 6, 134, 1, 0, "ms", false));
      
      videoClipMesg.addField(new Field("clip_end", 7, 134, 1, 0, "ms", false));
      
   }

   public VideoClipMesg() {
      super(Factory.createMesg(MesgNum.VIDEO_CLIP));
   }

   public VideoClipMesg(final Mesg mesg) {
      super(mesg);
   }


   /**
    * Get clip_number field
    *
    * @return clip_number
    */
   public Integer getClipNumber() {
      return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set clip_number field
    *
    * @param clipNumber
    */
   public void setClipNumber(Integer clipNumber) {
      setFieldValue(0, 0, clipNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get start_timestamp field
    *
    * @return start_timestamp
    */
   public DateTime getStartTimestamp() {
      return timestampToDateTime(getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
   }

   /**
    * Set start_timestamp field
    *
    * @param startTimestamp
    */
   public void setStartTimestamp(DateTime startTimestamp) {
      setFieldValue(1, 0, startTimestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get start_timestamp_ms field
    *
    * @return start_timestamp_ms
    */
   public Integer getStartTimestampMs() {
      return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set start_timestamp_ms field
    *
    * @param startTimestampMs
    */
   public void setStartTimestampMs(Integer startTimestampMs) {
      setFieldValue(2, 0, startTimestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get end_timestamp field
    *
    * @return end_timestamp
    */
   public DateTime getEndTimestamp() {
      return timestampToDateTime(getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
   }

   /**
    * Set end_timestamp field
    *
    * @param endTimestamp
    */
   public void setEndTimestamp(DateTime endTimestamp) {
      setFieldValue(3, 0, endTimestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get end_timestamp_ms field
    *
    * @return end_timestamp_ms
    */
   public Integer getEndTimestampMs() {
      return getFieldIntegerValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set end_timestamp_ms field
    *
    * @param endTimestampMs
    */
   public void setEndTimestampMs(Integer endTimestampMs) {
      setFieldValue(4, 0, endTimestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get clip_start field
    * Units: ms
    * Comment: Start of clip in video time
    *
    * @return clip_start
    */
   public Long getClipStart() {
      return getFieldLongValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set clip_start field
    * Units: ms
    * Comment: Start of clip in video time
    *
    * @param clipStart
    */
   public void setClipStart(Long clipStart) {
      setFieldValue(6, 0, clipStart, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get clip_end field
    * Units: ms
    * Comment: End of clip in video time
    *
    * @return clip_end
    */
   public Long getClipEnd() {
      return getFieldLongValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set clip_end field
    * Units: ms
    * Comment: End of clip in video time
    *
    * @param clipEnd
    */
   public void setClipEnd(Long clipEnd) {
      setFieldValue(7, 0, clipEnd, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

}
