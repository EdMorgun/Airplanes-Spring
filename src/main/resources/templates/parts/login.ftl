<#macro login>
    <form action="/login" method="post" class="logRegForm">
        <div class="topLine" id="logRegTopLine">Sign In Form</div>
        <div><label> Nickname: <input required type="text" name="username"/> </label></div>
        <div><label> Password: <input required type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div><input type="submit" value="Sign In"/></div>
        <a href="/registration">I want to create new account!</a>
    </form>
</#macro>

<#macro logout>
    <form class="logRegButs" action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <label style="display: block; max-width: 150px;"><#if name??>${name}</#if></label><input style="display: inline-block; max-width: 150px; float: right;" type="submit" value="Sign Out"/>
    </form>
</#macro>

<#macro registration>
    <form action="/registration" method="post" class="logRegForm">
        <div class="topLine" id="logRegTopLine">Register Form</div>
        <div><label> Username (must be unique): <input required type="text" name="username"/> </label></div>
        <div><label> First Name: <input type="text" name="firstname"/> </label></div>
        <div><label> Last Name: <input type="text" name="lastname"/> </label></div>
        <div><label> E-mail: <input type="text" name="email"/> </label></div>
        <div><label> Password: <input required type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <div><input type="submit" value="Sign Up"/></div>
        <div style="color: darkred; text-align: center;"><#if message??>${message}</#if></div>
        <a href="/login">Already have an account?</a>
    </form>
</#macro>