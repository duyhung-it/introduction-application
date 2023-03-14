<%--
  Created by IntelliJ IDEA.
  User: Nguyen Duy Hung
  Date: 3/12/2023
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="left-side-menu">

    <!-- LOGO -->
    <a href="javascript: void(0);" class="logo text-center logo-light">
                    <span class="logo-lg">
                        <img src="<c:url value="/template/assets/images/logo.png"/>" alt="" height="16">
                    </span>
        <span class="logo-sm">
                        <img src="<c:url value="/template/assets/images/logo_sm.png"/>" alt="" height="16">
                    </span>
    </a>

    <!-- LOGO -->
    <a href="javascript: void(0);" class="logo text-center logo-dark">
                    <span class="logo-lg">
                        <img src="<c:url value="/template/assets/images/logo-dark.png"/>" alt="" height="16">
                    </span>
        <span class="logo-sm">
                        <img src="<c:url value="/template/assets/images/logo_sm_dark.png"/>" alt="" height="16">
                    </span>
    </a>

    <div class="h-100 mm-active" id="left-side-menu-container" data-simplebar="init">
        <div class="simplebar-wrapper" style="margin: 0;">
            <div class="simplebar-height-auto-observer-wrapper">
                <div class="simplebar-height-auto-observer"></div>
            </div>
            <div class="simplebar-mask">
                <div class="simplebar-offset" style="right: 0; bottom: 0;">
                    <div class="simplebar-content-wrapper" style="height: 100%; overflow: hidden;">
                        <div class="simplebar-content" style="padding: 0;">

                            <!--- Sidemenu -->
                            <ul class="metismenu side-nav mm-show">

                                <li class="side-nav-title side-nav-item">Navigation</li>

                                <li class="side-nav-item">
                                    <a href="javascript: void(0);" class="side-nav-link">
                                        <i class="uil-home-alt"></i>
                                        <span class="badge badge-success float-right">4</span>
                                        <span> Dashboards </span>
                                    </a>
                                    <ul class="side-nav-second-level mm-collapse" aria-expanded="false">
                                        <li>
                                            <a href="javascript: void(0);">Analytics</a>
                                        </li>
                                        <li>
                                            <a href="javascript: void(0);">CRM</a>
                                        </li>
                                        <li>
                                            <a href="javascript: void(0);">Ecommerce</a>
                                        </li>
                                        <li>
                                            <a href="javascript: void(0);">Projects</a>
                                        </li>
                                    </ul>
                                </li>

                                <li class="side-nav-title side-nav-item">Apps</li>
                            </ul>
                            <!-- End Sidebar -->

                            <div class="clearfix"></div>

                        </div>
                    </div>
                </div>
            </div>
            <div class="simplebar-placeholder" style="width: auto; height: 72px;"></div>
        </div>
        <div class="simplebar-track simplebar-horizontal" style="visibility: hidden;">
            <div class="simplebar-scrollbar" style="width: 0; display: none;"></div>
        </div>
        <div class="simplebar-track simplebar-vertical" style="visibility: hidden;">
            <div class="simplebar-scrollbar"
                 style="height: 0; transform: translate3d(0px, 0px, 0px); display: none;"></div>
        </div>
    </div>
    <!-- Sidebar -left -->

</div>