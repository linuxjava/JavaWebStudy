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

@WebServlet("/addAccountServlet")
public class AddAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Map<String, String[]> parameterMap = request.getParameterMap();
        Account account = new Account();
        try {
            BeanUtils.populate(account, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(account);
        if(!StringUtils.isEmpty(account.getUsername())){
            AccountDaoImpl accountDao = new AccountDaoImpl();
            accountDao.add(account);

            response.sendRedirect(request.getContextPath() + "/pageServlet");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
