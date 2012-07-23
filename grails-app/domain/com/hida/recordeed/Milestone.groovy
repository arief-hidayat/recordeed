package com.hida.recordeed

import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormatter
import org.joda.time.format.DateTimeFormat

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
    static def createLunarMilestones(int year) {
        println "createLunarMilestones ${year} ${ConfigurationHolder.config.converter.dateFormat}"
        DateTimeFormatter fmt = DateTimeFormat.forPattern(ConfigurationHolder.config.converter.dateFormat);
        def config = ConfigurationHolder.config.app.lunarCalendars
        println "${config[year]}"
        if(config[year]) {
            def months = config[year].keySet()
            for(String month : months) {
                Milestone ms =Milestone.findByName("${month}-${year}")
                if(ms) {
                    ms.startDate = LocalDate.parse(config[year].startDate, fmt)
                    ms.endDate = LocalDate.parse(config[year].endDate, fmt)
                    ms.save(flush: true, failOnError: true)
                } else {
                    ms  = Milestone.createSpecialMilestone(
                            name : "${month}-${year}", description : "Milestone ${month} Tahun ${year}.",
                            startDate : LocalDate.parse(config[year]."${month}".startDate, fmt), endDate : LocalDate.parse(config[year]."${month}".endDate, fmt))
                }
            }
        }
        println "createLunarMilestones done"
    }
}
