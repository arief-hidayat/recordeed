package com.hida.recordeed

import com.recordeed.account.Role
import com.recordeed.account.User
import com.recordeed.account.UserRole

class UserService {

    def createUserWithRole(String username, String password, String authority) {
        Role role = Role.findByAuthority(authority) ?: new Role(authority: authority)
        if(!role.id) role.save(flush : true)
        User user = new User(username : username, password : password).save(flush:  true)
        UserRole.create(user, role, true)
        user
    }
}
