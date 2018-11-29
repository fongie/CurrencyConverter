package se.kth.korlinge.currencyconverter.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rate")
public class Rate {
   @Id
   @GeneratedValue( strategy = GenerationType.IDENTITY )
   @Column(name = "id")
   private int id;

   @NotNull
   @ManyToOne
   private Currency from;

   @NotNull
   @ManyToOne
   private Currency to;

   @Column(name = "value")
   private double value;

   public Rate() {

   }

   public Rate(Currency from, Currency to, double value) {

   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Currency getFrom() {
      return from;
   }

   public void setFrom(Currency from) {
      this.from = from;
   }

   public Currency getTo() {
      return to;
   }

   public void setTo(Currency to) {
      this.to = to;
   }

   public double getValue() {
      return value;
   }

   public void setValue(double value) {
      this.value = value;
   }
}
