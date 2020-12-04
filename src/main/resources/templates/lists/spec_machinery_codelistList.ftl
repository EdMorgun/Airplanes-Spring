<#import  "../parts/common.ftl" as c>
<@c.page>
    <div class="adminCurTableName">
        spec_machinery_codelist List
    </div>
    <@c.searchList />


    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>type_description</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/spec_machinery_codelist/" method="spec_machinery_codelist">
                <td></td>
                <td><input type="text" name="type_description" required placeholder="type_description"></td>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="create" value="1">
                <td><button type="submit">Create</button></td>
            </form>
        </tr>
        <#if spec_machinery_codelists??>
            <#list spec_machinery_codelists as spec_machinery_codelist>
                <tr>
                    <td>${spec_machinery_codelist.type_code}</td>
                    <td>${spec_machinery_codelist.type_description}</td>
                    <td><form action="/spec_machinery_codelist/${spec_machinery_codelist.type_code}" method="spec_machinery_codelist"><input type="hidden" name="kill" value="1">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/><button type="submit">Delete</button></form></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@c.page>