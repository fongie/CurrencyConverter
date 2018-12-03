package se.kth.korlinge.currencyconverter.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import se.kth.korlinge.currencyconverter.data.Currency;
import se.kth.korlinge.currencyconverter.data.Rate;
import se.kth.korlinge.currencyconverter.data.RateDTO;

/**
 * Interface for database operations regarding Rates
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY) //these methods can only be called in an ongoing transaction, that means, by service classes annotated as transactional
public interface RateRepository extends CrudRepository<Rate, Integer> {

   RateDTO findRateByFromAndTo(Currency from, Currency to);
}
