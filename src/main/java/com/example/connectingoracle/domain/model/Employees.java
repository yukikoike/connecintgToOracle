package com.example.connectingoracle.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employees {

    @Id
    private String id;

    private String name;

    private String email;
}
