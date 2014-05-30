package Classes;

import java.util.ArrayList;

/**
 * Created by Alex Shcherbak on 24.04.2014.
 */
public class Module implements Cloneable{
    public Integer id;
    public Integer lay_id;
    public String description;
    public String name;
    public ArrayList<Pattern> avilable_paterns= new ArrayList<Pattern>();//патерни доступні цьому модулю
    public Pattern selected_patern;//Вибраний патерн
    public Integer id_done;

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

        ArrayList<Pattern> avilable_p = new ArrayList<Pattern>(this.avilable_paterns.size());
        for(Pattern item: this.avilable_paterns) avilable_p.add(item.clone());
        m_return.avilable_paterns= avilable_p;
if(selected_patern!=null)
    m_return.selected_patern = this.selected_patern.clone();//Вибраний патерн
else
m_return.selected_patern=null;
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
