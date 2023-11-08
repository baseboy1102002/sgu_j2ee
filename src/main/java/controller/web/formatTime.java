package controller.web;

import java.util.Date;



public class formatTime {
	public static String formatTimeDifferences(Date timeFromDB) {
		Date currentTime = new Date();
		long timeDifference = currentTime.getTime() - timeFromDB.getTime();
		long seconds = timeDifference / 1000;



        if (seconds < 60) {
            return seconds + " giây trước";
        } else if (seconds < 3600) {
            long minutes = seconds / 60;
            return minutes + " phút trước";
        } else if (seconds < 86400) {
            long hours = seconds / 3600;
            return hours + " giờ trước";
        } else if (seconds < 2592000) {
            long days = seconds / 86400;
            return days + " ngày trước";
        } else {
            long months = seconds / 2592000;
            return months + " tháng trước";
        }
	}
}
