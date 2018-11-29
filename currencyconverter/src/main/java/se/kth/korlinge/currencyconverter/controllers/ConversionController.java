package se.kth.korlinge.currencyconverter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.kth.korlinge.currencyconverter.data.Currency;
import se.kth.korlinge.currencyconverter.services.ConvertService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ConversionController {
   @Autowired
   private ConvertService convertService;

   @GetMapping("/")
   public String getStartPage(Model model, Conversion conversion) {
      /*
      List<Currency> currencyList = new ArrayList<>(); //should be CurrencyDTO
      currencyList.add(new Currency("EUR", "Euro"));
      currencyList.add(new Currency("USD", "Amerikanska dollar"));
      */
      model.addAttribute("currencies", convertService.getCurrencies());
      return "/home";
   }
}
