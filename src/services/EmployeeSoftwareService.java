package services;

import constants.Status;
import constants.Type;
import database.DataBase;
import model.Employee;
import model.History;
import model.InvoiceMaterial;
import utils.InputValue;
import utils.SearchHistory;

import java.time.LocalDate;
import java.util.Iterator;

public class EmployeeSoftwareService implements IService {
    // màn hình chính chức năng nhân viên sửa phần mềm
    public void showFunction() {
        while (true) {
            System.out.println("1. Output Product");
            System.out.println("2. Seach History Repair Product");
            System.out.println("3. Hiển thị sản phẩm còn Pending của mình");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 3);
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
                    SearchHistory.showRepairProductPending(DataBase.employee);
                    break;
            }
        }
    }
    // màn hình chức năng serach history
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

    // output sản phẩm. hoàn thành nốt phần history Product
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
    // check trạng thái của sản phẩm
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
