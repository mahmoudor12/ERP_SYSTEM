package com.example.ERP_SYSTEM.Controller;

import com.example.ERP_SYSTEM.Repo.OrderItemRepo;
import com.example.ERP_SYSTEM.entities.Auftragsverwaltung.orderitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderItemController {

   @Autowired
    OrderItemRepo orderItemRepo ;

   @GetMapping("/OrderItems")
    public String getOrderItems(Model model){
        List<orderitem> orderitemList= orderItemRepo.findAll();
        model.addAttribute("orderItems",orderitemList);
        return "order-items";
   }
   @PostMapping("/postorderitem")
    public String setOrderItem(@ModelAttribute("orderitem") orderitem order, Model model
   ){
       if(order.check(order)){
           orderItemRepo.save(order);
       }else {

       }
       return "postorderitem";
   }
    @GetMapping("/orderitem/{id}")
    public String getOrderItem(@PathVariable Integer id, Model model){
        orderitem orderitem= orderItemRepo.findById(id).orElse(null);
        model.addAttribute("",orderitem);
        return "orderitem";
    }

}
