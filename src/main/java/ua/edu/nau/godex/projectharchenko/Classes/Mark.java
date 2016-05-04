package Classes;


/**
 * Created by Alex on 02.07.2014.
 */
public class Mark {
    private Integer id;
    private Integer numArch0;
    private Integer numArch1;
    private Integer mark;

    public Mark(Integer id, Integer numArch0, Integer numArch1, Integer mark) {
        this.id = id;
        this.numArch0 = numArch0;
        this.numArch1 = numArch1;
        this.mark = mark;
    }

    public Mark(Integer numArch0, Integer numArch1, Integer mark) {
        this.numArch0 = numArch0;
        this.numArch1 = numArch1;
        this.mark = mark;
    }

    public Integer getNumArch0() {
        return numArch0;
    }

    public void setNumArch0(Integer numArch0) {
        this.numArch0 = numArch0;
    }

    public Integer getNumArch1() {
        return numArch1;
    }

    public void setNumArch1(Integer numArch1) {
        this.numArch1 = numArch1;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mark() {
        this.id = null;
        this.numArch0 = null;
        this.numArch1 = null;
        this.mark = null;
    }
}
