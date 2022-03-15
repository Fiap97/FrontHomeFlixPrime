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
public class FilmCategoryDTO {

	
	private FilmDTO film;
	private CategoryDTO category;
	private Timestamp last_update;
	
}
