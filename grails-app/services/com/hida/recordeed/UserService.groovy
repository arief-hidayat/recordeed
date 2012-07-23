package com.hida.recordeed

import com.recordeed.account.Role
import com.recordeed.account.User
import com.recordeed.account.UserRole
import org.joda.time.LocalDate

class UserService {

    def createUserWithRole(String username, String password, String authority) {
        Role role = Role.findByAuthority(authority) ?: new Role(authority: authority)
        if(!role.id) role.save(flush : true)
        User user = new User(username : username, password : password).save(flush:  true)
        UserRole.create(user, role, true)
        user
    }

    def createPersonalGoal(User user, String milestoneName, LocalDate actualStart) {
        Milestone ms = Milestone.findByName(milestoneName)
        if(ms) {
            PersonalGoal goal = new PersonalGoal(user: user, milestone: ms,
                    name : "My Goal [${milestoneName}]", description: "My Goal [${milestoneName}]", actualStart : actualStart)
            goal.save(flush: true, failOnError: true)

        }
    }
    def selectDeedForMilestone(User user, PersonalGoal personalGoal, Deed deed) {

    }
}
