package cl.desafiolatam.FrontHomeFlixPrime.Service;

import java.util.List;

import cl.desafiolatam.FrontHomeFlixPrime.dto.FilmDTO;


public interface FilmService {

	
	List<FilmDTO> findAll();
	FilmDTO findById( Long id);

}
