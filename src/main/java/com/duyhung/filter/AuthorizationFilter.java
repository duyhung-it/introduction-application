package com.duyhung.filter;

import com.duyhung.entity.User;
import com.duyhung.util.SessionUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "AuthorizationFilter",value = "/*")
public class AuthorizationFilter implements Filter {
    private ServletContext context;
    public void init(FilterConfig config) throws ServletException {
        context = config.getServletContext();
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        String uri = request1.getRequestURI();
        if(uri.contains("/admin")){
            User user = (User) SessionUtil.getInstant().getValue(request1,"user");
            if(user != null){
                if(user.getIsAdmin()){
                    chain.doFilter(request,response);
                }
            }else{
                response1.sendRedirect(request1.getContextPath() + "/login?action=login&message=not_permission&alert=danger");
            }
        }else{
            chain.doFilter(request,response);
        }
    }
}
