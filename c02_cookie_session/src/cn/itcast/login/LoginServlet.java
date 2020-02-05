package cn.itcast.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        String code = req.getParameter("code");

        HttpSession session = req.getSession();
        String checkCode = (String)session.getAttribute("checkCode");
        //验证码进行一次校验后就应该移除
        session.removeAttribute("checkCode");

        if(checkCode != null && checkCode.equalsIgnoreCase(code)){
            if("test".equals(username) && "123".equals(pwd)){
                session.setAttribute("username", username);
                resp.sendRedirect(req.getContextPath() + "/login/success.jsp");
            }else {
                req.setAttribute("error_msg", "用户名或密码错误");
                req.getRequestDispatcher("/login/login.jsp").forward(req, resp);
            }
        }else {
            req.setAttribute("error_msg", "验证码错误");
            req.getRequestDispatcher("/login/login.jsp").forward(req, resp);
        }
    }
}
