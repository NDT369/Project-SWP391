/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminController;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.Account;

/**
 *
 * @author Pham Minh Giang
 */
public class UserListServlet extends HttpServlet {

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
            out.println("<title>Servlet UserListServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserListServlet at " + request.getContextPath() + "</h1>");
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

        AccountDAO a = new AccountDAO();
        List<Account> list = a.getAll();

        int gender = 0, role = 0, status = 0;
        List<Integer> l = new ArrayList<>();
        l.add(role);
        l.add(gender);
        l.add(status);
        request.setAttribute("int", l);

        request.setAttribute("UserList", list);
        request.getRequestDispatcher("Admin/userlist.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        String gender_raw = request.getParameter("gender");
        String role_raw = request.getParameter("role");
        String status_raw = request.getParameter("status");
        
        int gender = 0, role = 0, status = 0;

        AccountDAO a = new AccountDAO();
        List<Account> listall = a.getAll();
//        try {
//            gender = Integer.parseInt(gender_raw);
//        } catch (Exception e) {
//        }
//        try {
//            role = Integer.parseInt(role_raw);
//        } catch (Exception e) {
//        }
//        try {
//            status = Integer.parseInt(status_raw);
//        } catch (Exception e) {
//        }
//        if (gender_raw != null) {
//            List<Account> list = a.getByGender(gender);
//            request.setAttribute("UserList", list);
//            request.getRequestDispatcher("Admin/UserList.jsp").forward(request, response);
//        }
//        if (role_raw != null) {
//            List<Account> list = a.getByRole(role);
//            request.setAttribute("UserList", list);
//            request.getRequestDispatcher("Admin/UserList.jsp").forward(request, response);
//        }
//        if (status_raw != null) {
//            List<Account> list = a.getByStatus(status);
//            request.setAttribute("UserList", list);
//            request.getRequestDispatcher("Admin/UserList.jsp").forward(request, response);
//        }

        
        request.setAttribute("UserList", listall);
        request.getRequestDispatcher("Admin/userlist.jsp").forward(request, response);
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
