package com.hida.recordeed

class DeedService {

    def createDeed() {

    }

    def deleteDeed(Deed item, boolean force) {
        if(force) {
            //remove all link
            DeedCriteria.findByDeed(item)*.delete(flush : true)
            SelectedDeed.findAllByDeed(item).each { removeSelectedDeed(it) }
        }
        item.delete(flush: true)
    }

    def deletePersonalGoal(PersonalGoal item, boolean force) {
        if(force) {
            SelectedDeed.findAllByPersonalGoal(item).each { removeSelectedDeed(it) }
        }
        item.delete(flush : true)
    }

    /**
     * remove all SelectedDeedCriteria under a selectedDeed. then remove the selectedDeed itself.
     * @param item
     */
    def removeSelectedDeed(SelectedDeed item) {
        iterateOnSelectedDeedCriteria(item) { list, selCriteria -> selCriteria.delete( flush : true) }
        item.delete(flush : true)
    }

    def iterateOnSelectedDeedCriteria(SelectedDeed item, Closure callback) {
        PersonalGoal goal = item.personalGoal
        def allCriteria = DeedCriteria.findAllByDeed(item.deed)
        if(allCriteria.isEmpty()) return allCriteria
        def selectedCriteriaList = []
        if(goal) {
            for(DeedCriteria dc : allCriteria) {
                def selCriteria = SelectedDeedCriteria.get(goal.id, dc.id)
                if(selCriteria) callback(selectedCriteriaList,  selCriteria)
            }
        } else {
            for(DeedCriteria dc : allCriteria) {
                def selCriteria = SelectedDeedCriteria.findAllByDeedCriteria(dc)
                selCriteria.each { it -> callback(selectedCriteriaList,  it)}
            }
        }
        return selectedCriteriaList
    }

    def findSelectedDeedCriteria(SelectedDeed item) {
        iterateOnSelectedDeedCriteria(item) { list, selCriteria -> list << selCriteria }
    }


}
