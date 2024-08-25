/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

/**
 *
 * @author whyia
 */
public class TimeUtils {
    public static Time convertStringToSqlTime(String timeString) {
        // Định dạng thời gian
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        try {
            // Phân tích chuỗi thành đối tượng java.util.Date
            java.util.Date parsedDate = format.parse(timeString);
            // Chuyển đổi thành đối tượng java.sql.Time
            return new Time(parsedDate.getTime());
        } catch (ParseException e) {
            // Xử lý lỗi phân tích chuỗi
            System.err.println("Invalid time format: " + timeString);
            return null;
        }
    }
    public static String getAttendanceStatus(Time checkInTime) {
        // Định nghĩa thời gian 8 giờ sáng
        Time eightAM = Time.valueOf("08:00:00");

        if (checkInTime == null) {
            return "Nghỉ làm";  // Nếu không có thời gian check-in thì coi là nghỉ làm
        } else if (checkInTime.compareTo(eightAM) > 0) {
            return "Muộn";  // Nếu check-in sau 8 giờ sáng
        } else {
            return "Đúng giờ";  // Nếu check-in trước hoặc đúng 8 giờ sáng
        }
    }
}

