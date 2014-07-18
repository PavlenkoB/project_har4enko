package Classes;

import java.util.ArrayList;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class Module implements Cloneable{
    private Integer id;
    private Integer lay_id;
    private String description;
    private String name;
    private ArrayList<Pattern> avilable_patterns = new ArrayList<Pattern>();//патерни доступні цьому модулю
    private Pattern selected_pattern;//Вибраний патерн
    private Integer id_done;

    public ArrayList<Pattern> getAvilable_patterns() {
        return avilable_patterns;
    }

    public void setAvilable_patterns(ArrayList<Pattern> avilable_patterns) {
        this.avilable_patterns = avilable_patterns;
    }

    public Pattern getSelected_pattern() {
        return selected_pattern;
    }

    public void setSelected_pattern(Pattern selected_pattern) {
        this.selected_pattern = selected_pattern;
    }

    public Module clone() throws CloneNotSupportedException {
        Module m_return = (Module)super.clone();
        if (this.id != null)
            m_return.id = new Integer(this.id);
        else

            m_return.id = null;
        if (this.lay_id != null)
            m_return.lay_id = new Integer(this.lay_id);
        else
            m_return.lay_id = null;
        m_return.description=new String(this.description);
        m_return.name=new String(this.name);

        ArrayList<Pattern> avilable_p = new ArrayList<Pattern>(this.avilable_patterns.size());
        for(Pattern item: this.avilable_patterns) avilable_p.add(item.clone());
        m_return.avilable_patterns = avilable_p;
if(selected_pattern !=null)
    m_return.selected_pattern = this.selected_pattern.clone();//Вибраний патерн
else
m_return.selected_pattern =null;
        if (this.id_done != null)
            m_return.id_done = new Integer(this.id_done);
        else
            m_return.id_done = null;

        return m_return;
    }

    public Module(Integer id, Integer lay_id, String name, String description) {
        this.id = id;
        this.lay_id = lay_id;
        this.description = description;
        this.name = name;
    }

    public Module(Integer id, Integer lay_id, String name, String description, Integer id_done) {
        this.id = id;
        this.lay_id = lay_id;
        this.description = description;
        this.name = name;
        this.id_done = id_done;
    }
    public Module() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLay_id() {
        return lay_id;
    }

    public void setLay_id(Integer lay_id) {
        this.lay_id = lay_id;
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

    public Integer getId_done() {
        return id_done;
    }

    public void setId_done(Integer id_done) {
        this.id_done = id_done;
    }
}
