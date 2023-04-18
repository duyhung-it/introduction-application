<%--
  Created by IntelliJ IDEA.
  User: Nguyen Duy Hung
  Date: 3/14/2023
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/video-like" var="likeURL"/>
<section>
    <div class="container-fluid">
        <div class="row">
            <div class="col-12">
                <div class="content-title">
                    <h2><i class="mdi mdi-star-box mr-1"></i>Video Detail</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-8">
                <div class="box card">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-12">
                                    <iframe width="100%" height="450px"
                                            src="https://www.youtube.com/embed/${video.youtubeLink}">
                                    </iframe>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <h6>${video.title}</h6>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <h6>${video.description}</h6>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="btn-group w-100" role="group" aria-label="Basic outlined example">
                                        <c:if test="${favorite == null}">
                                            <button type="button" class="btn btn-link btn-rounded" id="btn-like" data-liked="false"
                                                    onclick="doLike(this,${video.id})">
                                                <i class="mdi mdi-heart-outline "></i>
                                                <span>Like</span>
                                            </button>
                                        </c:if>
                                        <c:if test="${favorite != null}">
                                            <button type="button" class="btn btn-link btn-rounded" id="btn-like" data-liked="true"
                                                    onclick="doLike(this,${video.id})">
                                                <i class="mdi mdi-heart"></i>
                                                <span>Unlike</span>
                                            </button>
                                        </c:if>
                                        <button type="button" class="btn btn-link btn-rounded"><i
                                                class="mdi mdi-share-all-outline"></i> <span>Share</span>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="box card">
                    <div class="card-body">
                        <table class="table table-centered w-100 dt-responsive nowrap dataTable no-footer dtr-inline" id="products-datatable" role="grid" aria-describedby="products-datatable_info">
                            <thead class="thead-light">
                            <tr role="row">
                                <th class="sorting_disabled" rowspan="1" colspan="1" aria-label="Action">History</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listVideos}" var="item">
                                <tr role="row" class="odd">
                                    <td class="sorting_1">
                                        <img src="<c:url value="/uploads/${item.poster}"/>" alt="contact-img" title="contact-img" class="rounded mr-1" height="48">
                                        <p class="m-0 d-inline-block align-middle font-16">
                                            <a href="#" class="text-body">${item.title}</a>
                                            <br>
                                            <span>${item.views}</span>
                                        </p>
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
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