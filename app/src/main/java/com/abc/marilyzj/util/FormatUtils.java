package com.abc.marilyzj.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;




public class FormatUtils {
    /**
     * 最多保留三位小数
     */
    public static String formatDouble(double d) {
        DecimalFormat df = new DecimalFormat("######0.000");
        return BigDecimal.valueOf(Double.parseDouble(df.format(d)))
                .stripTrailingZeros().toPlainString();
    }

    public static String listToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i < list.size() - 1) {
                    sb.append(list.get(i) + ",");
                } else {
                    sb.append(list.get(i));
                }
            }
        }
        return sb.toString();
    }
}
