package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookiedemo3")
public class CookieDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lastAccessTime = null;
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if ("lastAccessTime".equals(cookie.getName())) {
                lastAccessTime = cookie.getValue();
                break;
            }
        }

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String dateStr = sdf.format(date);

        Cookie cookie = new Cookie("lastAccessTime", URLEncoder.encode(dateStr, "utf-8"));
        cookie.setMaxAge(60 * 60 * 24 * 30);//一个月
        resp.addCookie(cookie);


        resp.setContentType("text/html;charset=utf-8");
        if (lastAccessTime != null) {
            resp.getWriter().write("欢迎回来，您上次访问时间为:" + URLDecoder.decode(lastAccessTime, "utf-8"));
        } else {
            resp.getWriter().write("您好，欢迎您首次访问");
        }
    }
}
