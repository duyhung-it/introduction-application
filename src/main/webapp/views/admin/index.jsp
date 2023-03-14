<%--
  Created by IntelliJ IDEA.
  User: Nguyen Duy Hung
  Date: 3/12/2023
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
  <title>Admin Home</title>
  <link rel="shortcut icon" href="<c:url value="/template/assets/images/favicon.ico"/>">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <!-- third party css -->
  <link href="<c:url value="/template/assets/css/vendor/jquery-jvectormap-1.2.2.css"/>" rel="stylesheet" type="text/css" />
  <!-- third party css end -->
  <!-- App css -->
  <link href="<c:url value="/template/assets/css/icons.min.css"/>" rel="stylesheet" type="text/css" />
  <link href="<c:url value="/template/assets/css/app-creative.min.css"/>" rel="stylesheet" type="text/css" id="light-style" />
<%--  <link href="<c:url value="/template/assets/css/app-creative-dark.min.css"/>" rel="stylesheet" type="text/css" id="dark-style" />--%>
  <link rel="stylesheet" href="<c:url value="/assets/css/style.css"/>">
</head>
<body class="loading"
      data-layout-config='{"leftSideBarTheme":"dark","layoutBoxed":false, "leftSidebarCondensed":false, "leftSidebarScrollable":false,"darkMode":false, "showRightSidebarOnStart": true}'>
<div>
  <%@include file="/layout/admin/menu.jsp"%>
  <div class="content-page">
    <div class="content">
      <%@include file="/layout/admin/header.jsp"%>
      <section class="m-3">
        <jsp:include page="${view}"/>
<%--        <%@ include file="form-video.jsp"%>--%>
      </section>
    </div>
    <%@include file="/layout/admin/footer.jsp"%>
  </div>
</div>
<%--bundle--%>
<script src="<c:url value="/template/assets/js/vendor.min.js"/>"></script>
<script src="<c:url value="/template/assets/js/app.min.js"/>"></script>
<%--<!-- third party js -->--%>
<%--<script src="<c:url value="/template/assets/js/vendor/jquery-jvectormap-1.2.2.min.js"/>"></script>--%>
<%--<script src="<c:url value="/template/assets/js/vendor/jquery-jvectormap-world-mill-en.js"/>"></script>--%>
<!-- third party js ends -->

<!-- demo app -->
<%--<script src="<c:url value="/template/assets/js/pages/demo.dashboard.js"/>"></script>--%>
<!-- end demo js-->
</body>
</html>