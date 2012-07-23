package com.hida.recordeed

import org.apache.commons.lang.StringUtils
import org.apache.commons.lang.builder.HashCodeBuilder
import org.joda.time.LocalDate

class SelectedDeed implements Serializable {
    PersonalGoal personalGoal
    Deed deed

    String quotaMode
    int minQuota  = 1

    // auto filled from milestone
    LocalDate fromDate
    LocalDate toDate

    // allow override.  copy from Deed but all nullable.
    boolean overrideDeed = false
    String name
    String description
    String referenceTime
    String specificRepeatingDay



    static constraints = {
        quotaMode nullable : true, inList : ListOfValue.QUOTA_MODES, validator : {
            val, obj -> !StringUtils.equals(val, ListOfValue.CUSTOM_PERIOD_QUOTA) || (obj.toDate && obj.fromDate)
        }
        minQuota min : 1
        //TODO: must be within the milestone period.
        fromDate nullable: true
        toDate nullable : true


        name  nullable : true
        description nullable: true
        referenceTime nullable : true, inList : ListOfValue.PRAYER_TIMES
        specificRepeatingDay nullable : true, inList: ListOfValue.REPEATING_DAYS
    }

    boolean equals(other) {
        if (!(other instanceof SelectedDeed)) {
            return false
        }

        other.personalGoal?.id == personalGoal?.id &&
                other.deed?.id == deed?.id
    }

    int hashCode() {
        def builder = new HashCodeBuilder()
        if (personalGoal) builder.append(personalGoal.id)
        if (deed) builder.append(deed.id)
        builder.toHashCode()
    }

    static SelectedDeed get(long personalGoalId, long deedId) {
        find 'from SelectedDeed where personalGoal.id=:personalGoalId and deed.id=:deedId',
                [personalGoalId: personalGoalId, deedId: deedId]
    }

    static SelectedDeed create(PersonalGoal personalGoal, Deed deed, def params = [:]) {
        params.personalGoal = personalGoal
        params.deed = deed
        if(!params.fromDate) params.fromDate = (personalGoal.actualStart ?: personalGoal.milestone.startDate)
        if(!params.toDate) params.toDate = personalGoal.milestone.endDate
        if( params.name || params.description || params.referenceTime || params.specificRepeatingDay) params.overrideDeed = true
        def flush = params.flush ?: false
        new SelectedDeed(params).save(flush: flush, insert: true)
    }

    static boolean remove(PersonalGoal personalGoal, Deed deed, boolean flush = false) {
        SelectedDeed instance = SelectedDeed.findByPersonalGoalAndDeed(personalGoal, deed)
        if (!instance) {
            return false
        }

        instance.delete(flush: flush)
        true
    }

    static void removeAll(PersonalGoal personalGoal) {
        executeUpdate 'DELETE FROM SelectedDeed WHERE personalGoal=:personalGoal', [personalGoal: personalGoal]
    }

    static void removeAll(Deed deed) {
        executeUpdate 'DELETE FROM SelectedDeed WHERE deed=:deed', [deed: deed]
    }

    static mapping = {
        id composite: ['deed', 'personalGoal']
        version false
    }

}
