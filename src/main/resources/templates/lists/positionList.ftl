<#import  "../parts/common.ftl" as c>
<@c.page>
    <div class="adminCurTableName">
        position List
    </div>
    <@c.searchList />


    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>name</th>
            <th>description</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/position/" method="post">
                <td></td>
                <td><input type="text" name="name" required placeholder="name"></td>
                <td><input type="text" name="description" required placeholder="description"></td>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="create" value="1">
                <td><button type="submit">Create</button></td>
            </form>
        </tr>
        <#if positions??>
            <#list positions as position>
                <tr>
                    <td>${position.position_id}</td>
                    <td>${position.name}</td>
                    <td>${position.description}</td>
                    <td><form action="/position/${position.position_id}" method="post"><input type="hidden" name="kill" value="1">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/><button type="submit">Delete</button></form></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@c.page>