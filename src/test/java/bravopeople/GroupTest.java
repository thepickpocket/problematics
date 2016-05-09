package bravopeople;

import org.junit.Test;
import org.junit.BeforeClass;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class GroupTest
{
    public static Group testGroup;
    public static int numMockedPeople = 5;
    public static ArrayList<PersonEntity> mockedPeople = new ArrayList<>();

    @BeforeClass
    public static void setup(){
        for (int i = 0; i < numMockedPeople; i++)
            mockedPeople.add(mock(PersonEntity.class));
        testGroup = new Group("Testing Group", mockedPeople);
    }

    @Test
    public void test_Group_Creation()
    {
        assertTrue(testGroup.getName().equals("Testing Group"));
        assertTrue(testGroup.getEntities().size() == numMockedPeople);
    }


    @Test
    public void test_Group_Null_String(){
        assertNotNull("The name was never initialized on creation.", testGroup.getName());
        testGroup.setName(null);
        assertNotNull("Should not be able to assign a null string as the group name.", testGroup.getName());
    }

    @Test
    public void test_Group_NotNull_String(){
        testGroup.setName("Testing Group name change");
        assertTrue(testGroup.getName().equals("Testing Group name change"));
    }

    @Test
    public void test_Adding_Person_Entity(){
        testGroup.addEntity(mock(PersonEntity.class));
        assertTrue(testGroup.getEntities().size() == (numMockedPeople+1));
    }

    @Test
    public void test_Get_Active_Status_Default(){
        assertTrue(testGroup.isActive());
    }

    @Test
    public void test_Change_Active_Status_Inactive(){
        testGroup.deactivate();
        assertFalse("Group was not successfully deactivated.", testGroup.isActive());
    }

    @Test
    public void test_Change_Active_Status_Active(){
        testGroup.deactivate();
        testGroup.activate();
        assertTrue("Group was not successfully re-activated.", testGroup.isActive());
    }
}
