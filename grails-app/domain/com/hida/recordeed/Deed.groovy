package com.hida.recordeed

class Deed {
    String name
    String description

    String referenceTime
    String specificRepeatingDay

    boolean allowOverride = false


    static constraints = {
        referenceTime nullable : true, inList : ListOfValue.PRAYER_TIMES
        specificRepeatingDay nullable : true, inList: ListOfValue.REPEATING_DAYS
    }

    DeedCriteria defineCriteria(String name, description) {
        return new DeedCriteria(deed : this, name : name, description: description)
    }
}