package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.StringUtils;
import org.example.entity.SheduleDto;
import org.example.json.JsonMapper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;


public class Main {

    private static final int DAYS_TO_ADD = 1;





    public static void main(String[] args) throws JsonProcessingException {
        JsonMapper mapper = new JsonMapper();
//        List<SheduleDto> sheduleDtos = mapper.getShedulesDtos();
//        System.out.println(sheduleDtos.size());
        SheduleDto s1 = new SheduleDto(1, "12:00:00", "21:00:00", false);
        SheduleDto s2 = new SheduleDto(2, "12:00:00", "21:00:00", true);
        SheduleDto s3 = new SheduleDto(3, "12:00:00", "21:00:00", false);
        SheduleDto s4 = new SheduleDto(4, "10:00:00", "21:00:00", true);
        SheduleDto s5 = new SheduleDto(5, "10:00:00", "21:00:00", false);
        SheduleDto s6 = new SheduleDto(6, null, null, true);
        SheduleDto s7 = new SheduleDto(7, "10:00:00", "21:00:00", true);
        List<SheduleDto> list = List.of(s1, s2, s3, s4, s5, s6, s7);
        System.out.println(buildSheduleCode(list));
        System.out.println(buildOpeningScheduleString(list));

    }
// qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq
//    akjashd kj da\
//
//    public static List<String> getDaysString() {
//        d asd
//                asddasd
//                        as
//                        d
//                                sa
//                                isNextDayTheSame(as)
//    }

    private static final Logger LOG = Logger.getLogger(Main.class.getName());
    private static final DateTimeFormatter DEFAULT_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter TIME_FORMATTER_FOR_CODE = DateTimeFormatter.ofPattern("HH.mm");

    private static final List<String> DAYS_STRING = List.of("ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ", "ВС");

    private static String buildOpeningScheduleString(List<SheduleDto> sheduleDtos) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 1;
        while (i < sheduleDtos.size()) {
            SheduleDto day = sheduleDtos.get(i);
            if (day.getDayOff()) {
                i++;
                j++;
                continue;
            }
            int countOfSameDays = 1;
            while (j < sheduleDtos.size() && isNextDayTheSame(day, sheduleDtos.get(j))) {
                countOfSameDays++;
                j++;
            }
            boolean flag = i == j - 1;
            result.append(StringUtils.isBlank(result) ? "" : ", ")
                    .append(day.getDayOff() ? "" : DAYS_STRING.get(i))
                    .append(flag ? "" : "-")
                    .append(flag ? "" : DAYS_STRING.get(j - 1))
                    .append(" c ")
                    .append(day.getOpenTime())
                    .append(" до ")
                    .append(day.getCloseTime());
            i += countOfSameDays;
            j++;
        }
        return result.toString();
    }

    private static String buildSheduleCode(List<SheduleDto> sheduleDtos) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 1;
        try {
            while (i < sheduleDtos.size()) {
                SheduleDto day = sheduleDtos.get(i);
                int countOfSameDays = 1;
                while (j < sheduleDtos.size() && isNextDayTheSame(day, sheduleDtos.get(j))) {
                    countOfSameDays++;
                    j++;
                }
                result.append(countOfSameDays)
                        .append("x")
                        .append(day.getDayOff() ? "close" : parseTimeForCode(day.getOpenTime()))
                        .append(day.getDayOff() ? "" : "-")
                        .append(day.getDayOff() ? "" : parseTimeForCode(day.getCloseTime()))
                        .append(j != sheduleDtos.size() ? "_" : "");
                i += countOfSameDays;
                j++;
            }
        } catch (DateTimeParseException e) {
            LOG.severe(e.getMessage());
            return null;
        }
        return result.toString();
    }

    private static String parseTimeForCode(String time) {
        return LocalTime.parse(time).format(TIME_FORMATTER_FOR_CODE);
    }

    private static boolean isNextDayTheSame(SheduleDto first, SheduleDto second) {
        if (first.getDayOff() && second.getDayOff()) {
            return true;
        }
        return first.getOpenTime() != null
                && first.getCloseTime() != null
                && second.getOpenTime() != null
                && second.getCloseTime() != null
                && first.getOpenTime().equals(second.getOpenTime())
                && first.getCloseTime().equals(second.getCloseTime())
                && first.getDayOff().equals(second.getDayOff());
    }

    public static Date paseTimeToDate(String time) {
        LocalTime dateTime = LocalTime.parse(time);
        return Date.from(dateTime.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant());
    }

    private static final DateTimeFormatter TIME_FORMATTER_FOR_SCHEDULE = DateTimeFormatter.ofPattern("HH:mm");

}