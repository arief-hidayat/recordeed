class UrlMappings {

	static mappings = {
        "/unauthorized"(controller: "login", action: "denied")


        "/oauth/$provider/success/"(controller: "springSecurityOAuth", action: "onSuccess")
        "/oauth/$provider/callback/"(controller: "oauth", action: "callback") // can  commented this out.
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
