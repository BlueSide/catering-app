package nl.blueside.cateringapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import java.time.LocalDate;

@Controller
@RequestMapping(path="/api")
public class MealTypeController
{

    @Autowired
	private MealTypeRepository mealTypeRepository;

	@GetMapping(path="/mealtype")
	public @ResponseBody Iterable<MealType> getAllMeals()
    {
		return mealTypeRepository.findAll();
	}

	@PostMapping(path="/mealtype")
	public @ResponseBody ResponseEntity<String> addMealType(@RequestBody MealType mealType)
    {
		mealTypeRepository.save(mealType);
        return ResponseEntity.ok().body(new JSONObject().put("status", "OK").toString());
	}

    
}
