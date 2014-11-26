package Classes;


/**
 * Created by Alex on 02.07.2014.
 */
public class Mark {
    private Integer id;
    private Integer num_arch_0;
    private Integer num_arch_1;
    private Integer mark;

    public Mark(Integer id, Integer num_arch_0, Integer num_arch_1, Integer mark) {
        this.id = id;
        this.num_arch_0 = num_arch_0;
        this.num_arch_1 = num_arch_1;
        this.mark = mark;
    }
    public Mark(Integer num_arch_0, Integer num_arch_1, Integer mark) {
        this.num_arch_0 = num_arch_0;
        this.num_arch_1 = num_arch_1;
        this.mark = mark;
    }

    public Integer getNum_arch_0() {
        return num_arch_0;
    }

    public void setNum_arch_0(Integer num_arch_0) {
        this.num_arch_0 = num_arch_0;
    }

    public Integer getNum_arch_1() {
        return num_arch_1;
    }

    public void setNum_arch_1(Integer num_arch_1) {
        this.num_arch_1 = num_arch_1;
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

    public Mark(){
        this.id = null;
        this.num_arch_0 = null;
        this.num_arch_1 = null;
        this.mark = null;
    }
}
