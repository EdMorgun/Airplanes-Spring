<#import  "../parts/common.ftl" as c>
<@c.page>
    <div class="adminCurTableName">
        plane List
    </div>
    <@c.searchList />


    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>number</th>
            <th>hangar_id</th>
            <th>model</th>
            <th>last_maintenance</th>
            <th>capacity</th>
            <th>resource</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/plane/" method="post">
                <td></td>
                <td><input type="text" name="number" required placeholder="number"></td>
                <td><input type="text" name="hangar_id" required placeholder="hangar_id"></td>
                <td><input type="text" name="model" required placeholder="model"></td>
                <td><input type="date" name="last_maintenance" required placeholder="last_maintenance"></td>
                <td><input type="text" name="capacity" required placeholder="capacity"></td>
                <td><input type="text" name="resource" required placeholder="resource"></td>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="create" value="1">
                <td><button type="submit">Create</button></td>
            </form>
        </tr>
        <#if planes??>
            <#list planes as plane>
                <tr>
                    <td>${plane.plane_id}</td>
                    <td>${plane.number}</td>
                    <td>${plane.hangar_id.hangar_id}</td>
                    <td>${plane.model}</td>
                    <td>${plane.last_maintenance}</td>
                    <td>${plane.capacity}</td>
                    <td>${plane.resource}</td>
                    <td><form action="/plane/${plane.plane_id}" method="post"><input type="hidden" name="kill" value="1">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/><button type="submit">Delete</button></form></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@c.page>
