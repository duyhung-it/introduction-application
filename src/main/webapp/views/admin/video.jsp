<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nguyen Duy Hung
  Date: 3/12/2023
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="container-fluid">

    <!-- start page title -->
    <div class="row">
        <div class="col-12">
            <div class="page-title-box">

                <h4 class="page-title">Products</h4>
            </div>
        </div>
    </div>
    <!-- end page title -->

    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <div class="row mb-2">
                        <div class="col-sm-4">
                            <a href="<c:url value="/admin-video?type=add"/>" class="btn btn-danger mb-2"><i
                                    class="mdi mdi-plus-circle mr-2"></i> Add Videos</a>
                        </div>
                        <div class="col-sm-8">
                            <div class="text-sm-right">
                                <button type="button" class="btn btn-success mb-2 mr-1"><i class="mdi mdi-settings"></i>
                                </button>
                                <button type="button" class="btn btn-light mb-2 mr-1">Import</button>
                                <button type="button" class="btn btn-light mb-2">Export</button>
                            </div>
                        </div><!-- end col-->
                    </div>

                    <div class="table-responsive">
                        <div id="products-datatable_wrapper" class="dataTables_wrapper dt-bootstrap4 no-footer">
                            <div class="row">
                                <div class="col-sm-12 col-md-6">
                                    <div class="dataTables_length" id="products-datatable_length"><label>Display <select
                                            class="custom-select custom-select-sm ml-1 mr-1">
                                        <option value="5">5</option>
                                        <option value="10">10</option>
                                        <option value="20">20</option>
                                        <option value="-1">All</option>
                                    </select>videos</label></div>
                                </div>
                                <div class="col-sm-12 col-md-6">
                                    <div id="products-datatable_filter" class="dataTables_filter"><label>Search:<input
                                            type="search" class="form-control form-control-sm" placeholder=""
                                            aria-controls="products-datatable"></label></div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <table class="table table-centered w-100 dt-responsive nowrap dataTable no-footer dtr-inline"
                                           id="products-datatable" role="grid"
                                           aria-describedby="products-datatable_info" style="width: 1108px;">
                                        <thead class="thead-light">
                                        <tr role="row">
                                            <th>Id</th>
                                            <th>Title</th>
                                            <th>Views</th>
                                            <th>Status</th>
                                            <th>Action</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${listVideos}">
                                            <tr role="row" class="odd">
                                                <td>${item.id}</td>
                                                <td class="sorting_1">
                                                    <img src="<c:url value="/uploads/${item.poster}"/>" alt="contact-img" title="contact-img" class="rounded mr-3" height="48">
                                                    <p class="m-0 d-inline-block align-middle font-16">
                                                        <a href="#" class="text-body">${item.title}</a>
                                                        <br>
                                                        <span class="text-warning mdi mdi-star"></span>
                                                        <span class="text-warning mdi mdi-star"></span>
                                                        <span class="text-warning mdi mdi-star"></span>
                                                        <span class="text-warning mdi mdi-star"></span>
                                                        <span class="text-warning mdi mdi-star"></span>
                                                    </p>
                                                </td>
                                                <td>${item.views}</td>
                                                <td>
                                                    <c:if test="${item.active}">
                                                    <span class="badge badge-success">active</span>
                                                    </c:if>
                                                    <c:if test="${!item.active}">
                                                        <span class="badge badge-danger">inactive</span>
                                                    </c:if>
                                                </td>
                                                <td class="table-action">
                                                    <a href="javascript:void(0);" class="action-icon"> <i
                                                            class="mdi mdi-eye"></i></a>
                                                    <a href="<c:url value="/admin-video?type=edit&id=${item.id}"/>" class="action-icon"> <i
                                                            class="mdi mdi-square-edit-outline"></i></a>
                                                    <a href="<c:url value="/admin-video/delete?id=${item.id}"/>" class="action-icon"> <i
                                                            class="mdi mdi-delete"></i></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12 col-md-5">
                                    <div class="dataTables_info" id="products-datatable_info" role="status"
                                         aria-live="polite">Showing products 1 to 5 of 12
                                    </div>
                                </div>
                                <div class="col-sm-12 col-md-7">
                                    <div class="dataTables_paginate paging_simple_numbers"
                                         id="products-datatable_paginate">
                                        <ul class="pagination pagination-rounded">
                                            <li class="paginate_button page-item previous disabled"
                                                id="products-datatable_previous"><a href="#"
                                                                                    aria-controls="products-datatable"
                                                                                    data-dt-idx="0" tabindex="0"
                                                                                    class="page-link"><i
                                                    class="mdi mdi-chevron-left"></i></a></li>
                                            <li class="paginate_button page-item active"><a href="#"
                                                                                            aria-controls="products-datatable"
                                                                                            data-dt-idx="1" tabindex="0"
                                                                                            class="page-link">1</a></li>
                                            <li class="paginate_button page-item "><a href="#"
                                                                                      aria-controls="products-datatable"
                                                                                      data-dt-idx="2" tabindex="0"
                                                                                      class="page-link">2</a></li>
                                            <li class="paginate_button page-item "><a href="#"
                                                                                      aria-controls="products-datatable"
                                                                                      data-dt-idx="3" tabindex="0"
                                                                                      class="page-link">3</a></li>
                                            <li class="paginate_button page-item next" id="products-datatable_next"><a
                                                    href="#" aria-controls="products-datatable" data-dt-idx="4"
                                                    tabindex="0" class="page-link"><i class="mdi mdi-chevron-right"></i></a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> <!-- end card-body-->
            </div> <!-- end card-->
        </div> <!-- end col -->
    </div>
    <!-- end row -->
</div>
