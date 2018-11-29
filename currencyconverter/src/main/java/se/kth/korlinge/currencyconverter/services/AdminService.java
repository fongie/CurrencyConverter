package se.kth.korlinge.currencyconverter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import se.kth.korlinge.currencyconverter.repositories.AccessRepository;
import se.kth.korlinge.currencyconverter.repositories.CurrencyRepository;
import se.kth.korlinge.currencyconverter.repositories.RateRepository;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class AdminService {
   @Autowired
   private AccessRepository accessRepository;

   @Autowired
   private RateRepository rateRepository;

   @Autowired
   private CurrencyRepository currencyRepository;

   public String hej() {
      return "Hej";
   }
}
