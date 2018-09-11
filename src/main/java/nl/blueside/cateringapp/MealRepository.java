package nl.blueside.cateringapp;

import org.springframework.data.repository.CrudRepository;
import java.time.LocalDateTime;

// This will be AUTO IMPLEMENTED by Spring into a Bean called mealRepository
public interface MealRepository extends CrudRepository<Meal, Long>
{
    Iterable<Meal> findByDate(LocalDateTime Date);
}
