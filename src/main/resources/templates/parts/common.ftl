<#import  "login.ftl" as l>

<#macro page>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Air</title>
    <style type="text/css">
        body {
            padding: 0;
            margin: 0;
            background-color: rgb(240, 240, 240);
        }

        a.topLine {
            position: absolute;
            height: 50px;
            width: calc(100% - 60px);
        }

        div.topLine {
            height: 50px;
            width: calc(100% - 60px);
            background-color: rgb(0, 102, 34);
            box-shadow: inset 0 14px 28px rgba(0,0,0,0.25), inset 0 10px 10px rgba(0,0,0,0.22);
            line-height: 50px;
            padding-left: 30px;
            padding-right: 30px;
            border-radius: 0 0 20px 20px;
        }

        .topLine {
            font: bold italic 20px serif;
            width: 50%;
            margin: 0;
            display: inline-block;
        }

        div.logRegButs, form.logRegButs {
            height: 50px;
            float: right;
            width: 15%;
            text-align: center;
            position: relative;
        }

        .logRegButs button, .logRegButs input {
            display: block;
            width: 100%;
            height: 19px;
            margin-top: 4px;
            background-color: rgb(0, 102, 34);
            font: 12px serif;
            color: white;
            border: 1px dotted white;
            box-shadow: inset 0 14px 28px rgba(0,0,0,0.25), inset 0 10px 10px rgba(0,0,0,0.22);
        }

        .logRegButs label {
            font: 18px serif;
            width: 100%;
        }

        .logRegButs button:hover, .logRegButs input:hover {
            background-color: rgb(0, 153, 51);
            cursor: pointer;
            border: 1px solid white;
        }

        form.logRegForm {
            display: block;
            position: absolute;
            height: auto;
            width: 30vw;
            margin-top: 15vh;
            margin-left: 35vw;
            border-radius: 10px;
            border: 2px dotted black;
            box-shadow: 0 0 200px 500px rgba(0, 0, 0, 0.8);
            background-color: rgb(240, 240, 240);
        }

        .logRegForm input, .logRegForm a {
            width: calc(100% - 2vw);
            margin-left: 1vw;
            border-radius: 3px;
            display: block;
            text-align: center;
        }

        #logRegTopLine {
            height: 30px;
            line-height: 30px;
            font: 20px serif;
            color: white;
            padding: 0;
            width: 100%;
            text-align: center;
        }

        a.forCancelRegLog {
            display: block;
            position: absolute;
            height: 100vh;
            width: 100vw;
        }

        a.mainPlate {
            width: 30vw;
            height: 15vw;
            margin: 1vw;
            background-color: rgb(100, 100, 0);
            box-shadow: inset 0 14px 28px rgba(0,0,0,0.25), inset 0 10px 10px rgba(0,0,0,0.22);
            display: inline-block;
            text-decoration: none;
            border-radius: 30px 0;
        }

        a.mainPlate:hover {
            background-color: olive;
            width: 32vw;
            height: 17vw;
            border: 1px solid black;
        }

        .mainPlate div {
            margin-top: 10vw;
            font: 3vw serif;
            color: black;
        }

        div.informPlate {
            width: 35vw;
            height: auto;
            display: inline-block;
            margin: 1vw;
            box-shadow: inset 0 14px 28px rgba(0,0,0,0.25), inset 0 10px 10px rgba(0,0,0,0.22);
            border: 1px solid black;
        }

        span.plateDescr {
            width: 5vw;
            height: auto;
            background-color: black;
            box-shadow: inset 0 14px 28px rgba(0,0,0,0.25), inset 0 10px 10px rgba(0,0,0,0.22);
            color: white;
            font: 16px serif;
        }

        .informPlate div {
            height: auto;
            font: bold 20px serif;
        }

        #searchForm {
            margin-top: 10px;
            font: 18px serif;
        }

        .adminCurTableName {
            font: bold 20px serif;
            height: 30px;
            width: 40%;
            margin: 0 auto;
            background-color: rgb(0, 102, 34);
            box-shadow: inset 0 10px 10px rgba(0,0,0,0.22), inset 0 14px 28px rgba(0,0,0,0.25);
            line-height: 30px;
            border-radius: 0 0 40px 40px;
            text-align: center;
        }

        table {
            max-width: 100%;
            table-layout: auto;
            border: 2px solid rgb(240, 240, 240);
            text-align: center;
            border-collapse: collapse;
            margin: 0 auto;
        }

        table input {
            width: 95%;
        }

        td {
            width: auto;
            word-wrap: break-word;
        }

        th {
            box-shadow: inset 0 10px 10px rgba(0,0,0,0.22), 0 14px 28px rgba(0,0,0,0.25);
        }

        td, th {
            border: 1px solid black;
        }

        select {
            background-color: rgb(0, 100, 34);
            color: white;
            font: italic 18px serif;
            width: 100%;
            border-radius: 40px 40px 0 0;
            padding: 0 10px;
            margin: 0;
        }

        select:hover, #chooseTab:hover {
            background-color: rgb(0, 140, 55);
        }

        #chooseTab {
            width: 100%;
            background-color: rgb(0, 100, 34);
            box-shadow: inset 0 10px 10px rgba(0,0,0,0.22), 0 14px 28px rgba(0,0,0,0.25);
            color: white;
            font: 18px serif;
            border-radius: 0 0 40px 40px;
            margin: 0;
        }
    </style>
</head>
<body>
    <a href="/" class="topLine"></a>
    <div class="topLine">
        Welcome to the AIS "Airlines"!
        <#if name??><@l.logout/>
        <#else>
            <div class="logRegButs">
                <a href="/login">
                    <button style="border-radius: 10px 10px 0 0;">Log In</button>
                </a>
                <a href="/registration">
                    <button style="border-radius: 0 0 10px 10px;">Register</button>
                </a>
            </div>
        </#if>
    </div>
    <#nested>
</body>
</html>
</#macro>

<#macro searchList>
    <form action="/admin" method="post" name="table" style="width: 40%; text-align: center; margin: 20px auto;">
        <label>
            <select size="1" name="table" required autofocus>
                <option hidden style="font: bold 20px serif;">Choose table to edit</option>
                <option value="users">Users</option>
                <option value="ad_service">ad_service</option>
                <option value="ad_service_code">ad_service_code</option>
                <option value="airport">airport</option>
                <option value="client">client</option>
                <option value="comment">comment</option>
                <option value="employee">employee</option>
                <option value="feedback">feedback</option>
                <option value="hangar">hangar</option>
                <option value="plane">plane</option>
                <option value="position">position</option>
                <option value="post">post</option>
                <option value="route">route</option>
                <option value="spec_machinery">spec_machinery</option>
                <option value="spec_machinery_codelist">spec_machinery_codelist</option>
                <option value="text_block">text_block</option>
                <option value="ticket">ticket</option>
            </select></label>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Open" id="chooseTab">
    </form>
</#macro>
