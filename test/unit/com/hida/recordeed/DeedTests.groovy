package com.hida.recordeed

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.apache.commons.lang.StringUtils

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Deed)
@Mock(Deed)
class DeedTests {

    /**
     * if  repeatedOnSpecificDay -> specificRepeatingDay must be set.
     */
    void testRepeatedOnSpecificDay() {
        Deed subh = new Deed(name: "subuh", description: "solat subuh", referenceTime: "Subuh")
        assert !StringUtils.equals(subh.referenceTime,ListOfValue.SUBH) &&  !subh.validate()

        subh.referenceTime = ListOfValue.SUBH
        subh.specificRepeatingDay = ListOfValue.DAILY
        assert subh.validate()

//        if  repeatedOnSpecificDay -> specificRepeatingDay must be set.
//        subh.repeatedOnSpecificDay = true
//        subh.specificRepeatingDay = null
//        assert !subh.validate()
    }

    void testSetupData() {
        // salat
        Deed maghribPrayer = new Deed(name: "Maghrib", description : "Solat Maghrib",
                referenceTime: ListOfValue.MAGRIB, specificRepeatingDay: ListOfValue.DAILY)
        maghribPrayer.save(flush : true, failOnError: true)
        Deed isyaPrayer = new Deed(name: "Isya", description : "Solat Isya",
                referenceTime: ListOfValue.ISYA, specificRepeatingDay: ListOfValue.DAILY)
        isyaPrayer.save(flush : true, failOnError: true)
        Deed subhPrayer = new Deed(name: "Subuh", description : "Solat Subuh",
                referenceTime: ListOfValue.SUBH, specificRepeatingDay: ListOfValue.DAILY)
        subhPrayer.save(flush : true, failOnError: true)
        Deed dzuhrPrayer = new Deed(name: "Dzuhur", description : "Solat Dzuhur",
                referenceTime: ListOfValue.DZUHR, specificRepeatingDay: ListOfValue.DAILY)
        dzuhrPrayer.save(flush : true, failOnError: true)
        Deed ashrPrayer = new Deed(name: "Ashar", description : "Solat Ashar",
                referenceTime: ListOfValue.ASHR, specificRepeatingDay: ListOfValue.DAILY)
        ashrPrayer.save(flush : true, failOnError: true)


        // puasa
        // must have some kind of info about the timing.
        // perhaps using command pattern
        Deed ramadhanFasting = new Deed(name :"Puasa Ramadhan", description: "Puasa wajib di Bulan Ramadhan")
        ramadhanFasting.save(flush : true, failOnError: true)

        // dzakat
        // not implemented yet

        // hajj
        // not implemented yet

        //-------------------------------------------------------------------------------------

        // solat sunnah (non-rawatib)
        // note rawatib will be included in  Deed Criteria
        // more sunnah prayers on next release.
        Deed qiyamulLayl = new Deed(name : "Salat Malam (Qiyamul Layl)", description: "Salat Malam (Qiyamul Layl)",
        referenceTime: ListOfValue.ISYA, specificRepeatingDay: ListOfValue.DAILY, allowOverride: true)
        qiyamulLayl.save(flush : true, failOnError: true)

        Deed dhuhaPrayer = new Deed(name : "Salat Dhuha", description: "Salat Dhuha", referenceTime: ListOfValue.SUBH,
        specificRepeatingDay: ListOfValue.DAILY, allowOverride: true)
        dhuhaPrayer.save(flush: true, failOnError: true)

        // puasa sunnah

        Deed mondayFasting = new Deed(name : "Puasa Senin Kamis (Hari Senin)", description: "Puasa Senin Kamis (Hari Senin)",
        referenceTime: ListOfValue.SUBH, specificRepeatingDay: ListOfValue.EVERY_MONDAY)
        mondayFasting.save(flush : true, failOnError: true)


        Deed thursdayFasting = new Deed(name : "Puasa Senin Kamis (Hari Kamis)", description: "Puasa Senin Kamis (Hari Kamis)",
                referenceTime: ListOfValue.SUBH, specificRepeatingDay: ListOfValue.EVERY_MONDAY)
        thursdayFasting.save(flush : true, failOnError: true)

        Deed daudFasting = new Deed(name :"Puasa Daud", description : "Puasa Daud. Sehari puasa, sehari berbuka",
        referenceTime: ListOfValue.SUBH, specificRepeatingDay: ListOfValue.ALTERNATE_DAY)
        daudFasting.save(flush:  true, failOnError: true)

        // shadaqah
        // lebih ke nominal.
        Deed shadaqah = new Deed(name : "Shadaqah", description : "Shadaqah yg bisa direpresentasikan dengan mata uang/alat tukar lainnya.",
                specificRepeatingDay: ListOfValue.DAILY, allowOverride: true)
        shadaqah.save(flush : true, failOnError: true)

        // qur'an
        // recommendednya daily. tp tiap orang kan bisa beda2. mungkin weekly. How?
        Deed qiraatQuran = new Deed(name : "Membaca Al Qur'an", description : "Mengaji Al Qur'an",
                specificRepeatingDay: ListOfValue.DAILY, allowOverride: true)
        qiraatQuran.save(flush : true, failOnError: true)

        Deed tahfidzQuran = new Deed(name :"Menghapal Al Qur'an", description: "Menghapal ayat (dan terjemah) Al Qur'an",
                specificRepeatingDay: ListOfValue.DAILY, allowOverride: true)
        tahfidzQuran.save(flush : true, failOnError: true)

        //olahraga
        Deed physicalExcercise = new Deed(name : "Olahraga", description : "Latihan fisik (Olahraga)",
                specificRepeatingDay: ListOfValue.DAILY, allowOverride: true)
        physicalExcercise.save(flush : true, failOnError: true)

    }

}
