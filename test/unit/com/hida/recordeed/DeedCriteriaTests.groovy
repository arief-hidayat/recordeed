package com.hida.recordeed



import grails.test.mixin.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DeedCriteria)
@Mock([Deed])
class DeedCriteriaTests {

    void testSomething() {
        Deed tahfidzQuran = new Deed(name :"Menghapal Al Qur'an", description: "Menghapal ayat (dan terjemah) Al Qur'an",
                specificRepeatingDay: ListOfValue.DAILY, allowOverride: true)
        tahfidzQuran.save(flush : true, failOnError: true)

        DeedCriteria cRemember = tahfidzQuran.defineCriteria("Daya Ingat", "Kemampuan mengingat ayat").saveWithDescription(
                0 : "Tidak ingat sama sekali",
                1 : "Ingat kurang dari 50%",
                2 : "Ingat 50% lebih tapi tidak sampe 100%",
                3 : "Ingat 100%",
        )
        assert cRemember.name && cRemember.description && cRemember.deed
        assert cRemember.ratingDescription0  && cRemember.ratingDescription1 && cRemember.ratingDescription3 && cRemember.ratingDescription5
        assert !cRemember.ratingDescription2 && !cRemember.ratingDescription4
    }
}
