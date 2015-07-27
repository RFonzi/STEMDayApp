package edu.acmatucf.stemdayapp;

public class ScheduleItem {

    private final long startDate;
    private final long endDate;
    private final String title;
    private final String location;

    public ScheduleItem(long startDate, long endDate, String title, String location) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.location = location;
    }

    public long getStartDate() {
        return startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }
}
