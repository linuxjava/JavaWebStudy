package com.itheima.web.servlet;

import com.alibaba.druid.util.StringUtils;
import com.itheima.bean.PageInfo;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/pageServlet")
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String pi = request.getParameter("pageIndex");
        String ps = request.getParameter("pageSize");
        String username = request.getParameter("username");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String queryType = request.getParameter("queryType");

        int pageIndex = StringUtils.isEmpty(pi) || !StringUtils.isNumber(pi) ? 1 : Integer.valueOf(pi);
        int pageSize = StringUtils.isEmpty(ps) || !StringUtils.isNumber(pi) ? 7 : Integer.valueOf(ps);

        //全局查询将pageIndex设置为1
        if("all".equalsIgnoreCase(queryType)){
            pageIndex = 1;
        }

        PageInfo.Condition condition = new PageInfo.Condition();
        condition.setUsername(username);
        condition.setAddress(address);
        condition.setEmail(email);

        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageIndex(pageIndex);
        pageInfo.setPageSize(pageSize);
        pageInfo.setCondition(condition);

        IAccountService service = new AccountServiceImpl();
        service.findByPage(pageIndex, pageSize, username, address, email, pageInfo);

        request.setAttribute("pi", pageInfo);
        request.getRequestDispatcher("/userlist.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
