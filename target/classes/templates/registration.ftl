<#import  "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <a class="forCancelRegLog" href="/"></a>
    <@l.registration />
    <div style="text-align: center; padding-top: 10px; height: 20vw;">
        <#if name??><a class="mainPlate" href="/orders"><div>Manage your tickets</div></a></#if>
        <a class="mainPlate" href="/main"><div>Available routes</div></a>
        <a class="mainPlate" href="/posts"><div>Read our latest news!</div></a>
    </div>
</@c.page>