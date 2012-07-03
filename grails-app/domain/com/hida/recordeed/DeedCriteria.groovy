package com.hida.recordeed

class DeedCriteria {

    Deed deed
    static mapping = {
        deed index: "record_criteria_idx"
    }
    String name
    String description


    int ratingScale  = 5

    String ratingDescription0
    String ratingDescription1
    String ratingDescription2
    String ratingDescription3
    String ratingDescription4
    String ratingDescription5

    def DeedCriteria saveWithDescription(def descriptions) {
        int max = descriptions.keySet().max()
        def index = Constant."INDEX_FOR_SCALE_${max}"
        for(int i=0;i<=max;i++) { this."ratingDescription${index[i]}" = descriptions.get(i) }
        this.save(flush: true, failOnError: true)
    }

    static constraints = {
        ratingScale( inList : [1,3,5])
        //TODO: validation. if ratingScale 5 -> all mandatory, if ratingScale 3 -> only the odd numbered description is mandatory.
        ratingDescription0 nullable : true
        ratingDescription1 nullable : true
        ratingDescription2 nullable : true
        ratingDescription3 nullable : true
        ratingDescription4 nullable : true
        ratingDescription5 nullable : true
    }
}
