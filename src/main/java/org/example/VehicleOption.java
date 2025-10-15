package org.example;

public class VehicleOption<V> {
    private String optionId = null;
    private V optionValue = null;
    private String optionUnit = null;

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public void setOptionValue(V optionValue) {
        this.optionValue = optionValue;
    }

    public void setOptionUnit(String optionUnit) {
        this.optionUnit = optionUnit;
    }

    public String getOptionId() {
        return optionId;
    }

    public V getOptionValue() {
        return optionValue;
    }

    public String getOptionUnit() {
        return optionUnit;
    }

    public VehicleOption(String optionId, V optionValue, String optionUnit) {
        setOptionId(optionId);
        setOptionValue(optionValue);
        setOptionUnit(optionUnit);
    }
}
