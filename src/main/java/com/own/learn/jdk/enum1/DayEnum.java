//package com.own.learn.jdk.enum1;
//
//public final class DayEnum extends Enum {
//    public static DayEnum MONDAY;
//
//    public static DayEnum TUESDAY;
//
//    public static DayEnum WEDNESDAY;
//
//    public static DayEnum THURSDAY;
//
//    public static DayEnum FRIDAY;
//
//    public static DayEnum SATURDAY;
//
//    public static DayEnum SUNDAY;
//    private static DayEnum $VALUES[];
//
//    static {
//        MONDAY = new DayEnum("MONDAY", 0);
//        TUESDAY = new DayEnum("TUESDAY", 1);
//        WEDNESDAY = new DayEnum("WEDNESDAY", 2);
//        THURSDAY = new DayEnum("THURSDAY", 3);
//        FRIDAY = new DayEnum("FRIDAY", 4);
//        SATURDAY = new DayEnum("SATURDAY", 5);
//        SUNDAY = new DayEnum("SUNDAY", 6);
//        $VALUES = (new DayEnum[]{
//                MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
//        });
//    }
//
//
//    public DayEnum[] values() {
//        return (DayEnum[]) $VALUES.clone();
//    }
//
//    public DayEnum valueOf(String name) {
//        return (DayEnum) Enum.valueOf(com.own.learn.jdk.enum1.DayEnum.class, name);
//
//    }
//
//    protected DayEnum(String name, int ordinal) {
//        super(name, ordinal);
//    }
//
//    @Override
//    public String toString() {
//        return super.toString();
//    }
//}
