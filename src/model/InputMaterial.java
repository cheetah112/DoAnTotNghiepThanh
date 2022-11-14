package model;

import java.time.LocalDate;

public class InputMaterial {
    private Material material;
    private LocalDate dayInput;

    public InputMaterial(Material material, LocalDate dayInput) {
        this.material = material;
        this.dayInput = dayInput;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public LocalDate getDayInput() {
        return dayInput;
    }

    public void setDayInput(LocalDate dayInput) {
        this.dayInput = dayInput;
    }

    @Override
    public String toString() {
        System.out.printf("Vật Liệu: %s \n Ngày: %s",material,dayInput + "\n");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
      return "";
    }
}
