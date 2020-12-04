<#import  "../parts/common.ftl" as c>
<@c.page>
    <div class="adminCurTableName">
        comment List
    </div>
    <@c.searchList />


    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>feedback_id</th>
            <th>like_amount</th>
            <th>dislike_amount</th>
            <th>text</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/comment/" method="post">
                <td></td>
                <td><input type="text" name="feedback_id" required placeholder="feedback_id"></td>
                <td><input type="text" name="like_amount" required placeholder="like_amount"></td>
                <td><input type="text" name="dislike_amount" required placeholder="dislike_amount"></td>
                <td><input type="text" name="text" required placeholder="text"></td>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="create" value="1">
                <td><button type="submit">Create</button></td>
            </form>
        </tr>
        <#if comments??>
            <#list comments as comment>
                <tr>
                    <td>${comment.comment_id}</td>
                    <td>${comment.feedback_id.feedback_id}</td>
                    <td>${comment.like_amount}</td>
                    <td>${comment.dislike_amount}</td>
                    <td>${comment.text}</td>
                    <td><form action="/comment/${comment.comment_id}" method="post"><input type="hidden" name="kill" value="1">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/><button type="submit">Delete</button></form></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@c.page>
