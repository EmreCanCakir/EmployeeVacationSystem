package db.model;


import java.sql.SQLException;

public class Validation {

    public static LoginResult<Boolean, Boolean> validateEmailAndPassword(String email, String password) throws SQLException {
        X x = new X();
        x.selectAccount();
        int employeeId = 0;
        for (int i = 0; i < x.accounts.size(); i++) {
            if (x.accounts.get(i).email.equals(email) && x.accounts.get(i).password.equals(password)) {
                employeeId = i + 1;
                boolean isAdmin = isAdmin(employeeId);
                return new LoginResult<>(true, isAdmin);
            }
        }
        return new LoginResult<>(false,false);
    }

    public static boolean isAdmin(int index) throws SQLException {
        X x = new X();
        x.selectEmployee();
        for (int i=0;i<x.employees.size();i++){
            if(x.employees.get(i).eid == index){
                if (x.employees.get(i).departmentId == 5 || x.employees.get(i).departmentId == 6){
                    System.out.println("department id : " + x.employees.get(i).departmentId );
                    return true;
                }
            }
        }
        return false;
    }

}
