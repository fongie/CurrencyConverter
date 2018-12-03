package se.kth.korlinge.currencyconverter.presentation.conversion;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Represents a request made to make a currency conversion.
 */
@UniqueToAndFrom
public class ConversionRequest {
    private String fromCurrency;

    @NotNull(message = "Enter a value")
    @Positive(message = "Enter a value larger than 0")
    private Integer value;

    private String toCurrency;

    public ConversionRequest() {

    }

    public ConversionRequest(String fromCurrency, Integer value, String toCurrency) {
       this.fromCurrency = fromCurrency;
       this.value = value;
       this.toCurrency = toCurrency;
    }

    public String getFromCurrency() {
       return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
       this.fromCurrency = fromCurrency;
    }

    public Integer getValue() {
       return value;
    }

    public void setValue(Integer value) {
       this.value = value;
    }

    public String getToCurrency() {
       return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
       this.toCurrency = toCurrency;
    }
 }

