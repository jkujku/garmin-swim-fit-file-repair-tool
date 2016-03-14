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


package com.garmin.fit.csv;

import com.garmin.fit.*;

import java.util.Collection;
import java.util.Iterator;

public class MesgCSVWriter implements MesgListener, MesgDefinitionListener {
   private CSVWriter csv;
   private boolean showInvalidsAsEmptyCells = false;
   private boolean hideUnknownData = false;
   private int numUnknownMesgs = 0;
   private int numUnknownFields = 0;
   private boolean dataInCsv;

   public MesgCSVWriter(String fileName) {
      this.csv = new CSVWriter(fileName);
      dataInCsv = false;
   }

   public void close() {
      csv.close();
   }

   public void showInvalidsAsEmptyCells() {
      showInvalidsAsEmptyCells = true;
   }

   public void hideUnknownData() {
      hideUnknownData = true;
   }

   public int getNumUnknownMesgs() {
      return numUnknownMesgs;
   }

   public int getNumUnknownFields() {
      return numUnknownFields;
   }

   public void onMesgDefinition(MesgDefinition mesgDef) {
      Collection<FieldDefinition> fields = mesgDef.getFields();
      Iterator<FieldDefinition> fieldsIterator;
      int headerNum;
      Mesg mesg = Factory.createMesg(mesgDef.getNum());
      if ( ( hideUnknownData ) && ( ( mesg == null ) || mesg.getName().equals("unknown") ) ) {
         return;
      }
      csv.clear();
      csv.set("Type", "Definition");
      csv.set("Local Number", mesgDef.getLocalNum());

      if (mesg == null)
         csv.set("Message", "unknown");
      else
         csv.set("Message", mesg.getName());

      headerNum = 0;
      fieldsIterator = fields.iterator();

      while (fieldsIterator.hasNext()) {
         FieldDefinition fieldDef = fieldsIterator.next();
         Field field = Factory.createField(mesgDef.getNum(), fieldDef.getNum());
         headerNum++;

         if ( ( hideUnknownData ) && ( ( field == null ) || ( field.getName().equals("unknown") ) ) )
            numUnknownFields++;
         else if ( field == null )
            csv.set("Field " + headerNum, "unknown");
         else
            csv.set("Field " + headerNum, field.getName());

         if ( !( field.getName().equals("unknown") && hideUnknownData ) ) {
            csv.set("Value " + headerNum, fieldDef.getSize() / Fit.baseTypeSizes[fieldDef.getType() & Fit.BASE_TYPE_NUM_MASK]);
            csv.set("Units " + headerNum, "");
         }
         else
            headerNum--;
      }

      csv.writeln();
      dataInCsv = true;
   }

   public void onMesg(Mesg mesg) {
      Collection<Field> fields = mesg.getFields();
      Iterator<Field> fieldsIterator;
      int headerNum;

      if ( ( mesg.getName().equals("unknown") ) && ( hideUnknownData ) ) {
         numUnknownMesgs++;
         return;
      }
      csv.clear();
      csv.set("Type", "Data");
      csv.set("Local Number", mesg.getLocalNum());
      csv.set("Message", mesg.getName());

      headerNum = 0;
      fieldsIterator = fields.iterator();

      while (fieldsIterator.hasNext()) {
         Field field = fieldsIterator.next();
         int subFieldIndex = mesg.GetActiveSubFieldIndex(field.getNum());

         headerNum++;

         if ( !( ( field.getName().equals("unknown") ) && ( hideUnknownData) ) )
            csv.set("Field " + headerNum, field.getName(subFieldIndex));

         String value = field.getStringValue(0, subFieldIndex);

         if (value == null || (showInvalidsAsEmptyCells && value.equals(Fit.baseTypeInvalidMap.get(field.getType(subFieldIndex)).toString())))
            value = "";

         for (int fieldElement = 1; fieldElement < field.getNumValues(); fieldElement++) {
            value += "|";

            String nextValue = field.getStringValue(fieldElement, subFieldIndex);

            if (nextValue != null)
               value += nextValue;
         }

         // Escapes embedded commas, double quotes, and newline characters
         value = value.replaceAll("\"", "\"\"");
         value = "\"" + value + "\"";

         if ( !( ( field.getName().equals("unknown") ) && ( hideUnknownData ) ) ) {
            csv.set("Value " + headerNum, value);
            csv.set("Units " + headerNum, field.getUnits(subFieldIndex));
         }
         else
            headerNum--;
      }

      csv.writeln();
      dataInCsv = true;
   }

   public boolean csvHasData() {
      return dataInCsv;
   }

}
