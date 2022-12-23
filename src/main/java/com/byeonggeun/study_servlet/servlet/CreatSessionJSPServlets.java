package com.byeonggeun.study_servlet.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// /session/CreatSessionJSPServlets?username=KimBG&password=1234
@WebServlet(urlPatterns = "/session/CreatSessionJSPServlets")
public class CreatSessionJSPServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // display
        // login
        HttpSession httpSession = null;
        HttpSession httpSession_false = null;

        // ID가 존재할 때
        // httpSession_false = request.getSession(false); // 존재하면 인스턴스화
        // httpSession = request.getSession(); // 무조건 인스턴스화

        // ID가 존재하지 않을 때
        // httpSession_false = request.getSession(false); // Null
        // httpSession = request.getSession(); // 무조건 인스턴스화

        String path = null;
        if ("KimBG".equals(username) && "1234".equals(password)) {
            // login
            httpSession = request.getSession(false); // 존재하면 인스턴스화
            if (httpSession == null) {
                httpSession = request.getSession(); // 무조건 인스턴스화
                httpSession.setAttribute("username", username);
                httpSession.setAttribute("password", password);
            }
            path = "/session/checkLogin.jsp";
        } else {
            // logout
            httpSession = request.getSession(false);
            if (httpSession != null) {
                httpSession.invalidate(); // 세션 삭제
            }
            path = "/session/checkLogout.jsp";
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
}
