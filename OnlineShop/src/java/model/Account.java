/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Pham Minh Giang
 */
public class Account {

    private int accountID;
    private String username;
    private String password;
    private String name;
    private boolean gender;
    private String email;
    private String phone;
    private String address;
    private boolean status;
    private String role;

    public Account() {
    }

    public Account(int accountID, String username, String password, String name, boolean gender, String email, String phone, String address, boolean status, String role) {
        this.accountID = accountID;
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.role = role;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", username=" + username + ", password=" + password + ", name=" + name + ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", address=" + address + ", status=" + status + ", role=" + role + '}';
    }
}
