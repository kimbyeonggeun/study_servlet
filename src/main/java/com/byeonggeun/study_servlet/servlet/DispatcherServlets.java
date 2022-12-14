package com.byeonggeun.study_servlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dispatcherServlets")
public class DispatcherServlets extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String hiddenParam = request.getParameter("hiddenParam");

        // /dispatcherServlets?hiddenParam=searchFormServlet
        if ("searchFormServlet".equals(hiddenParam)) {
            // hiddenParam.equals("serachFromServlet")를 사용하지 않음
            // "searchFormServlet".equals(hiddenParam)를 사용하면 null인지 확인도 함
            response.sendRedirect("/searchFormServlet");
            // /dispatcherServlets?hiddenParam=createCookieServlets
        } else if ("createCookieServlets".equals(hiddenParam)) {
            request.setAttribute("firstname", "yojulab");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cookies/createServlets");
            requestDispatcher.forward(request, response);
        } else {
            // normal display
            // /dispatcherServlets
            String message = "DispatcherServlets with Message !";
            PrintWriter printWriter = response.getWriter();

            printWriter.println("<html lang='en'>");
            printWriter.println("<head>");
            printWriter.println("<title>" + message + "</title>");
            printWriter.println("</head>");
            printWriter.println("<body>");
            printWriter.println("<button>recall DispatcherServlets</button>");
            printWriter.println("</form>");

            printWriter.println("</body>");
            printWriter.println("</html>");
            printWriter.close();
        }

    }
}
