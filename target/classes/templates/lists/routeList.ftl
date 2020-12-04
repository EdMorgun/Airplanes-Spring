<#import  "../parts/common.ftl" as c>
<@c.page>
    <div class="adminCurTableName">
        route List
    </div>
    <@c.searchList />


    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>source_airport_id</th>
            <th>dest_airport_id</th>
            <th>time_start</th>
            <th>time_end</th>
            <th>plane_id</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/route/" method="post">
                <td></td>
                <td><input type="text" name="source_airport_id" required placeholder="source_airport_id"></td>
                <td><input type="text" name="dest_airport_id" required placeholder="dest_airport_id"></td>
                <td><input type="date" name="time_start" required placeholder="time_start"></td>
                <td><input type="date" name="time_end" required placeholder="time_end"></td>
                <td><input type="text" name="plane_id" required placeholder="plane_id"></td>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="create" value="1">
                <td><button type="submit">Create</button></td>
            </form>
        </tr>
        <#if routes??>
            <#list routes as route>
                <tr>
                    <td>${route.route_id}</td>
                    <td>${route.source_airport_id.airport_id}</td>
                    <td>${route.dest_airport_id.airport_id}</td>
                    <td>${route.time_start}</td>
                    <td>${route.time_end}</td>
                    <td>${route.plane_id.plane_id}</td>
                    <td><form action="/route/${route.route_id}" method="post"><input type="hidden" name="kill" value="1">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/><button type="submit">Delete</button></form></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@c.page>
