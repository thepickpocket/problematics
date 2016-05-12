package bravopeople;

import java.sql.Date;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
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
        test = new Person("name", "surname", "id", "email@gamil.com");
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
    public void test_Person_Creation()
    {
        assertFalse("Initialization of person's name was not successful.", !test.getName().equals("name"));
        assertFalse("Initialization of person's surname was not successful.", !test.getSurname().equals("surname"));
        assertFalse("Initialization of person's id was not successful.", !test.getID().equals("id"));
        assertFalse("Initialization of person's email was  not successful.", !test.getEmail().equals("email@gamil.com"));
    }
    
    @Test
    public void test_Set_User_RightsDefault(){
        //Default
        try{
        test.setUserRights("Random1234514");
        }
        catch(Exception e){
            fail(e.getMessage());
        }
        assertFalse("Default User right test 1 failed", !test.getUserRights().equals("RESEARCHER"));
        //assertEquals("RESEARCHER", test.getUserRights());
        
        try{
        test.setUserRights("");
        }
        catch(Exception e){
            fail(e.getMessage());
        }
        assertFalse("Default User right test 2 failed", !test.getUserRights().equals("RESEARCHER"));
        //assertEquals("RESEARCHER", test.getUserRights());
        
        
    }
    
    @Test
    public void test_Set_User_Rights_Null(){

        //Checking if Set to null
        try{
        test.setUserRights(null);
        }
        catch(Exception e){
            fail(e.getMessage());
        }
      assertFalse("Setting user rights to null failed", !test.getUserRights().equals("RESEARCHER"));
    }
    
    @Test
    public void test_Set_User_Rights_CorrectValue(){
        //Test Setting the value
        try{
        test.setUserRights("ADMIN");
        }
        catch(Exception e){
            fail(e.getMessage());
        }
        assertFalse("CorrectValue User right test 1 failed", !test.getUserRights().equals("ADMIN"));
        
        
        try{
        test.setUserRights("RESEARCHGROUPLEADER");
        assertFalse("CorrectValue User right test 2 failed", !test.getUserRights().equals("RESEARCHGROUPLEADER"));
        }
        catch(Exception e){
            fail(e.getMessage());
        }
        
        try{
        test.setUserRights("RESEARCHER");
        assertFalse("CorrectValue User right test 3 failed", !test.getUserRights().equals("RESEARCHER"));
        }
        catch(Exception e){
            fail(e.getMessage());
        }
    }
    
    @Test
    public void test_SetOrganisation_WithStringParameter(){
        try{
            test.setOrganisation("Test");
        }
        catch(Exception e){ 
            fail(e.getMessage());
        }
        assertFalse("CorrectValue User organization was not set", !test.getOrganisation().getName().equals("Test"));
    }
    
     @Test
    public void test_SetOrganisation_WithOrganizationAsParameter(){
        //Organisation orgMock = mock(Organisation.class);
        when(orgMock.getName()).thenReturn("Org1");
        try{
        test.setOrganisation(orgMock);
        }
        catch(Exception e){ 
            fail(e.getMessage());
        }
        assertFalse("Organization set incorrectly", !test.getOrganisation().equals(orgMock));
        assertFalse("Organization name set incorrectly", !test.getOrganisation().getName().equals("Org1")); 
        
    }
    
    //@Ignore 
    @Test
    public void test_SetMultiple_Organisations(){
          //Test adding 100 organizations
        
        for(int i =0; i < 100; i++){
            when(orgMock.getName()).thenReturn("O" + i);
            try{
                test.setOrganisation(orgMock);
             }
            catch(Exception e){ 
                fail(e.getMessage());
        }
        }
        
        for(int i =0; i < 100; i++){
            //No way of getting all organizatins
            fail("No way of getting all organizations");
        }
    }
    
    @Test
    public void test_SetSingle_ResearchGroupAssociation(){
            
        
        //Test adding 1 research group
            when(researchGroupMock.getStartDate()).thenReturn(Date.valueOf("2016-01-01"));
            when(researchGroupMock.getEndDate()).thenReturn(Date.valueOf("2016-02-01"));
            when(researchGroupMock.getGroup()).thenReturn(groupMock);
            when(researchGroupMock.getRole()).thenReturn("STUDENT");  
            try{               
            test.setResearchGroupAssociation(researchGroupMock);
            }
            catch(Exception e ){
               fail(e.toString());
            }
 

            assertFalse("Start date error",!test.getResearchGroupAssociation().get(0).getStartDate().equals(Date.valueOf("2016-01-01")));
            assertFalse("End date error",!test.getResearchGroupAssociation().get(0).getEndDate().equals(this));
            assertFalse("Setting group error", !test.getResearchGroupAssociation().get(0).getGroup().equals(groupMock));
            assertFalse("Setting reasearch group error", !test.getResearchGroupAssociation().get(0).getRole().equals("Student"));
    }
    
    @Test
    public void test_SetMultiple_Research_GroupAssociation(){
            
        
        //Test adding 100 research groups
            
        try{
        for(int i =0; i <= 100; i++){
            when(researchGroupMock.getStartDate()).thenReturn(Date.valueOf("2016-01-"+(i+1)));
            when(researchGroupMock.getEndDate()).thenReturn(Date.valueOf("2016-02-"+(i+1)));
            when(researchGroupMock.getGroup()).thenReturn(groupMock);
            when(researchGroupMock.getRole()).thenReturn("Srudent");
            test.setResearchGroupAssociation(researchGroupMock);
        }
        }
        catch(Exception e){
            fail(e.toString());
        }
        
        for(int i =0; i < 100; i++){
            assertFalse("Start date error", !test.getResearchGroupAssociation().get(i).getStartDate().equals(Date.valueOf("2016-01-0"+(i+1))));
            assertFalse("End date error",  !test.getResearchGroupAssociation().get(i).getEndDate().equals(Date.valueOf("2016-02-0"+(i+1))));
            assertFalse("Setting group error", !test.getResearchGroupAssociation().get(i).getGroup().equals(groupMock));
            assertFalse("Setting reasearch group error", !test.getResearchGroupAssociation().get(i).getRole().equals("Student"));
            
        }
    }
    
    @Test
    public void test_SetSingle_ResearchCategory(){
            
        
        //Test adding 1 research category
            when(researchCatMock.getDate()).thenReturn(Date.valueOf("2016-01-01"));
            when(researchCatMock.getID()).thenReturn("ID"+0);
            when(researchCatMock.getName()).thenReturn("MockResearchCategory");
        try{
           
            test.setResearchCategory(researchCatMock);

        }
        catch(Exception e){
           fail(e.toString());
        }

            assertFalse("Setting ID error", !test.getResearchCategory().get(0).getID().equals("ID"+0));
            assertFalse("Setting date error", !test.getResearchCategory().get(0).getDate().equals(Date.valueOf("2016-01-01")));
            assertFalse("Setting research category error", !test.getResearchCategory().get(0).getName().equals("MockResearchCategory"));

    }
     @Test
    public void test_SetMultiple_ResearchCategory(){
            
            
        //Test adding 100 research groups
        try{
        for(int i =0; i <= 100; i++){
            when(researchCatMock.getDate()).thenReturn(Date.valueOf("2016-01-"+(i+1)));
            when(researchCatMock.getID()).thenReturn("ID"+i);
            when(researchCatMock.getName()).thenReturn("MockResearchCategory");
            test.setResearchCategory(researchCatMock);
        }
        }
        catch(Exception e){
             fail(e.toString());
        }
        for(int i =0; i < 100; i++){
      
            assertFalse("Setting ID error", !test.getResearchCategory().get(0).getID().equals("ID"+0));
            assertFalse("Setting date error", !test.getResearchCategory().get(0).getDate().equals(Date.valueOf("2016-01-0"+(i+1))));
            assertFalse("Setting research category error", !test.getResearchCategory().get(0).getName().equals("MockResearchCategory"));
        }
    }
}
