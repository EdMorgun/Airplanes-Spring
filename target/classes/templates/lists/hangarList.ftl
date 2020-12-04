<#import  "../parts/common.ftl" as c>
<@c.page>
    <div class="adminCurTableName">
        hangar List
    </div>
    <@c.searchList />


    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>capacity</th>
            <th>number</th>
            <th>airport_id</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/hangar/" method="post">
                <td></td>
                <td><input type="text" name="capacity" required placeholder="capacity"></td>
                <td><input type="text" name="number" required placeholder="number"></td>
                <td><input type="text" name="airport_id" required placeholder="airport_id"></td>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="create" value="1">
                <td><button type="submit">Create</button></td>
            </form>
        </tr>
        <#if hangars??>
            <#list hangars as hangar>
                <tr>
                    <td>${hangar.hangar_id}</td>
                    <td>${hangar.capacity}</td>
                    <td>${hangar.number}</td>
                    <td>${hangar.airport_id.name}</td>
                    <td><form action="/hangar/${hangar.hangar_id}" method="post"><input type="hidden" name="kill" value="1">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/><button type="submit">Delete</button></form></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@c.page>
