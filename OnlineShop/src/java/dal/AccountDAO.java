/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.function.Consumer;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
        String sql = "UPDATE [dbo].[Account]\n"
                + "     SET [Password] = ?\n"
                + " WHERE Username = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(2, Username);
            ps.setString(1, newPass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Account getAccountByUser(String username) {
        String sql = "select * from Account where Username = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                Account account = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getBoolean(10));
                return account;
            }

        } catch (SQLException e) {
        }
        return null;
    }

    

    public Account getAccountByEmailUsername(String username, String email) {
        String sql = "select * from Account where Username = ? and Email = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                Account account = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getBoolean(10));
                return account;
            }

        } catch (SQLException e) {
        }
        return null;
    }

   

    /**
     * * Random string password with at least 1 digit and 1 special character
     */
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        dao.changePass("phu", "123");
    }

}
