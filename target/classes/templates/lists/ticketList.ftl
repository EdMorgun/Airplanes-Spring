<#import  "../parts/common.ftl" as c>
<@c.page>
    <div class="adminCurTableName">
        ticket List
    </div>
    <@c.searchList />


    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>client_id</th>
            <th>route_id</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/ticket/" method="post">
                <td></td>
                <td><input type="text" name="client" required placeholder="client_id"></td>
                <td><input type="text" name="route" required placeholder="route_id"></td>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="create" value="1">
                <td><button type="submit">Create</button></td>
            </form>
        </tr>
        <#if tickets??>
            <#list tickets as ticket>
                <tr>
                    <td>${ticket.ticket_id}</td>
                    <td>${ticket.client.client_id}</td>
                    <td>${ticket.route.route_id}</td>
                    <td><form action="/ticket/${ticket.ticket_id}" method="post"><input type="hidden" name="kill" value="1">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/><button type="submit">Delete</button></form></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@c.page>
