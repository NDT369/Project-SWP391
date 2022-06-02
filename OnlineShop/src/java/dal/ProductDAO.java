/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Product;

/**
 *
 * @author Pham Minh Giang
 */
public class ProductDAO extends DBContext {

    private PreparedStatement ps;
    private ResultSet rs;

    public List<Product> getAll() { // giang
        List<Product> list = new ArrayList<>();
        String sql = "select p.Product_ID, p.Product_Name, p.Product_Price, p.Product_SalePrice, p.Product_Quantity, p.Product_ImgURL,\n"
                + "p.Product_Description, b.Brand_Name, cat.Category_Name, o.OS_Name, r.RAM_Name,\n"
                + "cpu.CPU_Name, d.Display_Name, cap.Capacity_Name, car.Card_Name, p.Product_CreateDate, p.Product_Status from Product p \n"
                + "join Brand b on p.Brand_ID = b.Brand_ID\n"
                + "join Category cat on p.Category_ID = cat.Category_ID\n"
                + "join OperatingSystem o on p.OS_ID = o.OS_ID\n"
                + "join RAM r on p.RAM_ID = r.RAM_ID\n"
                + "join CPU cpu on p.CPU_ID = cpu.CPU_ID\n"
                + "join Display d on p.Display_ID = d.Display_ID\n"
                + "join Capacity cap on p.Capacity_ID = cap.Capacity_ID\n"
                + "join Card car on p.Card_ID = car.Card_ID\n"
                + "";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),
                        rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
                        rs.getString(16), rs.getBoolean(17)));
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getSaleProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "select top 5 p.Product_ID, p.Product_Name, p.Product_Price, p.Product_SalePrice, p.Product_Quantity, p.Product_ImgURL,\n"
                + "p.Product_Description, b.Brand_Name, cat.Category_Name, o.OS_Name, r.RAM_Name,\n"
                + "cpu.CPU_Name, d.Display_Name, cap.Capacity_Name, car.Card_Name, p.Product_CreateDate, p.Product_Status from Product p \n"
                + "join Brand b on p.Brand_ID = b.Brand_ID\n"
                + "join Category cat on p.Category_ID = cat.Category_ID\n"
                + "join OperatingSystem o on p.OS_ID = o.OS_ID\n"
                + "join RAM r on p.RAM_ID = r.RAM_ID\n"
                + "join CPU cpu on p.CPU_ID = cpu.CPU_ID\n"
                + "join Display d on p.Display_ID = d.Display_ID\n"
                + "join Capacity cap on p.Capacity_ID = cap.Capacity_ID\n"
                + "join Card car on p.Card_ID = car.Card_ID\n"
                + "";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),
                        rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
                        rs.getString(16), rs.getBoolean(17)));
            }

        } catch (Exception e) {
        }
        return list;

    }

    public List<Product> getNewProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "select top 10 p.Product_ID, p.Product_Name, p.Product_Price, p.Product_SalePrice, p.Product_Quantity, p.Product_ImgURL,\n"
                + "p.Product_Description, b.Brand_Name, cat.Category_Name, o.OS_Name, r.RAM_Name,\n"
                + "cpu.CPU_Name, d.Display_Name, cap.Capacity_Name, car.Card_Name, p.Product_CreateDate, p.Product_Status from Product p \n"
                + "join Brand b on p.Brand_ID = b.Brand_ID\n"
                + "join Category cat on p.Category_ID = cat.Category_ID\n"
                + "join OperatingSystem o on p.OS_ID = o.OS_ID\n"
                + "join RAM r on p.RAM_ID = r.RAM_ID\n"
                + "join CPU cpu on p.CPU_ID = cpu.CPU_ID\n"
                + "join Display d on p.Display_ID = d.Display_ID\n"
                + "join Capacity cap on p.Capacity_ID = cap.Capacity_ID\n"
                + "join Card car on p.Card_ID = car.Card_ID order by Product_ID DESC";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),
                        rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
                        rs.getString(16), rs.getBoolean(17)));
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductByCate(String cate) {
        List<Product> list = new ArrayList<>();
        String sql = "select p.Product_ID, p.Product_Name, p.Product_Price, p.Product_SalePrice, p.Product_Quantity, p.Product_ImgURL,\n"
                + "                p.Product_Description, b.Brand_Name, cat.Category_Name, o.OS_Name, r.RAM_Name,\n"
                + "                cpu.CPU_Name, d.Display_Name, cap.Capacity_Name, car.Card_Name, p.Product_CreateDate, p.Product_Status from Product p \n"
                + "                join Brand b on p.Brand_ID = b.Brand_ID\n"
                + "                join Category cat on p.Category_ID = cat.Category_ID\n"
                + "                join OperatingSystem o on p.OS_ID = o.OS_ID\n"
                + "                join RAM r on p.RAM_ID = r.RAM_ID\n"
                + "                join CPU cpu on p.CPU_ID = cpu.CPU_ID\n"
                + "                join Display d on p.Display_ID = d.Display_ID\n"
                + "                join Capacity cap on p.Capacity_ID = cap.Capacity_ID\n"
                + "                join Card car on p.Card_ID = car.Card_ID where cat.Category_Name = '" + cate + "'";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),
                        rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
                        rs.getString(16), rs.getBoolean(17)));
            }

        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductByID(String id) {
        Product p = new Product();
        String sql = "select p.Product_ID, p.Product_Name, p.Product_Price, p.Product_SalePrice, p.Product_Quantity, p.Product_ImgURL,\n"
                + "p.Product_Description, b.Brand_Name, cat.Category_Name, o.OS_Name, r.RAM_Name,\n"
                + "cpu.CPU_Name, d.Display_Name, cap.Capacity_Name, car.Card_Name, p.Product_CreateDate, p.Product_Status from Product p \n"
                + "join Brand b on p.Brand_ID = b.Brand_ID\n"
                + "join Category cat on p.Category_ID = cat.Category_ID\n"
                + "join OperatingSystem o on p.OS_ID = o.OS_ID\n"
                + "join RAM r on p.RAM_ID = r.RAM_ID\n"
                + "join CPU cpu on p.CPU_ID = cpu.CPU_ID\n"
                + "join Display d on p.Display_ID = d.Display_ID\n"
                + "join Capacity cap on p.Capacity_ID = cap.Capacity_ID\n"
                + "join Card car on p.Card_ID = car.Card_ID where p.Product_ID = " + id;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                p = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3),
                        rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
                        rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
                        rs.getString(16), rs.getBoolean(17));
            }

        } catch (Exception e) {
        }
        return p;
    }

    public static void main(String[] args) {
        ProductDAO p = new ProductDAO();
        List<Product> list = p.getAll();
        System.out.println(list.get(0).toString());
    }
}
