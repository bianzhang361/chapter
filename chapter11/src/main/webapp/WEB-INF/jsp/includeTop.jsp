<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/18
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%
    String context = request.getContextPath();
    request.setAttribute("context", context);
%>
<div style="float: left; clear: left;">
    <a href="<c:url value="/index.jsp"/>">首页</a>
    <div style="float: right; clear: right;">
        <c:if test="${!empty USER_CONTEXT.userName}">
            ${sessionUser.userName},欢迎您的到来，
            <a href="<c:url value="login/doLogout.html"/>">
                注销
            </a>&nbsp;&nbsp;
            <a href="<c:url value="/vs/index.html"/>">
                管理景区
            </a>&nbsp;&nbsp;
        </c:if>
        <c:if test="${empty USER_CONTEXT.userName}">
            <a href="<c:url value="/login.jsp"/>">登录</a>&nbsp;&nbsp;
        </c:if>
    </div>
</div>