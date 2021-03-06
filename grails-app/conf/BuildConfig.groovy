grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.7
grails.project.source.level = 1.7
//grails.project.war.file = "target/${appName}-${appVersion}.war"
//Will remove the OSGi headers from the WAR file which is what is confusing JBoss 7
grails.project.war.osgi.headers=false

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenCentral()

        // uncomment these to enable remote dependency resolution from public Maven repositories
        //mavenCentral()
        //mavenLocal()
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        runtime 'mysql:mysql-connector-java:5.1.20'

        // JBoss bug
//        runtime 'org.springframework.social:spring-social-facebook-web:1.0.1.RELEASE'

        compile("joda-time:joda-time-hibernate:1.3") {
            excludes "joda-time", "hibernate"
        }
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.7.1"
        runtime ":resources:1.1.6"
        compile ':cloud-foundry:1.2.2'
//        compile ":angular-scaffolding:1.0-SNAPSHOT"


        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"
        compile ":joda-time:1.4"
        compile ":spring-security-core:1.2.7.3"
        compile ":oauth:2.0.1"
        compile ":spring-security-oauth:2.0.1.1"
//        compile ":facebook-graph:0.14"
        compile ":taggable:1.0.1"
        test ":spock:0.6"
        test ":cucumber:0.6.0"
        compile ":jmesa:2.0.4-SNAPSHOT-0.1"


        build ":tomcat:$grailsVersion"
    }
}
// please set the following in your $HOME/.grails/settings.groovy
//grails.plugin.cloudfoundry.username = 'your.email@server.com'
//grails.plugin.cloudfoundry.password = 's3kr3t'

// domain : recordeed.cloudfoundry.me. configuration token: will-some-with
