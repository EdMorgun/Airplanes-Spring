<#import  "parts/common.ftl" as c>
<@c.page>
<div style="text-align: center;">
    <#if nothing><div class="adminCurTableName" style="background-color: darkred">You don't have tickets!</div>
    <#else>
        <div class="adminCurTableName">Purchased tickets</div>
    </#if>
    <#if routes??>
        <#list routes as route>
            <div class="informPlate">
                <div>"${route.source_airport_id.name}" in ${route.source_airport_id.location} ==></div>
                <div>"${route.dest_airport_id.name}" in ${route.dest_airport_id.location}</div>
                <div>${route.time_start} - ${route.time_end}</div>
                <div style="border-top: 1px dotted black; font: italic 20px serif;">Plane number: ${route.plane_id.number}</div>
                <div>Total cost: ${route.start_cost}$</div>
                <div style="color: darkred; text-align: center;"><#if message??>${message}</#if></div>
            </div>
        </#list>
    </#if>
</div>
</@c.page>
