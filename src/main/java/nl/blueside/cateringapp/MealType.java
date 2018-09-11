package nl.blueside.cateringapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class MealType
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String meal;
    
    private String description;
    
	public Integer getId() { return id;	}
	public void setId(Integer id) { this.id = id; }

    public String getMeal() { return meal; }
    public void setMeal(String meal) { this.meal = meal; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

}
