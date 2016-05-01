package bravopeople;

import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class PersonTest
{

    private Person test;
    @Before
    public void setUp(){
        test = new Person("name", "surname", "id", "email");
    }
    /**
     *
     * TODO: Add proper tests once code is in place.
     * Tests
     *  - Contructor params are same as gets
     */
    @Test
    public void testPerson()
    {
        
        assertEquals("name", test.getName());
        assertEquals("surname", test.getSurname());
        assertEquals("id", test.getID());
        assertEquals("email", test.getEmail());
    }
    
    @Test
    public void testsetUserRights(){
        //Default
        test.setUserRights("Random");
        assertEquals("RESEARCHER", test.getUserRights());
        
        test.setUserRights("ADMIN");
        assertEquals("ADMIN", test.getUserRights());
        
        test.setUserRights("RESEARCHGROUPLEADER");
        assertEquals("RESEARCHGROUPLEADER", test.getUserRights());
        
        test.setUserRights("RESEARCHER");
        assertEquals("RESEARCHER", test.getUserRights());
    }
    
    @Test
    public void testsetOrganisation(){
        Organisation orgMock = mock(Organisation.class);
        when(orgMock.getName()).thenReturn("Org1");
        test.setOrganisation(orgMock);
        assertEquals("Org1", test.getOrganisation().getName());
    }
}
