package bravopeople;

;
import java.util.Date;

/**
 * @author Bravo Team
 * @version 1.0 This file defines the Research Category Class for the Researcher
 * Support System (RSS). The class defines the attributes of the user of the
 * system.
 */


public class ResearchCategory implements ResearchCategoryInterface
{

    String ID;
    String name;
    Date effectiveDate;

    public ResearchCategory()
    {
        ID = "dummy12345";
        name = "dummy";
        effectiveDate = new Date();
    }

    public ResearchCategory(String _ID, String _name, Date _date)
    {
        ID = _ID;
        name = _name;
        effectiveDate = _date;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String _name)
    {
        name = _name;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String _ID)
    {
        ID = _ID;
    }

    public Date getDate()
    {
        return effectiveDate;
    }

    public void setDate(Date _date)
    {
        effectiveDate = _date;
    }


    public double getResearchOuputTarget(int id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setResearchOuputTarget(int id, double outputTarget)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDateForResearchOutput(int id, Date date)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Date getDateForResearchOutput(int id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void addNewResearchOutputTarget(double outputTarget, Date date)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removeResearchOutputTarget(int id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}