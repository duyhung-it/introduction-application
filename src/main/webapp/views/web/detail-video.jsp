<%--
  Created by IntelliJ IDEA.
  User: Nguyen Duy Hung
  Date: 3/14/2023
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
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
            <div class="col-sm-9">
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
                        </div>
                </div>
            </div>
        </div>
    </div>
</section>
