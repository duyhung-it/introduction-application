<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nguyen Duy Hung
  Date: 3/12/2023
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container-fluid">
    <!-- start page title -->
    <div class="row">
        <div class="col-12">
            <div class="page-title-box">
                <h4 class="page-title">Videos</h4>
            </div>
        </div>
    </div>
    <!-- end page title -->
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-body">
                    <form action="admin-video/edit" method="post" enctype="multipart/form-data">
                        <input type="text" name="id" value="${video.id}" style="display: none">
                        <div class="row">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-3">
                                <div class="" style="border: 1px solid black;min-height: 50px">
                                    <img
                                            src="<c:url value="/uploads/${video.poster}"/>"
                                            alt=""
                                            style="max-width: 100%"
                                    />
                                </div>
                                <div>
                                    <div class="form-group">
                                        <label for="poster-id">Poster</label>
                                        <input
                                                type="file"
                                                id="poster-id"
                                                class="form-control"
                                                name="file-poster"
                                        />
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-5">
                                <div class="form-group">
                                    <label for="youtube-link">Youtube</label>
                                    <input
                                            type="text"
                                            id="youtube-link"
                                            class="form-control"
                                            name="youtube"
                                            value="${video.youtubeLink}"
                                    />
                                </div>
                                <div class="form-group">
                                    <label for="video-title">Video Title</label>
                                    <input
                                            type="text"
                                            id="video-title"
                                            class="form-control"
                                            name="title"
                                            value="${video.title}"
                                    />
                                </div>
                                <div class="form-group">
                                    <label for="view-count">View Count</label>
                                    <input
                                            type="number"
                                            id="view-count"
                                            class="form-control"
                                            name="title"
                                            value="${video.views}"
                                    />
                                </div>
                                <div class="mt-2">
                                    <div
                                            class="custom-control custom-radio custom-control-inline"
                                    >
                                        <input
                                                type="radio"
                                                id="customRadio3"
                                                name="active"
                                                class="custom-control-input"
                                                value="true"
                                                checked="${video.active}"
                                        />
                                        <label class="custom-control-label" for="customRadio3"
                                        >Active
                                        </label>
                                    </div>
                                    <div
                                            class="custom-control custom-radio custom-control-inline"
                                    >
                                        <input
                                                type="radio"
                                                id="customRadio4"
                                                name="active"
                                                class="custom-control-input"
                                                value="false"
                                                checked="${!video.active}"
                                        />
                                        <label class="custom-control-label" for="customRadio4"
                                        >Inactive
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-2"></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-8">
                                <div class="form-group">
                                    <label for="example-textarea">Description</label>
                                    <textarea
                                            class="form-control"
                                            id="example-textarea"
                                            rows="5"
                                            name="description"

                                    >${video.description}</textarea>
                                </div>
                            </div>
                            <div class="col-sm-2"></div>
                        </div>
                        <div class="row">
                            <div class="col-sm-2"></div>
                            <div class="col-sm-8">
                                <button class="btn btn-primary" type="submit">
                                    ${button}
                                </button>
                            </div>
                            <div class="col-sm-2"></div>
                        </div>
                    </form>
                </div>
                <!-- end card-body-->
            </div>
            <!-- end card-->
        </div>
        <!-- end col -->
    </div>
    <!-- end row -->
</div>
