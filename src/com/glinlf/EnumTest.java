package com.glinlf;

import org.junit.jupiter.api.Test;

/**
 * @author created by glinlf
 * @date 2019/1/17
 * @remark
 */
public class EnumTest {

    @Test
    public void test() {

    }

    public enum StrEnum {
        A("key1", "value1"),
        B("key2", "value2"),
        C("key3", "value3");

        public String key;
        public String value;

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        StrEnum(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public static StrEnum valueOfkey(String key) {
            StrEnum[] enums = StrEnum.values();
            for (StrEnum strEnum : enums) {
                if (strEnum.getKey().equals(key)) {
                    return strEnum;
                }
            }
            return null;
        }
    }

    @Test
    public void testEnum() {
        System.out.println(StrEnum.valueOfkey("key1").value);
    }

    public static void main(String[] args) {

    }
}
