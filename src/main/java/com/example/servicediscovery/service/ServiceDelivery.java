package com.example.servicediscovery.service;

import com.example.servicediscovery.dto.UserDTO;
import com.example.servicediscovery.emailrequest.EmailRequest;

public interface ServiceDelivery {

    public String create(UserDTO userDTO);

    public String update(UserDTO userDTO);

    public UserDTO getInfoById(Long id);

    public String delete(Long id);

    String send(EmailRequest request);

}
