package src.functions;

import Classes.Criterion;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by AlxEx on 16.12.2015.
 */
public class Property {
    private SimpleStringProperty criterion;

    public Property(Criterion criterion) {
        this.criterion = new SimpleStringProperty(criterion.getCriterion());
    }
}
