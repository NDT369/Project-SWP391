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
import java.util.Comparator;
import java.util.List;
import model.Account;
import model.Role;

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
    
    public Account checkUserExist(String username){
        String sql = "select * from Account where Username = ?";
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                return account;
            }
        }catch(SQLException ex){
            
        }
        return null;
    }
    
       
    public Account checkEmailExist(String email){
        String sql = "select * from Account where Email = ?";
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                return account;
            }
        }catch(SQLException ex){
            
        }
        return null;
    }
    
    public void registerNewAcc(Account a){
        String sql = "insert into Account values(?,?,?,?,?,?,?,2,1)";
        try{
            ps = connection.prepareStatement(sql);
            ps.setString(1, a.getUsername());
            ps.setString(2, a.getPassword());
            ps.setString(3, a.getName());
            ps.setBoolean(4, a.isGender());
            ps.setString(5, a.getEmail());
            ps.setString(6, a.getPhone());
            ps.setString(7, a.getAddress());
            ps.executeUpdate();
        }catch(SQLException ex){   
        }
   
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

    public List<Account> getByRole(int role) {
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

    public List<Account> getByStatus(int status) {
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

    public List<Account> getAllSort(String str, List<Account> l) { // giang
        List<Account> list = new ArrayList<>();
        Collections.sort(l, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                if (str.equals("Account_ID")) {
                    return o1.getAccountID() > o2.getAccountID() ? 1 : -1;
                }
                if (str.equals("Name")) {
                    return o1.getName().compareTo(o2.getName());
                }
                if (str.equals("Email")) {
                    return o1.getEmail().compareTo(o2.getEmail());
                }
                if (str.equals("Phone")) {
                    return o1.getPhone().compareTo(o2.getPhone());
                }
                if (str.equals("Role_ID")) {
                    return o1.getRole().compareTo(o2.getRole());
                }
                return o1.getAccountID() > o2.getAccountID() ? 1 : -1;
            }
        });
        return l;
    }

    public List<Account> fillter(String gender, String role, String status, List<Account> l) {
        List<Account> list = new ArrayList<>();
        if (gender.equals("") && role.equals("") && status.equals("")) {
            return l;
        }
        if (gender != "") {
            boolean g;
            if (gender.equals("1")) {
                g = true;
            } else {
                g = false;
            }
            for (Account account : l) {
                if (account.isGender() == g) {
                    list.add(account);
                }
            }
        }
        if (role != "") {
            for (int i = list.size() - 1; i >= 0; i--) {
                if (!list.get(i).getRole().equals(role)) {
                    list.remove(list.get(i));
                }
            }

        }
        if (status != "") {
            boolean s;
            if (status.equals("1")) {
                s = true;
            } else {
                s = false;
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i).isStatus() != s) {
                    list.remove(list.get(i));
                }
            }
        }
        Account x = null;
        if (list.size() == 0) {
            list.add(x);
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

    public List<Integer> getAllGender() {
        List<Integer> list = new ArrayList<>();
        String sql = "select DISTINCT Gender from Account";
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

    public List<Role> getAllRole() {
        List<Role> list = new ArrayList<>();
        String sql = "select * from Role_Account";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Role r = new Role();
                r.setRoleID(rs.getInt(1));
                r.setRoleName(rs.getString(2));
                list.add(r);
            }
        } catch (Exception e) {
        }
        return list;
    }

//    public List<Integer> getAllStatus() {
//        List<Integer> list = new ArrayList<>();
//        String sql = "select DISTINCT Account_Status from Account";
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

    public Account getAcountByID(int id) {
        String sql = "  select * from Account a\n"
                + "  join Role_Account r  on a.Role_ID = r.Role_ID\n"
                + "  where a.Account_ID = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(10), rs.getString(12));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void UpdateUserRole(String id, String role) {
        String sql = "update Account set Role_ID = " + role +" where Account_ID = " + id ;
        
        try {
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
      public void UpdateUserStatus(String id, String status) {
        String sql = "update Account set Account_Status = " + status +" where Account_ID = " + id ;        
        try {
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
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
//        List<Integer> list = new ArrayList<>();
//        list = a.getAllStatus();
//    
//        for (Integer i : list) {
//            System.out.println(i);
//        }
    }

}
