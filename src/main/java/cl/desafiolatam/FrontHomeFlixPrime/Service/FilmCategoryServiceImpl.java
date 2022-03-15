package cl.desafiolatam.FrontHomeFlixPrime.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.desafiolatam.FrontHomeFlixPrime.dto.FilmCategoryDTO;


@Service
public class FilmCategoryServiceImpl implements FilmCategoryService{

	
	

	@Value("${endpoints.filmCategory}")
	private String filmCategoryEndpoint;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public List<FilmCategoryDTO> findAll() {
		String url = filmCategoryEndpoint;

		// create headers
	    HttpHeaders headers = new HttpHeaders();

	    // create request
	    HttpEntity<?> request = new HttpEntity<Object>(headers);
	    
		
	    // make a request
	    ResponseEntity<List<FilmCategoryDTO>> response = restTemplate.exchange(url, HttpMethod.GET,request ,new ParameterizedTypeReference<List<FilmCategoryDTO>>() {});

	    System.out.println("Cantidad elementos: " + response.getBody().size());
	    
		return response.getBody();
	}

	@Override
	public List<FilmCategoryDTO> findByCategoryAndTitle(Long id, String title) {
		String url = filmCategoryEndpoint + "/" + id + "/" + title;
		
	    // create headers
	    HttpHeaders headers = new HttpHeaders();

	    // create request
	    HttpEntity<?> request = new HttpEntity<Object>(headers);
	    
	    // make a request
	    ResponseEntity<List<FilmCategoryDTO>> response = restTemplate.exchange(url, HttpMethod.GET, request, new ParameterizedTypeReference<List<FilmCategoryDTO>>() {});
	    
		return response.getBody();
	}


}
