package controller;

import DAO.CustomerDAO;
import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("list")
public class CustomerController {
    CustomerDAO customerDAO = new CustomerDAO();
    @GetMapping("")
    public ModelAndView showListCus(){
        ModelAndView mav = new ModelAndView("list");
        List<Customer> list = customerDAO.findAll();
        mav.addObject("list",list);
        return mav;
    }

    @GetMapping("create")
    public ModelAndView showFormCreate(){
        ModelAndView mav = new ModelAndView("create","customer",new Customer());
        return mav;
    }
    @PostMapping("create")
    public ModelAndView save(Customer customer) {
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        customerDAO.save(customer);
        return modelAndView;
    }

    @GetMapping("edit")
    public ModelAndView showFormEdit(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("edit","customer",customerDAO.findById(id));
        return modelAndView;
    }

    @PostMapping("edit")
    public ModelAndView edit(@ModelAttribute Customer customer){
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        customerDAO.update(customer.getId(),customer);
        return modelAndView;
    }

    @GetMapping("delete")
    public ModelAndView delete(@RequestParam int id){
        ModelAndView modelAndView= new ModelAndView("redirect:/list");
        customerDAO.remote(id);
        return modelAndView;
    }
}
