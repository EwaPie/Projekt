package com.projekt.util;


import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DecimalFormatter {

    private static DecimalFormatter FORMATTER;

    @Getter
    private final DecimalFormat decimalFormat;

    private DecimalFormatter() {
        decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setMinimumFractionDigits(0);
        decimalFormat.setGroupingUsed(false);
    }

    private static DecimalFormatter getInstance() {
        if (FORMATTER == null) {
            FORMATTER = new DecimalFormatter();
        }

        return FORMATTER;
    }

    public static String format(BigDecimal decimal) {
        return getInstance().getDecimalFormat().format(decimal);
    }

    public static String formatOrEmpty(BigDecimal decimal) {
        return decimal != null ? format(decimal) : StringUtils.EMPTY;
    }


}
