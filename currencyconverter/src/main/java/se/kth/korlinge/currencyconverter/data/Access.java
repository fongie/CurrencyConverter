package se.kth.korlinge.currencyconverter.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Represents an Access row in the database.
 */
@Entity
@Table(name = "access")
public class Access {
   @Id
   @GeneratedValue( strategy = GenerationType.IDENTITY )
   @Column(name = "id")
   private int id;

   @NotNull
   @ManyToOne
   private Rate rate;

   public Access() {

   }

   public Access(RateDTO rate) {
      this.rate = (Rate) rate;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Rate getRate() {
      return rate;
   }

   public void setRate(Rate rate) {
      this.rate = rate;
   }
}
