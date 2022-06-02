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
public class Product {
    private int id;
    private String name;
    private double price;
    private double saleprice;
    private int quantity;
    private String imgURL;
    private String description;
    private String brand;
    private String category;
    private String  os;
    private String ram;
    private String cpu;
    private String display;
    private String capacity;
    private String card;
    private String createdate;
    private boolean status;

    public Product() {
    }

    public Product(int id, String name, double price, double saleprice, int quantity, String imgURL, String description, String brand, String category, String os, String ram, String cpu, String display, String capacity, String card, String createdate, boolean status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.saleprice = saleprice;
        this.quantity = quantity;
        this.imgURL = imgURL;
        this.description = description;
        this.brand = brand;
        this.category = category;
        this.os = os;
        this.ram = ram;
        this.cpu = cpu;
        this.display = display;
        this.capacity = capacity;
        this.card = card;
        this.createdate = createdate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(double saleprice) {
        this.saleprice = saleprice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + ", saleprice=" + saleprice + ", quantity=" + quantity + ", imgURL=" + imgURL + ", description=" + description + ", brand=" + brand + ", category=" + category + ", os=" + os + ", ram=" + ram + ", cpu=" + cpu + ", display=" + display + ", capacity=" + capacity + ", card=" + card + ", createdate=" + createdate + ", status=" + status + '}';
    }

    
    
    
    
}
