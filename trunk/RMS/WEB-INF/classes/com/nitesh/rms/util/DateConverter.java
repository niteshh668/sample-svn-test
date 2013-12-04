package com.nitesh.rms.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {

   private static final DateFormat DATETIME_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

     public Object convertFromString(Map context, String[] strings, Class toClass) 
     {     
         Object obj = null;
      if (strings == null || strings.length == 0 || strings[0].trim().length() == 0) {
             obj = null;
         }

         try {
             obj =  DATETIME_FORMAT.parse(strings[0]);
             System.out.println(obj);
         } catch (ParseException e) {
             //throw new TypeConversionException("Unable to convert given object to date: " + strings[0]);
         }
         return obj;
     }

     public String convertToString(Map context, Object date) 
     {
         if (date != null && date instanceof Date) {         
             return DATETIME_FORMAT.format(date);
         } else {
             return null;
         }
     }
}