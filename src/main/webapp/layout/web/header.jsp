<%--
  Created by IntelliJ IDEA.
  User: Nguyen Duy Hung
  Date: 3/12/2023
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="navbar-custom topnav-navbar topnav-navbar-dark">
    <div class="container-fluid">

        <!-- LOGO -->
        <a href="<c:url value="/home"/>" class="topnav-logo">
                                <span class="topnav-logo-lg">
                                    <img src="<c:url value="/template/assets/images/logo-light.png"/>" alt="" height="16">
                                </span>
            <span class="topnav-logo-sm">
                                    <img src="<c:url value="/template/assets/images/logo_sm_dark.png"/>" alt="" height="16">
                                </span>
        </a>

        <ul class="list-unstyled topbar-right-menu float-right mb-0">

            <li class="dropdown notification-list d-lg-none">
                <a class="nav-link dropdown-toggle arrow-none" data-toggle="dropdown" href="#" role="button"
                   aria-haspopup="false" aria-expanded="false">
                    <i class="dripicons-search noti-icon"></i>
                </a>
                <div class="dropdown-menu dropdown-menu-animated dropdown-lg p-0">
                    <form class="p-3">
                        <input type="text" class="form-control" placeholder="Search ..."
                               aria-label="Recipient's username">
                    </form>
                </div>
            </li>
            <li class="dropdown notification-list">
                <c:if test="${user != null}">
                    <a class="nav-link dropdown-toggle nav-user arrow-none mr-0" data-toggle="dropdown" id="topbar-userdrop"
                       href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                        <span class="account-user-avatar">
                                            <img src="<c:url value="/template/assets/images/users/avatar-1.jpg"/>" alt="user-image"
                                                 class="rounded-circle">
                                        </span>
                        <span>
                                            <span class="account-user-name">${user.fullName}</span>
                                            <span class="account-position">Founder</span>
                                        </span>
                    </a>
                </c:if>
                <c:if test="${user == null}">
                    <ul>
                        <li><a href="<c:url value="/login?action=login"/>">Login</a></li>
                        <li><a href="#">Sign up</a></li>
                    </ul>
                </c:if>
                <div class="dropdown-menu dropdown-menu-right dropdown-menu-animated topbar-dropdown-menu profile-dropdown"
                     aria-labelledby="topbar-userdrop">
                    <!-- item-->
                    <div class=" dropdown-header noti-title">
                        <h6 class="text-overflow m-0">Welcome !</h6>
                    </div>
                    <!-- item-->
                    <a href="<c:url value="/home?action=logout"/>" class="dropdown-item notify-item">
                        <i class="mdi mdi-logout mr-1"></i>
                        <span>Logout</span>
                    </a>

                </div>
            </li>

        </ul>
        <a class="navbar-toggle" data-toggle="collapse" data-target="#topnav-menu-content">
            <div class="lines">
                <span></span>
                <span></span>
                <span></span>
            </div>
        </a>
        <div class="app-search dropdown">
            <form>
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search..." id="top-search">
                    <span class="mdi mdi-magnify search-icon"></span>
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="submit">Search</button>
                    </div>
                </div>

            </form>


        </div>
    </div>
</div>
<div class="topnav shadow-sm">
    <div class="container-fluid active">
        <nav class="navbar navbar-light navbar-expand-lg topnav-menu">
            <div class="collapse navbar-collapse active" id="topnav-menu-content">
                <ul class="navbar-nav">
                    <li class="nav-item active ">
                        <a class="nav-link" href="<c:url value="/home"/>"
                           aria-haspopup="true" aria-expanded="true">
                            <i class="uil-dashboard mr-1"></i>Home
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
</div>
