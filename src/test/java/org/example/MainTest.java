package org.example;

import org.example.entity.SheduleDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void buildOpeningScheduleString() {
        SheduleDto s1 = new SheduleDto(1, "12:00:00", "21:00:00", false);
        SheduleDto s2 = new SheduleDto(2, "12:00:00", "21:00:00", false);
        SheduleDto s3 = new SheduleDto(3, "12:00:00", "21:00:00", false);
        SheduleDto s4 = new SheduleDto(4, "12:00:00", "21:00:00", false);
        SheduleDto s5 = new SheduleDto(5, null, null, true);
        SheduleDto s6 = new SheduleDto(6, "10:00:00", "21:00:00", false);
        SheduleDto s7 = new SheduleDto(7, "10:00:00", "21:00:00", false);
        List<SheduleDto> list = List.of(s1, s2, s3, s4, s5, s6, s7);

        String expected = "ПН-ЧТ с 12:00:00 до 21:00:00, СБ-ВС с 10:00:00 до 21:00:00";
        String result = Main.buildOpeningScheduleString(list);

        Assertions.assertEquals(expected, result);
    } //проверка незапушенного коммита
    //еще одна проверка
    @Test
    void buildSheduleCode() {
        SheduleDto s1 = new SheduleDto(1, "12:00:00", "21:00:00", false);
        SheduleDto s2 = new SheduleDto(2, "12:00:00", "21:00:00", false);
        SheduleDto s3 = new SheduleDto(3, "12:00:00", "21:00:00", false);
        SheduleDto s4 = new SheduleDto(4, "10:00:00", "21:00:00", false);
        SheduleDto s5 = new SheduleDto(5, null, null, true);
        SheduleDto s6 = new SheduleDto(6, null, null, true);
        SheduleDto s7 = new SheduleDto(7, "10:00:00", "21:00:00", false);
        List<SheduleDto> list = List.of(s1, s2, s3, s4, s5, s6, s7);

        String expected = "3x12.00-21.00_1x10.00-21.00_2xclose_1x10.00-21.00";
        String result = Main.buildSheduleCode(list);

        Assertions.assertEquals(expected, result);
    }
}