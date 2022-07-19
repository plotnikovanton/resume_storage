package ru.javaops.webapp.util;

import ru.javaops.webapp.model.Organization;

public class HtmlUtil {
    public static String formatDates(Organization.Position position) {
        return DateUtil.format(position.getStartDate()) + " - " + DateUtil.format(position.getEndDate());
    }
}
