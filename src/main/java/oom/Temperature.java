package oom;

import java.util.Objects;

class Temperature implements Comparable<Temperature> {
    private final double degrees;

    Temperature(double degrees) {
        this.degrees = degrees;
    }

    @Override
    public int compareTo(Temperature other) {
        // (1)
        return Double.compare(degrees, other.degrees);
    }

    @Override
    public boolean equals(Object o) {
        // (2)
        if (o == this) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Temperature temperature = (Temperature) o;
        return Double.compare(degrees, temperature.degrees) == 0 ? true : false;
    }

    @Override
    public int hashCode() {
        // (3)
        return Objects.hash(degrees);
    }
}
