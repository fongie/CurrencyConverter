package se.kth.korlinge.currencyconverter.controllers;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

 class Conversion {
   private String fromCurrency;

   @NotNull(message = "Enter a value")
   @Positive(message = "Enter a sum larger than 0")
   private Integer fromValue;

   private String toCurrency;

   @NotNull(message = "Enter a value")
   @Positive(message = "Enter a sum larger than 0")
   private Integer toValue;

   public Conversion() {

   }

   public Conversion(String fromCurrency, Integer fromValue, String toCurrency, Integer toValue) {
      this.fromCurrency = fromCurrency;
      this.fromValue = fromValue;
      this.toCurrency = toCurrency;
      this.toValue = toValue;
   }

   public String getFromCurrency() {
      return fromCurrency;
   }

   public void setFromCurrency(String fromCurrency) {
      this.fromCurrency = fromCurrency;
   }

   public Integer getFromValue() {
      return fromValue;
   }

   public void setFromValue(Integer fromValue) {
      this.fromValue = fromValue;
   }

   public String getToCurrency() {
      return toCurrency;
   }

   public void setToCurrency(String toCurrency) {
      this.toCurrency = toCurrency;
   }

   public Integer getToValue() {
      return toValue;
   }

   public void setToValue(Integer toValue) {
      this.toValue = toValue;
   }
}
