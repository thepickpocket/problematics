package bravopeople;

import java.util.*;

/**
 * <h1>Group</h1>
 * The group class to which either a person or subgroups can belong to (Composite pattern).
 * @author Bravo Team
 * @version 1.0
 */
class Group extends PersonEntity implements GroupInterface {
	private String name;
	private Boolean active;
	private ArrayList<PersonEntity> entities;		// Composite Pattern

	/**
	 * Default constructor - Dummy object creation
	 */
	public Group() {
		this.name = "MockGroup";
		this.entities = new ArrayList<PersonEntity>();
	}

	/**
	 * Creates a group object which may consist of sub groups or people.
	 * @param name Name of the group 
	 * @param entities Subgroups or people contain in the Group class
	 */
	public Group(String name, ArrayList<PersonEntity> entities) {
		this.name = name;
		this.entities = entities;
	}

	/**
	 * Getter
	 * @return Group's name
	 */
	public String getName() { return name; }

	/**
	 * Getter
	 * @return Dynamically re-sizable ArrayList used to store subgroups or person objects 
	 */
	public ArrayList<PersonEntity> getEntities() { return entities; }

	/**
	 * Setter
	 * @param name Group's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void addEntity(PersonEntity entity)
	{
		this.entities.add(entity);
	}

	/**
	 * Setter
	 * @param entities Dynamically re-sizable ArrayList used to store subgroups or person objects 
	 */
	public void setEntities(ArrayList<PersonEntity> entities) {
		this.entities = entities;
	}

    /**
     * Checks if the group is active or inactive
     * @return true if active (default), false if inactive.
     */
    public boolean isActive()
    {
        return true;
    }

    /**
     * Sets the group to active (true)
     */
    public void activate()
    {
	this.active = true;
    }

    /**
     * Sets the group to inactive (false)
     */
    public void deactivate()
    {
	this.active = false;
    }
}
