<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>今日文章更新</title>
</head>

<style type="text/css">
    table {
        font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
        width: 100%;
        border-collapse: collapse;
    }

    td, th {
        font-size: 1em;
        border: 1px solid #5B4A42;
        padding: 3px 7px 2px 7px;
    }

    th {
        font-size: 1.1em;
        text-align: center;
        padding-top: 5px;
        padding-bottom: 4px;
        background-color: #24A9E1;
        color: #ffffff;
    }
    td{
        background-color: #F5F5DC;
    }
    span{
        color: blue;
    }
</style>
<body>
<#--<script src="http://www.w3school.com.cn/jquery/jquery.js"></script>-->
<#--<script type="text/javascript">-->
    <#--function click(obj) {-->
        <#--$.ajax({-->
            <#--url: /refresh/newurl/,-->
            <#--type: post,-->
            <#--data:{-->
                <#--var a = $(obj).parent().parent().find("td");-->
                <#--var arr = {-->
                    <#--nickName: a.eq(0).text(),-->
                    <#--title: a.eq(1).text()-->
                <#--}-->
            <#--},-->
            <#--async: false-->
            <#--success:function (data) {-->
                <#--//返回的是newUrl-->
                <#--window.open(data);-->
            <#--}-->

        <#--})-->
    <#--})-->
<#--//<td ><a onclick="click(this)">重新获取</a></td>-->
<#--</script>-->
<div>
    <table id="customers">
        <tr>
            <th>公众号</th>
            <th>名称</th>
            <th>描述</th>
            <th>发布时间</th>
        </tr>
    <#list params as articleInfoDto>
        <#if (articleInfoDto.articles)?exists>
            <tr>
                    <td rowspan=${(articleInfoDto.articles)?size}>${(articleInfoDto.nickname)!""}</td>
            <#list articleInfoDto.articles as article>
                    <td  color="blue"><a href=${(article.articleContentUrl)!""}><span>${(article.articleTitle)!""}</span></a></td>
                    <td>${(article.articleDigest)!""}</td>
                    <td >
                        <#--url有中文会被编码，只写数字和字母-->
                        <a href="http://localhost:8888/refresh/newurl?accountId=${(articleInfoDto.accountId)}&articleId=${(article.articleId)}">
                            <#--先转字符串除去","再转number 成功！-->
                            <span><#assign dlong = article.articleDatetime?c?number*1000 />${dlong?number_to_datetime}</span>
                        </a>
                    </td>
             </tr>
            </#list>
        </#if>
    </#list>
    </table><br>
    <span><em>备注:链接过期请点击发布时间重新获取</em></span>
</div>
</body>
</html>