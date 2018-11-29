package se.kth.korlinge.currencyconverter.controllers;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueToAndFromValidator implements ConstraintValidator<UniqueToAndFrom, ConversionRequest> {

   @Override
   public void initialize(UniqueToAndFrom constraintAnnotation) {
   }

   @Override
   public boolean isValid(ConversionRequest value, ConstraintValidatorContext context) {

      String fromValue = (String) new BeanWrapperImpl(value)
            .getPropertyValue("fromCurrency");
      String toValue = (String) new BeanWrapperImpl(value)
            .getPropertyValue("toCurrency");

      if (fromValue.equals(toValue)) {
         return false;
      } else {
         return true;
      }
   }
}
