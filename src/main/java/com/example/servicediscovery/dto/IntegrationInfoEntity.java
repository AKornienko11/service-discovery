package com.example.servicediscovery.dto;

import jakarta.persistence.*;

@Entity

@Table(name = "links_properties")
public class IntegrationInfoEntity {

    public IntegrationInfoEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;


    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
