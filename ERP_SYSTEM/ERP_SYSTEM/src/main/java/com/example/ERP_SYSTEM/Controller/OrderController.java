package com.example.ERP_SYSTEM.Controller;

import com.example.ERP_SYSTEM.Repo.OrderRepo;
import com.example.ERP_SYSTEM.entities.Auftragsverwaltung.Order;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepo repoOrder;

    @GetMapping("/{id}")
    public String getOrder(Model model, @PathVariable Integer id) {
        Order order = repoOrder.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order with ID " + id + " not found"));
        model.addAttribute("order", order);
        return "order";
    }


    @GetMapping("/all")
    public String getAllOrders(Model model) {
        List<Order> orders = repoOrder.findAll();
        model.addAttribute("orders", orders);
        return "order-show";
    }

    @GetMapping("/new")
    public String getNewOrder(Model model) {
        model.addAttribute("order", new Order());
        return "order-details";
    }

    @PostMapping("/save")
    public String saveOrder(@ModelAttribute Order order) {
        repoOrder.save(order);
        return "redirect:/order/all";
    }

}
