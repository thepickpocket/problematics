package bravopeople;

import java.sql.Date;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class PersonTest
{

    private Person test;
    private Organisation orgMock;
    private ResearchGroupAssociation researchGroupMock;
    private Group groupMock;
    private ResearchCategory researchCatMock;
    
    @Before
    public void setUp(){
        test = new Person("name", "surname", "id", "email");
        orgMock = mock(Organisation.class);
        researchGroupMock = mock(ResearchGroupAssociation.class);
        groupMock = mock(Group.class);
        researchCatMock = mock(ResearchCategory.class);
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
    public void testSetUserRightsDefault(){
        //Default
        test.setUserRights("Random1234514");
        assertEquals("RESEARCHER", test.getUserRights());
        
        //Checking if Set to null
        test.setUserRights(null);
        assertEquals("RESEARCHER", test.getUserRights());
        
        test.setUserRights("");
        assertEquals("RESEARCHER", test.getUserRights());
    }
    
    @Test
    public void testsetUserRightsToCorrectValue(){
        //Test Setting the value
        
        test.setUserRights("ADMIN");
        assertEquals("ADMIN", test.getUserRights());
        
        test.setUserRights("RESEARCHGROUPLEADER");
        assertEquals("RESEARCHGROUPLEADER", test.getUserRights());
        
        test.setUserRights("RESEARCHER");
        assertEquals("RESEARCHER", test.getUserRights());
    }
    
    @Test
    public void testSetOrganisationWithStringParameter(){
        test.setOrganisation("Test");
        assertEquals("Test", test.getOrganisation().getName());
        
      
    }
    
     @Test
    public void testSetOrganisationWithOrganizationAsParameter(){
        //Organisation orgMock = mock(Organisation.class);
        when(orgMock.getName()).thenReturn("Org1");
        test.setOrganisation(orgMock);
        assertEquals(orgMock, test.getOrganisation());
        assertEquals("Org1", test.getOrganisation().getName()); 
    }
    
    @Ignore //No way of getting all organizatins
    @Test
    public void testSetMultipleOrganisations(){
          //Test adding 10 organizations
        
        for(int i =0; i < 10; i++){
            when(orgMock.getName()).thenReturn("O" + i);
            test.setOrganisation(orgMock);
            //assertEquals("O"+i, test.getOrganisation().getName());
        }
        
        for(int i =0; i < 10; i++){
            //assertEquals("O"+i, test.getOrganization());
            //
        }
    }
    
    @Test
    public void testSetSingleResearchGroupAssociation(){
            
        
        //Test adding 1 research group

            when(researchGroupMock.getStartDate()).thenReturn(Date.valueOf("2016-01-01"));
            when(researchGroupMock.getEndDate()).thenReturn(Date.valueOf("2016-02-01"));
            when(researchGroupMock.getGroup()).thenReturn(groupMock);
            when(researchGroupMock.getRole()).thenReturn("STUDENT");
            test.setResearchGroupAssociation(researchGroupMock);
        
 
            assertEquals(Date.valueOf("2016-01-01"), test.getResearchGroupAssociation().get(0).getStartDate());
            assertEquals(Date.valueOf("2016-02-02"), test.getResearchGroupAssociation().get(0).getEndDate());
            assertEquals(groupMock, test.getResearchGroupAssociation().get(0).getGroup());
            assertEquals("Student", test.getResearchGroupAssociation().get(0).getRole());
    }
    
    @Test
    public void testSetResearchGroupAssociation(){
            
        
        //Test adding 10 research groups
        System.out.println(Date.valueOf("2016-01-"+(9+1)));
        for(int i =0; i <= 10; i++){
            System.out.println(Date.valueOf("2016-01-"+(i+1)));
            when(researchGroupMock.getStartDate()).thenReturn(Date.valueOf("2016-01-"+(i+1)));
            when(researchGroupMock.getEndDate()).thenReturn(Date.valueOf("2016-02-"+(i+1)));
            when(researchGroupMock.getGroup()).thenReturn(groupMock);
            when(researchGroupMock.getRole()).thenReturn("STUDENT");
            test.setResearchGroupAssociation(researchGroupMock);
            //assertEquals("O"+i, test.getOrganisation().getName());
        }
        
        for(int i =0; i < 10; i++){
            assertEquals(Date.valueOf("2016-01-0"+(i+1)), test.getResearchGroupAssociation().get(i).getStartDate());
            assertEquals(Date.valueOf("2016-02-0"+(i+1)), test.getResearchGroupAssociation().get(i).getEndDate());
            assertEquals(groupMock, test.getResearchGroupAssociation().get(i).getGroup());
            assertEquals("Student", test.getResearchGroupAssociation().get(i).getRole());
            //
        }
    }
    
    @Test
    public void testSetSingleResearchCategory(){
            
        
        //Test adding 1 research category
            when(researchCatMock.getDate()).thenReturn(Date.valueOf("2016-01-01"));
            when(researchCatMock.getID()).thenReturn("ID"+0);
            when(researchCatMock.getName()).thenReturn("MockResearchCategory");
            test.setResearchCategory(researchCatMock);

        

            assertEquals("ID"+0, test.getResearchCategory().get(0).getID());
            assertEquals(Date.valueOf("2016-01-01"), test.getResearchCategory().get(0).getDate());
            assertEquals("MockResearchCategory", test.getResearchCategory().get(0).getName());

    }
     @Test
    public void testSetResearchCategory(){
            
        
        //Test adding 10 research groups
        System.out.println(Date.valueOf("2016-01-"+(9+1)));
        for(int i =0; i <= 10; i++){
            System.out.println(Date.valueOf("2016-01-"+(i+1)));
            when(researchCatMock.getDate()).thenReturn(Date.valueOf("2016-01-"+(i+1)));
            when(researchCatMock.getID()).thenReturn("ID"+i);
            when(researchCatMock.getName()).thenReturn("MockResearchCategory");
            test.setResearchCategory(researchCatMock);
            //assertEquals("O"+i, test.getOrganisation().getName());
        }
        
        for(int i =0; i < 10; i++){
            assertEquals("ID"+i, test.getResearchCategory().get(i).getID());
            assertEquals(Date.valueOf("2016-01-0"+(i+1)), test.getResearchCategory().get(i).getDate());
            assertEquals("MockResearchCategory", test.getResearchCategory().get(i).getName());
            //
        }
    }
}
