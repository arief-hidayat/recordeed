package com.hida.recordeed

import com.recordeed.account.Role
import com.recordeed.account.User
import com.recordeed.account.UserRole
import org.joda.time.LocalDate
import org.codehaus.groovy.grails.commons.ConfigurationHolder

class UserService {

    def createUserWithRole(String username, String password, String authority) {
        Role role = Role.findByAuthority(authority) ?: new Role(authority: authority)
        if(!role.id) role.save(flush : true)
        User user = new User(username : username, password : password, enabled: true).save(flush:  true)
        UserRole.create(user, role, true)
        user
    }

    def createPersonalGoal(User user, String milestoneName, LocalDate actualStart = null) {
        Milestone ms = Milestone.findByName(milestoneName)
        if(ms) {
            PersonalGoal goal = new PersonalGoal(user: user, milestone: ms,
                    name : "My Goal [${milestoneName}]", description: "My Goal [${milestoneName}]", actualStart : actualStart)
            goal.save(flush: true, failOnError: true)
        }
    }
    def setupDeedPackages(User user) {
        PersonalGoal myGoal = createPersonalGoal(user, "Ramadhan-2012", null)
        ["Maghrib", "Isya", "Subuh", "Dzuhur", "Ashar"].each { myGoal.selectDeedForPersonalGoal(it); selectDefaultCriteria(myGoal, it) }
        myGoal.selectDeedForPersonalGoal("PuasaRamadhan", [specificRepeatingDay : ListOfValue.DAILY])  // override for this milestone (it's daily)
        myGoal.selectDeedForPersonalGoal("Olahraga", [description : "Jogging", quotaMode : ListOfValue.WEEKLY_QUOTA, minQuota: 1])
        myGoal.selectDeedForPersonalGoal("SalatMalam", [quotaMode : ListOfValue.WEEKLY_QUOTA, minQuota: 6])
        myGoal.selectDeedForPersonalGoal("SalatDhuha", [quotaMode : ListOfValue.WEEKLY_QUOTA, minQuota: 3])
        myGoal.selectDeedForPersonalGoal("BacaQuran")
        myGoal.selectDeedForPersonalGoal("TadaburQuran", [quotaMode : ListOfValue.WEEKLY_QUOTA, minQuota: 3]) // tiap sesi 2 jam.
        myGoal.selectDeedForPersonalGoal("HapalQuran", [quotaMode : ListOfValue.WEEKLY_QUOTA, minQuota: 3])  // tiap sesi ` jam
        ["PuasaRamadhan", "Olahraga","SalatMalam","SalatDhuha","BacaQuran","TadaburQuran", "HapalQuran"].each{ selectDefaultCriteria(myGoal, it) }
    }
    private static defaultCriteriaMap = [:]
    def selectDefaultCriteria(PersonalGoal goal , String deedName) {
        println "selectDefaultCriteria for ${deedName}"
        if(!defaultCriteriaMap) ConfigurationHolder.config.app.defaultDeeds.each { it -> defaultCriteriaMap[it.name] = it.defaultCriteria ?: []}
        def criteriaNames = defaultCriteriaMap[deedName] ?: []
        if(!criteriaNames.isEmpty()) {
            Deed deed = Deed.findByName(deedName)
            criteriaNames.each {
                DeedCriteria crt = DeedCriteria.findByDeedAndName(deed, it)
                if(crt) { goal.prepareDeedCriteria(crt).save(flush : true, failOnError: true) // no saveWithOverride here.
                } else {println "deed's criteriaName ${it} not found."}
            }
        }
    }
}
