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

public enum WktStepDuration {
   TIME((short)0),
   DISTANCE((short)1),
   HR_LESS_THAN((short)2),
   HR_GREATER_THAN((short)3),
   CALORIES((short)4),
   OPEN((short)5),
   REPEAT_UNTIL_STEPS_CMPLT((short)6),
   REPEAT_UNTIL_TIME((short)7),
   REPEAT_UNTIL_DISTANCE((short)8),
   REPEAT_UNTIL_CALORIES((short)9),
   REPEAT_UNTIL_HR_LESS_THAN((short)10),
   REPEAT_UNTIL_HR_GREATER_THAN((short)11),
   REPEAT_UNTIL_POWER_LESS_THAN((short)12),
   REPEAT_UNTIL_POWER_GREATER_THAN((short)13),
   POWER_LESS_THAN((short)14),
   POWER_GREATER_THAN((short)15),
   REPETITION_TIME((short)28),
   INVALID((short)255);


   protected short value;




   private WktStepDuration(short value) {
     this.value = value;
   }

   public static WktStepDuration getByValue(final Short value) {
      for (final WktStepDuration type : WktStepDuration.values()) {
         if (value == type.value)
            return type;
      }

      return WktStepDuration.INVALID;
   }

   public short getValue() {
      return value;
   }


}
