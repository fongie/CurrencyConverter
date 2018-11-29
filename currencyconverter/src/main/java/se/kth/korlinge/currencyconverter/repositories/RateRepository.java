package se.kth.korlinge.currencyconverter.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import se.kth.korlinge.currencyconverter.data.Currency;
import se.kth.korlinge.currencyconverter.data.Rate;

@Repository
@Transactional(propagation = Propagation.MANDATORY) //these methods can only be called in an ongoing transaction, that means, by service classes annotated this transactional
public interface RateRepository extends CrudRepository<Rate, Integer> {

   Rate findRateByFromAndTo(Currency from, Currency to);
}
