package com.duyhung.controller.admin;

import com.duyhung.entity.Video;
import com.duyhung.service.IVideoService;
import com.duyhung.service.impl.VideoService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@WebServlet(name = "AdminHomeController", value = {"/admin-home","/admin-video"})
public class HomeController extends HttpServlet {
    private IVideoService service;

    @Override
    public void init() throws ServletException {
        service =new VideoService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("video")){
            String type = request.getParameter("type");
            if(type != null && (type.equals("edit") || type.equals("add"))) {
                String id = request.getParameter("id");
                if(id != null){
                    Video video = service.findById(Long.parseLong(id));
                    request.setAttribute("video",video);
                }
                request.setAttribute("button",type.toUpperCase());
                request.setAttribute("view", "/views/admin/form-video.jsp");
            }else{
                List<Video> listVideos = service.getAll();
                request.setAttribute("listVideos",listVideos);
                request.setAttribute("view", "/views/admin/video.jsp");
            }
        }else{
            request.setAttribute("view","/views/admin/home.jsp");
        }
        request.getRequestDispatcher("/views/admin/index.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
