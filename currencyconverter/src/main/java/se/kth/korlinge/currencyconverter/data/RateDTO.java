package se.kth.korlinge.currencyconverter.data;

/**
 * Read-only view of a Rate row in the database
 */
public interface RateDTO {
   int getId();
   double getValue();
   CurrencyDTO getFrom();
   CurrencyDTO getTo();
}
