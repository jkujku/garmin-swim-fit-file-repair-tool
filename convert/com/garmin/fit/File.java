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

public enum File {
   DEVICE((short)1),
   SETTINGS((short)2),
   SPORT((short)3),
   ACTIVITY((short)4),
   WORKOUT((short)5),
   COURSE((short)6),
   SCHEDULES((short)7),
   WEIGHT((short)9),
   TOTALS((short)10),
   GOALS((short)11),
   BLOOD_PRESSURE((short)14),
   MONITORING_A((short)15),
   ACTIVITY_SUMMARY((short)20),
   MONITORING_DAILY((short)28),
   MONITORING_B((short)32),
   SEGMENT((short)34),
   SEGMENT_LIST((short)35),
   MFG_RANGE_MIN((short)0xF7),
   MFG_RANGE_MAX((short)0xFE),
   INVALID((short)255);


   protected short value;




   private File(short value) {
     this.value = value;
   }

   public static File getByValue(final Short value) {
      for (final File type : File.values()) {
         if (value == type.value)
            return type;
      }

      return File.INVALID;
   }

   public short getValue() {
      return value;
   }


}
