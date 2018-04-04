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

    //TODO refactor this shit
    protected void processUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //(expression, List<parameters>)
        Map<String, ArrayList<String>> expressionParameters = new HashMap<String, ArrayList<String>>();
        initExpresionParameters(expressionParameters);

        addNotEmptyToDictionaryValues(request);

        addNotCorrectToErrorDictionary(request, expressionParameters);

        if (dictionaryErrors.isEmpty())
            getServletContext().getRequestDispatcher("/success.jsp").forward(request, response);

        request.setAttribute("dictionaryValues", dictionaryValues);
        request.setAttribute("dictionaryErrors", dictionaryErrors);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void initExpresionParameters(Map<String, ArrayList<String>> expressionParameters) {
        expressionParameters.put(expressionString,
                new ArrayList<>(Arrays.asList("name", "surname", "patronymic", "login", "cityOfResidence", "street")));
        expressionParameters.put(expressionMobileNumber,
                new ArrayList<>(Arrays.asList("mobileNumber", "mobileNumber2")));
        expressionParameters.put(expressionHomeNumber,
                new ArrayList<>(Arrays.asList("homeNumber")));
        expressionParameters.put(expressionEmail,
                new ArrayList<>(Arrays.asList("email")));
        expressionParameters.put(expressionSkype,
                new ArrayList<>(Arrays.asList("skype")));
        expressionParameters.put(expressionAddressIndex,
                new ArrayList<>(Arrays.asList("index")));
        expressionParameters.put(expressionAddresHomeNumber,
                new ArrayList<>(Arrays.asList("apartmentNumber")));
    }

    private void addNotEmptyToDictionaryValues(HttpServletRequest request) {
        ArrayList<String> keysParameters = (ArrayList<String>) Collections.list(request.getParameterNames());
        try {
            for (int i = 0; i < keysParameters.size(); ++i) {
                String key = keysParameters.get(i);
                checkValueEmpty(key, request.getParameter(key));
                dictionaryValues.put(key, request.getParameter(key));
            }
        } catch (IOException e) {
            request.setAttribute("errors", (String) e.getMessage());
        }
    }

    private void addNotCorrectToErrorDictionary(HttpServletRequest request, Map<String, ArrayList<String>> expressionParameters) {
        for (String expression : expressionParameters.keySet()) {
            for (String fieldName : expressionParameters.get(expression)) {
                String fieldValue = request.getParameter(fieldName);
                if (!checkCorrect(fieldValue, expression))
                    dictionaryErrors.add(fieldName);
            }
        }
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
