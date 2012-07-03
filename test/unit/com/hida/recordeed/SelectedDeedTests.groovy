package com.hida.recordeed

import com.recordeed.account.User
import grails.test.mixin.TestFor
import org.joda.time.LocalDate
import grails.test.mixin.Mock
import com.recordeed.account.Role
import com.recordeed.account.UserRole

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(SelectedDeed)
@Mock([User, Role, UserRole, Milestone, PersonalGoal, Deed,SelectedDeed])
class SelectedDeedTests {

    void testSomething() {
        // create personal goal
        User.metaClass.'static'.encodePassword = {}
        User tester = User.retrieveOrCreateDefaultUser("budi", "ROLE_TESTER")
        Milestone ramadhanMs  = Milestone.createSpecialMilestone(name : "Milestone 2012 - Ramadhan", description : "Milestone Ramadhan Tahun 2012.",
                startDate : new LocalDate(2012,7,21), endDate : new LocalDate(2012,8,19))
        PersonalGoal goal = new PersonalGoal(user: tester, milestone: ramadhanMs, name : "My Ramadhan Goal (2012)", description: "My Ramadhan Goal (2012)")
        goal.actualStart = new LocalDate(2012,7,28)
        goal.save(flush: true, failOnError: true)

        //create deed
        Deed physicalExcercise = new Deed(name : "Olahraga", description : "Latihan fisik (Olahraga)",
                specificRepeatingDay: ListOfValue.DAILY, allowOverride: true)
        physicalExcercise.save(flush : true, failOnError: true)

        // want to swim. ideal target would be everyday. but beat it. you just don't have that luxury. Target min : 10 times a month.
        SelectedDeed swimmingPlan = SelectedDeed.create(goal, physicalExcercise,
                [name : "Berenang", description : "Berenang setiap minggu di NTU", quotaMode : ListOfValue.MONTHLY_QUOTA, minQuota: 10])

        // make sure it's overridden correctly.
        assert swimmingPlan
        assert swimmingPlan.overrideDeed
        assert swimmingPlan.name && swimmingPlan.description
        assertEquals(swimmingPlan.fromDate, goal.actualStart ?: goal.milestone.startDate)
        assertEquals(swimmingPlan.toDate, goal.milestone.endDate)
        assertEquals(swimmingPlan.quotaMode, ListOfValue.MONTHLY_QUOTA)
        assertEquals(swimmingPlan.minQuota, 10)
    }
}
