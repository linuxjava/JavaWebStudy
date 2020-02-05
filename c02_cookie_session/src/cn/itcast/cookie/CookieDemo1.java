package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookiedemo1")
public class CookieDemo1 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("key1", "test");
        resp.addCookie(cookie1);
        Cookie cookie2 = new Cookie("key2", "中文cookie");
        cookie2.setMaxAge(15);//设置cookie过期时间
        resp.addCookie(cookie2);

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("设置cookie完成");
    }
}
