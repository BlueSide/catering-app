package nl.blueside.cateringapp;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called mealRepository
public interface MealTypeRepository extends CrudRepository<MealType, Long> {

}
