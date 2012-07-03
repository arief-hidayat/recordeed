package com.hida.recordeed

/**
 * Created with IntelliJ IDEA.
 * User: hida
 * Date: 6/20/12
 * Time: 4:44 PM
 * To change this template use File | Settings | File Templates.
 */
class ListOfValue {
    static def MAGRIB =  "Maghrib"
    static def ISYA =  "Isya"
    static def SUBH =  "Subh"
    static def DZUHR =  "Dzuhr"
    static def ASHR =  "Ashr"
    static def DAILY = "Daily"
    static def PRAYER_TIMES = [MAGRIB, ISYA, SUBH, DZUHR,ASHR]

    static def ALTERNATE_DAY = "Alternate Day"
//    static def DAY_OF_WEEK = "Day of Week"
    static def EVERY_SUNDAY = "Every Sunday"
    static def EVERY_MONDAY = "Every Monday"
    static def EVERY_TUESDAY = "Every Tuesday"
    static def EVERY_WEDNESDAY = "Every Wednesday"
    static def EVERY_THURSDAY = "Every Thursday"
    static def EVERY_FRIDAY = "Every Friday"
    static def EVERY_SATURDAY = "Every Saturday"
    static def REPEATING_DAYS = [DAILY, ALTERNATE_DAY, EVERY_SUNDAY,EVERY_MONDAY,EVERY_TUESDAY,EVERY_WEDNESDAY,EVERY_THURSDAY, EVERY_FRIDAY,EVERY_SATURDAY]


    static def WEEKLY_QUOTA =  "Weekly Quota"
    static def MONTHLY_QUOTA =  "Monthly Quota"
    static def CUSTOM_PERIOD_QUOTA =  "Quota for Custom Period"
    static def QUOTA_MODES = [WEEKLY_QUOTA, MONTHLY_QUOTA, CUSTOM_PERIOD_QUOTA]

    static def QUARTERLY =  "Quarterly"
    static def YEARLY =  "YEARLY"
    static def SPECIAL_OCCASION =  "Special Occasion"
    static def MILESTONE_TYPES = [QUARTERLY, YEARLY, SPECIAL_OCCASION]

}
