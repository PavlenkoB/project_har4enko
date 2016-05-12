package ua.edu.nau.godex.projectharchenko.classes;

/**
 * Created by AlxEx on 14.12.2015.
 */
public enum Criterion {
    CAPACITY("CAPACITY"), ШВИДКОДІЯ("ШВИДКОДІЯ"), SECURITY("Захищеність");

    String criterion;

    Criterion(String criterion) {
        this.criterion = criterion;
    }

    public static Criterion fromString(String parameterName) {
        if (parameterName != null) {
            for (Criterion criterion : Criterion.values()) {
                if (parameterName.equalsIgnoreCase(criterion.criterion)) {
                    return criterion;
                }
            }
        }
        return null;
    }

    public static int size() {
        return values().length;
    }

    public String getCriterion() {
        return criterion;
    }

    public void setCriterion(String criterion) {
        this.criterion = this.name();
    }
}
