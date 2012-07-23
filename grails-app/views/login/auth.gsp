<html>
<head>
	<meta name='layout' content='jQueryMobile'/>
	<title><g:message code="springSecurity.login.title"/></title>
</head>

<body>
<div data-role="page">
    <div data-role="header">
        <h1>
            <g:message code="springSecurity.login.header"/>
            %{--<g:message code="recordeed.welcome"/>--}%
        </h1>
    </div>

    <div data-role="content">
        <div data-role="controlgroup" data-type="horizontal">
        </div>
        <div class="ui-grid-a">
            <div class="ui-block-a">
                <a href="/recordeed/oauth/facebook/authenticate" rel="external" provider="facebook" data-role="button"  data-theme="b"  id="facebook-connect-link">Facebook</a>
            </div>
            <div class="ui-block-b">
                <a href="/recordeed/oauth/twitter/authenticate" rel="external" provider="twitter" data-role="button" data-theme="b"  id="twitter-connect-link">Twitter</a>
            </div>
        </div>
    </div>

    <div data-role="footer" data-theme="c">
        <p>&copy; 2012 - RecorDeed</p>
    </div>

</div>

%{--<div id='login'>--}%
	%{--<div class='inner'>--}%
		%{--<div class='fheader'><g:message code="springSecurity.login.header"/></div>--}%

		%{--<g:if test='${flash.message}'>--}%
			%{--<div class='login_message'>${flash.message}</div>--}%
		%{--</g:if>--}%

		%{--<form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>--}%
			%{--<p>--}%
				%{--<label for='username'><g:message code="springSecurity.login.username.label"/>:</label>--}%
				%{--<input type='text' class='text_' name='j_username' id='username'/>--}%
			%{--</p>--}%

			%{--<p>--}%
				%{--<label for='password'><g:message code="springSecurity.login.password.label"/>:</label>--}%
				%{--<input type='password' class='text_' name='j_password' id='password'/>--}%
			%{--</p>--}%

			%{--<p id="remember_me_holder">--}%
				%{--<input type='checkbox' class='chk' name='${rememberMeParameter}' id='remember_me' <g:if test='${hasCookie}'>checked='checked'</g:if>/>--}%
				%{--<label for='remember_me'><g:message code="springSecurity.login.remember.me.label"/></label>--}%
			%{--</p>--}%

			%{--<p>--}%
				%{--<input type='submit' id="submit" value='${message(code: "springSecurity.login.button")}'/>--}%
			%{--</p>--}%
            %{--<p>--}%
                %{--<a href="/oauth/twitter/authenticate" provider="twitter">Twitter</a>--}%
            %{--</p>--}%
		%{--</form>--}%
	%{--</div>--}%
%{--</div>--}%
%{--<script type='text/javascript'>--}%
	%{--<!----}%
	%{--(function() {--}%
		%{--document.forms['loginForm'].elements['j_username'].focus();--}%
	%{--})();--}%
	%{--// -->--}%
%{--</script>--}%
</body>
</html>
