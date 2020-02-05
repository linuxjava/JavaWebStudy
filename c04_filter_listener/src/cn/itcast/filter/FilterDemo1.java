package cn.itcast.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

import static javax.servlet.DispatcherType.FORWARD;
import static javax.servlet.DispatcherType.REQUEST;

//@WebFilter(urlPatterns = {"/*.jsp"}, dispatcherTypes = REQUEST)
//@WebFilter(value = "/index.jsp", dispatcherTypes = {REQUEST, FORWARD})
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截前");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("拦截后");
    }

    @Override
    public void destroy() {

    }
}
