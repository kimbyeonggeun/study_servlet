package com.yojulab.study_servlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.yojulab.study_servlet.DatasInfor;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dispatcherJSPTablesListServlets")
public class DispatcherJSPTablesListServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DatasInfor datasInfor = new DatasInfor();
        ArrayList<String> tablesListWithStrng = datasInfor.getTablesListData();
        HashMap<String, String> searchForm = datasInfor.getSearchFormData();
        request.setAttribute("tablesListWithString", tablesListWithStrng);
        request.setAttribute("searchForm", searchForm);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/tables_list.jsp");
        requestDispatcher.forward(request, response);

    }
}
