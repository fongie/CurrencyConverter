package se.kth.korlinge.currencyconverter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import se.kth.korlinge.currencyconverter.data.Currency;
import se.kth.korlinge.currencyconverter.repositories.CurrencyRepository;
import se.kth.korlinge.currencyconverter.repositories.RateRepository;


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

   public double convert(Currency from, Currency to, double value) {
      return 0;
   }
}
