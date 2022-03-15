package models;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

class DepartmentTest {

    @Test
    public void department_instaniciatescorrectly_true() {
        Department testdepartment = new Department("1", "business ", "bus", "");
        assertEquals(true, testdepartment instanceof Department);
    }

    @Test
    public void department_InstantiateWithDepartName_true() {
        Department testDepart = new Department("1", "business", "bus","2");
        assertEquals("bus", testDepart.getDepartName());
    }

    @Test
    public void department_InstantiateWithDepartDesc_true() {
        Department testDepart = new Department("bus", "business", "bus","2");
        assertEquals("bus", testDepart.getDepartDesc());
    }
    @Test
    public void department_InstantiateWithEmployeeNo_true() {
        Department testDepart = new Department("bus", "business", "bus","2");
        assertEquals(2, testDepart.getEmployeeNo());
    }

}