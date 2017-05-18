<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/18
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>列表</title>
</head>
<body>
    <%@ include file="includeTop.jsp" %>
    <div style="clear: both">
        <div style="float: right;">
        <form action="${context}/search" method="post">
            请输入景区名：<input type="text" name="spaceName" style="width: 400px;"/>
            <input type="submit" value="查询"/>
            <input type="hidden" name="_method" value="PUT"/>
        </form>
        </div>

    <table border="1px" width="100%">
        <tr>
            <td>景区名</td>
            <td>所在地</td>
            <td>简介</td>
        </tr>
        <c:forEach var="viewSpace" items="${viewSpaces}">
            <tr>
                <td>
                    <a href="<c:url value="/viewManage.do?method=showViewSpace&spaceId=${viewSpace.spaceId}"/> ">
                            ${viewSpace.spaceName}
                    </a>
                </td>
                <td>${viewSpace.address}</td>
                <td>${viewSpace.briefDesc}</td>
            </tr>
        </c:forEach>
    </table>
    </div>
</body>
</html>
