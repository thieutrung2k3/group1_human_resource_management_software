package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateUtils {
    public static String formatDateToString(LocalDate time, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return time.format(formatter);
    }
    
    public static java.sql.Date convertStringToSqlDate(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            java.util.Date utilDate = dateFormat.parse(date);
            return new java.sql.Date(utilDate.getTime());
            
        }catch(ParseException ex){
            System.out.println("error in convertStringToSqlDate: " + ex.getMessage());
            return null;
        }
    }
}
