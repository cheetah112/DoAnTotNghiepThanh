package model;

import java.time.LocalDate;

public class InvoiceMaterial {
    private String codeMaterial;
    private Material material;
    private Employee employeeFunction;
    private int amountOder;
    private LocalDate dayNhap;
    private Employee employeeWareHouse;
    private LocalDate dayget;

    public InvoiceMaterial(String codeMaterial, Material material, Employee employeeFunction, int amountOder, LocalDate dayNhap) {
        this.codeMaterial = codeMaterial;
        this.material = material;
        this.employeeFunction = employeeFunction;
        this.amountOder = amountOder;
        this.dayNhap = dayNhap;
    }

    public String getCodeMaterial() {
        return codeMaterial;
    }

    public void setCodeMaterial(String codeMaterial) {
        this.codeMaterial = codeMaterial;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Employee getEmployeeFunction() {
        return employeeFunction;
    }

    public void setEmployeeFunction(Employee employeeFunction) {
        this.employeeFunction = employeeFunction;
    }

    public int getAmountOder() {
        return amountOder;
    }

    public void setAmountOder(int amountOder) {
        this.amountOder = amountOder;
    }

    public LocalDate getDayNhap() {
        return dayNhap;
    }

    public void setDayNhap(LocalDate dayNhap) {
        this.dayNhap = dayNhap;
    }

    public Employee getEmployeeWareHouse() {
        return employeeWareHouse;
    }

    public void setEmployeeWareHouse(Employee employeeWareHouse) {
        this.employeeWareHouse = employeeWareHouse;
    }

    public LocalDate getDayget() {
        return dayget;
    }

    public void setDayget(LocalDate dayget) {
        this.dayget = dayget;
    }

    @Override
    public String toString() {
        System.out.printf("Mã Hóa Đơn: %s \n Vật Liệu: %s \n Nhân Viên Oder: %s \n Số Lượng Oder: %s \n Ngày Oder: %s \n Nhân Viên Kho: %s \n Ngày Hoàn Thành: %s ",codeMaterial,material,employeeFunction,amountOder,dayNhap,employeeWareHouse,dayget + "\n");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return "";
    }
}
