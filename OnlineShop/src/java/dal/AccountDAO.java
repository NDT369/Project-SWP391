/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;

/**
 *
 * @author DUC THINH
 */
public class AccountDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public Account checkAccount(String username, String password) {
        String sql = "select * from Account a\n"
                + "join Role_Account r on a.Role_ID = r.Role_ID\n"
                + "where a.Username = ? and a.[Password] = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setUsername(username);
                account.setPassword(password);
                account.setName(rs.getString(4));
                account.setRole(rs.getString(12));
                return account;
            }

        } catch (SQLException e) {
        }
        return null;
    }

    public void changePass(String Username, String newPass) {
        String sql = "UPDATE [dbo].[Account]\n" +
                    "     SET [Password] = ?\n" +
                    " WHERE Username = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, Username);
            ps.setString(2, newPass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
}
