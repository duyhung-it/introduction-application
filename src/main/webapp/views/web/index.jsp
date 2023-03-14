<%--
  Created by IntelliJ IDEA.
  User: Nguyen Duy Hung
  Date: 3/14/2023
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Introduction Application</title>
    <link rel="shortcut icon" href="<c:url value="/template/assets/images/favicon.ico"/>">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <!-- third party css -->
    <link href="<c:url value="/template/assets/css/vendor/jquery-jvectormap-1.2.2.css"/>" rel="stylesheet" type="text/css" />
    <!-- third party css end -->
    <!-- App css -->
    <link href="<c:url value="/template/assets/css/icons.min.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/template/assets/css/app-creative.min.css"/>" rel="stylesheet" type="text/css" id="light-style" />
    <link rel="stylesheet" href="<c:url value="/assets/css/style.css"/>"/>
</head>
<body data-layout="topnav">
<div>
    <div class="content-page">
        <div class="content">
            <%@ include file="/layout/web/header.jsp"%>
            <jsp:include page="${view}"/>
        </div>
        <%@ include file="/layout/web/footer.jsp"%>
    </div>
</div>

<script src="<c:url value="/template/assets/js/vendor.min.js"/>"></script>
<script src="<c:url value="/template/assets/js/app.min.js"/>"></script>
</body>
</html>
