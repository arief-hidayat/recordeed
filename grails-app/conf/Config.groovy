import org.scribe.builder.api.TwitterApi
import org.scribe.builder.api.FacebookApi
import com.hida.recordeed.ListOfValue

// locations to search for config files that get merged into the main config
// config files can either be Java properties files or ConfigSlurper scripts

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.config.locations = ["file:${userHome}/.grails/social-network-config.groovy"]


grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [ html: ['text/html','application/xhtml+xml'],
                      xml: ['text/xml', 'application/xml'],
                      text: 'text/plain',
                      js: 'text/javascript',
                      rss: 'application/rss+xml',
                      atom: 'application/atom+xml',
                      css: 'text/css',
                      csv: 'text/csv',
                      all: '*/*',
                      json: ['application/json','text/json'],
                      form: 'application/x-www-form-urlencoded',
                      multipartForm: 'multipart/form-data'
                    ]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']


// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// enable query caching by default
grails.hibernate.cache.queries = true

// set per-environment serverURL stem for creating absolute links
environments {
    development {
        grails.logging.jul.usebridge = true
    }
    production {
        grails.logging.jul.usebridge = false
        // TODO: grails.serverURL = "http://www.changeme.com"
    }
}

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
           'org.codehaus.groovy.grails.web.pages', //  GSP
           'org.codehaus.groovy.grails.web.sitemesh', //  layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping', // URL mapping
           'org.codehaus.groovy.grails.commons', // core / classloading
           'org.codehaus.groovy.grails.plugins', // plugins
           'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}

// Added by the Spring Security Core plugin:
grails.plugins.springsecurity.userLookup.userDomainClassName = 'com.recordeed.account.User'
grails.plugins.springsecurity.userLookup.authorityJoinClassName = 'com.recordeed.account.UserRole'
grails.plugins.springsecurity.authority.className = 'com.recordeed.account.Role'


cucumber {
    features = [
            "test/functional/features"
    ]
    glue = [
            "test/functional/steps",
            "test/functional/hooks"
    ]
}

// Added by the Joda-Time plugin:
grails.gorm.default.mapping = {
	"user-type" type: org.joda.time.contrib.hibernate.PersistentDateTime, class: org.joda.time.DateTime
	"user-type" type: org.joda.time.contrib.hibernate.PersistentDuration, class: org.joda.time.Duration
	"user-type" type: org.joda.time.contrib.hibernate.PersistentInstant, class: org.joda.time.Instant
	"user-type" type: org.joda.time.contrib.hibernate.PersistentInterval, class: org.joda.time.Interval
	"user-type" type: org.joda.time.contrib.hibernate.PersistentLocalDate, class: org.joda.time.LocalDate
	"user-type" type: org.joda.time.contrib.hibernate.PersistentLocalTimeAsString, class: org.joda.time.LocalTime
	"user-type" type: org.joda.time.contrib.hibernate.PersistentLocalDateTime, class: org.joda.time.LocalDateTime
	"user-type" type: org.joda.time.contrib.hibernate.PersistentPeriod, class: org.joda.time.Period
}
grails.gorm.default.failOnError = true

oauth {
    providers {
        twitter {
            api = TwitterApi
            successUri = "http://127.0.0.1:8080/recordeed/oauth/twitter/success"
            failureUri = "/unauthorized"
            callback = "http://127.0.0.1:8080/recordeed/oauth/twitter/callback"
        }

        facebook {
            api = FacebookApi
            successUri = "http://localhost:8080/recordeed/oauth/facebook/success"
            failureUri = "/unauthorized"
            callback = "http://localhost:8080/recordeed/oauth/facebook/callback"
        }

    }
    registration.askToLinkOrCreateAccountUri = "askToLinkOrCreateAccount"
    debug = true
    connectTimeout = 5000
    receiveTimeout = 5000
}

// Added by the Spring Security OAuth plugin:
grails.plugins.springsecurity.oauth.domainClass = 'com.recordeed.account.OAuthID'

//grails.serverURL = "www.recordeed.com"

converter.dateFormat = "dd/MM/yyyy"
app.lunarCalendars = [
        2012 : [
                "Ramadhan" : [ startDate : "21/07/2012", endDate : "18/08/2012"]
        ]
]

