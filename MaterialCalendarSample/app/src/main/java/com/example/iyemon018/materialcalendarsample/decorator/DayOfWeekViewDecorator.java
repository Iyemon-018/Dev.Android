package com.example.iyemon018.materialcalendarsample.decorator;

import android.text.style.ForegroundColorSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Calendar;

public final class DayOfWeekViewDecorator implements DayViewDecorator {

    private final int dayOfWeek;
    private final int foreground;

    public DayOfWeekViewDecorator(int dayOfWeek, int foreground) {
        this.dayOfWeek = dayOfWeek;
        this.foreground = foreground;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return day.getCalendar().get(Calendar.DAY_OF_WEEK) == this.dayOfWeek;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new ForegroundColorSpan(this.foreground));
    }
}
