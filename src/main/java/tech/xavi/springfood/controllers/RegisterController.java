package tech.xavi.springfood.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.xavi.springfood.models.Customer;

@RestController
@RequestMapping("api/account")
public class RegisterController {

    @PostMapping()
    public void createCustomer(@RequestBody Customer customer){

    }
}
