class BootStrap {
    def userService
    def init = { servletContext ->
        userService.createUserWithRole("admin","awesome", "ROLE_ADMIN")
        userService.createUserWithRole("test","test", "ROLE_USER")
    }
    def destroy = {
    }
}
