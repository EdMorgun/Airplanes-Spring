<#import  "../parts/common.ftl" as c>
<@c.page>
    <div class="adminCurTableName">
        ad_service List
    </div>
    <@c.searchList />


    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>ad_code_id</th>
            <th>ticket_id</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/ad_service/" method="post">
                <td></td>
                <td><input type="text" name="ad_code_id" required placeholder="ad_code_id"></td>
                <td><input type="text" name="ticket_id" required placeholder="ticket_id"></td>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="create" value="1">
                <td><button type="submit">Create</button></td>
            </form>
        </tr>
            <#if ad_services??>
            <#list ad_services as ad_service>
        <tr>
            <td>${ad_service.ad_service_id}</td>
            <td>${ad_service.ad_code_id.ad_code_id}</td>
            <td>${ad_service.ticket_id.ticket_id}</td>
            <td><form action="/ad_service/${ad_service.ad_service_id}" method="post"><input type="hidden" name="kill" value="1">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/><button type="submit">Delete</button></form></td>
        </tr>
        </#list>
        </#if>
        </tbody>
    </table>
</@c.page>
