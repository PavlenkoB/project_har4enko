package ua.edu.nau.godex.projectharchenko.criterios_viewer.src.functions;

import Classes.Criterion;

/**
 * Created by AlxEx on 19.01.2016.
 */
public class CriterionMark {
    private Criterion criterion1;
    private Criterion criterion2;
    private int mark;

    public CriterionMark(Criterion criterion1, Criterion criterion2, int mark) {
        this.criterion1 = criterion1;
        this.criterion2 = criterion2;
        this.mark = mark;
    }

    public Criterion getCriterion1() {
        return criterion1;
    }

    public Criterion getCriterion2() {
        return criterion2;
    }

    public int getMark() {
        return mark;
    }
}
