package model;

import services.Login;

import java.time.LocalDate;

public class Invoice {
    private String codeInvoive;
    private Customer customer;
    private Product product;
    private double price;
    private LocalDate dateAdd;
    private LocalDate datePay;
    private Employee employee;

    public Invoice(String codeInvoive, Customer customer, Product product, double price, LocalDate dateAdd, LocalDate datePay, Employee employee) {
        this.codeInvoive = codeInvoive;
        this.customer = customer;
        this.product = product;
        this.price = price;
        this.dateAdd = dateAdd;
        this.datePay = datePay;
        this.employee = employee;
    }


    public String getCodeInvoive() {
        return codeInvoive;
    }

    public void setCodeInvoive(String codeInvoive) {
        this.codeInvoive = codeInvoive;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(LocalDate dateAdd) {
        this.dateAdd = dateAdd;
    }

    public LocalDate getDatePay() {
        return datePay;
    }

    public void setDatePay(LocalDate datePay) {
        this.datePay = datePay;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        System.out.printf("Mã hoá đơn: %-10s -  %-20s" + '\n' + "%-20s" +'\n' + "Giá: %-30s  -  " +
                        "Ngày nhận máy: %-21s  -  Ngày trả máy: %-15s" + '\n'+ "Nhân Viên Tạo Hóa ĐƠn: %s" + '\n',codeInvoive,customer,product,price,dateAdd
                ,datePay,employee + "\n");
        return "";
    }
}
