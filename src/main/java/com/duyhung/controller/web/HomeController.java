package com.duyhung.controller.web;

import com.duyhung.entity.User;
import com.duyhung.entity.Video;
import com.duyhung.service.IUserService;
import com.duyhung.service.IVideoService;
import com.duyhung.service.impl.UserService;
import com.duyhung.service.impl.VideoService;
import com.duyhung.util.FormUtil;
import com.duyhung.util.SessionUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "HomeController", value = {"/login","/home","/home/detail-video"})
public class HomeController extends HttpServlet {
    private IUserService service;
    private IVideoService videoService;
    @Override
    public void init() throws ServletException {
        service = new UserService();
        videoService = new VideoService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if((action != null && action.equals("login"))){
            String message = req.getParameter("message");
            String alert = req.getParameter("alert");
            if(message != null && alert != null){
                req.setAttribute("message",message);
                req.setAttribute("alert",alert);
            }
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
            requestDispatcher.forward(req,resp);
        }else if(action != null && action.equals("logout")){
            SessionUtil.getInstant().removeValue(req,"user");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
            requestDispatcher.forward(req,resp);
        }else{
            String uri = req.getRequestURI();
            if(uri.contains("detail")){
                String id = req.getParameter("id");
                if(id != null){
                    Video video = videoService.findById(Long.parseLong(id));
                    req.setAttribute("video",video);
                }
                req.setAttribute("view","/views/web/detail-video.jsp");
            }else {
                String view = "/views/web/home.jsp";
                req.setAttribute("listVideos", videoService.getAll());
                req.setAttribute("view", view);

            }
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/web/index.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action != null && action.equals("login")){
            User user = FormUtil.toEntity(User.class,req);
            user = service.findByEmailAndPass(user.getEmail(), user.getPassword());
            if(user != null){
                SessionUtil.getInstant().putValue(req,"user",user);
                if(user.getIsAdmin()){
                    resp.sendRedirect(req.getContextPath() + "/admin-home");
                }else{
                    resp.sendRedirect(req.getContextPath() + "/home?message=success");
                }
            }else{
                resp.sendRedirect(req.getContextPath() + "/login?action=login&message=invalid");
            }
        }
    }
}
