package cl.desafiolatam.FrontHomeFlixPrime.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {

	
	private Long film_id;
	private String title;
	private String description;
	private int release_year;
	private int language_id;
	private int original_language_id;
	private int rental_duration;
	private int rental_rate;
	private int length;
	private int replacement_cost;
	private String rating;
	private String special_features;
	private Timestamp last_update;

}
