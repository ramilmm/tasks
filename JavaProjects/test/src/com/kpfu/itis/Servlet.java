package com.kpfu.itis;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer counter = (Integer) session.getAttribute("Counter");
        if (counter == null) {
            counter = 0;
        }
        counter++;
        session.setAttribute("Counter", counter);

        response.setContentType("text/html");
        response.getWriter().print(counter);
        response.getWriter().close();
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.include(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.include(request,response);
    }
}
