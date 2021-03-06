import com.hida.recordeed.Deed
import com.hida.recordeed.Milestone
import com.recordeed.account.User
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.joda.time.LocalDate
import com.hida.recordeed.DeedCriteria
import com.hida.recordeed.SelectedDeed
import com.hida.recordeed.ListOfValue
import com.hida.recordeed.PersonalGoal

class BootStrap {
    def userService
    def init = { servletContext ->
        userService.createUserWithRole("admin","awesome", "ROLE_ADMIN")
        Milestone.createLunarMilestones(new LocalDate().year)
        ConfigurationHolder.config.app.defaultDeeds.each {
            println "default deed : ${it}"
            Deed deed = Deed.findByName(it.name)
            if(deed) deed.properties = it
            else deed = new Deed(it)
            deed.save(flush : true, failOnError: true)
            println "deed ${it.name} saved"
            if(it.defaultCriteria) {
                it.defaultCriteria.each {criteriaName ->
                    println "   deed criteria ${criteriaName}"
                    def criteriaConfig = ConfigurationHolder.config.app.defaultDeedCriteria[criteriaName]
                    DeedCriteria crt = DeedCriteria.findByDeedAndName(deed, criteriaName)
                    if(crt) {
                        // update?
                    } else {
                        deed.defineCriteria(criteriaName, criteriaConfig.description ).saveWithDescription(criteriaConfig.rating)
                    }
                }
            }
        }

//        User test = userService.createUserWithRole("test","test", "ROLE_USER")
//        userService.setupDeedPackages(test)

    }
    def destroy = {
    }
}
