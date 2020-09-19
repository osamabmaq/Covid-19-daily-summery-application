package com.osama.covid19summaryapp.dto;

import java.text.DecimalFormat;

public class GroupsCommaSeparatedNumber {
    private final String threeGroupingColonSeparatedNumber;

    private GroupsCommaSeparatedNumber(int number, byte groupLength) {
        if (groupLength < 1)
            throw new IllegalArgumentException();
        threeGroupingColonSeparatedNumber = makeGroupsFormattedNumber(number, groupLength);
    }

    public static GroupsCommaSeparatedNumber createWithThreeLengthGroups(int number) {
        return new GroupsCommaSeparatedNumber(number, (byte) 3);
    }

    public static GroupsCommaSeparatedNumber create(int number, byte groupLength) {
        return new GroupsCommaSeparatedNumber(number, groupLength);
    }

    private String makeGroupsFormattedNumber(int number, byte groupLength) {
        DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
        format.setGroupingSize(groupLength);
        return format.format(number);
    }

    @Override
    public String toString() {
        return threeGroupingColonSeparatedNumber;
    }
}