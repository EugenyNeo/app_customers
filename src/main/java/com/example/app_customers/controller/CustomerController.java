package com.example.app_customers.controller;

import com.example.app_customers.model.Customer;
import com.example.app_customers.repository.CustomerRepository;
import com.example.app_customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/")
    public String greet(Map<String, Object> model){
        return "greet";
    }

    @GetMapping("/main")
    public String viewHomePage(Model model){
        model.addAttribute("listCustomers", customerService.getAllCustomers());
        return "index";
    }

    @GetMapping("/showNewCustomerForm")
    public String showNewCustomerForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value ="id") long id, Model model){
        Customer customer = customerService.getCustomerById(id);

        model.addAttribute("customer", customer);
        return "update";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteTicket(@PathVariable (value= "id") long id){
        this.customerService.deleteCustomerById(id);
        return "redirect:/";
    }

    @PostMapping("/main")
    private String filter(@RequestParam String filter,  Model model){
        Iterable<Customer> customers;
        if(filter != null && filter.isEmpty()){
            customers = customerRepository.findAllByGroupName(filter);
        }else{
            customers = customerRepository.findAll();
        }
        model.addAttribute("customer", customers);
        return "index";
    }


}
