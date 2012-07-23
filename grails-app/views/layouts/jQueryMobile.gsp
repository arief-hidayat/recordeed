<%--
  Created by IntelliJ IDEA.
  User: hida
  Date: 7/19/12
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="HandheldFriendly" content="True">
    <meta name="MobileOptimized" content="320">
    %{--<!-- Home screen icon  Mathias Bynens mathiasbynens.be/notes/touch-icons -->--}%
    %{--<!-- For iPhone 4 with high-resolution Retina display: -->--}%
    %{--<link rel="apple-touch-icon-precomposed" sizes="114x114" href="${resource(url : 'apple-touch-icon.png')}">--}%
    %{--<!-- For first-generation iPad: -->--}%
    %{--<link rel="apple-touch-icon-precomposed" sizes="72x72" href="${resource(url : 'apple-touch-icon.png')}">--}%
    %{--<!-- For non-Retina iPhone, iPod Touch, and Android 2.1+ devices: -->--}%
    %{--<link rel="apple-touch-icon-precomposed" href="${resource(url : 'apple-touch-icon-precomposed.png')}">--}%
    %{--<!-- For nokia devices and desktop browsers : -->--}%
    %{--<link rel="shortcut icon" href="${resource(url : 'favicon.ico')}" />--}%

    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
    <!-- Mobile IE allows us to activate ClearType technology for smoothing fonts for easy reading -->
    <meta http-equiv="cleartype" content="on">
    <g:layoutHead/>
    <r:require module="jQueryMobilResource"/>
    <r:require module="otherResource"/>
    <r:require module="jQueryCDN"/>
    <r:require module="mobileInit"/>
    <r:require module="jQueryMobileCDN"/>
    <r:require module="otherMobileLib"/>
    <r:layoutResources />
    <!-- Startup Images for iDevices -->
    <script>(function(){var a;if(navigator.platform==="iPad"){a=window.orientation!==90||window.orientation===-90?"images/startup-tablet-landscape.png":"images/startup-tablet-portrait.png"}else{a=window.devicePixelRatio===2?"images/startup-retina.png":"images/startup.png"}document.write('<link rel="apple-touch-startup-image" href="'+a+'"/>')})()</script>
    <!-- The script prevents links from opening in mobile safari. https://gist.github.com/1042026 -->
    <script>(function(a,b,c){if(c in b&&b[c]){var d,e=a.location,f=/^(a|html)$/i;a.addEventListener("click",function(a){d=a.target;while(!f.test(d.nodeName))d=d.parentNode;"href"in d&&(d.href.indexOf("http")||~d.href.indexOf(e.host))&&(a.preventDefault(),e.href=d.href)},!1)}})(document,window.navigator,"standalone")</script>
</head>
<body>
<g:layoutBody/>
<r:layoutResources />
</body>
</html>