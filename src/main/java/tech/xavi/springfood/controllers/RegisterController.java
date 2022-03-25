package tech.xavi.springfood.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.xavi.springfood.dao.CustomerDao;
import tech.xavi.springfood.models.Customer;

@RestController
@RequestMapping("api/account")
public class RegisterController {

    @Autowired
    CustomerDao customerDao;

    @PostMapping()
    public void createCustomer(@RequestBody Customer customer){
        customerDao.register(customer);
    }
}
