package se.kth.korlinge.currencyconverter.presentation.admin;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * Represents a request to change a currency exchange rate
 */
public class RateChangeRequest {

   private int rateId;

   @NotNull(message = "Enter a value")
   @Positive(message = "Enter a value larger than 0")
   private double value;

   public RateChangeRequest() {

   }

   public RateChangeRequest(int rateId, double value) {
      this.rateId = rateId;
      this.value = value;
   }

   public int getRateId() {
      return rateId;
   }

   public void setRateId(int rateId) {
      this.rateId = rateId;
   }

   public double getValue() {
      return value;
   }

   public void setValue(double value) {
      this.value = value;
   }
}
