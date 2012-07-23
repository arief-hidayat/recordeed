<head>
    <meta name='layout' content='jQueryMobile'/>
    <title>Create or Link Account</title>
</head>

<body>
<div data-role="page">
    <div data-role="header">
        <h1>Create or Link Account
        </h1>
    </div>

    <div data-role="content">
        <div class="ui-body ui-body-b">
            <g:form action="createAccount" method="post" autocomplete="off">
                <fieldset>
                    <legend><g:message code="springSecurity.oauth.registration.create.legend" default="Create a new account"/></legend>
                    <div class="fieldcontain ${hasErrors(bean: createAccountCommand, field: 'username', 'error')} ">
                        <label for='username'><g:message code="OAuthCreateAccountCommand.username.label" default="Username"/>:</label>
                        <g:textField name='username' value='${createAccountCommand?.username}'/>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: createAccountCommand, field: 'password1', 'error')} ">
                        <label for='password1'><g:message code="OAuthCreateAccountCommand.password1.label" default="Password"/>:</label>
                        <g:passwordField name='password1' value='${createAccountCommand?.password1}'/>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: createAccountCommand, field: 'password2', 'error')} ">
                        <label for='password2'><g:message code="OAuthCreateAccountCommand.password2.label" default="Password re-type"/>:</label>
                        <g:passwordField name='password2' value='${createAccountCommand?.password2}'/>
                    </div>
                    <g:submitButton name="${message(code: 'springSecurity.oauth.registration.create.button', default: 'Create')}"/>
                </fieldset>
            </g:form>
        </div>
        <div class="ui-body ui-body-b">
            <g:form action="linkAccount" method="post" autocomplete="off">
                <fieldset>
                    <legend><g:message code="springSecurity.oauth.registration.login.legend" default="Link to an existing account"/></legend>
                    <div class="fieldcontain ${hasErrors(bean: linkAccountCommand, field: 'username', 'error')} ">
                        <label for='username'><g:message code="OAuthLinkAccountCommand.username.label" default="Username"/>:</label>
                        <g:textField name='username' value='${linkAccountCommand?.username}'/>
                    </div>
                    <div class="fieldcontain ${hasErrors(bean: linkAccountCommand, field: 'password', 'error')} ">
                        <label for='password'><g:message code="OAuthLinkAccountCommand.password.label" default="Password"/>:</label>
                        <g:passwordField name='password' value='${linkAccountCommand?.password}'/>
                    </div>
                    <g:submitButton name="${message(code: 'springSecurity.oauth.registration.login.button', default: 'Login')}"/>
                </fieldset>
            </g:form>
        </div>

        %{--<br/>--}%


        <br/>

        <g:link controller="login" action="auth"><g:message code="springSecurity.oauth.registration.back" default="Back to login page"/></g:link>
    </div>

    <div data-role="footer" data-theme="c">
        <p>&copy; 2012 - RecorDeed</p>
    </div>

</div>


%{--<div class='body' style="padding: 15px;">--}%
    %{--<g:if test='${flash.error}'>--}%
        %{--<div class="errors">${flash.error}</div>--}%
    %{--</g:if>--}%

    %{--<h4><g:message code="springSecurity.oauth.registration.link.not.exists" default="No user was found with this account." args="[session.springSecurityOAuthToken.providerName]"/></h4>--}%
    %{--<br/>--}%

    %{--<g:hasErrors bean="${createAccountCommand}">--}%
        %{--<div class="errors">--}%
            %{--<g:renderErrors bean="${createAccountCommand}" as="list"/>--}%
        %{--</div>--}%
    %{--</g:hasErrors>--}%

    %{--<g:form action="createAccount" method="post" autocomplete="off">--}%
        %{--<fieldset>--}%
            %{--<legend><g:message code="springSecurity.oauth.registration.create.legend" default="Create a new account"/></legend>--}%
            %{--<div class="fieldcontain ${hasErrors(bean: createAccountCommand, field: 'username', 'error')} ">--}%
                %{--<label for='username'><g:message code="OAuthCreateAccountCommand.username.label" default="Username"/>:</label>--}%
                %{--<g:textField name='username' value='${createAccountCommand?.username}'/>--}%
            %{--</div>--}%
            %{--<div class="fieldcontain ${hasErrors(bean: createAccountCommand, field: 'password1', 'error')} ">--}%
                %{--<label for='password1'><g:message code="OAuthCreateAccountCommand.password1.label" default="Password"/>:</label>--}%
                %{--<g:passwordField name='password1' value='${createAccountCommand?.password1}'/>--}%
            %{--</div>--}%
            %{--<div class="fieldcontain ${hasErrors(bean: createAccountCommand, field: 'password2', 'error')} ">--}%
                %{--<label for='password2'><g:message code="OAuthCreateAccountCommand.password2.label" default="Password re-type"/>:</label>--}%
                %{--<g:passwordField name='password2' value='${createAccountCommand?.password2}'/>--}%
            %{--</div>--}%
            %{--<g:submitButton name="${message(code: 'springSecurity.oauth.registration.create.button', default: 'Create')}"/>--}%
        %{--</fieldset>--}%
    %{--</g:form>--}%

    %{--<br/>--}%

    %{--<g:hasErrors bean="${linkAccountCommand}">--}%
        %{--<div class="errors">--}%
            %{--<g:renderErrors bean="${linkAccountCommand}" as="list"/>--}%
        %{--</div>--}%
    %{--</g:hasErrors>--}%

    %{--<g:form action="linkAccount" method="post" autocomplete="off">--}%
        %{--<fieldset>--}%
            %{--<legend><g:message code="springSecurity.oauth.registration.login.legend" default="Link to an existing account"/></legend>--}%
            %{--<div class="fieldcontain ${hasErrors(bean: linkAccountCommand, field: 'username', 'error')} ">--}%
                %{--<label for='username'><g:message code="OAuthLinkAccountCommand.username.label" default="Username"/>:</label>--}%
                %{--<g:textField name='username' value='${linkAccountCommand?.username}'/>--}%
            %{--</div>--}%
            %{--<div class="fieldcontain ${hasErrors(bean: linkAccountCommand, field: 'password', 'error')} ">--}%
                %{--<label for='password'><g:message code="OAuthLinkAccountCommand.password.label" default="Password"/>:</label>--}%
                %{--<g:passwordField name='password' value='${linkAccountCommand?.password}'/>--}%
            %{--</div>--}%
            %{--<g:submitButton name="${message(code: 'springSecurity.oauth.registration.login.button', default: 'Login')}"/>--}%
        %{--</fieldset>--}%
    %{--</g:form>--}%

    %{--<br/>--}%

    %{--<g:link controller="login" action="auth"><g:message code="springSecurity.oauth.registration.back" default="Back to login page"/></g:link>--}%
%{--</div>--}%

</body>
