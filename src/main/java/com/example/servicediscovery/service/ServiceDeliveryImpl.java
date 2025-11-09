package com.example.servicediscovery.service;

import com.example.servicediscovery.dto.UserDTO;
import com.example.servicediscovery.emailrequest.EmailRequest;
import com.example.servicediscovery.service.InitialUrl.InitialisationUrl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceDeliveryImpl implements ServiceDelivery {

    private InitialisationUrl initialisationUrl;
    private RestTemplate restTemplate = new RestTemplate();

    public ServiceDeliveryImpl(InitialisationUrl initialisationUrl) {
        this.initialisationUrl = initialisationUrl;
    }

    @Override
    public String create(UserDTO userDTO) {
        String url = initialisationUrl.prepareUrlForIntegration("post");
        HttpEntity<?> requestEntity = new HttpEntity<>(userDTO);
        return restTemplate.exchange(
                        url,
                        HttpMethod.POST,
                        requestEntity,
                        String.class)
                .getBody();
    }

    @Override
    public String update(UserDTO userDTO) {
        String url = initialisationUrl.prepareUrlForIntegration("update");
        HttpEntity<?> requestEntity = new HttpEntity<>(userDTO);
        return restTemplate.exchange(
                        url,
                        HttpMethod.PUT,
                        requestEntity,
                        String.class)
                .getBody();
    }

    @Override
    public UserDTO getInfoById(Long id) {
        String url = initialisationUrl.prepareUrlForIntegration("get");
        HttpEntity<?> requestEntity = new HttpEntity<>(null);
        return this.restTemplate.exchange(
                        url + id,
                        HttpMethod.GET,
                        requestEntity,
                        UserDTO.class)
                .getBody();
    }


    @Override
    public String delete(Long id) {
        String url = initialisationUrl.prepareUrlForIntegration("delete");
        HttpEntity<?> requestEntity = new HttpEntity<>(null);
        return this.restTemplate.exchange(
                        url + id,
                        HttpMethod.DELETE,
                        requestEntity,
                        String.class)
                .getBody();
    }

    @Override
    public String send(EmailRequest request) {
        String url = initialisationUrl.prepareUrlForIntegration("send");
        HttpEntity<?> requestEntity = new HttpEntity<>(request);
        return restTemplate.exchange(
                        url,
                        HttpMethod.POST,
                        requestEntity,
                        String.class)
                .getBody();
    }

}
