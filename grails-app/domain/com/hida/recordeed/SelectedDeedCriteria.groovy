package com.hida.recordeed


import org.apache.commons.lang.builder.HashCodeBuilder

class SelectedDeedCriteria implements Serializable {
    PersonalGoal personalGoal
    DeedCriteria deedCriteria

    boolean equals(other) {
        if (!(other instanceof SelectedDeedCriteria)) {
            return false
        }

        other.personalGoal?.id == personalGoal?.id &&
                other.deedCriteria?.id == deedCriteria?.id
    }

    int hashCode() {
        def builder = new HashCodeBuilder()
        if (personalGoal) builder.append(personalGoal.id)
        if (deedCriteria) builder.append(deedCriteria.id)
        builder.toHashCode()
    }

    static SelectedDeedCriteria get(long personalGoalId, long deedCriteriaId) {
        find 'from SelectedDeedCriteria where personalGoal.id=:personalGoalId and deedCriteria.id=:deedCriteriaId',
                [personalGoalId: personalGoalId, deedCriteriaId: deedCriteriaId]
    }

    def saveWithOverride(def params) {
        if(params.priorityMagnitude || params.ratingScale) params.overrideRatingScale = true
        int ratingScale = params.ratingScale ?: deedCriteria.ratingScale
        def index = Constant."INDEX_FOR_SCALE_${ratingScale}"
        for(int i=0;i<=ratingScale;i++) { this."ratingDescription${index[i]}" = params.get(i) }
        this.properties = params
        this.save(flush: true, failOnError: true)
    }

    static SelectedDeedCriteria create(PersonalGoal personalGoal, DeedCriteria deedCriteria, def params) {
        params.personalGoal = personalGoal
        params.deedCriteria= deedCriteria
        boolean flush = params.flush ?: false
        if(params.priorityMagnitude || params.ratingScale) params.overrideRatingScale = true
        int ratingScale = params.ratingScale ?: deedCriteria.ratingScale
        if(!params.overrideRatingScale) (0..ratingScale).each{if(params."ratingDescription${it}") params.overrideRatingScale  = true}
        new SelectedDeedCriteria(params).save(flush: flush, insert: true)
    }

    static boolean remove(PersonalGoal personalGoal, DeedCriteria deedCriteria, boolean flush = false) {
        SelectedDeedCriteria instance = SelectedDeedCriteria.findByPersonalGoalAndDeedCriteria(personalGoal, deedCriteria)
        if (!instance) {
            return false
        }

        instance.delete(flush: flush)
        true
    }

    static void removeAll(PersonalGoal personalGoal) {
        executeUpdate 'DELETE FROM SelectedDeedCriteria WHERE personalGoal=:personalGoal', [personalGoal: personalGoal]
    }

    static void removeAll(DeedCriteria deedCriteria) {
        executeUpdate 'DELETE FROM SelectedDeedCriteria WHERE deedCriteria=:deedCriteria', [deedCriteria: deedCriteria]
    }

    static mapping = {
        id composite: ['deedCriteria', 'personalGoal']
        version false
    }

    /**
     * overriding the value. only check if any one of override flags below is set.
     */
    boolean overrideRatingScale = false
    int priorityMagnitude = 100
    int ratingScale  = 5
    String ratingDescription0
    String ratingDescription1
    String ratingDescription2
    String ratingDescription3
    String ratingDescription4
    String ratingDescription5


    static constraints = {
        priorityMagnitude min: 1, max : 100
        ratingScale( inList : [1,3,5])
        //TODO: validation. if ratingScale 5 -> all mandatory, if ratingScale 3 -> only the odd numbered description is mandatory.
        ratingDescription0 nullable : true
        ratingDescription1 nullable : true
        ratingDescription2 nullable : true
        ratingDescription3 nullable : true
        ratingDescription4 nullable : true
        ratingDescription5 nullable : true
    }
}
