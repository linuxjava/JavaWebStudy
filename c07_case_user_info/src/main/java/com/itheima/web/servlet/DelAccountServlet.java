package com.itheima.web.servlet;

import com.alibaba.druid.util.StringUtils;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/delAccountServlet")
public class DelAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageIndex = request.getParameter("pageIndex");
        Map<String, String[]> parameterMap = request.getParameterMap();
        String[] uids = parameterMap.get("uid");

        if(uids != null){
            IAccountService service = new AccountServiceImpl();
            service.delByIds(uids);
        }

        if(StringUtils.isEmpty(pageIndex)){
            response.sendRedirect(request.getContextPath() + "/pageServlet");
        }else {
            response.sendRedirect(request.getContextPath() + "/pageServlet?pageIndex=" + pageIndex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
