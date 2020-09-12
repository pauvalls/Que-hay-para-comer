package com.lookiero.quehayparacomer.infrastructure.delivery.springboot.config;

import com.lookiero.quehayparacomer.domain.model.ingredient.IngredientRepository;
import com.lookiero.quehayparacomer.infrastructure.delivery.persistence.cache.CacheRepositoryAdapter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
//@EnableJpaRepositories(basePackages = {"com.lookiero.quehayparacomer.infrastructure.persistance.jpa.ingredientc"})
//@EntityScan(basePackages = {"com.lookiero.quehayparacomer.infrastructure.persistance.jpa.ingredient"})
@ComponentScan({
        "com.lookiero.quehayparacomer.infrastructure.delivery.springboot.persistence"
})
public class Persistance {
    //    IngredientRepository ingredientRepository(final JpaIngredientRepository repository){
//        return new JpaIngredientRepositoryAdapter(repository);
//    }

    @Bean
    IngredientRepository ingredientRepository(final CacheRepositoryAdapter cache) {
        return new CacheRepositoryAdapter();
    }
    @Bean
    CacheRepositoryAdapter cacheRepositoryAdapter() {
        return new CacheRepositoryAdapter();
    }
}
