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


public class HI36Mesg extends Mesg implements MesgWithEvent {

   protected static final  Mesg hi36Mesg;
   static {
      hi36Mesg = new Mesg("hi36", MesgNum.HI36);
      hi36Mesg.addField(new Field("hi36n253", 253, 134, 1, 0, "", false));
      hi36Mesg.addField(new Field("hi36n16", 16, 10, 1, 0, "", false));
      hi36Mesg.addField(new Field("hi36n20", 20, 10, 1, 0, "", false));
      hi36Mesg.addField(new Field("hi36n21", 21, 10, 1, 0, "", false));
   }

   public HI36Mesg() {
      super(Factory.createMesg(MesgNum.HI36));
   }

   public HI36Mesg(final Mesg mesg) {
      super(mesg);
   }

   /**
    * Get timestamp field
    * Units: s
    * Comment: Lap end time.
    *
    * @return timestamp
    */
   public DateTime getTimestamp() {
      return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
   }

   /**
    * Set timestamp field
    * Units: s
    * Comment: Lap end time.
    *
    * @param timestamp
    */
   public void setTimestamp(DateTime timestamp) {
      setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get event field
    *
    * @return event
    */
   public Event getEvent() {
      Short value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Event.getByValue(value);
   }

   /**
    * Set event field
    *
    * @param event
    */
   public void setEvent(Event event) {
      setFieldValue(0, 0, event.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get event_type field
    *
    * @return event_type
    */
   public EventType getEventType() {
      Short value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return EventType.getByValue(value);
   }

   /**
    * Set event_type field
    *
    * @param eventType
    */
   public void setEventType(EventType eventType) {
      setFieldValue(1, 0, eventType.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get event_group field
    *
    * @return event_group
    */
   public Short getEventGroup() {
      return getFieldShortValue(26, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set event_group field
    *
    * @param eventGroup
    */
   public void setEventGroup(Short eventGroup) {
      setFieldValue(26, 0, eventGroup, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }
}
