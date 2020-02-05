package cn.itcast.servlet.request;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

/**
 * servlet request功能
 */
@WebServlet("/servlet3")
public class ServletDemo3 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求行数据
        String method = req.getMethod();
        System.out.println("method = " + method);
        String contextPath = req.getContextPath();
        System.out.println("contextPath = " + contextPath);
        String servletPath = req.getServletPath();
        System.out.println("servletPath = " + servletPath);
        String queryString = req.getQueryString();
        System.out.println("queryString = " + queryString);
        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL = " + requestURL);
        String protocol = req.getProtocol();
        System.out.println("protocol = " + protocol);
        String remoteAddr = req.getRemoteAddr();
        System.out.println("remoteAddr = " + remoteAddr);

        //获取请求头数据
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String header = headerNames.nextElement();
            String value = req.getHeader(header);
            System.out.println(header + " : " + value);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
    }
}
