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
@TestFor(SelectedDeedCriteria)
@Mock([User, Role, UserRole, Milestone, PersonalGoal, Deed, DeedCriteria,SelectedDeedCriteria])
class SelectedDeedCriteriaTests {

    void testSomething() {
        // create personal goal
        User.metaClass.'static'.encodePassword = {}
        User tester = User.retrieveOrCreateDefaultUser("budi", "ROLE_TESTER")
        Milestone ramadhanMs  = Milestone.createSpecialMilestone(name : "Milestone 2012 - Ramadhan", description : "Milestone Ramadhan Tahun 2012.",
                startDate : new LocalDate(2012,7,21), endDate : new LocalDate(2012,8,19))
        PersonalGoal goal = new PersonalGoal(user: tester, milestone: ramadhanMs, name : "My Ramadhan Goal (2012)", description: "My Ramadhan Goal (2012)")
        goal.actualStart = new LocalDate(2012,7,28)
        goal.save(flush: true, failOnError: true)

        //create deed & criteria
        Deed tahfidzQuran = new Deed(name :"Menghapal Al Qur'an", description: "Menghapal ayat (dan terjemah) Al Qur'an",
                specificRepeatingDay: ListOfValue.DAILY, allowOverride: true)
        tahfidzQuran.save(flush : true, failOnError: true)

        DeedCriteria cRemember = tahfidzQuran.defineCriteria("Daya Ingat", "Kemampuan mengingat ayat").saveWithDescription(
                0 : "Tidak ingat sama sekali",
                1 : "Ingat kurang dari 50%",
                2 : "Ingat 50% lebih tapi tidak sampe 100%",
                3 : "Ingat 100%",
        )

        SelectedDeedCriteria myCriteria = goal.prepareDeedCriteria(cRemember).saveWithOverride(
                priorityMagnitude : 90, ratingScale : 1,
                0: "Tidak Hapal",
                1: "Hapal"
        )

        assert myCriteria.overrideRatingScale
        assert myCriteria.ratingDescription0   && myCriteria.ratingDescription5
        assert !myCriteria.ratingDescription2 && !myCriteria.ratingDescription4  && !myCriteria.ratingDescription1 && !myCriteria.ratingDescription3


    }
}
