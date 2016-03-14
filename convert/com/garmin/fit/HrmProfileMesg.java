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


public class HrmProfileMesg extends Mesg {

   protected static final  Mesg hrmProfileMesg;
   static {
      // hrm_profile
      hrmProfileMesg = new Mesg("hrm_profile", MesgNum.HRM_PROFILE);
      hrmProfileMesg.addField(new Field("message_index", 254, 132, 1, 0, "", false));
      
      hrmProfileMesg.addField(new Field("enabled", 0, 0, 1, 0, "", false));
      
      hrmProfileMesg.addField(new Field("hrm_ant_id", 1, 139, 1, 0, "", false));
      
      hrmProfileMesg.addField(new Field("log_hrv", 2, 0, 1, 0, "", false));
      
      hrmProfileMesg.addField(new Field("hrm_ant_id_trans_type", 3, 10, 1, 0, "", false));
      
   }

   public HrmProfileMesg() {
      super(Factory.createMesg(MesgNum.HRM_PROFILE));
   }

   public HrmProfileMesg(final Mesg mesg) {
      super(mesg);
   }


   /**
    * Get message_index field
    *
    * @return message_index
    */
   public Integer getMessageIndex() {
      return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set message_index field
    *
    * @param messageIndex
    */
   public void setMessageIndex(Integer messageIndex) {
      setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get enabled field
    *
    * @return enabled
    */
   public Bool getEnabled() {
      Short value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set enabled field
    *
    * @param enabled
    */
   public void setEnabled(Bool enabled) {
      setFieldValue(0, 0, enabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get hrm_ant_id field
    *
    * @return hrm_ant_id
    */
   public Integer getHrmAntId() {
      return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set hrm_ant_id field
    *
    * @param hrmAntId
    */
   public void setHrmAntId(Integer hrmAntId) {
      setFieldValue(1, 0, hrmAntId, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get log_hrv field
    *
    * @return log_hrv
    */
   public Bool getLogHrv() {
      Short value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set log_hrv field
    *
    * @param logHrv
    */
   public void setLogHrv(Bool logHrv) {
      setFieldValue(2, 0, logHrv.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get hrm_ant_id_trans_type field
    *
    * @return hrm_ant_id_trans_type
    */
   public Short getHrmAntIdTransType() {
      return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set hrm_ant_id_trans_type field
    *
    * @param hrmAntIdTransType
    */
   public void setHrmAntIdTransType(Short hrmAntIdTransType) {
      setFieldValue(3, 0, hrmAntIdTransType, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

}
