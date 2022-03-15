package cl.desafiolatam.FrontHomeFlixPrime.dto;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="category")
public class CategoryDTO {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long category_id;
	private String name;
	private Timestamp last_update;

}