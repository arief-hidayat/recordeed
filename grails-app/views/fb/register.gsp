<!doctype html>
<html>
<head>
    <title>Registration</title>
    <meta name="layout" content="main">
</head>
<body>
%{--https://localhost:8443/recordeed/fb/registration--}%
    <iframe src="https://www.facebook.com/plugins/registration?
                 client_id=382536498462959&
                 redirect_uri=https://localhost:8443/recordeed/fb/registration&
                 fields=name,gender,location,email,password"
            scrolling="auto"
            frameborder="no"
            style="border:none"
            allowTransparency="true"
            width="100%"
            height="330">
    </iframe>
</body>
</html>