package bravopeople;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.UUID;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertEquals;

public class OrganisationTest
{

    private static Organisation testOrganisation;

    @BeforeClass
    public static void setup() {
        testOrganisation = new Organisation("Testing Organisation", getID());
    }

    private static String getID() {
        return UUID.randomUUID().toString();

    }

    /**
     * Tests
     *  - Contructor name is same as getName
     */
    @Test
    public void testOrganisation()
    {
        Organisation test = new Organisation();
        assertEquals("Organisation", test.getName());
    }

    /**
     * Tests
     *  - Contructor name is same as getName
     */
    @Test
    public void testOrganisationTwo() {
        Organisation test = new Organisation("Only a Name");
        assertEquals("Only a Name", test.getName());
    }

    /**
     * Tests if the organisation was created
     */
    @Test
    public void test_Organisation_Creation() {
        assertNotNull("Organisation Created", testOrganisation);
        assertNotNull("The name was never initialized on creation.", testOrganisation.getName());
    }

    /**
     * Tests if the organisation getter and setter methods exist for the ID variable
     */
    @Test
    public void test_Organisation_ID_Methods_Exist() {
        fail("No Getter Methodd for ID in Organisation Class");
        String s = getID();
        testOrganisation.setID(s);
        assertTrue("ID value setter did not work", testOrganisation.ID.equals(s));
    }

    /**
     * Tests if the organisation getter and setter methods exist for the ID variable
     */
    @Test
    public void test_Organisation_Name_Methods_Exist() {
        String s = "New Name";
        testOrganisation.setName(s);
        assertTrue("ID value setter did not work", testOrganisation.getName().equals(s));
        assertTrue("ID value getter did not work", testOrganisation.getName().equals(s));

    }

    /**
     * Tests if the name of the organisation cant be set to an null string
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Organisation_Null_String() {
        try {
            testOrganisation.setName(null);
            fail("Illegal Argument Exception should have been thrown - Name cant be null");
        } catch (Exception ex) {
            assertTrue("Illegal Argument Exception should have been thrown - Name cant be null", ex instanceof NullPointerException);
        }
    }

    /**
     * Tests if the name of the organisation cant be set to an empty string
     */
    @Test
    public void test_Organisation_Empty_String() {
        try {
            testOrganisation.setName("");
            fail("Illegal Argument Exception should have been thrown - Name cant be empty");
        } catch (Exception ex) {
            assertTrue("Illegal Argument Exception should have been thrown - Name cant be empty", ex instanceof IllegalArgumentException);
        }
    }

    /**
     * Tests if the name of the organisation cant be set to only a number
     */
    @Test
    public void test_Organisation_Name_Not_Number() {
        try {
            testOrganisation.setName("1");
            fail("Illegal Argument Exception should have been thrown - Name cant be a number");
        } catch (Exception ex) {
            assertTrue("Illegal Argument Exception should have been thrown - Name cant be a number", ex instanceof IllegalArgumentException);
        }
    }

    /**
     * Tests if the name of the organisation can be changed
     */
    @Test
    public void test_Organisation_NotNull_String() {
        testOrganisation.setName("Testing Organisation name change Before");
        testOrganisation.setName("Testing Organisation name change After");
        assertTrue("Organisation name change did not work", testOrganisation.getName().equals("Testing Organisation name change After"));
    }

    /**
     * Tests if the name of the organisation is not to short
     */
    @Test
    public void test_Organisation_MinLenght_String() {
        try {
            testOrganisation.setName("a");
            fail("Illegal Argument Exception should have been thrown - Name String cant just be one letter");
        } catch (Exception ex) {
            assertTrue("Illegal Argument Exception should have been thrown - Name String cant just be one letter", ex instanceof IllegalArgumentException);
        }
    }

    /**
     * Tests if the id of the organisation cant be set to an null string
     */
    @Test
    public void test_Organisation_ID_Null_String() {
        try {
            testOrganisation.setID(null);
            fail("Null Pointer Exception should have been thrown - ID cant be null");
        } catch (Exception ex) {
            assertTrue("Null Pointer Exception should have been thrown - ID cant be null", ex instanceof IllegalArgumentException);
        }
    }

    /**
     * Tests if the ID of the organisation cant be set to an empty string
     */
    @Test(expected = IllegalArgumentException.class)
    public void test_Organisation_ID_Empty_String() {
        try {
            testOrganisation.setID("");
            fail("Illegal Argument Exception should have been thrown - ID cant be empty");
        } catch (Exception ex) {
            assertTrue("Illegal Argument Exception should have been thrown - ID cant be empty", ex instanceof IllegalArgumentException);
        }
    }

    /**
     * Tests if the ID of the organisation can be changed
     */
    @Test
    public void test_Organisation_ID_NotNull_String() {
//        testOrganisation.setID("Testing Organisation ID change Before");
//        testOrganisation.setID("Testing Organisation ID change After");
//        assertTrue("Organisation ID change did not work", testOrganisation.getID().equals("Testing Organisation ID change After"));
        fail("Organisation ID change did not work - organisation.getID() method does not exist");
    }
}
