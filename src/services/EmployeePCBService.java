package services;

import constants.Status;
import database.DataBase;
import model.Employee;
import model.History;
import model.InvoiceMaterial;
import model.Material;
import utils.InputValue;
import utils.SearchHistory;

import java.time.LocalDate;
import java.util.Iterator;

public class EmployeePCBService implements IService {
    // màn hình chính chức năng Nhân viên sửa chữa PCB. sửa chữa phần bản mạch PBA
    public void showFunction() {
        while (true) {
            System.out.println("1. Output Product");
            System.out.println("2. Seach History Repair Product");
            System.out.println("3. Oder Vật Liệu");
            System.out.println("4. Hiển thị sản phẩm còn Pending của mình");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 4);
            if (choose == 0) {
                DataBase.employee = null;
                break;
            }
            switch (choose) {
                case 1:
                    showOutputProduct();
                    break;
                case 2:
                    showSearchRepairProduct();
                    break;
                case 3:
                    showOderMaterial();
                    break;
                case 4:
                    SearchHistory.showRepairProductPending(DataBase.employee);
                    break;
            }
        }
    }

    // màn hình Oder vật liệu để thay thế
    private void showOderMaterial() {
        while (true) {
            System.out.println("1. Tạo hóa đơn Oder Material");
            System.out.println("2. Search history Hóa Đơn Oder Material");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    createInvoiceMaterial();
                    break;
                case 2:
                    searchHistoryInvoiceOderMaterial();
                    break;
            }
        }
    }
    // tìm kiếm lịch sử hóa đơn oder material
    private void searchHistoryInvoiceOderMaterial(){
        while (true) {
            System.out.println("1. Search By Id");
            System.out.println("2. Search All History");
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
    // tạo 1 hóa đơn oder material
    private void createInvoiceMaterial() {
        System.out.println("Nhập code hóa đơn");
        String codeInvoice = InputValue.checkCodeInvoiceMaterial();
        if (codeInvoice == null){
            return;
        }
        System.out.println("Nhập ID Vật liệu");
        String idMaterial = InputValue.getString();
        Material material = getMaterial(idMaterial);
        if (material == null){
            System.out.println("Không có vật liệu nào");
            return;
        }
        Employee employee = DataBase.employee;
        System.out.println("Nhập số lượng Oder");
        int amountOder = InputValue.getInputInt();
        LocalDate dayOder = LocalDate.now();
        InvoiceMaterial invoiceMaterial = new InvoiceMaterial(codeInvoice,material,employee,amountOder,dayOder);
        DataBase.invoiceMaterialList.add(invoiceMaterial);
    }
    // lấy 1 material
    private Material getMaterial(String idMaterial) {
        for (Material material : DataBase.materialList){
            if (material.getIdMaterial().equals(idMaterial)){
                return material;
            }
        }
        return null;
    }
    // tìm kiếm lịch sử sản phẩm
    private void showSearchRepairProduct() {
        while (true) {
            System.out.println("1. Search By ID");
            System.out.println("2. Search All");
            System.out.println("0. Back");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    SearchHistory.searchHistoryRepairProductByID();
                    break;
                case 2:
                    SearchHistory.searchAll(DataBase.historyList);
                    break;
            }
        }
    }

    // output sản phẩm
    private void showOutputProduct() {
        System.out.println("Nhập ID sản phẩm");
        String idProduct = InputValue.getString();
        for (History history : DataBase.historyList) {
            if (history.getProduct().getIdProduct().equals(idProduct) && history.getStatusFuncion() == null) {
                System.out.println("Nhập vị trí lỗi");
                String location = InputValue.getString();
                Status status = chooseStatus();
                LocalDate dayInput = LocalDate.now();
                history.setLocation(location);
                history.setStatusFuncion(status);
                history.setDayInputFuncion(dayInput);
                System.out.println("Đã Output Thành Công");
            }
            if (history.getProduct().getIdProduct().equals(idProduct) && history.getEmployeeFuncion().equals(DataBase.employee)){
                System.out.println("Product không phải trách nhiệm của bạn");
                return;
            }
            if (history.getProduct().getIdProduct().equals(idProduct) && history.getStatusFuncion() == Status.OK || history.getStatusFuncion() == Status.NG) {
                System.out.println("Product đã Output Thành Công");
                return;
            }
        }
    }
    // check trạng thái sản phẩm
    private Status chooseStatus() {
        Status status = null;
        System.out.println("Chọn trạng thái sản phẩm");
        System.out.println("1. OK " +
                "2. Hỏng");
        int choose = InputValue.getInt(1, 2);
        switch (choose) {
            case 1:
                status = Status.OK;
                break;
            case 2:
                status = Status.NG;
                break;
        }
        return status;
    }
}
