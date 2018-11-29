package se.kth.korlinge.currencyconverter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import se.kth.korlinge.currencyconverter.services.AdminService;

@Controller
public class AdminController {
   @Autowired
   private AdminService adminService;

   @GetMapping("/admin")
   public String getAdminPage() {
      return "HEJADMIN";
   }
}
