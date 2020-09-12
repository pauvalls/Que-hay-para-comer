package com.lookiero.quehayparacomer.infrastructure.delivery.springboot.controller.createingredient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NutricionalValuesDTO {
    public double kcal;
    public double grasas;
    public double azucar;
}
