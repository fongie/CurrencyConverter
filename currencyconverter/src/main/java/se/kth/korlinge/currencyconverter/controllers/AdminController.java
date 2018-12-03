package se.kth.korlinge.currencyconverter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import se.kth.korlinge.currencyconverter.services.AdminService;
import se.kth.korlinge.currencyconverter.services.ConvertService;

import javax.validation.Valid;

@Controller
public class AdminController {
   @Autowired
   private AdminService adminService;
   @Autowired
   ConvertService convertService;

   @GetMapping("/admin")
   public String getAdminPage(Model model, RateChangeRequest rateChangeRequest) {
      model.addAttribute("currencies",convertService.getCurrencies());
      model.addAttribute("conversionCount", adminService.getConversionCount());
      model.addAttribute("rates", adminService.getRates());
      return "/admin";
   }

   @PostMapping("/admin")
   public String changeRate(@Valid RateChangeRequest rateChangeRequest, BindingResult result, Model model) {
      if (result.hasErrors()) {
         result.getAllErrors().forEach(System.out::println);
         return getAdminPage(model, rateChangeRequest);
      }
      adminService.changeRate(rateChangeRequest);
      model.addAttribute("result", true);
      return getAdminPage(model, rateChangeRequest);
      //return "/admin";
   }
}
