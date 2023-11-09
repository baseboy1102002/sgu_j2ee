package controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionManager {

    public static void startSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
    }
    public static void storeUserInfo(HttpServletRequest request, String Email, String Password, String Name, String ConfirmCode, String Phone) {
        HttpSession session = request.getSession();
        session.setAttribute("Email", Email);
        session.setAttribute("Password", Password);
        session.setAttribute("Name", Name);
        session.setAttribute("ConfirmCode", ConfirmCode);
        session.setAttribute("Phone", Phone);
    }
    
    public static String getEmail(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String Email = (String) session.getAttribute("Email");
        return Email;
    }

    public static String getPassword(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String Password = (String) session.getAttribute("Password");
        return Password;
    }
    
    public static String getName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String Name = (String) session.getAttribute("Name");
        return Name;
    }
    
    public static String getConfirmCode(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String ConfirmCode = (String) session.getAttribute("ConfirmCode");
        return ConfirmCode;
    }
    
    public static String getPhone(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String Phone = (String) session.getAttribute("Phone");
        return Phone;
    }
    
}

