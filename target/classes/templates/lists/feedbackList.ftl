<#import  "../parts/common.ftl" as c>
<@c.page>
    <div class="adminCurTableName">
        feedback List
    </div>
    <@c.searchList />


    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>client_id</th>
            <th>like_amount</th>
            <th>dislike_amount</th>
            <th>text</th>
            <th>post_id</th>
            <th>theme</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/feedback/" method="post">
                <td></td>
                <td><input type="text" name="client_id" required placeholder="client_id"></td>
                <td><input type="text" name="like_amount" required placeholder="like_amount"></td>
                <td><input type="text" name="dislike_amount" required placeholder="dislike_amount"></td>
                <td><input type="text" name="text" required placeholder="text"></td>
                <td><input type="text" name="post_id" required placeholder="post_id"></td>
                <td><input type="text" name="theme" required placeholder="theme"></td>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="create" value="1">
                <td><button type="submit">Create</button></td>
            </form>
        </tr>
        <#if feedbacks??>
            <#list feedbacks as feedback>
                <tr>
                    <td>${feedback.feedback_id}</td>
                    <td>${feedback.client_id.client_id}</td>
                    <td>${feedback.like_amount}</td>
                    <td>${feedback.dislike_amount}</td>
                    <td>${feedback.text}</td>
                    <td>${feedback.post_id.post_id}</td>
                    <td>${feedback.theme}</td>
                    <td><form action="/feedback/${feedback.feedback_id}" method="post"><input type="hidden" name="kill" value="1">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/><button type="submit">Delete</button></form></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@c.page>
