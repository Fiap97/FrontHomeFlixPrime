package cl.desafiolatam.FrontHomeFlixPrime.Service;

import java.util.List;

import cl.desafiolatam.FrontHomeFlixPrime.dto.CategoryDTO;


public interface CategoryService {

	
	List<CategoryDTO> findAll();
	CategoryDTO findById( Long id);
}
