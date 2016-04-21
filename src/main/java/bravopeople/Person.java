/**
  * @author Bravo Team
  *	@version 1.0
  *	This file defines the Person Class for the Researcher Support System (RSS).
  *	The class defines the attributes of the user of the system.
  */

package bravopeople;
import java.util.LinkedList;

public class Person extends PersonEntity implements PersonInterface
{
	private String Name;
	private String Surname;
	private String ID;
	private String email_address;
    private UserRight rights;
	private enum UserRight {
	RESEARCHER, RESEARCHGROUPLEADER, ADMIN
	}
	
	private LinkedList<Organisation> organisations;  	///Person can belong to 0 or more organisations
	private LinkedList<ResearchGroupAssociation> research_groups; 	///Person can have multiple associations with research groups
	private LinkedList<ResearchCategory> research_category;  ///Person may be associated with a research Category
	
	/**
		Default contructor with dummy data
	*/
	
	Person()
	{
		Name ="Name";
		Surname = "Surname";
		ID= "00000000000";
		email_address = "email@domain.com";
        rights = UserRight.RESEARCHER;
		
		organisations = new LinkedList<Organisation>();
		research_groups = new LinkedList<ResearchGroupAssociation>();
		research_category = new LinkedList<ResearchCategory>();
	}
	
	/**
	* 	Constructor creates a person object
	* 	@param  name Name of the person
	*	@param surname Surmane of the person
	*	@param id Identity number of the person
	*	@param email Email Address of the person
    *   @param right The rights the person has. Can be:
    *                                              ADMIN
    *                                              RESEARCHER
    *                                              RESEARCHGROUPLEADER
	*/
	Person(String name,String surname,String id,String email, String right)
	{
		setName(name);
		setSurname(surname);
		setEmail(email);
		setID(id);
        setUserRights(right);
	}

    /**
     * 	Constructor creates a person object
     * 	@param  name Name of the person
     *	@param surname Surmane of the person
     *	@param id Identity number of the person
     *	@param email Email Address of the person
     */
    Person(String name,String surname,String id,String email)
    {
        setName(name);
        setSurname(surname);
        setEmail(email);
        setID(id);
        setUserRights("RESEARCHER");
    }
	
	/**
	* Setter 	
	* @param name Name of the person
	*/
	public void setName(String name)
	{
		Name = name;
	}
	
	/**
	* Setter 	
	* @param surname Surname of the person
	*/
	public void setSurname(String surname)
	{
		Surname = surname;
	}
	
	/**
	* Setter 	
	* @param id The name of the person
	*/
	public void setID(String id)
	{
		ID = id;
	}
	
	/**
	* Setter 	
	* @param email primary Email Address of the person
	*/
	public void setEmail(String email)
	{
		email_address = email;
	}
	
	/**
	* Setter 	
	* @param organisation Name of the organisation the person belongs to.
	*/
	public void setOrganisation(String organisation)
	{
		organisations.add(new Organisation(organisation));
	}
	
	/**
	* Setter 	
	* @param group Research group that the of the person is associated with
	*/
	public void setResearchGroupAssociation(ResearchGroupAssociation group)
	{
		research_groups.add(group);
	}
	
	/**
	* Setter 	
	* @param category Research category that the of the person is associated with
	*/
	public void setResearchCategory(ResearchCategory category)
	{
		research_category.add(category);
	}
	
	
	/**
	* Getter
	* @return name of the person
	*/
	public String getName()
	{
		return Name;
	}
	
	/**
	* Getter
	* @return Surname of the person
	*/
	public String getSurname()
	{
		return Surname;
	}
	
	/**
	* Getter
	* @return Identity number of the person
	*/
	public String getID()
	{
		return ID;
	}
	
	/**
	* Getter
	* @return The  primary of the person
	*/
	public String getEmail()
	{
		return email_address;
	}
	
	/**
	* Getter
	* @return the list of organisations this person belongs to or may return null if they do not belong to any organisations.
	*/
//	public LinkedList<Organisation> getOrganisation()
//	{
//		if(this.organisations.isEmpty())
//			return null;
//		return organisations;
//	}
	
	/**
	* Getter
	* @return the list of research categories this person is associated with or may return null if they if they are not associated with any.
	*/
	
	public LinkedList<ResearchCategory> getResearchCategory()
	{
		if(research_category.isEmpty())
			return null;
		else
			return research_category;
	}
	
	/**
	* Getter
	* @return the list of research groups this person is associated with or may return null if they if they are not associated with any.
	*/
	public LinkedList<ResearchGroupAssociation> getResearchGroupAssociation()
	{
		if(research_groups.isEmpty())
			return null;
		else
			return research_groups;
	}

    /**
     *  Setter
     *  Set the user rights.
     * @param right Can be:
     *              ADMIN
     *              RESEARCHER
     *              RESEARCHGROUPLEADER
     */
	public void setUserRights(String right)
    {
        if (right.toUpperCase().equals("ADMIN"))
            rights = UserRight.ADMIN;
        else if (right.toUpperCase().equals("RESEARCHER"))
            rights = UserRight.RESEARCHER;
        else if (right.toUpperCase().equals("RESEARCHGROUPLEADER"))
            rights = UserRight.RESEARCHGROUPLEADER;
    }

    /**
     * Getter
     * @return The user rights for the person. Returns:
     *                                          ADMIN
     *                                          RESEARCHER
     *                                          RESEARCHGROUPLEADER
     */
    public String getUserRights()
    {
		if(rights == UserRight.ADMIN)
			return "ADMIN";
		else if (rights == UserRight.RESEARCHER)
			return "RESEARCHER";
		else
			return "RESEARCHGROUPLEADER";
    }
}

  

