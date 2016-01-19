package src.functions;

import Classes.Architecture;
import Classes.Criterion;

/**
 * Created by AlxEx on 19.01.2016.
 */
public class ArchitectureCriterionMark {
    private Architecture architecture;
    private Criterion criterion;
    private int mark;

    public ArchitectureCriterionMark(Architecture architecture, Criterion criterion, int mark) {
        this.architecture = architecture;
        this.criterion = criterion;
        this.mark = mark;
    }

    public Architecture getArchitecture() {
        return architecture;
    }

    public Criterion getCriterion() {
        return criterion;
    }

    public int getMark() {
        return mark;
    }

    public boolean isIt(Architecture architecture, Criterion criterion) {
        return this.architecture.equals(architecture) && this.criterion.equals(criterion);
    }
}
