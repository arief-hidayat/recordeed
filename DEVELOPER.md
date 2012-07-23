# Development Environment

My development environments:

* JDK 1.7
* Grails 2.1.0
* Git
* IntelliJ IDEA (should be able to be replaced by SpringSource TS)


# Testing

Testing tools are mostly from Grails plugins:

* jUnit & Spock (for unit test)
* Cucumber (for functional test)
* Node + Cucumber-js (for testing cucumber)

# Development Road Map

Note that this might changed drastically over the time during initial stage.

This application will be focus more on mobile web application.
As we think, that normal users would be less attracted to use desktop to update the <code>recorDeed</code> frequently.

The technology that are currently used is jQuery Mobile. The decision is not fixed yet.We might see later how it goes.

## Version 1.0
Online Mobile application. Plan to use: jQuery Mobile connected to Grails backend server (server-side template)

v1.0:

* Integration with social media like facebook and twitter. Only for login and registration.
* Auto creation of personal goal. All selected deed and criteria will be predefined.
* Enable user to record their rating for every deeds selected.

v1.1:
* Enable personalization on goal. Change description and set of deed he/she wants to focus on.
* Enable user to see simple report on his performance.

v1.2:
* Enable personalization on rating system for each criteria.
* First enhancement of performance report


## Version 2.0
Change to hybrid mobile application with online - offline capabilities. When user unable to connect to internet,
the data will be persisted in it's own browser. Later it will be pushed to backend server when it's online.
We might probably switch to native apps environment. We'll see it later.

## Version 3.0
Enable server push for any kind of notification.



