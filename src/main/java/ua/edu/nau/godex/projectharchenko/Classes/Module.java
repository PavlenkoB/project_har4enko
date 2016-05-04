package Classes;

import editor.classes.DerbyDBManager;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class Module implements Cloneable {
    private Integer id;
    private Integer layId;
    private String description;
    private String name;
    private ArrayList<Pattern> avilablePatterns = new ArrayList<Pattern>();//патерни доступні цьому модулю
    private Pattern selectedPattern;//Вибраний патерн
    private Integer idDone;

    public Module(Integer id, Integer layId, String name, String description) {
        this.id = id;
        this.layId = layId;
        this.description = description;
        this.name = name;
    }

    public Module(Integer id, Integer layId, String name, String description, Integer idDone) {
        this.id = id;
        this.layId = layId;
        this.description = description;
        this.name = name;
        this.idDone = idDone;
    }

    public Module() {
    }

    public ArrayList<Pattern> getAvilablePatterns() {
        return avilablePatterns;
    }

    public void setAvilablePatterns(ArrayList<Pattern> avilablePatterns) {
        this.avilablePatterns = avilablePatterns;
    }

    public Pattern getSelectedPattern() {
        return selectedPattern;
    }

    public void setSelectedPattern(Pattern selectedPattern) {
        this.selectedPattern = selectedPattern;
    }

    public Module clone() throws CloneNotSupportedException {
        Module m_return = (Module) super.clone();
        if (this.id != null)
            m_return.id = new Integer(this.id);
        else

            m_return.id = null;
        if (this.layId != null)
            m_return.layId = new Integer(this.layId);
        else
            m_return.layId = null;
        m_return.description = new String(this.description);
        m_return.name = new String(this.name);

        ArrayList<Pattern> avilable_p = new ArrayList<Pattern>(this.avilablePatterns.size());
        for (Pattern item : this.avilablePatterns) avilable_p.add(item.clone());
        m_return.avilablePatterns = avilable_p;
        if (selectedPattern != null)
            m_return.selectedPattern = this.selectedPattern.clone();//Вибраний патерн
        else
            m_return.selectedPattern = null;
        if (this.idDone != null)
            m_return.idDone = new Integer(this.idDone);
        else
            m_return.idDone = null;

        return m_return;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLayId() {
        return layId;
    }

    public void setLayId(Integer layId) {
        this.layId = layId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdDone() {
        return idDone;
    }

    public void setIdDone(Integer idDone) {
        this.idDone = idDone;
    }

    public static Module load_module_from_DB(Integer module_ID, DerbyDBManager derby_DB_connection) {
        Module module = new Module();
        try {
            ResultSet rs_arch = derby_DB_connection.executeQuery("SELECT * FROM MODULE WHERE ID=" + module_ID);
            rs_arch.next();
            module.setId(rs_arch.getInt("ID"));
            module.setLayId(rs_arch.getInt("LAY_ID"));
            module.setName(rs_arch.getString("NAME"));
            module.setDescription(rs_arch.getString("DESCRIPTION"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return module;
    }
}
