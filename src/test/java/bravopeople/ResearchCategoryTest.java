package bravopeople;

import static bravopeople.GroupTest.mockedPeople;
import junit.framework.TestCase;

import java.util.Date;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ResearchCategoryTest extends TestCase
{

    public ResearchCategoryTest(String testName)
    {
        super(testName);
    }

    //----------------------------------------------------Testing object creaion-----------------------------------------------
    //Testing the creation of the object with no parameters - hence default constructor
    //Test C1
    @Test
    public void test_Category_Creation_Default()
    {
        ResearchCategory testCat = new ResearchCategory();
        assertTrue("ID not correctly set", testCat.getID().equals("dummy12345"));
        assertTrue("Name not correctly set", testCat.getName().equals("dummy"));
    }

    //Testing the creation of the object with valid parameters
    //Test C2
    @Test
    public void test_Category_Creation_Valid()
    {
        Date date = new Date();
        ResearchCategory testCat = new ResearchCategory("ID01", "Testing Category", date);
        assertTrue("ID does not match the constructor parameter", testCat.getID().equals("ID01"));
        assertTrue("Name does not match the constructor parameter", testCat.getName().equals("Testing Category"));
        assertTrue("Date does not match the constructor parameter", testCat.getDate().equals(date));
    }

    //Testing the creation of the object with null parameters
    //Test C3
    @Test
    public void test_Category_Creation_Null()
    {
        try
        {
            ResearchCategory testCat = new ResearchCategory(null, null, null);
            fail("No excpetion thrown for C3");
        }
        catch (IllegalArgumentException e)
        {

        }
    }

    //---------------------------------------------Modifying Category name--------------------------------------------------------
    //Testing whether the name of a ResearchCategory object can be changed to a valid name
    //Test C4
    @Test
    public void test_Modifying_Category_Name_Valid()
    {
        Date date = new Date();
        ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
        testCat.setName("New01");
        assertTrue("Name was not updated succesfully", testCat.getName().equals("New01"));
    }

    //Testing whether the name of a ResearchCategory object can be changed to a null name
    //Test C5
    @Test
    public void test_Modifying_Category_Name_Null()
    {
        Date date = new Date();
        ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
        try
        {
            testCat.setName(null);
            fail("No exception thrown for C5");
        }
        catch (IllegalArgumentException e)
        {

        }

    }

    //----------------------------------Test adding of new researchOutputTarget with effectiveDate--------------------------------
    //Test whether one can add a new researchOutputTarget with effectiveDate, using valid parameters
    //Test C6
    @Test
    public void test_Adding_New_ResearchOutputTarget_Valid()
    {
        try
        {
            Date date = new Date();
            double outputTarget = 4;
            ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
            testCat.addNewResearchOutputTarget(outputTarget, date);
        }
        catch (UnsupportedOperationException exc)
        {
            fail("C10 " + exc.getMessage());
        }

    }

    //Test whether one can add a new researchOutputTarget with effectiveDate, using null parameters
    //Test C7
    @Test
    public void test_Adding_New_ResearchOutputTarget_Null()
    {
        try
        {
            Date date = new Date();
            double outputTarget = 4.0;
            ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
            testCat.addNewResearchOutputTarget(outputTarget, null);
            fail("No exception thrown for C11");
        }
        catch (UnsupportedOperationException exc)
        {
            fail("C11 " + exc.getMessage());
        }
        catch (IllegalArgumentException e)
        {

        }

    }

    //Test whether one can add a new researchOutputTarget with effectiveDate, using null parameters
    //Test C8
    @Test
    public void test_Adding_New_ResearchOutputTarget_Invalid()
    {
        try
        {
            Date date = new Date();
            double outputTarget = -4.0;
            ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
            testCat.addNewResearchOutputTarget(outputTarget, date);
            fail("No exception thrown for C11");
        }
        catch (UnsupportedOperationException exc)
        {
            fail("C11 " + exc.getMessage());
        }
        catch (IllegalArgumentException e)
        {

        }

    }

    //-------------------------------------Test modifying of researchOutputTarget for a specific date-------------------------------
    //Test whether one can change the researchOutputTarget, associated with a specific date, with a valid parameter
    //Test C9
    @Test
    public void test_Modifying_Output_Target_Valid()
    {
        try
        {
            Date date = new Date();
            //id of the researchOutputTarget that should be updated
            int id = 1;
            double outputTarget = 4;
            ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
            testCat.setResearchOuputTarget(id, outputTarget);
            assertTrue("OutputTarget was updated unsuccessfully", testCat.getResearchOuputTarget(id) == outputTarget);
        }
        catch (UnsupportedOperationException exc)
        {
            fail("C6 " + exc.getMessage());
        }

    }

    //Test whether one can change the researchOutputTarget, associated with a specific date, with an invalid parameter
    //Test C10
    @Test
    public void test_Modifying_ResearchOutput_Invalid()
    {
        try
        {
            Date date = new Date();
            double outputTarget = -4.0;
            //id of the researchOutputTarget that should be updated
            int id = 1;
            ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
            testCat.setResearchOuputTarget(id, outputTarget);
            fail("No exception thrown for C7");
        }
        catch (UnsupportedOperationException exc)
        {
            fail("C7 " + exc.getMessage());
        }
        catch (IllegalArgumentException e)
        {

        }

    }

    //----------------------------------Modifying the date for a specific researchOutputTarget--------------------------------
    //Test whether one can change the date, associated with a specific researchOutputTarget, with a valid parameter
    //Test C11
    @Test
    public void test_Modifying_Date_For_ResearchOutput_Valid()
    {
        try
        {
            Date date = new Date();
            double outputTarget = 4;
            //id of the effeciveDate that should be updated
            int id = 1;
            ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
            testCat.setDateForResearchOutput(id, date);
            assertTrue("Date for output target was updated unsuccessfully", testCat.getDateForResearchOutput(id).equals(date));
        }
        catch (UnsupportedOperationException exc)
        {
            fail("C8 " + exc.getMessage());
        }

    }

    //Test whether one can change the date, associated with a specific researchOutputTarget, with a null parameter
    //Test C12
    @Test
    public void test_Modifying_Date_For_ResearchOutput_Null()
    {
        try
        {
            Date date = new Date();
            double outputTarget = 4.0;
            //id of the effeciveDate that should be updated
            int id = 1;
            ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
            testCat.setDateForResearchOutput(id, null);
            fail("No exception thrown for C9");
        }
        catch (UnsupportedOperationException exc)
        {
            fail("C9 " + exc.getMessage());
        }
        catch (IllegalArgumentException e)
        {

        }

    }

    //----------------------------------Test removing a researchOutputTarget--------------------------------
    //Test whether one can remove a researchOutputTarget with effectiveDate
    //Test C13
    @Test
    public void test_Remove_ResearchOutputTarget()
    {
        try
        {
            Date date = new Date();
            double outputTarget = 4;
            int id = 1;
            ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
            testCat.removeResearchOutputTarget(id);
        }
        catch (UnsupportedOperationException exc)
        {
            fail("C12 " + exc.getMessage());
        }

    }
}
