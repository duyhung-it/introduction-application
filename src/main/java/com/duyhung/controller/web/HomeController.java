package com.duyhung.controller.web;

import com.duyhung.entity.Favorite;
import com.duyhung.entity.User;
import com.duyhung.entity.Video;
import com.duyhung.service.IFavoriteService;
import com.duyhung.service.IUserService;
import com.duyhung.service.IVideoService;
import com.duyhung.service.impl.FavoriteService;
import com.duyhung.service.impl.UserService;
import com.duyhung.service.impl.VideoService;
import com.duyhung.util.FormUtil;
import com.duyhung.util.SessionUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "HomeController", value = {"/login","/home","/home/detail-video"})
public class HomeController extends HttpServlet {
    private IUserService service;
    private IVideoService videoService;
    private IFavoriteService favoriteService;
    @Override
    public void init() throws ServletException {
        service = new UserService();
        videoService = new VideoService();
        favoriteService = new FavoriteService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        User user = (User) SessionUtil.getInstant().getValue(req,"user");
        if((action != null && action.equals("login"))){
            String message = req.getParameter("message");
            String alert = req.getParameter("alert");
            if(message != null && alert != null){
                req.setAttribute("message",message);
                req.setAttribute("alert",alert);
            }
            req.getSession().setMaxInactiveInterval(0);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
            requestDispatcher.forward(req,resp);
        }else if(action != null && action.equals("logout")){
            SessionUtil.getInstant().removeValue(req,"user");
            req.getSession().setMaxInactiveInterval(0);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
            requestDispatcher.forward(req,resp);
        }else{
            String uri = req.getRequestURI();
            if(uri.contains("detail")){
                String id = req.getParameter("id");
                if(id != null){
                    Video video = videoService.findById(Long.parseLong(id));
                    req.setAttribute("video",video);
                    video.setViews(video.getViews() + 1);
                    videoService.update(video);
                    Cookie cookie = new Cookie(video.getId() +"",video.getId()+"");
                    resp.addCookie(cookie);
                    Cookie[] cookies = req.getCookies();
                    List<Video> viewed = new ArrayList<>();
                    for(Cookie c : cookies){
                        try{
                            if(!c.getName().equalsIgnoreCase("JSESSIONID")){
                                Video v = videoService.findById(Long.parseLong(c.getValue()));
                                if(v != null) viewed.add(v);
                            }
                        }catch (NumberFormatException ex){
                            ex.printStackTrace();
                        }
                    }
                    req.setAttribute("listVideos",viewed);
                    if(user != null){
                        Favorite favorite = favoriteService.getOne(user.getId(),Long.parseLong(id));
                        req.setAttribute("favorite",favorite);
                        req.setAttribute("user",user);
                    }
                }
                req.setAttribute("view","/views/web/detail-video.jsp");
            }else {
                String view = "/views/web/home.jsp";
                req.setAttribute("listVideos", videoService.getAll());
                req.setAttribute("view", view);
                if(user != null){
                    List<Favorite> favorites = favoriteService.getAllByUser(user);
                    Map<String,String> mapFavorite = new HashMap<>();
                    for(Favorite f : favorites){
                        mapFavorite.put(f.getVideoId()+"abc","true");
                    }
                    String videoId = req.getParameter("idVideo");
                    mapFavorite.put(videoId + "abc", "true");
                    req.setAttribute("favorites",mapFavorite);
                }
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
