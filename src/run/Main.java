package run;

import services.EmployeeSoftwareService;
import services.EmployeeWareHouseSercive;
import services.Login;

public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        login.showLogin();
    }
}