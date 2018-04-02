package main.java.ua.kpi.tef;

import main.java.ua.kpi.tef.model.GroupSubscriber;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("group", GroupSubscriber.getCollection());
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8 ");
        PrintWriter out = response.getWriter();
        String Name = request.getParameter("name");
        out.print(Name);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//or
        response.setContentType("text/html; charset=utf-8 ");
        PrintWriter out = response.getWriter();
        out.print("<h2> Hello world</h2>");

    }
}
