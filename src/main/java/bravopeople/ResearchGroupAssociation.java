package bravopeople;

import java.util.Date;

/**
 * <h1>Association class with a research group</h1>
 * Object representing the relationship of a person class with a specific research 
 * project. 
 * @author Bravo Team
 * @version 1.0
 */
class ResearchGroupAssociation implements ResearchGroupAssociationInterface{
	private Date startDate;
	private Date endDate;		// [0..1]
	private ResearchGroupAssociationType role;
	private Group group;
	private Boolean active;
	private enum ResearchGroupAssociationType {		
		STUDENT, COLLABORATOR, MEMBER, GROUPLEADER
	}
	
	/**
	 * Dummy constructor used to generate a test sample for unit testing. 
	 * Will later be replaced.
	 */
	public ResearchGroupAssociation() {
		this.startDate = new Date();		// This will need to be converted before adding to database
		this.endDate = null;
		this.role = ResearchGroupAssociationType.MEMBER;
		this.group = new Group();
		this.active = true;
	}
	
	/**
	 * Constructor
	 * @param startDate Date when the person became part of the research group
	 * @param group 	Research group with which the person is associated
	 * @param role		Role of the person in the research group
	 */
	public ResearchGroupAssociation(Date startDate, Group group, String role) {
		this.startDate = startDate;
		this.endDate = null;
		this.group = group;

		String s = role.toUpperCase();
		if (s.equals("STUDENT")) {
			this.role = ResearchGroupAssociationType.STUDENT;

		} else if (s.equals("COLLABORATOR")) {
			this.role = ResearchGroupAssociationType.COLLABORATOR;

		} else if (s.equals("MEMBER")) {
			this.role = ResearchGroupAssociationType.MEMBER;

		} else if (s.equals("GROUPLEADER")) {
			this.role = ResearchGroupAssociationType.GROUPLEADER;

		} else {
			this.role = ResearchGroupAssociationType.STUDENT;
		}
	} // End of Constructor

	/**
	 * Getter
	 * @return	Date when the person joined the research group
	 */
	public Date getStartDate() { return startDate; }

	/**
	 * Getter
	 * @return Date when the person left the research group
	 */
	public Date getEndDate() { return endDate; }						// Can return null

	/**
	 * Getter
	 * @return Role of the person within the research group
	 */
	public String getRole() {
		if (this.role == ResearchGroupAssociationType.STUDENT)
			return "Student";
		else if (this.role == ResearchGroupAssociationType.COLLABORATOR)
			return "Collaborator";
		else if (this.role == ResearchGroupAssociationType.MEMBER)
			return "Member";
		else
			return "Groupleader";
	}

	/**
	 * Getter
	 * @return Group to which the person is associated
	 */
	public Group getGroup() { return group; }
	
	/**
	 * Setter
	 * @param startDate Date when the person joined the research group
	 */
	public void setStartDate(Date startDate) {
		if (startDate != null)
			this.startDate = startDate;
	}

	/**
	 * Setter
	 * @param endDate Date when the person left the research group
	 */
	public void setEndDate(Date endDate) {
		if (endDate != null)
			this.endDate = endDate;
	}

	/**
	 * Setter
	 * @param role Role of the person within the research group
	 */
	public void setRole(String role) {
		String s = role.toUpperCase();
		if (s.equals("STUDENT")) {
			this.role = ResearchGroupAssociationType.STUDENT;

		} else if (s.equals("COLLABORATOR")) {
			this.role = ResearchGroupAssociationType.COLLABORATOR;

		} else if (s.equals("MEMBER")) {
			this.role = ResearchGroupAssociationType.MEMBER;

		} else if (s.equals("GROUPLEADER")) {
			this.role = ResearchGroupAssociationType.GROUPLEADER;

		} else {
			this.role = ResearchGroupAssociationType.STUDENT;
		}
	}

	/**
	 * Setter
	 * @param group Group to which the person is associated
	 */
	public void setGroup(Group group) {
		if (group != null)
			this.group = group;
	}

	/**
	 * Checks if the association is active or inactive
	 * @return true if active (default), false if inactive.
	 */
	public boolean isActive()
    {
        return active;
    }

	/**
	 * Sets the association to active (true)
	 */
	public void activate()
    {
		this.active = true;
    }

	/**
	 * Sets the association to inactive (false)
	 */
	public void deactivete()
    {
		this.active = false;
    }
}	// End of ResearchGroupAssociation class