package cn.itcast.login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("/*")
public class LoginFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("username");

        String uri = req.getRequestURI();
        if(uri.endsWith(".js") || uri.endsWith(".css") || uri.endsWith(".jpg") || uri.endsWith(".png") || uri.contains("/login.jsp")
                || uri.contains("/checkcode")|| uri.contains("/loginservlet")){
            //不拦截这些资源
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            if (username != null && !"".equals(username)) {//已登录
                filterChain.doFilter(servletRequest, servletResponse);
            } else {//未登录
                req.setAttribute("error_msg", "您尚未登录");
                req.getRequestDispatcher("/login/login.jsp").forward(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
