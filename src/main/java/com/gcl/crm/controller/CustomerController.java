package com.gcl.crm.controller;

import com.gcl.crm.form.ComboboxForm;
import com.gcl.crm.form.CustomerForm;
import com.gcl.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private static final String ADD_CUSTOMER_PAGE = "/addCustomerPage.html";
    private static final String CUSTOMER_FORM = "CustomerForm";
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String goHomePage(Model model) {
        return "/customer/home-customer-page-V2";
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public String addCustomerPage(Model model, @ModelAttribute("CustomerForm") CustomerForm customerForm) {
        ComboboxForm comboboxForm = customerService.initComboboxData();
        customerForm.setComboboxForm(comboboxForm);
        model.addAttribute(CUSTOMER_FORM, customerForm);
        return ADD_CUSTOMER_PAGE;
    }

    @RequestMapping(value = "/initCombobox", method = RequestMethod.GET)
    public ResponseEntity initCombobox() {
        ComboboxForm comboboxForm = customerService.initComboboxData();
        return new ResponseEntity<>(comboboxForm, HttpStatus.OK);
    }

    @PostMapping(value = "/registerCustomer")
    public String saveCustomer(Model model, @ModelAttribute(CUSTOMER_FORM) CustomerForm customerForm
            , BindingResult result, Errors errors) {
        if(result.hasErrors()){
            return "/customer/home-customer-page-V2";
        }
        model.addAttribute(CUSTOMER_FORM, customerForm);
        return ADD_CUSTOMER_PAGE;
    }
}
