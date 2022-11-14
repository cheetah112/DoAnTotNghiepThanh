package model;

import constants.Type;

public class Employee {

    private String idNhanVien;
    private String fullName;
    private Type type;

    public Employee() {
    }

    public Employee(String idNhanVien, String fullName, Type type) {
        this.idNhanVien = idNhanVien;
        this.fullName = fullName;
        this.type = type;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        System.out.printf("ID Nhân Viên: %-7s  -  Họ và Tên: %-24s  -  Loại: %-20s",idNhanVien,fullName,type + "\n");
        return "";
    }
}
