package com.duyhung.controller.admin.video;

import com.duyhung.entity.Video;
import com.duyhung.service.IVideoService;
import com.duyhung.service.impl.VideoService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet(name = "VideoController", value = {"/admin-video/edit","/admin-video/delete"})
@MultipartConfig
public class VideoController extends HttpServlet {
    private IVideoService service;

    @Override
    public void init() throws ServletException {
        service = new VideoService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("delete")){
            String id = request.getParameter("id");
            if(id != null) doDelete(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String title = request.getParameter("title");
        String poster = getFileName(request.getPart("file-poster"));
        String description = request.getParameter("description");
        String youtubeLink = request.getParameter("youtube");
        Boolean active = Boolean.parseBoolean(request.getParameter("active"));
        Integer view = 0;
        Long id = idStr.isEmpty() ? null : Long.parseLong(idStr);
        Video video = new Video(id,title,poster,view,description,active,youtubeLink);
        if(id == null){
            Long savedId = service.save(video);
            if(savedId != null){
                response.sendRedirect(request.getContextPath() + "/admin-video");
            }
        }else{
            if(service.update(video)){
                response.sendRedirect(request.getContextPath() + "/admin-video");
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if(id != null){
            Video video = new Video();
            video.setId(Long.parseLong(id));
            if(service.remove(video)){
                resp.sendRedirect(req.getContextPath() + "/admin-video");
            }
        }
    }

    private String getFileName(Part part) throws IOException {
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        File uploads = new File("D:\\FPT Polytechnic\\Servlet_JSP\\Practice\\IntroductionApplication\\src\\main\\webapp\\uploads");
        File file = new File(uploads,fileName);
        if(!file.exists()){
            file.mkdir();
            part.write(file.getAbsolutePath());
        }
        return fileName;
    }
}
