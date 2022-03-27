package hu.polnikadam.wysiokocsma.model;

import static java.lang.Double.POSITIVE_INFINITY;

enum LiverStrength {
    Babamáj(0.5),
    Tinimáj(2.5),
    Egyetemistamáj(3.0),
    Gyémántmáj(4.0),
    Fannimáj(POSITIVE_INFINITY);

    private final Double liverStrength;

    LiverStrength(Double liverStrength) {
        this.liverStrength = liverStrength;
    }

    public Double getLiverStrength() {
        return liverStrength;
    }
}
