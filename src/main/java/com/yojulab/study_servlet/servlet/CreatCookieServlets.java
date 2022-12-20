package com.yojulab.study_servlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cookies/createServlets")
public class CreatCookieServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Cookie
        Cookie cookie_first = new Cookie("firstName", "KIM");
        Cookie cookie_second = new Cookie("secondName", "BG");
        response.addCookie(cookie_first);
        response.addCookie(cookie_second);

        // display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>CreatCookieServlets</div>");
        printWriter.close();
    }
}
