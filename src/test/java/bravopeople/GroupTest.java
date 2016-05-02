package bravopeople;

import org.junit.Test;
import org.junit.BeforeClass;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

public class GroupTest
{
    public static Group testGroup;
    //public static ArrayList<PersonEntity> subGroups;

    @BeforeClass
    public static void setup(){
        testGroup = new Group("Testing Group", new ArrayList<PersonEntity>());
    }

    @Test
    public void testGroup()
    {
        assertTrue(testGroup.getName().equals("Testing Group"));
    }

    @Test
    public void test_Group_Null_String(){
        testGroup.setName(null);
        assertNotNull("Cannot assign a null value to a name.", testGroup.getName());
    }
}
