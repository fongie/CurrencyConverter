package se.kth.korlinge.currencyconverter.presentation.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import se.kth.korlinge.currencyconverter.services.ConvertService;

import javax.validation.Valid;

/**
 * Entry point for HTTP requests concerning the conversion interface.
 */
@Controller
public class ConversionController {
   @Autowired
   private ConvertService convertService;

   /**
    * Get starting page
    * @return
    */
   @GetMapping("/")
   public String getStartPage() {
      return "redirect:convert";
   }

   /**
    * Get the conversion page
    * @param model
    * @param conversionRequest
    * @return
    */
   @GetMapping("/convert")
   public String getConverterPage(Model model, ConversionRequest conversionRequest) {
      model.addAttribute("currencies", convertService.getCurrencies());
      return "convert";
   }

   /**
    * Post a new request to make a currency conversion
    * @param conversionRequest
    * @param result
    * @param model
    * @return
    */
   @PostMapping("/convert")
   public String convert(@Valid ConversionRequest conversionRequest, BindingResult result, Model model) {
      if (result.hasErrors()) {
         return getConverterPage(model, conversionRequest);
      }
      ConversionResult conversionResult = convertService.convert(conversionRequest);
      model.addAttribute("conversionResult", conversionResult);

      return getConverterPage(model, conversionRequest);
   }

}
