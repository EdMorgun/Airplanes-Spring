<#import  "../parts/common.ftl" as c>
<@c.page>
<div class="adminCurTableName">
    spec_machinery List
</div>
    <@c.searchList />


    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>number</th>
            <th>airport_id</th>
            <th>type_code</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/spec_machinery/" method="post">
                <td></td>
                <td><input type="text" name="number" required placeholder="number"></td>
                <td><input type="text" name="airport_id" required placeholder="airport_id"></td>
                <td><input type="text" name="type_code" required placeholder="type_code"></td>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="create" value="1">
                <td><button type="submit">Create</button></td>
            </form>
        </tr>
        <#if spec_machinerys??>
            <#list spec_machinerys as spec_machinery>
                <tr>
                    <td>${spec_machinery.spec_machinery_id}</td>
                    <td>${spec_machinery.number}</td>
                    <td>${spec_machinery.airport_id.name}</td>
                    <td>${spec_machinery.type_code.type_description}</td>
                    <td><form action="/spec_machinery/${spec_machinery.spec_machinery_id}" method="post"><input type="hidden" name="kill" value="1">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/><button type="submit">Delete</button></form></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@c.page>
