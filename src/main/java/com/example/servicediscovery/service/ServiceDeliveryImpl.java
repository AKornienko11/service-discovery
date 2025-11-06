package com.example.servicediscovery.service;

import com.example.servicediscovery.dto.IntegrationInfoEntity;
import com.example.servicediscovery.dto.UserDTO;
import com.example.servicediscovery.emailrequest.EmailRequest;
import com.example.servicediscovery.repository.IntegrationRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceDeliveryImpl implements ServiceDelivery {

    private IntegrationRepository integrationRepository;
    private RestTemplate restTemplate = new RestTemplate();

    public ServiceDeliveryImpl(IntegrationRepository integrationRepository) {
        this.integrationRepository = integrationRepository;
    }

    @Override
    public String create(UserDTO userDTO) {
        String url = prepareUrlForIntegration(2L);
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
        String url = prepareUrlForIntegration(3L);
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
        String url = prepareUrlForIntegration(1L);
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
        String url = prepareUrlForIntegration(4L);
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
        String url = prepareUrlForIntegration(5L);
        HttpEntity<?> requestEntity = new HttpEntity<>(request);
        return restTemplate.exchange(
                        url,
                        HttpMethod.POST,
                        requestEntity,
                        String.class)
                .getBody();
    }

    private String prepareUrlForIntegration(Long integrationInfoId) {
        IntegrationInfoEntity info = integrationRepository.findById(integrationInfoId).get();
        return info.getUrl();
    }
}
