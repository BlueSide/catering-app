package nl.blueside.cateringapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.Instant;
import java.util.TimeZone;

@Entity
public class Meal
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;
    private LocalDateTime date;
    private String meal;
    private String notes;
    
	public Integer getId() { return id;	}
	public void setId(Integer id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

    public LocalDateTime getDate() { return date; }
    //public void setDate(LocalDateTime date) { this.date = date; }
    public void setDate(Long date)
    {
        this.date = LocalDateTime.ofInstant(Instant.ofEpochMilli(date), TimeZone.getDefault().toZoneId());
    }

    public String getMeal() { return meal; }
    public void setMeal(String meal) { this.meal = meal; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

}
