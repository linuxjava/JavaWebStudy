package cn.itcast.servlet.filedownload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");

        ServletContext servletContext = getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        FileInputStream fileInputStream = new FileInputStream(realPath);

        //1设置相应类型
        String mimeType = servletContext.getMimeType(realPath);
        //1.1设置响应头类型：content-type
        resp.setContentType(mimeType);
        //1.2解决中文文件名在下载提示中乱码问题
        filename = DownLoadUtils.getFileName(req.getHeader("user-agent"), filename);
        //1.2如果不设置文件下载方式，那么默认会在浏览器中直接显示，而不是下载
        resp.setHeader("content-disposition", "attachment;filename=" + filename);

        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(data)) != -1){
            outputStream.write(data, 0, len);
        }

        fileInputStream.close();
    }
}
