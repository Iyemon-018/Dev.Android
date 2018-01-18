package com.example.iyemon018.materialcalendarsample.decorator;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.util.Arrays;
import java.util.Collection;

public final class DotViewDecorator implements DayViewDecorator {

    private final Collection<CalendarDay> dates;

    private final float radius;

    private final int color;

    public DotViewDecorator(CalendarDay date, float radius, int color) {
        this.dates = Arrays.asList(date);
        this.radius = radius;
        this.color = color;
    }

    public DotViewDecorator(Collection<CalendarDay> dates, float radius, int color) {
        this.dates = dates;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return this.dates.contains(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new DotSpan(this.radius, this.color));
    }
}
