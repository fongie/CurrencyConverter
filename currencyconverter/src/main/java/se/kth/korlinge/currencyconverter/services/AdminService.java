package se.kth.korlinge.currencyconverter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import se.kth.korlinge.currencyconverter.controllers.RateChangeRequest;
import se.kth.korlinge.currencyconverter.data.Rate;
import se.kth.korlinge.currencyconverter.data.RateDTO;
import se.kth.korlinge.currencyconverter.repositories.AccessRepository;
import se.kth.korlinge.currencyconverter.repositories.CurrencyRepository;
import se.kth.korlinge.currencyconverter.repositories.RateRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles logic needed by the admin page.
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class AdminService {
   @Autowired
   private AccessRepository accessRepository;

   @Autowired
   private RateRepository rateRepository;

   /**
    * Get the total number of conversions made by all users in the history of the application.
    * @return
    */
   public int getConversionCount() {
      return accessRepository.getTotalConversions();
   }

   /**
    * Get all available exchange rates.
    * @return
    */
   public List<RateDTO> getRates() {
      List<RateDTO> rates = new ArrayList<>();
      rateRepository.findAll().forEach(rates::add);
      return rates;
   }

   /**
    * Change the value of an exchange rate.
    * @param rateChangeRequest
    */
   public void changeRate(RateChangeRequest rateChangeRequest) {
      Rate rate = rateRepository.findById(rateChangeRequest.getRateId()).get();
      rate.setValue(rateChangeRequest.getValue());
      rateRepository.save(rate);
   }
}
