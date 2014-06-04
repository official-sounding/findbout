package com.officialsounding.findbout.model;

import org.joda.time.LocalDate;

public class Bout {

    private Team home;
    private Team away;
    private LocalDate date;
    private String sanctionedBy;
    private double distanceMeters;

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSanctionedBy() {
        return sanctionedBy;
    }

    public void setSanctionedBy(String sanctionedBy) {
        this.sanctionedBy = sanctionedBy;
    }

    public double getDistanceMeters() {
        return distanceMeters;
    }

    public void setDistanceMeters(double distanceMeters) {
        this.distanceMeters = distanceMeters;
    }

    public double getDistanceMiles() {
        return distanceMeters * 0.00062137;
    }
}
