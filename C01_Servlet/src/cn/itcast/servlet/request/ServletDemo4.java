package cn.itcast.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Map;

/**
 * 获取请求参数通用方式：不论get还是post请求方式都可以使用下列方法来获取请求参数
 */
@WebServlet("/servlet4")
public class ServletDemo4 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        test(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        test(req, resp);
    }

    private void test(HttpServletRequest req, HttpServletResponse resp){
        //tomcat 8 已经将get方式乱码问题解决了,post方式：会乱码
        try {
            req.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println(parameterMap);

        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String key = parameterNames.nextElement();
            String value = req.getParameter(key);
            System.out.println(key + " : " + value);
        }
    }
}
