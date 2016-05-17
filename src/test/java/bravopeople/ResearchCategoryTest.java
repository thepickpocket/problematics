package bravopeople;

import static bravopeople.GroupTest.mockedPeople;
import java.util.Calendar;
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

    //--------------------------------------Test the constructors-------------------------------
    //Testing the creation of the object with valid parameters
    //Test C1
    @Test
    public void test_Category_Creation_Valid()
    {
        try
        {
            ResearchCategory testCat = new ResearchCategory("ID", "Name");
            assertTrue("Name was not set succesfully", testCat.getName().equals("Name"));
        }
        catch (UnsupportedOperationException exc)
        {
            fail("C1 " + exc.getMessage());
        }
    }

    //Testing the creation of the object with invalid parameters
    //Test C2
    @Test
    public void test_Category_Creation_Invalid()
    {
        try
        {
            ResearchCategory testCat = new ResearchCategory("", "");
            fail("No IllegalArgumentException thrown for C2");
        }
        catch (IllegalArgumentException e)
        {
        }
        catch (UnsupportedOperationException exc)
        {
            fail("C2 " + exc.getMessage());
        }
    }

    //Testing the creation of the object with null parameters
    //Test C3
    @Test
    public void test_Category_Creation_Null()
    {
        try
        {
            ResearchCategory testCat = new ResearchCategory(null, null);
            fail("No IllegalArgumentException thrown for C3");
        }
        catch (IllegalArgumentException e)
        {
        }
        catch (UnsupportedOperationException exc)
        {
            fail("C3 " + exc.getMessage());
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

    //Testing whether the name of a ResearchCategory object can be changed to an invalid name
    //Test C5
    @Test
    public void test_Modifying_Category_Name_Invalid()
    {
        Date date = new Date();
        ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
        try
        {
            testCat.setName("");
            fail("No IllegalArgumentException thrown for C5");
        }
        catch (IllegalArgumentException e)
        {

        }

    }

    //Testing whether the name of a ResearchCategory object can be changed to a null name
    //Test C6
    @Test
    public void test_Modifying_Category_Name_Null()
    {
        Date date = new Date();
        ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
        try
        {
            testCat.setName(null);
            fail("No IllegalArgumentException thrown for C6");
        }
        catch (IllegalArgumentException e)
        {

        }

    }

    //----------------------------------Test adding of new ResearcherCategoryState--------------------------------
    //Test whether one can add a new ResearcherCategoryState, using valid parameters
    //Test C7
    @Test
    public void test_Adding_New_ResearcherCategoryState_Valid()
    {
        try
        {
            Date date = new Date();
            double outputTarget = 4;
            ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
            testCat.addNewResearcherCategoryState(outputTarget, date);
        }
        catch (UnsupportedOperationException exc)
        {
            fail("C7 " + exc.getMessage());
        }

    }

    //Test whether one can add a new ResearcherCategoryState, using invalid parameters
    //Test C8
    @Test
    public void test_Adding_New_ResearcherCategoryState_InvalidOne()
    {
        try
        {
            Date date = new Date();
            double outputTarget = -4.0;
            ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
            testCat.addNewResearcherCategoryState(outputTarget, date);
            fail("No exception thrown for C8");
        }
        catch (UnsupportedOperationException exc)
        {
            fail("C8 " + exc.getMessage());
        }
        catch (IllegalArgumentException e)
        {

        }

    }

    //Test whether one can add a new ResearcherCategoryState, using past dates
    //Test C9
    @Test
    public void test_Adding_New_ResearcherCategoryState_InvalidTwo()
    {
        try
        {
            Date date = new Date();
            double outputTarget = 4.0;
            ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.MONTH, 9);
            cal.set(Calendar.DATE, 24);
            cal.set(Calendar.YEAR, 2013);
            cal.set(Calendar.HOUR, 13);
            cal.set(Calendar.MINUTE, 45);
            cal.set(Calendar.SECOND, 52);
            testCat.addNewResearcherCategoryState(outputTarget, cal.getTime());
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

    //Test whether one can add a new ResearcherCategoryState, using double dates
    //Test C10
    @Test
    public void test_Adding_New_ResearcherCategoryState_InvalidThree()
    {
        try
        {
            Date date = new Date();
            double outputTarget = 4.0;
            ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
            testCat.addNewResearcherCategoryState(outputTarget, date);
            testCat.addNewResearcherCategoryState(outputTarget, date);
            fail("No exception thrown for C10");
        }
        catch (UnsupportedOperationException exc)
        {
            fail("C10 " + exc.getMessage());
        }
        catch (IllegalArgumentException e)
        {

        }

    }

    //Test whether one can add a new ResearcherCategoryState, using null date
    //Test C11
    @Test
    public void test_Adding_New_ResearcherCategoryState_Null()
    {
        try
        {
            Date date = new Date();
            double outputTarget = 4.0;
            ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
            testCat.addNewResearcherCategoryState(outputTarget, null);
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
   
    //----------------------------------Test removing a ResearchCategoryState Object--------------------------------
    //Test whether one can remove a researchOutputTarget with effectiveDate
    //Test C12
    @Test
    public void test_Remove_ResearchCategoryState()
    {
        try
        {
            Date date = new Date();
            int id = 1;
            ResearchCategory testCat = new ResearchCategory("T01", "ValidCat", date);
            testCat.removeResearcherCategoryState(id);
        }
        catch (UnsupportedOperationException exc)
        {
            fail("C12 " + exc.getMessage());
        }

    }
}
