<#import  "../parts/common.ftl" as c>
<@c.page>

    <div class="adminCurTableName">
        <span>airport List</span>
    </div>
    <@c.searchList />
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>name</th>
            <th>location</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/airport/" method="post">
                <td></td>
                <td><input type="text" name="name" required placeholder="name"></td>
                <td><input type="text" name="location" required placeholder="location"></td>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="create" value="1">
                <td><button type="submit">Create</button></td>
            </form>
        </tr>
        <#if airports??>
            <#list airports as airport>
                <tr>
                    <td>${airport.airport_id}</td>
                    <td>${airport.name}</td>
                    <td>${airport.location}</td>
                    <td><form action="/airport/${airport.airport_id}" method="post"><input type="hidden" name="kill" value="1">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/><button type="submit">Delete</button></form></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@c.page>
