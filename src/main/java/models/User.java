package models;

public class User {

    private int id;
    private String name;
    private String position;
    private String role;
    private String department;
    private int departId;


    public User(String name, String position, String role, String department, int departId) {
        this.name = name;
        this.position = position;
        this.role = role;
        this.department = department;
        this.id = id;
        this.departId = departId;
    }

    public int getDepartId() {
        return departId;
    }

    public void setDepartId(int departId) {
        this.departId = departId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
