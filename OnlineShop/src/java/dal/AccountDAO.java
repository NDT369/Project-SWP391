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
import java.util.List;
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

    public void changePass(int accountID, String newPass) {
        String sql = "UPDATE [dbo].[Account]\n"
                + "     SET [Password] = ?\n"
                + " WHERE Account_ID = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, accountID);
            ps.setString(2, newPass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Account> getAll() { // giang
        List<Account> list = new ArrayList<>();
        String sql = "select * from Account";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(10), rs.getString(9)));
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<Account> getByGender(int gender) {
        List<Account> list = new ArrayList<>();
        String sql = "select * from Account where Gender = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, gender);
            while (rs.next()) {
                list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(10), rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Account> getByRole(int role){
        List<Account> list = new ArrayList<>();
        String sql = "select * from Account where Role_ID = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, role);
            while (rs.next()) {
                list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(10), rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Account> getByStatus(int status){
        List<Account> list = new ArrayList<>();
        String sql = "select * from Account where Account_Status = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, status);
            while (rs.next()) {
                list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(10), rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    

    public List<Account> getAllSort(String str) { // giang
        List<Account> list = new ArrayList<>();
        String sql = "select * from Account order by " + str;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt("Account_ID"), rs.getString("Username"), rs.getString("Password"), rs.getString("Name"), rs.getBoolean("Gender"),
                        rs.getString("Email"), rs.getString("Phone"), rs.getString("Address"), rs.getBoolean("Account_Status"), rs.getString("Role_ID")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Account> SearchUser(String str) {
        List<Account> list = new ArrayList<>();
        String sql = "select * from Account where"
                + " (Name like '%" + str + "%' or Phone like '%" + str + "%' or Email like '%" + str + "%')";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(10), rs.getString(9)));
            }
        } catch (Exception e) {
        }
        return list;
    }

//    public List<Integer> getAllGender() {
//        List<Integer> list = new ArrayList<>();
//        String sql = "select DISTINCT Gender from Account";
//        try {
//            ps = connection.prepareStatement(sql);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                list.add(rs.getInt(1));
//            }
//        } catch (Exception e) {
//        }
//        return list;
//    }
    public List<Integer> getAllRole() {
        List<Integer> list = new ArrayList<>();
        String sql = "select DISTINCT Role_ID from Account";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Account getAcountByID(int id) {
        String sql = "select * from Account where Account_ID = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(10), rs.getString(9));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static void main(String[] args) {
        AccountDAO a = new AccountDAO();
//        List<Account> list = new ArrayList<>();
//        list = a.getAll();
//        for (Account i : list) {
//            System.out.println(i.toString());
//        }
//        List<Integer> list = new ArrayList<>();
//        list = a.getAllRole();
//        for (Integer i : list) {
//            System.out.println(i);
//        }

//        Account ac = new Account();
//        ac = a.getAcountByID(3);
//        System.out.println(ac.toString());
//        List<Account> list = new ArrayList<>();
//        list = a.getAllSort("Name");
//        System.out.println(list.size());
//        for (Account account : list) {
//            System.out.println(account);
//        }

        Account acc = a.getAcountByID(4);
        System.out.println(acc.toString());
    }

}
