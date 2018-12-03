package se.kth.korlinge.currencyconverter.controllers;

/**
 * Represents the result of a currency conversion.
 */
public class ConversionResult {
   private String from;
   private String to;
   private Integer fromValue;
   private double toValue;
   private double rate;

   public ConversionResult(String from, String to, Integer fromValue, double toValue, double rate) {
      this.from = from;
      this.to = to;
      this.fromValue = fromValue;
      this.toValue = toValue;
      this.rate = rate;
   }

   public String getFrom() {
      return from;
   }

   public void setFrom(String from) {
      this.from = from;
   }

   public String getTo() {
      return to;
   }

   public void setTo(String to) {
      this.to = to;
   }

   public Integer getFromValue() {
      return fromValue;
   }

   public void setFromValue(Integer fromValue) {
      this.fromValue = fromValue;
   }

   public double getToValue() {
      return toValue;
   }

   public void setToValue(double toValue) {
      this.toValue = toValue;
   }

   public double getRate() {
      return rate;
   }

   public void setRate(double rate) {
      this.rate = rate;
   }
}
