package se.kth.korlinge.currencyconverter.data;

/**
 * Read-only view of a Currency row in the database
 */
public interface CurrencyDTO {
   String getAbbreviation();
   String getName();
}
