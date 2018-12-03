package se.kth.korlinge.currencyconverter.data;

public interface RateDTO {
   int getId();
   double getValue();
   CurrencyDTO getFrom();
   CurrencyDTO getTo();
}
