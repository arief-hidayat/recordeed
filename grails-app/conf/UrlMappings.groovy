class UrlMappings {

	static mappings = {
        "/oauth/success"(controller: "login", action: "full")
        "/unauthorized"(controller: "login", action: "denied")
//        "/oauth/$provider/callback/"(controller: "oauth", action: "callback")
//        "/linkOrCreateAcct"(controller: "springSecurityOAuthToken", action: "askToLinkOrCreateAccount")
        "/oauth/$provider/callback/"(controller: "springSecurityOAuth", action: "onSuccess")

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
