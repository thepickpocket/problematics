package bravopeople;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ResearchGroupAssociationTest
{
    public static Group mockedGroup;
    public static Date d;
    public static ResearchGroupAssociation test;

    @BeforeClass
    public static void setup(){
        mockedGroup = mock(Group.class);
        d = new Date();
    }

    /**
     * Checks if the default constructor works
     */
    @Test
    public void test_RGA_Creation_DefaultValues()
    {
        ResearchGroupAssociation test = new ResearchGroupAssociation();
        assertNotNull("Creation of researchGroupAssociation failed.", test);
        assertNotNull("A Default ResearchGroupAssociation should always have a start date, not null.", test.getStartDate());
        assertNull("A Default ResearchGroupAssociation should always have a null end date.", test.getEndDate());
        assertTrue("Default of MEMBER not assigned.", test.getRole().equals("Member"));
        assertNotNull("A Default ResearchGroupAssociation should always have a group, not null.", test.getGroup());

        assertTrue("A Default ResearchGroupAssociation should always be active.", test.isActive());
    }


    /**
     * Checks if the parametrised constructor works
     */
    @Test
    public void test_RGA_Creation_NullValues() {
        test = new ResearchGroupAssociation(null, null, "");
        assertNotNull("Creation of researchGroupAssociation failed.", test);
        assertNotNull("A ResearchGroupAssociation should always have a start date, not null.", test.getStartDate());
        assertNull("A ResearchGroupAssociation should always have a null end date.", test.getEndDate());
        assertTrue("Student not assigned as role.", test.getRole().equals("Student"));
        assertNotNull("A Default ResearchGroupAssociation should always have a group, not null.", test.getGroup());
        assertTrue("A Default ResearchGroupAssociation should always be active.", test.isActive());
    }

    @Test
    public void test_RGA_Creation_GoodValues(){
        test = new ResearchGroupAssociation(d, mockedGroup, "Groupleader");
        assertTrue("Initialization of role was not successful.", test.getRole().equals("Groupleader"));

        try {
            Boolean active = test.isActive();
        } catch (Exception ex) {
            fail("NullPointerException for active status. The active status is never set/initialized");
        }
    }

    @Test
    public void test_RGA_GetSetStartingDate(){
        try {
            Thread.sleep(2 * 60 * 10);
            Date newDate = new Date();
            test.setStartDate(newDate);
            assertFalse("The set date method failed to set the date in the object.", test.getStartDate() == d);
            assertTrue("The set date method failed to set the date in the object.", test.getStartDate() == newDate);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void test_RGA_SetStartEndDate_Null(){
        test.setStartDate(d);
        test.setStartDate(null);
        assertNotNull("The setStartDate(Date date) method allowed the setting of the start date to NULL.", test.getStartDate());
        test.setEndDate(d);
        test.setEndDate(null);
        assertNotNull("The setEndDate(Date date) method allowed the setting of the end date to NULL", test.getEndDate());
    }

    @Test
    public void test_RGA_GetSetEndingDate(){
        Date newDate = new Date();
        test.setEndDate(newDate);
        assertTrue("End date was not set in object by setEndDate(Date date)", test.getEndDate() == newDate);
    }

    @Test
    public void test_RGA_GetSetUserRole(){
        test.setRole("Student");
        assertTrue("Method setRole(String role) did not successfully set the role in the object.", test.getRole().equals("Student"));
        test.setRole("Collaborator");
        assertTrue("Method setRole(String role) did not successfully set the role in the object.", test.getRole().equals("Collaborator"));
        test.setRole("Member");
        assertTrue("Method setRole(String role) did not successfully set the role in the object.", test.getRole().equals("Member"));
        test.setRole("Groupleader");
        assertTrue("Method setRole(String role) did not successfully set the role in the object.", test.getRole().equals("Groupleader"));
        test.setRole("SomethingStrange");
        assertFalse("Method setRole(String role) did not successfully set the role in the object to default value.", test.getRole().equals("SomethingStrange"));
    }

    @Test
    public void test_RGA_GetSetGroup(){
        test = new ResearchGroupAssociation(d, mockedGroup, "Groupleader");
        test.setGroup(null);
        assertNotNull("A ResearchGroupAssociation should always have a group, not null.", test.getGroup());
        test.setGroup(mock(Group.class));
        assertFalse("Setting of a new group failed.", test.getGroup() == mockedGroup);
    }

    @Test
    public void test_RGA_SetActiveStatus(){
        test.activate();
        assertTrue("Method activate() did not set active status in object to active.", test.isActive());
    }

    @Test
    public void test_RGA_SetInactiveStatus(){
        test.deactivete();
        assertFalse("Method deactivete() did not set active status in object to inactive.", test.isActive());
    }
}
