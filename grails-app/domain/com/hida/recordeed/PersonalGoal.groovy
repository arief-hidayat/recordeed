package com.hida.recordeed

import com.recordeed.account.User
import org.joda.time.LocalDate

class PersonalGoal {
    User user
    Milestone milestone

    String name
    String description

    //TODO: note on change of this date might affect selected Deed.
    LocalDate actualStart
    LocalDate actualEnd

    static mapping = {
        milestone index : "personal_goal_idx"
    }

    static constraints = {
        milestone unique : "user"
        actualStart nullable : true
        actualEnd nullable : true
    }

//    def selectDeedForPersonalGoal(Deed deed, def params) {
//        params.flush = true
//        SelectedDeed selDeed = SelectedDeed.create(this, deed, params)
//    }

    def SelectedDeedCriteria prepareDeedCriteria(DeedCriteria criteria) {
        new SelectedDeedCriteria(personalGoal: this, deedCriteria: criteria)
    }
    def selectDeedForPersonalGoal(def theDeed, def params = [:]) {
        Deed deed = theDeed instanceof Deed ? theDeed : Deed.findByName(theDeed)
        if(deed) {
            SelectedDeed.create(this, deed, params)
        } else { println "deed ${theDeed} not found"}

    }
}
