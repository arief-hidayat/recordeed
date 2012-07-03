package com.hida.recordeed

import com.recordeed.account.Role
import com.recordeed.account.User
import com.recordeed.account.UserRole
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.joda.time.LocalDate

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(PersonalGoal)
@Mock([User, Role, UserRole, Milestone])
class PersonalGoalTests {

    void testRamadhanGoal() {
        User.metaClass.'static'.encodePassword = {}
        User tester = User.retrieveOrCreateDefaultUser("budi", "ROLE_TESTER")
        Milestone ramadhanMs  = Milestone.createSpecialMilestone(name : "Milestone 2012 - Ramadhan", description : "Milestone Ramadhan Tahun 2012.",
                startDate : new LocalDate(2012,7,21), endDate : new LocalDate(2012,8,19))
        PersonalGoal goal = new PersonalGoal(user: tester, milestone: ramadhanMs, name : "My Ramadhan Goal (2012)", description: "My Ramadhan Goal (2012)")
        goal.save(flush: true, failOnError: true)

        goal.actualStart = new LocalDate(2012,7,21)
        goal.save(flush: true, failOnError: true)
    }
}
