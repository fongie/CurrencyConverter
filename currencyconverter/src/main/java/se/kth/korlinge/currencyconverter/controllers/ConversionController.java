package se.kth.korlinge.currencyconverter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import se.kth.korlinge.currencyconverter.services.ConvertService;

@Controller
public class ConversionController {
   @Autowired
   private ConvertService convertService;

   @GetMapping("/")
   public String getStartPage() {
      return "HEJ";
   }
}
