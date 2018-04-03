package main.java.ua.kpi.tef.Controllers;

public interface RegisterFormExpression {
    String expressionString = "[A-Za-z]{1,15}";
    String expressionFullName = "[A-Za-z]{3,15} [A-Za-z]{3,15} [A-Za-z]{3,15}";
    String expressionHomeNumber = "\\d-\\d{2}-\\d{2}";
    String expressionMobileNumber = "^\\d{3}-\\d{3}-\\d{2}-\\d{2}$";
    String expressionEmail = "^[A-Za-z0-9._+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$";
    String expressionAddresHomeNumber = "[0-9]+([A-Z])?";
    String expressionAddressIndex = "[0-9]+";
}
