package com.theironyard.charlotte.FoodTruckFinder.models;

public class YelpOpenHour {
    private int day;
    private String start;
    private String end;
    private boolean is_overnight;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public boolean isIs_overnight() {
        return is_overnight;
    }

    public void setIs_overnight(boolean is_overnight) {
        this.is_overnight = is_overnight;
    }

    @Override
    public String toString() {
        return "YelpOpenHour{" +
                "day=" + day +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", is_overnight=" + is_overnight +
                '}';
    }
}


//        hours[x].open	object[]	The detailed opening hours of each day in a week.
//        hours[x].open[x].day	int	From 0 to 6, representing day of the week from Monday to Sunday. Notice that you may get the same day of the week more than once if the business has more than one opening time slots.
//        hours[x].open[x].start	string	Start of the opening hours in a day, in 24-hour clock notation, like 1000 means 10 AM.
//        hours[x].open[x].start	string	Start of the opening hours in a day, in 24-hour clock notation, like 1000 means 10 AM.
//        hours[x].open[x].end	string	End of the opening hours in a day, in 24-hour clock notation, like 2130 means 9:30 PM.
//        hours[x].open[x].is_overnight	boolean	Whether the business opens overnight or not. When this is true, the end time will be lower than the start time.
