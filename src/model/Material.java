package model;

import java.time.LocalDate;

public class Material {

    private String idMaterial;
    private String nameMaterial;
    private int amount;

    public Material(String idMaterial, String nameMaterial, int amount) {
        this.idMaterial = idMaterial;
        this.nameMaterial = nameMaterial;
        this.amount = amount;
    }

    public String getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(String idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNameMaterial() {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial = nameMaterial;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        System.out.printf("ID Vật Liệu: %-10s  -  Tên Vật Liệu: %-20s  -  Sô Lượng: %-10s ",idMaterial,nameMaterial,amount + "\n");
        return "";
    }
}
