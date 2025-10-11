package org.example;

public class VehicleOption {
    private String optionId = null;
    private String optionValue = null;
    private String optionUnit = null;

    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public void setOptionUnit(String optionUnit) {
        this.optionUnit = optionUnit;
    }

    public String getOptionId() {
        return optionId;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public String getOptionUnit() {
        return optionUnit;
    }

    public VehicleOption(String optionId, String optionValue, String optionUnit) {
        setOptionId(optionId);
        setOptionValue(optionValue);
        setOptionUnit(optionUnit);
    }
}
