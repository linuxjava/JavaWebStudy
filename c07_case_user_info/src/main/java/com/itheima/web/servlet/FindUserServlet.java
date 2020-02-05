package com.itheima.web.servlet;

import com.alibaba.druid.util.StringUtils;
import com.itheima.domain.Account;
import com.itheima.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");

        AccountServiceImpl service = new AccountServiceImpl();
        Account account = service.findById(uid);

        request.setAttribute("user", account);
        StringBuilder builder = new StringBuilder();
        builder.append("/updateuser.jsp?");

        request.getRequestDispatcher("/updateuser.jsp?").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
