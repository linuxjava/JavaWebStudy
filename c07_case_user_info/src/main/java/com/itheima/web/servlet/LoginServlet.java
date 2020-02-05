package com.itheima.web.servlet;

import com.alibaba.druid.util.StringUtils;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.domain.Account;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkcodeParam = request.getParameter("checkcode");
        String checkCode = (String) request.getSession().getAttribute("checkCode");
        request.getSession().removeAttribute("checkCode");
        if(StringUtils.isEmpty(checkcodeParam) || !checkcodeParam.equalsIgnoreCase(checkCode)){
            setErrMsg(request, response, "验证码错误");
            return;
        }

        Map<String, String[]> parameterMap = request.getParameterMap();

        Account account = new Account();
        try {
            BeanUtils.populate(account, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        AccountDaoImpl accountDao = new AccountDaoImpl();
        Account newAccount = accountDao.login(account.getUsername(), account.getPassword());
        if(newAccount == null){
            setErrMsg(request, response, "账号或密码错误");
            return;
        }

        request.removeAttribute("errMsg");
        request.getSession().setAttribute("account", newAccount);

        response.sendRedirect(request.getContextPath() + "/pageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void setErrMsg(HttpServletRequest request, HttpServletResponse response, String msg) throws ServletException, IOException {
        request.setAttribute("errMsg", msg);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
