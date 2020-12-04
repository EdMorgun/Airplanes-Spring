<#import  "../parts/common.ftl" as c>
<@c.page>
    <div class="adminCurTableName">
        text_block List
    </div>
    <@c.searchList />


    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>text</th>
            <th>order_num</th>
            <th>post_id</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <form action="/text_block/" method="post">
                <td></td>
                <td><input type="text" name="text" required placeholder="text"></td>
                <td><input type="text" name="order_num" required placeholder="order_num"></td>
                <td><input type="text" name="post_id" required placeholder="post_id"></td>
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="hidden" name="create" value="1">
                <td><button type="submit">Create</button></td>
            </form>
        </tr>
        <#if text_blocks??>
            <#list text_blocks as text_block>
                <tr>
                    <td>${text_block.text_block_id}</td>
                    <td>${text_block.text}</td>
                    <td>${text_block.order_num}</td>
                    <td>${text_block.post_id.post_id}</td>
                    <td><form action="/text_block/${text_block.text_block_id}" method="post"><input type="hidden" name="kill" value="1">
                            <input type="hidden" name="_csrf" value="${_csrf.token}"/><button type="submit">Delete</button></form></td>
                </tr>
            </#list>
        </#if>
        </tbody>
    </table>
</@c.page>
