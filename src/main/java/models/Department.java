package models;

public class Department {

    private int id;
    private String departName;
    private String departDesc;
    private String employeeNo;

    public Department(String id, String departName, String departDesc, String employeeNo) {

        this.departName = departName;
        this.departDesc = departDesc;
        this.employeeNo = employeeNo;
    }


    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getDepartDesc() {
        return departDesc;
    }

    public void setDepartDesc(String departDesc) {
        this.departDesc = departDesc;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getId() {
        return id;
    }
}
