<#import  "../parts/common.ftl" as c>
<@c.page>
    <div class="adminCurTableName">
        ad_service_code List
    </div>
    <@c.searchList />
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>descr</th>
            <th>cost</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/ad_service_code/" method="post">
                <td></td>
                <td><input type="text" name="descr" required placeholder="descr"></td>
                <td><input type="text" name="cost" required placeholder="cost"></td>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="create" value="1">
                <td><button type="submit">Create</button></td>
            </form>
        </tr>
        <#if ad_service_codes??>
            <#list ad_service_codes as ad_service_code>
                <tr>
                    <td>${ad_service_code.ad_code_id}</td>
                    <td>${ad_service_code.descr}</td>
                    <td>${ad_service_code.cost}</td>
                    <td><form action="/ad_service_code/${ad_service_code.ad_code_id}" method="post"><input type="hidden" name="kill" value="1">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/><button type="submit">Delete</button></form></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@c.page>
