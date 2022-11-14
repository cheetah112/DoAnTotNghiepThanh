package services;

import constants.Type;
import database.DataBase;
import model.Account;
import model.Employee;
import model.History;
import utils.InputValue;
import utils.SearchHistory;

import java.util.Iterator;

public class AdminService implements IService {

    // màn hình chính của ADMIN
    public void showFunction() {
        while (true) {
            System.out.println("1. Quản Lý Nhân Viên");
            System.out.println("2. Quản Lý Tài khoản");
            System.out.println("3. Search History");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0) {
                DataBase.employee = null;
                break;
            }
            switch (choose) {
                case 1:
                    showEmployeeFunction();
                    break;
                case 2:
                    showAccountFunction();
                    break;
                case 3:
                    showSearchHistory();
                    break;
            }
        }
    }
    // chức năng quản lý tài khoản
    public void showAccountFunction() {
        while (true) {
            System.out.println("1. Thêm Tài Khoản");
            System.out.println("2. Xóa Tài Khoản");
            System.out.println("3. Thay đổi mặt khẩu");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    showAddAcc();
                    break;
                case 2:
                    deteletAcc();
                    break;
                case 3:
                    changePassword();
                    break;
            }
        }
    }
    // thay đổi mật khẩu
    private void changePassword() {
        System.out.println("Nhập tài khoản cần thay đổi");
        String userName = InputValue.getString();
        boolean ketQuaCheckAcc = InputValue.checkAccount(userName);
        if (ketQuaCheckAcc == true) {
            System.out.println("Nhập mật khẩu mới");
            String newPassword = InputValue.getString();
            Iterator<Account> it = DataBase.accountsList.iterator();
            while (it.hasNext()) {
                Account account = it.next();
                if (account.equals(userName)) {
                    account.setPassword(newPassword);
                    System.out.println("Đã thay đổi thành công");
                }
            }
        }
        if (ketQuaCheckAcc == false) {
            System.out.println("Tài khoản không tồn tại");
        }
    }
    // xóa tài khonar
    public void deteletAcc() {
        System.out.println("Nhập tài khoản cần xóa ");
        String userName = InputValue.getString();
        boolean ketQuaCheckAcc = InputValue.checkAccount(userName);
        if (ketQuaCheckAcc == true) {
            Iterator<Account> it = DataBase.accountsList.iterator();
            while (it.hasNext()) {
                Account account = it.next();
                if (account.equals(userName)) {
                    it.remove();
                    System.out.println("Đã xóa tài khoản thành công");
                }
            }
        }
        if (ketQuaCheckAcc == false) {
            System.out.println("Tài khoản không tồn tại");
        }
    }

    // thêm 1 tài khoản mới
    public void showAddAcc() {
        String userName = InputValue.getIDEmployee();
        if (userName == null){
            System.out.println("Nhân viên không tồn tại");
            return;
        }
        System.out.println("Nhập Mật Khẩu");
        String password = InputValue.getString();
        boolean ketQua = InputValue.checkUsername(userName);
        if (ketQua == true){
            System.out.println("Tài khoản đã tồn tại");
            return;
        }
        if (ketQua == false){
            System.out.println("Đã thêm tài khoản thành công");
            Account account = new Account(userName, password);
            DataBase.accountsList.add(account);
        }
    }
    // check loại nhân viên
    private Type inputType() {
        Type type = null;
        System.out.println("1. Nhân Viên Lễ Tân " +
                "2. Nhân viên WIP " +
                "3. Nhân Viên sửa chữa Font " +
                "4. Nhân viên sửa chữa phần mềm " +
                "5. Nhân viên sửa chữa PBA " +
                "6. Nhân viên Kho " +
                "7. Quản lý ");
        int choose = InputValue.getInt(1, 7);
        switch (choose) {
            case 1:
                type = Type.NHANVIENLETAN;
                break;
            case 2:
                type = Type.NHANVIENWIP;
                break;
            case 3:
                type = Type.NHANVIENSUAFONT;
                break;
            case 4:
                type = Type.NHANVIENSUAPHANMEM;
                break;
            case 5:
                type = Type.NHANVIENSUAPCB;
                break;
            case 6:
                type = Type.NHANVIENKHO;
                break;
            case 7:
                type = Type.QUANLY;
                break;
        }
        return type;
    }

    // quản lý chức năng nhân viên
    public void showEmployeeFunction() {
        while (true) {
            System.out.println("1. Thêm Nhân Viên");
            System.out.println("2. Xóa Nhân Viên");
            System.out.println("3. Thay đổi tên nhân viên");
            System.out.println("4. Thay đổi công việc nhân viên");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 4);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    deteletEmployee();
                    break;
                case 3:
                    changeNameEmployee();
                    break;
                case 4:
                    changeWorkEmployee();
                    break;
            }
        }
    }
    // thay đổi công việc employ
    private void changeWorkEmployee() {
        System.out.println("Nhập ID Nhân Viên cần thay đổi");
        String idNhanVien = InputValue.getString();
        boolean ketQuaCheckID = InputValue.checkEmployee(idNhanVien);
        if (ketQuaCheckID == true) {
            Type type = inputType();
            Iterator<Employee> it = DataBase.employeeList.iterator();
            while (it.hasNext()) {
                Employee employee = it.next();
                if (employee.getIdNhanVien().equals(idNhanVien)) {
                    employee.setType(type);
                    System.out.println("Đã thay đổi thành công");
                }
            }
        }
        if (ketQuaCheckID == false) {
            System.out.println("Nhân Viên không tồn tại");
        }
    }
    // thay đổi tên nhân viên
    private void changeNameEmployee() {
        System.out.println("Nhập ID Nhân Viên cần thay đổi");
        String idNhanVien = InputValue.getString();
        boolean ketQuaCheckID = InputValue.checkEmployee(idNhanVien);
        if (ketQuaCheckID == true) {
            System.out.println("Nhập tên mới");
            String newNameEmployee = InputValue.getString();
            Iterator<Employee> it = DataBase.employeeList.iterator();
            while (it.hasNext()) {
                Employee employee = it.next();
                if (employee.getIdNhanVien().equals(idNhanVien)) {
                    employee.setFullName(newNameEmployee);
                    System.out.println("Đã thay đổi thành công");
                }
            }
        }
        if (ketQuaCheckID == false) {
            System.out.println("Nhân Viên không tồn tại");
        }
    }

    // xóa 1 nhân viên
    private void deteletEmployee() {
        System.out.println("Nhập ID Nhân Viên cần xóa ");
        String idNhanVien = InputValue.getString();
        boolean ketQuaCheckID = InputValue.checkEmployee(idNhanVien);
        if (ketQuaCheckID == true) {
            Iterator<Employee> it = DataBase.employeeList.iterator();
            while (it.hasNext()) {
                Employee employee = it.next();
                if (employee.getIdNhanVien().equals(idNhanVien)) {
                    it.remove();
                    System.out.println("Đã xóa thành công");
                }
            }
        }
        if (ketQuaCheckID == false) {
            System.out.println("Nhân Viên không tồn tại");
        }
    }
    // thêm 1 nhân viên
    private void addEmployee() {
        String idNhanVien = InputValue.checkGetEmployee();
        if (idNhanVien == null){
            return;
        }
        System.out.println("Nhập Họ và Tên Nhân viên");
        String fullNameNhanVien = InputValue.getString();
        System.out.println("Nhập loại nhân viên");
        Type type = inputType();
        System.out.println("Đã thêm nhân viên thành công");
        Employee employee = new Employee(idNhanVien, fullNameNhanVien, type);
        DataBase.employeeList.add(employee);
    }
    // Search lịch sử
    private void showSearchHistory() {
        while (true) {
            System.out.println("1. Search history Sản Phẩm vẫn Đang Pending tại Lễ Tân");
            System.out.println("2. Search history Customer");
            System.out.println("3. Search history Pending Invoice");
            System.out.println("4. Search History Completed Invoice");
            System.out.println("5. Search history Employee");
            System.out.println("6. Search history Account");
            System.out.println("7. Search History Material");
            System.out.println("8. Search History Repair Product");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 8);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    SearchHistory.searchAll(DataBase.productList);
                    break;
                case 2:
                    showSearchCustomer();
                    break;
                case 3:
                    showSearchInvoice();
                    break;
                case 4:
                    showSearchCompletedInvoice();
                    break;
                case 5:
                    showSearchEmployee();
                    break;
                case 6:
                    showSearchAccount();
                    break;
                case 7:
                    showSearchMaterial();
                    break;
                case 8:
                    showSearchRepairProduct();
                    break;

            }
        }
    }

    private void showSearchCompletedInvoice() {
        while (true) {
            System.out.println("1. Search By Code Invoice");
            System.out.println("2. Search By Return Invoice");
            System.out.println("3. Search By Repair Invoice");
            System.out.println("4. Search All");
            System.out.println("0. Back");
            int choose = InputValue.getInt(1, 4);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    SearchHistory.searchCompletedInvoiceByCode();
                    break;
                case 2:
                    SearchHistory.searchCompletedInvoiceByReturn();
                    break;
                case 3:
                    SearchHistory.searchCompletedInvoiceByRepair();
                    break;
                case 4:
                    SearchHistory.searchAll(DataBase.completedInvoiceList);
                    break;
            }
        }
    }

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

    // check lịch sử  Customer
    private void showSearchCustomer() {
        while (true) {
            System.out.println("1. Search By ID");
            System.out.println("2. Search By Name");
            System.out.println("3. Search All");
            System.out.println("0. Back");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    searchCustomerByID();
                    break;
                case 2:
                    SearchHistory.searchCustomerByName();
                    break;
                case 3:
                    SearchHistory.searchAll(DataBase.invoiceList);
                    break;
            }
        }
    }
    // tìm kiếm khách hàng bằng ID và COde
    private void searchCustomerByID(){
        while (true){
            System.out.println("1. Search By ID Customer");
            System.out.println("2. Search By Code Invoice");
            System.out.println("0. Quay Lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0){
                break;
            }
            switch (choose){
                case 1:
                    SearchHistory.searchCustomerByID();
                    break;
                case 2:
                    SearchHistory.searchCustomerByCodeInvoice();
                    break;
            }
        }
    }
    // màn hình tìm kiếm hóa đơn
    private void showSearchInvoice() {
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
                    SearchHistory.searchInvoiceByID();
                    break;
                case 2:
                    SearchHistory.searchAll(DataBase.invoiceList);
                    break;
            }
        }
    }
    // màn hình tìm kiếm nhân viên
    private void showSearchEmployee() {
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
                    SearchHistory.searchEmployeeByID();
                    break;
                case 2:
                    SearchHistory.searchAll(DataBase.employeeList);
                    break;
            }
        }
    }
    // màn hình tìm kiếm acc
    private void showSearchAccount() {
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
                    SearchHistory.searchAccountByID();
                    break;
                case 2:
                    SearchHistory.searchAll(DataBase.accountsList);
                    break;
            }
        }
    }


    // màn hình tìm kiếm material
    private void showSearchMaterial() {
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
                    searchInvoiceMaterial();
                    break;
                case 2:
                    searchInputMaterial();
                    break;
            }
        }
    }
    // tìm kiếm input material
    private void searchInputMaterial() {
        while (true) {
            System.out.println("1. Search By ID");
            System.out.println("2. Search All Invoice Material");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    SearchHistory.searchInputMaterialByID();
                    break;
                case 2:
                    SearchHistory.searchAll(DataBase.inPutMaterialList);
                    break;
            }
        }
    }
    // tim kiếm hóa đơn material
    private void searchInvoiceMaterial() {
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
