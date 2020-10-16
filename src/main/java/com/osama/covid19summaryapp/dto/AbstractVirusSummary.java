package com.osama.covid19summaryapp.dto;

public abstract class AbstractVirusSummary {
    private GroupsCommaSeparatedNumber totalConfirmed;
    private GroupsCommaSeparatedNumber totalDeaths;
    private GroupsCommaSeparatedNumber totalRecovered;

    public GroupsCommaSeparatedNumber getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(int totalConfirmed) {
        this.totalConfirmed = GroupsCommaSeparatedNumber.createWithThreeLengthGroups(totalConfirmed);
    }

    public GroupsCommaSeparatedNumber getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = GroupsCommaSeparatedNumber.createWithThreeLengthGroups(totalDeaths);
    }

    public GroupsCommaSeparatedNumber getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(int totalRecovered) {
        this.totalRecovered = GroupsCommaSeparatedNumber.createWithThreeLengthGroups(totalRecovered);
    }

    @Override
    public String toString() {
        return "Total confirmed : " + getTotalConfirmed()
                + ", Total recovered : " + getTotalRecovered()
                + ", Total deaths :" + getTotalDeaths();
    }
}