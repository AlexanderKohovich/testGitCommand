package org.example.entity;

public class SheduleDto {
    private Integer dayOfWeek;
    private String openTime;
    private String closeTime;
    private Boolean dayOff;

    public SheduleDto(Integer dayOfWeek, String openTime, String closeTime, Boolean dayOff) {
        this.dayOfWeek = dayOfWeek;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.dayOff = dayOff;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Boolean getDayOff() {
        return dayOff;
    }

    public void setDayOff(Boolean dayOff) {
        this.dayOff = dayOff;
    }
}
