package se.kth.korlinge.currencyconverter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import se.kth.korlinge.currencyconverter.controllers.ConversionResult;
import se.kth.korlinge.currencyconverter.data.CurrencyDTO;
import se.kth.korlinge.currencyconverter.data.RateDTO;
import se.kth.korlinge.currencyconverter.repositories.CurrencyRepository;
import se.kth.korlinge.currencyconverter.repositories.RateRepository;
import se.kth.korlinge.currencyconverter.controllers.ConversionRequest;

import java.util.ArrayList;
import java.util.List;


//requires new means a new transaction is started whenever a method in this class is called
//this means that this class sort of does transaction handling
//transactions autostart on method call and auto end on method end
//rollbackFor = Exception.class can be used to rollback (not commit) transactions for all exceptions, default is only runtimeexceptions
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class ConvertService {
   @Autowired
   private RateRepository rateRepository;

   @Autowired
   private CurrencyRepository currencyRepository;

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

      return result;
   }

   public List<CurrencyDTO> getCurrencies() {
      List<CurrencyDTO> currencies = new ArrayList<>();
      currencyRepository.findAll().forEach(f -> currencies.add(f));
      return currencies;
   }
}
