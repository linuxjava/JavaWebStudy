package cn.itcast.servlet.response;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 字符输出和字节输出
 */
@WebServlet("/responseDemo3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码，解决中文乱码问题
        resp.setContentType("text/html;charset=utf-8");

        //字符输出
        //resp.getWriter().write("返回相应数据");

        //字节输出
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write("字节束输出流".getBytes("utf-8"));//必须要设置编码，否则会乱码
    }
}
