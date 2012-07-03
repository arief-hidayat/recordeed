package com.hida.recordeed

import org.joda.time.LocalDate

/**
 * For this release. User can create milestones. Only one for each of the following types:
 * Yearly.
 * Quarterly.
 * Special month: Ramadhan.
 */
class Milestone {

    String name
    String description

    String type

    LocalDate startDate
    LocalDate endDate

    static constraints = {
        type inList : ListOfValue.MILESTONE_TYPES
        //TODO validate date
    }
    //TODO: move to groovy dynamic. create%type%Milestone
    static def createYearlyMilestone(def params) {
        Milestone ms = new Milestone(params)
        ms.type = ListOfValue.YEARLY
        ms.save(flush : true, failOnError: true)
        ms
    }
    static def createQuarterlyMilestone(def params) {
        Milestone ms = new Milestone(params)
        ms.type = ListOfValue.QUARTERLY
        ms.save(flush : true, failOnError: true)
        ms
    }
    static def createSpecialMilestone(def params) {
        Milestone ms = new Milestone(params)
        ms.type = ListOfValue.SPECIAL_OCCASION
        ms.save(flush : true, failOnError: true)
        ms
    }
}
