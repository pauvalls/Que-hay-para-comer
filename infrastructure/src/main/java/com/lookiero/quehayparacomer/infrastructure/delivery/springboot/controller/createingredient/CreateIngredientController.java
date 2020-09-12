package com.lookiero.quehayparacomer.infrastructure.delivery.springboot.controller.createingredient;

import com.lookiero.quehayparacomer.application.CreateANewIngredient.CreateIngredient;
import com.lookiero.quehayparacomer.application.CreateANewIngredient.CreateIngredientCommand;
import com.lookiero.quehayparacomer.infrastructure.delivery.springboot.controller.createingredient.dto.CreateIngredientBodyRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
public class CreateIngredientController {
    private CreateIngredient createIngredient;

    public CreateIngredientController(final CreateIngredient createIngredient) {
        this.createIngredient = createIngredient;
    }

    @RequestMapping(value = "/ingredient/save", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)

    public void CreateIngredient(@RequestBody CreateIngredientBodyRequestDTO createIngredientBodyRequestDTO) {
        createIngredient.execute(
                CreateIngredientCommand
                        .builder()
                        .uuid(UUID.randomUUID().toString())
                        .name(createIngredientBodyRequestDTO.name)
                        .kcal(createIngredientBodyRequestDTO.nutricionalValuesDTO.kcal)
                        .grasas(createIngredientBodyRequestDTO.nutricionalValuesDTO.grasas)
                        .azucar(createIngredientBodyRequestDTO.nutricionalValuesDTO.azucar)
                        .build()
        );

    }
}
