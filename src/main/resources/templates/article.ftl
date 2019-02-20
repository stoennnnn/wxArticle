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
</style>
<body>
<script>

</script>
<div>
    <h2>最新文章！！！</h2>
    <table id="customers">
        <tr>
            <th>公众号</th>
            <th>名称</th>
            <th>描述</th>

        </tr>
    <#list params as articleInfoDto>
        <#if (articleInfoDto.articles)?exists>
            <tr onclick="click">
                    <td rowspan=${(articleInfoDto.articles)?size}>${(articleInfoDto.nickname)!""}</td>
            <#list articleInfoDto.articles as article>
                    <td  color="blue"><a href=${(article.articleContentUrl)!""}>${(article.articleTitle)!""}</a></td>
                    <td>${(article.articleDigest)!""}</td>
            </tr>
            </#list>
        </#if>
    </#list>
    </table>
</div>
</body>
</html>