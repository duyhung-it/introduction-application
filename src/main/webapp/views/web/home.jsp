<%--
  Created by IntelliJ IDEA.
  User: Nguyen Duy Hung
  Date: 3/12/2023
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<c:url value="/video-like" var="likeURL"/>
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
                                    <img src="<c:url value="/uploads/${item.poster}"/>" class="img-thumbnail" alt=""/>
                                </div>
                            </a>
                            <div class="detail-box">
                                <div class="row">
                                    <div class="col-sm-9">
                                        <h6 class="card-title">${item.title}</h6>
                                    </div>
                                    <div class="col-sm-3">
                                        <i class="mdi mdi-eye"></i> <span>${item.views}</span>
                                    </div>
                                    <div class="col-sm-12">
                                        <div class="btn-group w-100" role="group" aria-label="Basic outlined example">

                                            <c:set var="id" value="${item.id}abc"/>
                                            <c:if test="${favorites[id] == null}">
                                                <button type="button" class="btn btn-link btn-rounded" id="btn-like" data-liked="false"
                                                        onclick="doLike(this,${item.id})">
                                                    <i class="mdi mdi-heart-outline "></i>
                                                    <span>Like</span>
                                                </button>
                                            </c:if>
                                            <c:if test="${favorites[id]}">
                                                <button type="button" class="btn btn-link btn-rounded" id="btn-like" data-liked="true"
                                                        onclick="doLike(this,${item.id})">
                                                    <i class="mdi mdi-heart"></i>
                                                    <span>Unlike</span>
                                                </button>
                                            </c:if>
                                            <button type="button" class="btn btn-link btn-rounded"><i
                                                    class="mdi mdi-share-all-outline"></i> <span>Share</span>
                                            </button>
                                        </div>
                                    </div>
                                        <%--                                        <div class="col-sm-6">--%>
                                        <%--                                            <div class="" role="group" aria-label="Basic outlined example">--%>
                                        <%--                                                <button type="button" class="btn btn-light"><i class="mdi mdi-heart-outline "></i> <span>Like</span> </button>--%>
                                        <%--                                                <button type="button" class="btn btn-light"><i class="mdi mdi-share-all-outline"></i> <span>Share</span> </button>--%>
                                        <%--                                            </div>--%>
                                        <%--                                        </div>--%>
                                </div>
                            </div>
                        </div>
                        <div style="clear: both"></div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>
<c:if test="${user != null}">
    <script type="text/javascript">
        function doLike(btn, id) {
            let data = {};
            data.userId = ${user.id};
            data.videoId = id;
            let abc = id + "abc";
            console.log(data.id);
            let liked =  btn.getAttribute("data-liked");
            if(liked === "false"){
                btn.dataset.liked = "true";
                btn.getElementsByTagName("i")[0].className = "mdi mdi-heart";
                btn.getElementsByTagName("span")[0].innerHTML = "Unliked";
                like(data);
            }else{
                btn.dataset.liked = "false";
                btn.getElementsByTagName("i")[0].className = "mdi mdi-heart-outline";
                btn.getElementsByTagName("span")[0].innerHTML = "Like";
                unLiked(data);
            }
        }

        function like(data) {
            $.ajax({
                url: '${likeURL}',
                type: 'POST',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (response) {

                },
                error: function (error) {
                    window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
                }
            });
        }
        function unLiked(data) {
            $.ajax({
                url: '${likeURL}',
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (response) {

                },
                error: function (error) {
                    window.location.href = "${NewURL}?type=list&maxPageItem=2&page=1&message=error_system";
                }
            });
        }
    </script>
</c:if>
