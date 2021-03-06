package se.kth.korlinge.currencyconverter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import se.kth.korlinge.currencyconverter.presentation.conversion.ConversionResult;
import se.kth.korlinge.currencyconverter.data.Access;
import se.kth.korlinge.currencyconverter.data.CurrencyDTO;
import se.kth.korlinge.currencyconverter.data.RateDTO;
import se.kth.korlinge.currencyconverter.repositories.AccessRepository;
import se.kth.korlinge.currencyconverter.repositories.CurrencyRepository;
import se.kth.korlinge.currencyconverter.repositories.RateRepository;
import se.kth.korlinge.currencyconverter.presentation.conversion.ConversionRequest;

import java.util.ArrayList;
import java.util.List;


/**
 * Handles logic needed by the currency converter page.
 * Would be called "ConversionService" if that was not a pre-defined bean in Spring
 */
//requires new means a new transaction is started whenever a method in this class is called
//this means that this class does transaction handling
//transactions autostart on method call and auto end on method end
//rollbackFor = Exception.class can be used to rollback (not commit) transactions for all exceptions, default is only runtimeexceptions,
   //          but since we don't throw any exceptions on our own, we only need it for runtimeexceptions as default
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class ConvertService {
   @Autowired
   private RateRepository rateRepository;

   @Autowired
   private CurrencyRepository currencyRepository;

   @Autowired
   AccessRepository accessRepository;

   /**
    * Make a currency conversion
    * @param conversionRequest
    * @return A ConversionResult
    */
   public ConversionResult convert(ConversionRequest conversionRequest) {
      String from = conversionRequest.getFromCurrency();
      String to = conversionRequest.getToCurrency();
      RateDTO rate = rateRepository.findRateByFromAndTo(currencyRepository.findById(from).get(), currencyRepository.findById(to).get());

      int valueToConvert = conversionRequest.getValue();
      double conversionRate = rate.getValue();
      double convertedValue = valueToConvert * conversionRate;
      ConversionResult result = new ConversionResult(
            conversionRequest.getFromCurrency(),
            conversionRequest.getToCurrency(),
            valueToConvert,
            convertedValue,
            conversionRate
      );

      accessRepository.save(new Access(rate)); //log accesses for admin site
      return result;
   }

   /**
    * Return all available currencies
    * @return
    */
   public List<CurrencyDTO> getCurrencies() {
      List<CurrencyDTO> currencies = new ArrayList<>();
      currencyRepository.findAll().forEach(f -> currencies.add(f));
      return currencies;
   }
}
