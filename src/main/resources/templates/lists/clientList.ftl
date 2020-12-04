<#import  "../parts/common.ftl" as c>
<@c.page>
    <div class="adminCurTableName">
        client List
    </div>
    <@c.searchList />


    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>full_name</th>
            <th>birth_date</th>
            <th>passport_data</th>
            <th>email</th>
            <th>usr_id</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/client/" method="post">
                <td></td>
                <td><input type="text" name="full_name" placeholder="full_name"></td>
                <td><input type="date" name="birth_date" placeholder="birth_date"></td>
                <td><input type="text" name="passport_data" placeholder="passport_data"></td>
                <td><input type="text" name="email" placeholder="email"></td>
                <td><input type="text" name="usr" placeholder="usr_id"></td>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="create" value="1">
                <td><button type="submit">Create</button></td>
            </form>
        </tr>
        <#if clients??>
            <#list clients as client>
                <tr>
                    <td>${client.client_id}</td>
                    <td><#if client.full_name??>${client.full_name}</#if></td>
                    <td><#if client.birth_date??>${client.birth_date}</#if></td>
                    <td><#if client.passport_data??>${client.passport_data}</#if></td>
                    <td><#if client.email??>${client.email}</#if></td>
                    <td><#if client.usr??>${client.usr.id}</#if></td>
                    <td><form action="/client/${client.client_id}" method="post"><input type="hidden" name="kill" value="1">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/><button type="submit">Delete</button></form></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@c.page>
