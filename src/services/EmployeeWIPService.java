package services;

import constants.Status;
import constants.Type;
import database.DataBase;
import model.Employee;
import model.History;
import model.Product;
import utils.InputValue;
import utils.SearchHistory;

import java.time.LocalDate;

public class EmployeeWIPService implements IService {
    // màn hình chính chức năng của nhân viên WIP
    public void showFunction() {
        while (true) {
            System.out.println("1. Transfer Product");
            System.out.println("2. Seach History Repair Product");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0) {
                DataBase.employee = null;
                break;
            }
            switch (choose) {
                case 1:
                    showTransferProduct();
                    break;
                case 2:
                    showSearchRepairProduct();
                    break;
            }
        }
    }

    // màn hình chứ năng tìm kiếm lịch sử
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
    // chức năng chuyển sản phẩm sang công đoạn sau
    private void showTransferProduct() {
        System.out.println("Nhập ID sản phẩm");
        String idProduct = InputValue.getString();
        for (History history : DataBase.historyList) {
            if (history.getProduct().getIdProduct().equals(idProduct) && history.getEmployeeFuncion() == null) {
                System.out.println("nhập ID nhân viên tiếp theo");
                String idEmployee = InputValue.getString();
                Employee employeeFuncion = getEmployeeAfter(idEmployee);
                if (employeeFuncion == null){
                    System.out.println("Không tìm thấy nhân viên nào hoặc nhân viên không phải nhân viên Fuction");
                    return;
                }
                LocalDate dayInput = LocalDate.now();
                history.setDayInputWIP(dayInput);
                history.setEmployeeFuncion(employeeFuncion);
                System.out.println("Đã chuyển thành công");
                return;
            }
            if (history.getProduct().getIdProduct().equals(idProduct) && history.getEmployeeFuncion() != null){
                System.out.println("Sản phẩm đã được chia đến đội tiếp theo");
                return;
            }
        }
    }

    // check nhân viên viên công đoạn sau
    private Employee getEmployeeAfter(String idEmployee) {
        for (Employee employee : DataBase.employeeList) {
            if (employee.getIdNhanVien().equals(idEmployee) && employee.getType() == Type.NHANVIENSUAFONT) {
                return employee;
            }
            if (employee.getIdNhanVien().equals(idEmployee) && employee.getType() == Type.NHANVIENSUAPCB) {
                return employee;
            }
            if (employee.getIdNhanVien().equals(idEmployee) && employee.getType() == Type.NHANVIENSUAPHANMEM) {
                return employee;
            }
        }
        return null;
    }
}
