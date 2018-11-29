package se.kth.korlinge.currencyconverter.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency")
public class Currency {
   @Id
   @Column(name = "abbreviation", nullable = false)
   private String abbreviation;

   @Column(name = "name")
   private String name;

   public Currency() {

   }

   public Currency(String abbreviation, String name) {
      this.abbreviation = abbreviation;
      this.name = name;
   }

   public String getAbbreviation() {
      return abbreviation;
   }

   public void setAbbreviation(String abbreviation) {
      this.abbreviation = abbreviation;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
