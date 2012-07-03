package com.recordeed.account

class User {

	transient springSecurityService

	String username
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

    static User retrieveOrCreateDefaultUser(String username, String roleName) {
        User user = User.findByUsername(username)
        if(user) return user
        user = new User(username : username, password : "123", enable : true, accountExpired: false, accountLocked: false, passwordExpired: false )
        user.save(flush : true)
        Role role = Role.findOrCreateWhere(authority: roleName)
        UserRole.create(user, role, true)
        return user
    }

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
