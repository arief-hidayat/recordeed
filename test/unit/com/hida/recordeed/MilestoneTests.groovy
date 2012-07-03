package com.hida.recordeed

import grails.test.mixin.TestFor
import org.joda.time.LocalDate

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Milestone)
class MilestoneTests {

    void testSomething() {
        // perhaps instead of gregorian calendar, user can opt to use hijriah calendar.
        LocalDate firstDayOfYear =new LocalDate().dayOfYear().withMinimumValue()
        LocalDate lastDayOfYear =new LocalDate().dayOfYear().withMaximumValue()
        Milestone milestone2012 = Milestone.createYearlyMilestone(name : "Milestone 2012", description : "Milestone Tahun 2012",
                startDate : firstDayOfYear, endDate : lastDayOfYear)
        Milestone milestone2012Q1 = Milestone.createQuarterlyMilestone(name : "Milestone 2012 Q1", description : "Milestone Tahun 2012. First Quarter.",
                startDate : firstDayOfYear, endDate : firstDayOfYear.plusMonths(3).minusDays(1))
        Milestone milestone2012Q2 = Milestone.createQuarterlyMilestone(name : "Milestone 2012 Q2", description : "Milestone Tahun 2012. Second Quarter.",
                startDate : firstDayOfYear.plusMonths(3), endDate : firstDayOfYear.plusMonths(6).minusDays(1))
        Milestone milestone2012Q3 = Milestone.createQuarterlyMilestone(name : "Milestone 2012 Q3", description : "Milestone Tahun 2012. Third Quarter.",
                startDate : firstDayOfYear.plusMonths(6), endDate : firstDayOfYear.plusMonths(9).minusDays(1))
        Milestone milestone2012Q4 = Milestone.createQuarterlyMilestone(name : "Milestone 2012 Q4", description : "Milestone Tahun 2012. Fourth Quarter.",
                startDate : firstDayOfYear.plusMonths(9), endDate : lastDayOfYear)


    }
}
