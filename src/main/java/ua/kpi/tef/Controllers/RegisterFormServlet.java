package main.java.ua.kpi.tef.Controllers;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import main.java.ua.kpi.tef.model.Subscriber;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/RegisterFormServlet")
public class RegisterFormServlet extends HttpServlet implements RegisterFormExpression {

    protected void processUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8 ");
        Subscriber subscriber = new Subscriber();
        Map<String, String> dictionary = new HashMap<String, String>();

        try {
            Enumeration<String> keysParameters = request.getParameterNames();
            while (keysParameters.hasMoreElements()) {
                String key = keysParameters.nextElement();
                checkValueNull(key, request.getParameter(key), "");
                dictionary.put(key, request.getParameter(key));
            }

        } catch (IOException e) {
            request.setAttribute("errors", (String) e.getMessage());
        }

        request.setAttribute("dictionary", dictionary);
//        request.setAttribute("group", GroupSubscriber.getCollection());
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private String checkValueNull(String fieldName, String value, String expressionString) throws IOException {
        Pattern pattern = Pattern.compile(expressionString);
        Matcher matcher = pattern.matcher(value);
        if (matcher.matches()) {
            throw new IOException("Wrong input " + fieldName);
        }
        return value;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processUser(request, response);


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//or
        response.setContentType("text/html; charset=utf-8 ");
        PrintWriter out = response.getWriter();
        out.print("<h2> Hello world</h2>");

    }
}
