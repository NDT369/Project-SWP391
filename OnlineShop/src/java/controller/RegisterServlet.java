/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author DUC THINH
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        String gender_raw = request.getParameter("gender");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String username = request.getParameter("uname");
        String password = request.getParameter("pass");
        String conpass = request.getParameter("conpass");
        AccountDAO ad = new AccountDAO();
        Account a = ad.checkUserExist(username);
        Account a1 = ad.checkEmailExist(email);
        String mess;
        boolean gender;
        if (gender_raw.equals("male")) {
            gender = true;
        } else {
            gender = false;
        }
        

        if (a != null) {
            mess = "UserName already exist!";
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            if (a1 != null) {
                mess = "Email already registered";
                request.setAttribute("mess", mess);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else {
                if (conpass.equals(password) == false) {
                    mess = "Confirm password incorrect";
                    request.setAttribute("mess", mess);
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                } else {
                    Account newAcc = new Account();
                    newAcc.setName(fullname);
                    newAcc.setGender(gender);
                    newAcc.setEmail(email);
                    newAcc.setPhone(phone);
                    newAcc.setAddress(address);
                    newAcc.setUsername(username);
                    newAcc.setPassword(password);
                    ad.registerNewAcc(newAcc);
                }
            }
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}