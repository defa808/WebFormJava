package main.java.ua.kpi.tef.Controllers;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import main.java.ua.kpi.tef.model.Subscriber;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/RegisterFormServlet")
public class RegisterFormServlet extends HttpServlet implements RegisterFormExpression {

    private Map<String, String> dictionaryValues;
    private ArrayList<String> dictionaryErrors;


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//or
        response.setContentType("text/html; charset=utf-8 ");
        PrintWriter out = response.getWriter();
        out.print("<h2> Hello world</h2>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8 ");
        dictionaryValues = new HashMap<String, String>();
        dictionaryErrors = new ArrayList<String>();
        processUser(request, response);

    }

    protected void processUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<String> keysParameters = (ArrayList<String>) Collections.list(request.getParameterNames());

//        Subscriber subscriber = new Subscriber();

        int indexParameter = 0;

        try {
            for (int i = 0; i < keysParameters.size(); ++i) {
                indexParameter = i;
                String key = keysParameters.get(i);
                checkValueEmpty(key, request.getParameter(key));
                dictionaryValues.put(key, request.getParameter(key));
            }

        } catch (IOException e) {
            request.setAttribute("errors", (String) e.getMessage());
        }
//TODO refactoring!

        if (!checkCorrect(request.getParameter("name"), expressionString)) {
            dictionaryErrors.add("name");
        }
        if (!checkCorrect(request.getParameter("surname"), expressionString)) {
            dictionaryErrors.add("surname");
        }
        if (!checkCorrect(request.getParameter("patronymic"), expressionString)) {
            dictionaryErrors.add("patronymic");
        }
        if (!checkCorrect(request.getParameter("login"), expressionString)) {
            dictionaryErrors.add("login");
        }
        if (!checkCorrect(request.getParameter("homeNumber"), expressionHomeNumber)) {
            System.out.println(request.getParameter("homeNumber"));
            dictionaryErrors.add("homeNumber");
        }
        if (!checkCorrect(request.getParameter("mobileNumber"), expressionMobileNumber)) {
            dictionaryErrors.add("mobileNumber");
        }
        if (!checkCorrect(request.getParameter("mobileNumber2"), expressionMobileNumber)) {
            dictionaryErrors.add("mobileNumber2");
        }
        if (!checkCorrect(request.getParameter("email"), expressionEmail)) {
            dictionaryErrors.add("email");
        }
        if (!checkCorrect(request.getParameter("skype"), expressionSkype)) {
            dictionaryErrors.add("skype");
        }
        if (!checkCorrect(request.getParameter("index"), expressionAddressIndex)) {
            dictionaryErrors.add("index");
        }
        if (!checkCorrect(request.getParameter("cityOfResidence"), expressionString)) {
            dictionaryErrors.add("cityOfResidence");
        }
        if (!checkCorrect(request.getParameter("street"), expressionString)) {
            dictionaryErrors.add("street");
        }

        if (!checkCorrect(request.getParameter("apartmentNumber"), expressionAddresHomeNumber)) {
            dictionaryErrors.add("apartmentNumber");
        }

        if (dictionaryErrors.isEmpty())
            getServletContext().getRequestDispatcher("/success.jsp").forward(request, response);



        request.setAttribute("dictionaryValues", dictionaryValues);
        request.setAttribute("dictionaryErrors", dictionaryErrors);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

//        request.setAttribute("group", GroupSubscriber.getCollection());
    }

    private void checkValueEmpty(String fieldName, String value) throws IOException {
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(value);
        if (matcher.matches()) {
            throw new IOException("field is empty" + fieldName);
        }
    }

    private boolean checkCorrect(String value, String patternExpression) {
        Pattern pattern = Pattern.compile(patternExpression);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }


}
