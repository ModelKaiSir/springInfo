package com.spring.utils;

import java.math.BigDecimal;
import java.util.Date;

public class JavaUtil {

    public final static String STR = "STR";
    public final static String BIGD = "BIGD";
    public final static String INTGER = "INTGER";
    public final static String DATE = "DATE";
    public final static String NULL = "NULL";

    public static String getStr(Object obj) {
        if (null != obj) {
            return obj.toString();
        } else {
            return "";
        }
    }

    public static BigDecimal getBigDecimal(Object obj) {
        if (null != obj) {
            return new BigDecimal(obj.toString());
        } else {
            return BigDecimal.ZERO;
        }
    }

    public static Date getDate(Object obj) {
        if (null != obj) {
            if (obj instanceof Date) {
                return (Date) obj;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 字符串工具
     *
     * @author qiukai
     */
    public static class StrUtil {
        /**
         * String 参数中有一个为空 或者 "" 返回 true BigDecimal 参数中有一个为空 或者 BigDecimal.ZERO
         * 返回 true INTEGER 参数中有一个为空 或者 0 返回 true
         *
         * @param a 参数
         * @return true : 存在空字符串。 false : 不为空。
         */
        public static boolean isEmpty(Object... a) {
            boolean b = a == null ? true : false;
            if (b) {
                return b;
            }
            for (Object a_ : a) {
                String s = "";

                if (a_ instanceof String) {
                    s = STR;
                } else if (a_ instanceof java.math.BigDecimal) {
                    s = BIGD;
                }

                switch (s) {
                    case STR:
                        String a_a = (String) a_;
                        if (a_a == null || a_a.equals("")) {
                            b = true;
                            return b;
                        }
                        break;
                    case BIGD:
                        java.math.BigDecimal a_b = (java.math.BigDecimal) a_;
                        if (a_b == null || a_b.compareTo(java.math.BigDecimal.ZERO) == 0) {
                            b = true;
                            return b;
                        }
                        break;
                    case INTGER:
                        Integer a_c = (Integer) a_;
                        if (a_c == null || a_c.equals(0)) {
                            b = true;
                            return b;
                        }
                        break;
                    default:
                        b = a_ == null ? true : false;
                        if (b) {
                            return true;
                        }
                }
                continue;
            }
            return b;
        }
    }
}
