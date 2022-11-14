package model;

import java.time.LocalDate;

public class Product {
    private String idProduct;
    private String nameProduct;
    private String nameErrol;
    private LocalDate ngayNhan;

    public Product() {
    }

    public Product(String idProduct, String nameProduct, String nameErrol,LocalDate ngayNhan) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.nameErrol = nameErrol;
        this.ngayNhan = ngayNhan;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameErrol() {
        return nameErrol;
    }

    public void setNameErrol(String nameErrol) {
        this.nameErrol = nameErrol;
    }

    public LocalDate getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(LocalDate ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    @Override
    public String toString() {
        System.out.format("ID Product:  %-9s -  Tên Sản Phẩm:  %-20s  -  Lỗi:  %-30s  -  Ngày Nhận:  %-10s",idProduct,nameProduct,nameErrol,ngayNhan + "\n");
        return "";
    }
}
