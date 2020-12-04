<#import  "../parts/common.ftl" as c>
<@c.page>
    <div class="adminCurTableName">
        user List
    </div>
    <@c.searchList />
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Password</th>
            <th>Roles</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>E-mail</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/users/" method="post">
                <td></td>
                <td><input type="text" name="username" required placeholder="username"></td>
                <td><input type="password" name="password" required placeholder="password"></td>
                <td></td>
                <td><input type="text" name="firstname" placeholder="first name"></td>
                <td><input type="text" name="lastname" placeholder="last name"></td>
                <td><input type="text" name="email" placeholder="e-mail"></td>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="create" value="1">
                <td><button class="butsAdmin" type="submit">Create</button></td>
            </form>
        </tr>
        <#if users??>
            <#list users as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td><#list user.roles as role>${role}<#sep>, </#list></td>
                    <td><#if user.firstname??>${user.firstname}</#if></td>
                    <td><#if user.lastname??>${user.lastname}</#if></td>
                    <td><#if user.email??>${user.email}</#if></td>
                    <td><form class="butsAdmin" action="/users/${user.id}" method="post"><input type="hidden" name="kill" value="1">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/><button class="butsAdmin" type="submit">Delete</button></form></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>


</@c.page>
