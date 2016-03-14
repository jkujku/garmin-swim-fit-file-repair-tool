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

public enum SegmentDeleteStatus {
   DO_NOT_DELETE((short)0),
   DELETE_ONE((short)1),
   DELETE_ALL((short)2),
   INVALID((short)255);


   protected short value;




   private SegmentDeleteStatus(short value) {
     this.value = value;
   }

   public static SegmentDeleteStatus getByValue(final Short value) {
      for (final SegmentDeleteStatus type : SegmentDeleteStatus.values()) {
         if (value == type.value)
            return type;
      }

      return SegmentDeleteStatus.INVALID;
   }

   public short getValue() {
      return value;
   }


}
