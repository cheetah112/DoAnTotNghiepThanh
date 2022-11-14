package utils;

import java.util.Iterator;
import java.util.List;

import constants.StatusInvoice;
import database.DataBase;
import model.*;

public class SearchHistory {
    // Method in toàn bộ list ra màn hình
    public static <E> void searchAll(List<E> list) {
        if (list.isEmpty()) {
            System.out.println("Chưa có Thông tin nào");
        }
        for (E e : list) {
            System.out.println(e.toString());
        }
    }


    // Method tìm khách hàng theo ID Customer
    public static void searchCustomerByID() {
        if (DataBase.customerList.isEmpty()){
            System.out.println("Không có thông tin nào");
            return;
        }
        Iterator<Customer> it = DataBase.customerList.iterator();
        System.out.println("Nhap ID Customer:");
        String idCustomer = InputValue.getString();
        while (it.hasNext()) {
            Customer customer = it.next();
            if (customer.getIdCustomer().equals(idCustomer)) {
                System.out.println(customer.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng nào");
    }

    // Method tìm hóa đơn theo Code hóa đơn
    public static void searchInvoiceByID() {
        if (DataBase.invoiceList.isEmpty()){
            System.out.println("Không có thông tin nào");
            return;
        }
        Iterator<Invoice> it = DataBase.invoiceList.iterator();
        System.out.println("Nhap ID Invoice:");
        String idInvoice = InputValue.getString();
        while (it.hasNext()) {
            Invoice invoice = it.next();
            if (idInvoice.equals(invoice.getCodeInvoive())) {
                System.out.println(invoice.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn nào");
    }

    // Method tìm tài khoản theo ID Employee
    public static void searchAccountByID() {
        if (DataBase.accountsList.isEmpty()){
            System.out.println("Không có thông tin nào");
            return;
        }
        Iterator<Account> it = DataBase.accountsList.iterator();
        System.out.println("Nhap ID Account:");
        String idAccount = InputValue.getString();
        while (it.hasNext()) {
            Account account = it.next();
            if (account.getUserName().equals(idAccount)) {
                System.out.println(account.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy Tài khoản nào");
    }

    // method tìm kiếm nhân viên theo ID Employee
    public static void searchEmployeeByID() {
        if (DataBase.employeeList.isEmpty()){
            System.out.println("Không có thông tin nào");
            return;
        }
        Iterator<Employee> it = DataBase.employeeList.iterator();
        System.out.println("Nhap ID Employee:");
        String idEmployee = InputValue.getString();
        while (it.hasNext()) {
            Employee employee = it.next();
            if (employee.getIdNhanVien().equals(idEmployee)) {
                System.out.println(employee.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy Nhân viên nào");
    }

    // method tìm kiếm khách hàng theo tên Customer
    public static void searchCustomerByName() {
        if (DataBase.invoiceList.isEmpty()){
            System.out.println("Không có thông tin nào");
            return;
        }
        Iterator<Invoice> it = DataBase.invoiceList.iterator();
        System.out.println("Nhap Name Customer:");
        String name = InputValue.getString();
        while (it.hasNext()) {
            Invoice invoice = it.next();
            if (invoice.getCustomer().getNameCustomer().contains(name)) {
                System.out.println(invoice.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng nào");
    }

    // method tòm kiếm hóa đơn oder vật liệu theo code invoice
    public static void searchInvoiceOderMaterialByCode() {
        if (DataBase.invoiceMaterialList.isEmpty()){
            System.out.println("Không có thông tin nào");
            return;
        }
        Iterator<InvoiceMaterial> it = DataBase.invoiceMaterialList.iterator();
        System.out.println("Nhập Code Invoice Material");
        String codeInvoice = InputValue.getString();
        while (it.hasNext()) {
            InvoiceMaterial invoiceMaterial = it.next();
            if (invoiceMaterial.getCodeMaterial().equals(codeInvoice)) {
                System.out.println(invoiceMaterial.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn nào");
    }

    //Tìm kiếm input material bằng ID Material
    public static void searchInputMaterialByID() {
        if (DataBase.inPutMaterialList.isEmpty()){
            System.out.println("Không có thông tin nào");
            return;
        }
        Iterator<InputMaterial> it = DataBase.inPutMaterialList.iterator();
        System.out.println("Nhập ID Material");
        String idMaterial = InputValue.getString();
        while (it.hasNext()) {
            InputMaterial inputMaterial = it.next();
            if (inputMaterial.getMaterial().getIdMaterial().equals(idMaterial)) {
                System.out.println(inputMaterial.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy vật liệu nào");
    }

    public static void searchCustomerByCodeInvoice() {
        if (DataBase.invoiceList.isEmpty()){
            System.out.println("Không có thông tin nào");
            return;
        }
        Iterator<Invoice> it = DataBase.invoiceList.iterator();
        System.out.println("Nhap ID Customer");
        String idCustomer = InputValue.getString();
        while (it.hasNext()) {
            Invoice invoice = it.next();
            if (invoice.getCustomer().getIdCustomer().equals(idCustomer)) {
                System.out.println(invoice.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng nào");
    }
    public static void searchHistoryRepairProductByID(){
        if (DataBase.historyList.isEmpty()){
            System.out.println("Không có thông tin nào");
            return;
        }
        Iterator<History> it = DataBase.historyList.iterator();
        System.out.println("Nhap ID product:");
        String idProduct = InputValue.getString();
        while (it.hasNext()) {
            History history = it.next();
            if (idProduct.equals(history.getProduct().getIdProduct())) {
                System.out.println(history.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy Sản phẩm nào");
    }

    public static void showRepairProductPending(Employee employee) {
        if (DataBase.historyList.isEmpty()){
            System.out.println("Không có thông tin nào");
            return;
        }
        Iterator<History> it = DataBase.historyList.iterator();
        while (it.hasNext()) {
            History history = it.next();
            if (history.getStatusFuncion() == null && history.getEmployeeFuncion().equals(employee)) {
                System.out.printf("Thông Tin Sản phẩm:   %s \n Trạng Thái:   %s \n Tên Người Sửa:  %s",history.getProduct(),history.getStatusRece(),history.getEmployeeRece());
                return;
            }
        }
        System.out.println("Không tìm thấy Sản phẩm nào");
    }

    public static void searchCompletedInvoiceByCode() {
        if (DataBase.completedInvoiceList.isEmpty()){
            System.out.println("Không có thông tin nào");
            return;
        }
        Iterator<CompletedInvoice> it = DataBase.completedInvoiceList.iterator();
        System.out.println("Nhap Code Invoice");
        String codeCompletedInvoice = InputValue.getString();
        while (it.hasNext()) {
            CompletedInvoice completedInvoice = it.next();
            if (completedInvoice.getInvoice().getCodeInvoive().equals(codeCompletedInvoice)) {
                System.out.println(completedInvoice.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn nào");
    }

    public static void searchCompletedInvoiceByReturn() {
        if (DataBase.completedInvoiceList.isEmpty()){
            System.out.println("Không có thông tin nào");
            return;
        }
        Iterator<CompletedInvoice> it = DataBase.completedInvoiceList.iterator();
        while (it.hasNext()) {
            CompletedInvoice completedInvoice = it.next();
            if (completedInvoice.getStatus() == StatusInvoice.RETURN) {
                System.out.println(completedInvoice.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn nào");
    }

    public static void searchCompletedInvoiceByRepair() {
        if (DataBase.completedInvoiceList.isEmpty()){
            System.out.println("Không có thông tin nào");
            return;
        }
        Iterator<CompletedInvoice> it = DataBase.completedInvoiceList.iterator();
        while (it.hasNext()) {
            CompletedInvoice completedInvoice = it.next();
            if (completedInvoice.getStatus() == StatusInvoice.REPAIR) {
                System.out.println(completedInvoice.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn nào");
    }

    public static void searchNameCustomerByCodeInvoice() {
        if (DataBase.invoiceList.isEmpty()){
            System.out.println("Không có thông tin nào");
            return;
        }
        Iterator<Invoice> it = DataBase.invoiceList.iterator();
        System.out.println("Nhap Name Customer");
        String nameCustomer = InputValue.getString();
        while (it.hasNext()) {
            Invoice invoice = it.next();
            if (invoice.getCustomer().getNameCustomer().contains(nameCustomer)) {
                System.out.println(invoice.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng nào");
    }
}
