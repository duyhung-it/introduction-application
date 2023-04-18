package com.duyhung.controller.web;

import com.duyhung.entity.Favorite;
import com.duyhung.entity.User;
import com.duyhung.entity.Video;
import com.duyhung.service.IFavoriteService;
import com.duyhung.service.IVideoService;
import com.duyhung.service.impl.FavoriteService;
import com.duyhung.service.impl.VideoService;
import com.duyhung.util.HttpUtil;
import com.duyhung.util.SessionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FavoriteController",value = {
        "/video-like",
        "/video-my-favorites"
})
public class FavoriteController extends HttpServlet {
    private IFavoriteService favoriteService;
    private IVideoService videoService;
    @Override
    public void init() throws ServletException {
        favoriteService = new FavoriteService();
        videoService = new VideoService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) SessionUtil.getInstant().getValue(req,"user");
        String view = "/views/web/favorite-videos.jsp";
        if(user != null){
            List<Video> list = videoService.getVideoFavorite(user.getId());
            req.setAttribute("listVideos",list);
        }else {
            view = "/views/web/error404.jsp";
        }
        req.setAttribute("view",view);
        req.getRequestDispatcher("/views/web/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper writer = new ObjectMapper();
        User user = (User) SessionUtil.getInstant().getValue(req,"user");
        if(user != null){
            Favorite favorite = HttpUtil.of(req.getReader()).toModel(Favorite.class);
            if(favorite != null){
                favoriteService.likeAVideo(favorite);
            }
            writer.writeValue(resp.getOutputStream(),favorite);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper writer = new ObjectMapper();
        User user = (User) SessionUtil.getInstant().getValue(req,"user");
        if(user != null){
            Favorite favorite = HttpUtil.of(req.getReader()).toModel(Favorite.class);
            if(favorite != null){
                favoriteService.unlikeAVideo(favorite);
            }
            writer.writeValue(resp.getOutputStream(),favorite);
        }
    }
}
