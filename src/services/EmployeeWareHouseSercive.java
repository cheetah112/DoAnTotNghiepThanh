package services;

import database.DataBase;
import model.*;
import utils.InputValue;
import utils.SearchHistory;

import javax.xml.stream.FactoryConfigurationError;
import java.time.LocalDate;
import java.util.Iterator;

public class EmployeeWareHouseSercive implements IService {
    // màn hình chính chức năng nhân viên Kho
    public void showFunction() {
        while (true) {
            System.out.println("1. Quản lý Vật Liệu");
            System.out.println("2. Search History");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0) {
                DataBase.employee = null;
                break;
            }
            switch (choose) {
                case 1:
                    showMangerMaterial();
                    break;
                case 2:
                    searchHistory();
                    break;
            }
        }
    }
    // màn hình chức năng quản lý vật liệu
    private void showMangerMaterial() {
        while (true) {
            System.out.println("1. Nhập Vật Liệu");
            System.out.println("2. Xuất Vật Liệu");
            System.out.println("3. Danh sách Vật liệu tồn kho");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    inputMaterial();
                    break;
                case 2:
                    getMaterialByCodeInvoiceMaterial();
                    break;
                case 3:
                    materialList();
                    break;
            }
        }
    }
    // chức năng input Material
    private void inputMaterial(){
        System.out.println("Nhập ID Vật liệu");
        String idMaterial = InputValue.getString();
        if (DataBase.inPutMaterialList.isEmpty()){
            inputMaterialNew(idMaterial);
            return;
        }
        for (InputMaterial inputMaterial : DataBase.inPutMaterialList){
            if (inputMaterial.getMaterial().getIdMaterial().equals(idMaterial)){
                inputMaterialOld(idMaterial);
                return;
            } else {
                inputMaterialNew(idMaterial);
                return;
            }
        }



    }
    // input material old
    private void inputMaterialOld(String idMaterial) {
        for (InputMaterial inputMaterial : DataBase.inPutMaterialList ){
            if (inputMaterial.getMaterial().getIdMaterial().equals(idMaterial)){
                System.out.println("Số lượng thêm vào");
                int amount = InputValue.getInputInt();
                inputMaterial.getMaterial().setAmount((inputMaterial.getMaterial().getAmount() + amount));
                inputMaterial.setDayInput(LocalDate.now());
            }
        }
    }
    // input material new
    private void inputMaterialNew(String idMaterial) {
        System.out.println("Nhập tên vật liệu");
        String nameMaterial = InputValue.getString();
        System.out.println("Nhập số lượng");
        int amount = InputValue.getInputInt();
        Material material = new Material(idMaterial,nameMaterial,amount);
        DataBase.materialList.add(material);
        LocalDate dayInput = LocalDate.now();
        InputMaterial inputMaterial = new InputMaterial(material,dayInput);
        DataBase.inPutMaterialList.add(inputMaterial);

    }

    // lấy material bằng code invoice material
    private void getMaterialByCodeInvoiceMaterial() {
        System.out.println("Nhập Code Invoice Material");
        String codeInvoice = InputValue.getString();
        if (DataBase.invoiceMaterialList.isEmpty()){
            System.out.println("Không có hóa đơn nào");
        }
        for (InvoiceMaterial invoiceMaterial : DataBase.invoiceMaterialList){
            if (invoiceMaterial.getCodeMaterial().equals(codeInvoice)){
                System.out.println(invoiceMaterial.toString());
                while (true){
                    System.out.println("1. Hoàn thành Hóa đơn");
                    System.out.println("0. Quay lại");
                    int choose = InputValue.getInt(0, 1);
                    switch (choose){
                        case 0:
                            break;
                        case 1:
                            invoiceCompleted(codeInvoice);
                            minusAmountMaterial(codeInvoice);
                            break;
                    }
                }
            }
        }
    }
    // trừ sso lượng trong kho
    private void minusAmountMaterial(String codeInvoice) {
        String idMaterial = getIDMaterial(codeInvoice);
        if (idMaterial == null){
            System.out.println();
        }
        if (DataBase.inPutMaterialList.isEmpty()){
            System.out.println("Không còn vật liệu trong kho");
            return;
        }
        int amount = getAmountMaterial(codeInvoice);
        for (InputMaterial inputMaterial : DataBase.inPutMaterialList){
           if (inputMaterial.getMaterial().getIdMaterial().equals(idMaterial)){
               inputMaterial.getMaterial().setAmount((inputMaterial.getMaterial().getAmount() - amount));
           }
        }
    }
    // lấy sso lượng material ra
    private int getAmountMaterial(String codeInvoice) {
        for (InvoiceMaterial invoiceMaterial : DataBase.invoiceMaterialList){
            if (invoiceMaterial.getCodeMaterial().equals(codeInvoice)){
                return invoiceMaterial.getAmountOder();
            }
        }
        return 0;
    }

    // lấy ID material trong invoice Material list ra
    private String getIDMaterial(String codeInvoice) {
        for (InvoiceMaterial invoiceMaterial : DataBase.invoiceMaterialList){
            if (invoiceMaterial.getCodeMaterial().equals(codeInvoice)){
                return invoiceMaterial.getMaterial().getIdMaterial();
            }
        }
        return null;
    }

    // chức năng hoàn thành hóa đơn oder Material. lưu thông tin cuối cùng
    private void invoiceCompleted(String codeInvoice){
        if (DataBase.invoiceMaterialList.isEmpty()){
            System.out.println("Không có thông tin nào");
            return;
        }
        for (InvoiceMaterial invoiceMaterial : DataBase.invoiceMaterialList){
            if (invoiceMaterial.getCodeMaterial().equals(codeInvoice)){
                Employee employee = DataBase.employee;
                LocalDate dayGet = LocalDate.now();
                invoiceMaterial.setEmployeeWareHouse(employee);
                invoiceMaterial.setDayget(dayGet);
            }
        }
    }
    // in ra material list
    private void materialList() {
        if (DataBase.materialList.isEmpty()){
            System.out.println("Không còn vật liệu trong kho");
        }
        for (Material material : DataBase.materialList){
            if (material.getAmount() > 0){
                System.out.println(material.toString());
            }
        }
    }
    // chức năng tìm kiếm lịch sử
    private void searchHistory() {
        while (true) {
            System.out.println("1. Search History Invoice Material");
            System.out.println("2. Search History Input Material");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    historyInvoiceMaterial();
                    break;
                case 2:
                    SearchHistory.searchAll(DataBase.inPutMaterialList);
                    break;
            }
        }
    }

    //  lịch sử invoice Material
    private void historyInvoiceMaterial() {
        while (true) {
            System.out.println("1. Search By Code");
            System.out.println("2. Search All Invoice Material");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    SearchHistory.searchInvoiceOderMaterialByCode();
                    break;
                case 2:
                    SearchHistory.searchAll(DataBase.invoiceMaterialList);
                    break;
            }
        }
    }


}
