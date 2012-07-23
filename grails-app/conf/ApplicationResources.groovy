modules = {
//    overrides {
//        jquery {
//            resource url : "js/jquery-1.7.2.min.js", linkOverride: "http://code.jquery.com/jquery-1.7.2.min.js", disposition: 'head'
//        }
//    }
    application {
        resource url:'js/application.js'
    }
    jQueryMobilResource {
        resource url:[dir:'css',file:'jquery.mobile-1.1.1.min.css'], linkOverride : "http://code.jquery.com/mobile/1.1.1/jquery.mobile-1.1.1.min.css"
    }
    otherResource {
        resource url:[dir:'css',file:'custom.css']
    }
    jQueryCDN {
        resource url : "js/jquery-1.7.2.min.js", linkOverride: "http://code.jquery.com/jquery-1.7.2.min.js", disposition: 'head'
    }
    mobileInit {
        resource url: "js/mobileinit.js", disposition: 'head'
        resource url: "js/ios-orientationchange-fix.min.js", disposition: 'head'
    }
    jQueryMobileCDN {
        resource url: "js/jquery.mobile-1.1.1.min.js", linkOverride: "http://code.jquery.com/mobile/1.1.1/jquery.mobile-1.1.1.min.js" , disposition: 'head'
    }
    otherMobileLib {
        resource url: "js/application.js", disposition: 'head'
        resource url: "js/bookmark_bubble.js", disposition: 'head'
        resource url: "js/jquery.cookie.js", disposition: 'head'
        resource url: "js/example.js", disposition: 'head'
    }
    images {
        resource url: [dir:'css/images',file:'icons-18-white.png']
        resource url: [dir:'css/images',file:'icons-18-black.png']
        resource url: [dir:'css/images',file:'icons-36-white.png']
        resource url: [dir:'css/images',file:'icons-36-black.png']
        resource url: [dir:'css/images',file:'ajax-loader.gif']
    }
}