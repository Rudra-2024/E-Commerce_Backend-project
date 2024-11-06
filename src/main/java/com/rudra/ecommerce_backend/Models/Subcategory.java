package com.rudra.ecommerce_backend.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Subcategory extends BaseModel{
    private String surname;
}
