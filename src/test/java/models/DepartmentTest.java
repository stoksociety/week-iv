package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    public void department_instaniciatescorrectly_true() {
        Department testdepartment = new Department("1", "business ", "bus", "1");
        assertEquals(true, testdepartment instanceof Department);
    }

    @Test
    public void department_InstantiateWithDepartName_true() {
        Department testDepart = new Department("1", "business", "bus","2");
        assertEquals("bus", testDepart.getDepartName());
    }

    @Test
    public void department_InstantiateWithDepartDesc_true() {
        Department testDepart = new Department("bus", "business", "bus","3");
        assertEquals("bus", testDepart.getDepartDesc());
    }
    @Test
    public void department_InstantiateWithEmployeeNo_true() {
        Department testDepart = new Department("bus", "business", "bus","4");
        assertEquals(2, testDepart.getEmployeeNo());
    }

}