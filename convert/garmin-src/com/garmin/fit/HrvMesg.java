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


public class HrvMesg extends Mesg {

   protected static final  Mesg hrvMesg;
   static {
      // hrv
      hrvMesg = new Mesg("hrv", MesgNum.HRV);
      hrvMesg.addField(new Field("time", 0, 132, 1000, 0, "s", false));
      
   }

   public HrvMesg() {
      super(Factory.createMesg(MesgNum.HRV));
   }

   public HrvMesg(final Mesg mesg) {
      super(mesg);
   }


   /**
    * @return number of time
    */
   public int getNumTime() {
      return getNumFieldValues(0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get time field
    * Units: s
    * Comment: Time between beats
    *
    * @param index of time
    * @return time
    */
   public Float getTime(int index) {
      return getFieldFloatValue(0, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set time field
    * Units: s
    * Comment: Time between beats
    *
    * @param index of time
    * @param time
    */
   public void setTime(int index, Float time) {
      setFieldValue(0, index, time, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

}