package cl.desafiolatam.FrontHomeFlixPrime.Service;

import java.util.List;

import cl.desafiolatam.FrontHomeFlixPrime.dto.FilmCategoryDTO;


public interface FilmCategoryService {

	
	List<FilmCategoryDTO> findAll();
	List<FilmCategoryDTO> findByCategoryAndTitle(Long id, String title);

}
