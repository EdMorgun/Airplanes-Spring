<#import  "../parts/common.ftl" as c>
<@c.page>
    <div class="adminCurTableName">
        employee List
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
            <th>airport_name</th>
            <th>position_name</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/employee/" method="post">
                <td></td>
                <td><input type="text" name="full_name" required placeholder="full_name"></td>
                <td><input type="date" name="birth_date" required placeholder="birth_date"></td>
                <td><input type="text" name="passport_data" required placeholder="passport_data"></td>
                <td><input type="text" name="email" placeholder="email"></td>
                <td><input type="text" name="airport_id" placeholder="airport_id"></td>
                <td><input type="text" name="position_id" required placeholder="position_id"></td>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="create" value="1">
                <td><button type="submit">Create</button></td>
            </form>
        </tr>
        <#if employees??>
            <#list employees as employee>
                <tr>
                    <td>${employee.employee_id}</td>
                    <td>${employee.full_name}</td>
                    <td>${employee.birth_date}</td>
                    <td>${employee.passport_data}</td>
                    <td><#if employee.email??>${employee.email}</#if></td>
                    <td><#if employee.airport_id??>${employee.airport_id.name}</#if></td>
                    <td>${employee.position_id.name}</td>
                    <td><form action="/employee/${employee.employee_id}" method="post"><input type="hidden" name="kill" value="1">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/><button type="submit">Delete</button></form></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@c.page>
