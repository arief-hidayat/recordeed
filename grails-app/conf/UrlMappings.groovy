class UrlMappings {

	static mappings = {
//        "/oauth/success"(controller: "login", action: "full")
        "/unauthorized"(controller: "login", action: "denied")
//        "/oauth/$provider/callback/"(controller: "springSecurityOAuth", action: "onSuccess")


        "/oauth/$provider/success/"(controller: "springSecurityOAuth", action: "onSuccess")
        "/oauth/$provider/callback/"(controller: "oauth", action: "callback")
        "/oauth/$provider/askToLinkOrCreateAccount" (controller: "oauth", action:"askToLinkOrCreateAccount")

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
