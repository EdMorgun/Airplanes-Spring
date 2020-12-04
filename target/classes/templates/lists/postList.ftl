<#import  "../parts/common.ftl" as c>
<@c.page>
    <div class="adminCurTableName">
        post List
    </div>
    <@c.searchList />


    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>theme</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/post/" method="post">
                <td></td>
                <td><input type="text" name="theme" required placeholder="theme"></td>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="create" value="1">
                <td><button type="submit">Create</button></td>
            </form>
        </tr>
        <#if posts??>
            <#list posts as post>
                <tr>
                    <td>${post.post_id}</td>
                    <td>${post.theme}</td>
                    <td><form action="/post/${post.post_id}" method="post"><input type="hidden" name="kill" value="1">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/><button type="submit">Delete</button></form></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@c.page>