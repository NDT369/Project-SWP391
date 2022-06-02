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
import javax.ws.rs.core.Response;
import model.Account;
import model.Role;

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
        List<Account> listAccount = a.getAll();
        List<Integer> listGender = a.getAllGender();
        List<Role> listRole = a.getAllRole();
//        List<Integer> listStatus = a.getAllStatus();

        String gender = "";
        String role = "";
        String status = "";
        if (request.getParameter("gender") != null) {
            gender = request.getParameter("gender");
        }
        if (request.getParameter("role") != null) {
            role = request.getParameter("role");
        }
        if (request.getParameter("status") != null) {
            status = request.getParameter("status");
        }

        request.setAttribute("gender", gender);
        request.setAttribute("role", role);
        request.setAttribute("status", status);

        request.setAttribute("sort", "");
        request.setAttribute("GenderList", listGender);
        request.setAttribute("RoleList", listRole);
//        request.setAttribute("StatusList", listStatus);
        request.setAttribute("UserList", listAccount);
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
        AccountDAO a = new AccountDAO();
        List<Account> list = a.getAll();

        String search = "";
        search = request.getParameter("search");
        if (!search.equals("")) {
            for (int i = list.size() - 1; i >= 0; i--) {
                if (!list.get(i).getName().toLowerCase().contains(search.toLowerCase())
                        && !list.get(i).getEmail().toLowerCase().contains(search.toLowerCase())
                        && !list.get(i).getPhone().toLowerCase().contains(search.toLowerCase())) {
                    list.remove(list.get(i));
                }
            }
        }

        String gender = "";
        String role = "";
        String status = "";
        if (request.getParameter("gender") != null && !request.getParameter("gender").equals("")) {
            gender = request.getParameter("gender");

        }
        if (request.getParameter("role") != null && !request.getParameter("role").equals("")) {
            role = request.getParameter("role");
        }
        if (request.getParameter("status") != null && !request.getParameter("status").equals("")) {
            status = request.getParameter("status");
        }

        request.setAttribute("gender", gender);
        request.setAttribute("role", role);
        request.setAttribute("status", status);
        request.setAttribute("search", search);

        List<Account> listFilter = a.fillter(gender, role, status, list);

        String sort_raw = "";
        if (request.getParameter("sort") != null && !request.getParameter("sort").equals("")) {
            sort_raw = request.getParameter("sort");
        }

        listFilter = a.getAllSort(sort_raw, listFilter);
        request.setAttribute("sort", sort_raw);
        request.setAttribute("UserList", listFilter);
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
