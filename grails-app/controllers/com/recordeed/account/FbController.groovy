package com.recordeed.account

class FbController {
    def userService
    def register() {

    }
    def registration = {
        println "FB registration ${params}"
        def regData = params.registration
        if(regData) {
            def username = "${regData.email}"
            User user = User.findByUsername(username)
            if(user) {
            } else {
                user = userService.createUserWithRole(username, regData.password, "ROLE_USER")
                user.displayName = regData.name
                user.gender = regData.gender
//                user.locationName =regData.location?.name
//                user.locationId = regData.location?.id
                user.save()
            }
        }
        redirect uri : "/"
    }
}
