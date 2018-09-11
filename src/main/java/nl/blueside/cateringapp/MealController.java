package nl.blueside.cateringapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.Instant;
import java.util.TimeZone;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping(path="/api")
public class MealController {

    @Autowired
	private MealRepository mealRepository;

	@GetMapping(path="/meals/{d}")
	public @ResponseBody Iterable<Meal> getAllMealsByDate(@PathVariable Long d)
    {
        LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(d), TimeZone.getDefault().toZoneId());
        return mealRepository.findByDate(date);
	}

    @GetMapping(path="/meals")
	public @ResponseBody Iterable<Meal> getAllMeals()
    {
        return mealRepository.findAll();
	}

	@PostMapping(path="/meals")
	public @ResponseBody ResponseEntity<String> addMeal(@RequestBody Meal meal)
    {
    	mealRepository.save(meal);
        return ResponseEntity.ok().body(new JSONObject().put("status", "OK").toString());
	}
    
}
