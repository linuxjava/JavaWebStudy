package cn.itcast.servlet.login.servlet;

import cn.itcast.servlet.login.bean.LoginParams;
import cn.itcast.servlet.login.bean.User;
import cn.itcast.servlet.login.dao.impl.UserDao;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

//        String username = request.getParameter("username");
//        String password = request.getParameter("password");

        //BeanUtils使用
        LoginParams loginParams = new LoginParams();
        try {
            BeanUtils.populate(loginParams, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        UserDao userDao = new UserDao();
        User user = userDao.login(loginParams.getUsername(), loginParams.getPassword());
        if(user == null){
            request.getRequestDispatcher("/loginFailServlet").forward(request, response);
        }else {
            request.setAttribute("name", loginParams.getUsername());
            request.getRequestDispatcher("/loginSuccServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
