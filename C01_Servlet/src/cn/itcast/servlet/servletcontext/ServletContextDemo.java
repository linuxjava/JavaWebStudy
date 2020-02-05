package cn.itcast.servlet.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext代表整个web应用，可以和程序的容器(服务器)来通信
 */
@WebServlet("/servletcontextdemo")
public class ServletContextDemo extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

        String realPath = servletContext.getRealPath("login.html");
        System.out.println(realPath);
        String mimeType = servletContext.getMimeType(realPath);
        System.out.println(mimeType);

        realPath = servletContext.getRealPath("/WEB-INF/web.xml");
        System.out.println(realPath);
        mimeType = servletContext.getMimeType(realPath);
        System.out.println(mimeType);

        realPath = servletContext.getRealPath("/WEB-INF/druid.properties");
        System.out.println(realPath);
        mimeType = servletContext.getMimeType(realPath);
        System.out.println(mimeType);

        //域对象，设置共享数据
        servletContext.setAttribute("name", "test");
    }
}
