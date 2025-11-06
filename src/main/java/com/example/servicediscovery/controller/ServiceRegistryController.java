package com.example.servicediscovery.controller;

import com.example.servicediscovery.dto.UserDTO;
import com.example.servicediscovery.emailrequest.EmailRequest;
import com.example.servicediscovery.service.ServiceDelivery;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class ServiceRegistryController {

    private ServiceDelivery serviceDelivery;

    public ServiceRegistryController(ServiceDelivery serviceDelivery) {
        this.serviceDelivery = serviceDelivery;
    }


    @GetMapping("/get/{id}")
    public UserDTO getInfoById(@PathVariable Long id) {
        return serviceDelivery.getInfoById(id);
    }

    @PostMapping("/create")
    public String create(@RequestBody UserDTO userDTO) {
        return serviceDelivery.create(userDTO);
    }

    @PutMapping("/update")
    public String update(@RequestBody UserDTO userDTO) {
        return serviceDelivery.update(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return serviceDelivery.delete(id);
    }

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest request) {
        return serviceDelivery.send(request);
    }

}