app.defaultDeeds = [
        [name: "Maghrib", description : "Solat Maghrib",
                referenceTime: ListOfValue.MAGRIB, specificRepeatingDay: ListOfValue.DAILY, defaultCriteria : ["KetepatanWaktu", "Jamaah", "Rawatib", "KualitasSalat", "Dzikr&Doa"]],
        [name: "Isya", description : "Solat Isya",
                referenceTime: ListOfValue.ISYA, specificRepeatingDay: ListOfValue.DAILY, defaultCriteria : ["KetepatanWaktu", "Jamaah", "Rawatib", "KualitasSalat", "Dzikr&Doa"]],
        [name: "Subuh", description : "Solat Subuh",
                referenceTime: ListOfValue.SUBH, specificRepeatingDay: ListOfValue.DAILY, defaultCriteria : ["KetepatanWaktu", "Jamaah", "Rawatib", "KualitasSalat", "Dzikr&Doa"]],
        [name: "Dzuhur", description : "Solat Dzuhur",
                referenceTime: ListOfValue.DZUHR, specificRepeatingDay: ListOfValue.DAILY, defaultCriteria : ["KetepatanWaktu", "Jamaah", "Rawatib", "KualitasSalat", "Dzikr&Doa"]],
        [name: "Ashar", description : "Solat Ashar",
                referenceTime: ListOfValue.ASHR, specificRepeatingDay: ListOfValue.DAILY, defaultCriteria : ["KetepatanWaktu", "Jamaah", "Rawatib", "KualitasSalat", "Dzikr&Doa"]],
        [name :"PuasaRamadhan", description: "Puasa wajib di Bulan Ramadhan", defaultCriteria: ["KualitasPuasa"]],
        [name : "SalatMalam", description: "Salat Malam (Qiyamul Layl)",
                referenceTime: ListOfValue.ISYA, specificRepeatingDay: ListOfValue.DAILY, allowOverride: true, defaultCriteria: ["KualitasSalat"]],
        [name : "SalatDhuha", description: "Salat Dhuha", referenceTime: ListOfValue.SUBH,
                specificRepeatingDay: ListOfValue.DAILY, allowOverride: true, defaultCriteria: ["KualitasSalat"]],
        [name : "PuasaSenin", description: "Puasa Senin Kamis (Hari Senin)",
                referenceTime: ListOfValue.SUBH, specificRepeatingDay: ListOfValue.EVERY_MONDAY, defaultCriteria: ["KualitasPuasa"]],
        [name : "PuasaKamis", description: "Puasa Senin Kamis (Hari Kamis)",
                referenceTime: ListOfValue.SUBH, specificRepeatingDay: ListOfValue.EVERY_MONDAY, defaultCriteria: ["KualitasPuasa"]],
        [name :"PuasaDaud", description : "Puasa Daud. Sehari puasa, sehari berbuka",
                referenceTime: ListOfValue.SUBH, specificRepeatingDay: ListOfValue.ALTERNATE_DAY, defaultCriteria: ["KualitasPuasa"]],
//        [name : "Shadaqah", description : "Shadaqah yg bisa direpresentasikan dengan mata uang/alat tukar lainnya.",
//                specificRepeatingDay: ListOfValue.DAILY, allowOverride: true],
        [name : "BacaQuran", description : "Mengaji Al Qur'an", specificRepeatingDay: ListOfValue.DAILY, allowOverride: true, defaultCriteria: ["KriteriaUmum"]],
        [name : "TadaburQuran", description : "Mentadaburi Al Qur'an", specificRepeatingDay: ListOfValue.DAILY, allowOverride: true, defaultCriteria: ["KriteriaUmum"]],
        [name :"HapalQuran", description: "Menghapal ayat (dan terjemah) Al Qur'an", specificRepeatingDay: ListOfValue.DAILY, allowOverride: true, defaultCriteria: ["KriteriaUmum"]],
        [name : "Olahraga", description : "Latihan fisik (Olahraga)", specificRepeatingDay: ListOfValue.DAILY, allowOverride: true, defaultCriteria: ["KriteriaUmum"]],
        [name : "AmalanLain", description : "Amalan Lain", specificRepeatingDay: ListOfValue.DAILY, allowOverride: true, defaultCriteria: ["KriteriaUmum"]]
]

app.defaultDeedCriteria = [
        "KetepatanWaktu" : [ description : "Ketepatan Waktu", rating : [
                0 : "Tidak mengerjakan pada waktunya",
                1 : "Dikerjakan 15 menit akhir waktu",
                2 : "Dikerjakan antara 15 menit setelah adzan hingga 15 menit sblm akhir waktu" ,
                3 : "Dikerjakan paling lambat 15 menit setelah adzan"
        ]],
        "Jamaah": [description : "Berjamaah", rating: [
                0 : "Tidak berjamaah",
                1 : "Berjamaah"
        ]], "Rawatib" : [description : "Salat sunnah rawatib", rating: [
                0 : "Tidak dikerjakan",
                1 : "Dikerjakan"
        ]], "KualitasSalat" : [description: "Kualitas salat (pelaksanaan rukun salat & kekhusyukan)", rating: [
                0 : "Ada rukun yang dilanggar (misalnya tidak tuma'ninah).",
                1 : "Rukun sempurna tetapi tidak khusyuk (parah)",
                2 : "Rukun sempurna tetapi sedikit tidak khusyuk",
                3 : "Rukun sempurna dan kekhusyukan memenuhi standar pribadi"
        ]], "Dzikr&Doa" : [description : "Dzikir dan doa setelah salat", rating: [
                0 : "Tidak dikerjakan",
                1 : "Dikerjakan"
        ]], "KualitasPuasa" : [description: "Kualitas puasa (pelaksanaan rukun puasa)", rating: [
                0 : "Ada rukun & syarat sah yang dilanggar.",
                1 : "Rukun sempurna dan memenuhi standar pribadi"
        ]],  "KualitasPelaksanaan" : [description: "Kualitas pelaksanaan", rating: [
                0 : "Tidak memenuhi target",
                1 : "Memenuhi target"
        ]],  "KriteriaUmum" : [description: "Pelaksanaan", rating: [
                0 : "Tidak dikerjakan",
                1 : "Dikerjakan"
        ]],
]

app.defaultSelectedDeed = [
        "Ramadhan-2012" : []
]
