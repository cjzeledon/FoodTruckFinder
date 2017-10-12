package com.theironyard.charlotte.FoodTruckFinder.models;

import java.util.List;

//public class YelpHour {
//    private boolean is_open_now;
//    private String hours_type;
//    private List<YelpOpenHour> open;
//}


//hours[x].is_open_now	boolean	Whether the business is currently open or not.
//        hours[x].hours_type	string	The type of the opening hours information. Right now, this is always REGULAR.
//        hours[x].open	object[]	The detailed opening hours of each day in a week.
//        hours[x].open[x].day	int	From 0 to 6, representing day of the week from Monday to Sunday. Notice that you may get the same day of the week more than once if the business has more than one opening time slots.
//        hours[x].open[x].start	string	Start of the opening hours in a day, in 24-hour clock notation, like 1000 means 10 AM.
//        hours[x].open[x].start	string	Start of the opening hours in a day, in 24-hour clock notation, like 1000 means 10 AM.
//        hours[x].open[x].end	string	End of the opening hours in a day, in 24-hour clock notation, like 2130 means 9:30 PM.
//        hours[x].open[x].is_overnight	boolean	Whether the business opens overnight or not. When this is true, the end time will be lower than the start time.