<%--
  Created by IntelliJ IDEA.
  User: Nguyen Duy Hung
  Date: 3/12/2023
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<section>
    <div class="container-fluid">
        <div class="new-content">
            <div class="content-title">
                <h2><i class="mdi mdi-star-box mr-1"></i>Video</h2>
            </div>
            <div class="row">
                <c:forEach items="${listVideos}" var="item">
                    <div
                            class="col-lg-3 col-md-4 col-sm-6"
                    >
                        <div class="box card card-hover">
                            <a href="<c:url value="/home/detail-video?id=${item.id}"/>">
                                <div class="img-box">
                                    <img src="<c:url value="/uploads/${item.poster}"/>" class="img-thumbnail" alt="" />
                                </div>
                                <div class="detail-box">
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <h6>${item.title}</h6>
                                        </div>
                                        <div class="col-sm-8">
                                            <div class="btn-group" role="group" aria-label="Basic outlined example">
                                                <button type="button" class="btn btn-light"><i class="mdi mdi-heart-outline "></i> <span>Like</span> </button>
                                                <button type="button" class="btn btn-light"><i class="mdi mdi-share-all-outline"></i> <span>Share</span> </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div style="clear: both"></div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>

