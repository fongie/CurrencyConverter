package se.kth.korlinge.currencyconverter.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import se.kth.korlinge.currencyconverter.data.Access;

/**
 * Interface for database operations regarding Accesses
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY) //these methods can only be called in an ongoing transaction, that means, by service classes annotated this transactional
public interface AccessRepository extends CrudRepository<Access, Integer> {

   @Query(value = "SELECT COUNT(*) FROM `access`", nativeQuery = true)
   int getTotalConversions();
}
