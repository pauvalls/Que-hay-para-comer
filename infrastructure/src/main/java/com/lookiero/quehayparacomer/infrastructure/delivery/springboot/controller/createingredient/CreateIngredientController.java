package com.lookiero.quehayparacomer.infrastructure.delivery.springboot.controller.createingredient;

import com.lookiero.quehayparacomer.application.CreateANewIngredient.CreateIngredient;
import com.lookiero.quehayparacomer.application.CreateANewIngredient.CreateIngredientCommand;
import com.lookiero.quehayparacomer.domain.model.ingredient.Ingredient;
import com.lookiero.quehayparacomer.infrastructure.delivery.springboot.controller.createingredient.dto.CreateIngredientBodyRequestDTO;
import com.lookiero.quehayparacomer.infrastructure.delivery.springboot.controller.createingredient.dto.CreateIngredientBodyResponseDTO;
import com.lookiero.quehayparacomer.infrastructure.delivery.springboot.controller.createingredient.dto.NutricionalValuesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
public class CreateIngredientController {
    private CreateIngredient createIngredient;

    public CreateIngredientController(final CreateIngredient createIngredient) {
        this.createIngredient = createIngredient;
    }

    @RequestMapping(value = "/ingredient/save", method = RequestMethod.POST)
    public ResponseEntity CreateIngredient(@RequestBody CreateIngredientBodyRequestDTO createIngredientBodyRequestDTO) {
        final Ingredient response = createIngredient.execute(
                CreateIngredientCommand
                        .builder()
                        .uuid(UUID.randomUUID().toString())
                        .name(createIngredientBodyRequestDTO.name)
                        .kcal(createIngredientBodyRequestDTO.nutricionalValuesDTO.kcal)
                        .grasas(createIngredientBodyRequestDTO.nutricionalValuesDTO.grasas)
                        .azucar(createIngredientBodyRequestDTO.nutricionalValuesDTO.azucar)
                        .build()
        );
        return ResponseEntity.ok(
                CreateIngredientBodyResponseDTO
                .builder()
                .id(response.getIngredientid().toString())
                .name(response.getIngredientName().name)
                .nutricionalValuesDTO(
                        new NutricionalValuesDTO(response.getIngredientNuticialValues().kcal,
                                response.getIngredientNuticialValues().azucar,
                                response.getIngredientNuticialValues().grasas
                        )
                ));


    }
}
