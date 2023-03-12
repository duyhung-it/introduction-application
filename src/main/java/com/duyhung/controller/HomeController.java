package com.duyhung.controller;

import com.duyhung.entity.User;
import com.duyhung.service.IUserService;
import com.duyhung.service.impl.UserService;
import com.duyhung.util.FormUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "HomeController", value = {"/login","/home"})
public class HomeController extends HttpServlet {
    private IUserService service;

    @Override
    public void init() throws ServletException {
        service = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/login.jsp");
        String message = req.getParameter("message");
        if(message != null) req.setAttribute("message",message);
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action != null && action.equals("login")){
            User user = FormUtil.toEntity(User.class,req);
            user = service.findByEmailAndPass(user.getEmail(), user.getPassword());
            if(user != null){
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
