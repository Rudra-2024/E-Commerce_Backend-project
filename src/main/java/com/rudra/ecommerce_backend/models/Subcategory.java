package com.rudra.ecommerce_backend.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Subcategory extends BaseModel{
    private String surname;
}
