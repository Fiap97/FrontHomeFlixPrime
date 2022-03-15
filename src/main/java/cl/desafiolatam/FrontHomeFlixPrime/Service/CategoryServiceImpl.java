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

import cl.desafiolatam.FrontHomeFlixPrime.dto.CategoryDTO;


@Service
public class CategoryServiceImpl implements CategoryService{

	@Value("${endpoints.category}")
	private String categoryEndpoint;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public List<CategoryDTO> findAll() {
		String url = categoryEndpoint;

		// create headers
	    HttpHeaders headers = new HttpHeaders();

	    // create request
	    HttpEntity<?> request = new HttpEntity<Object>(headers);
	    
		
	    // make a request
	    ResponseEntity<List<CategoryDTO>> response = restTemplate.exchange(url, HttpMethod.GET,request ,new ParameterizedTypeReference<List<CategoryDTO>>() {});

	    System.out.println("Cantidad elementos: " + response.getBody().size());
	    
		return response.getBody();
	}

	@Override
	public CategoryDTO findById(Long id) {
		String url = categoryEndpoint + "/" + id;
		
	    // create headers
	    HttpHeaders headers = new HttpHeaders();

	    // create request
	    HttpEntity<?> request = new HttpEntity<Object>(headers);
	    
	    // make a request
	    ResponseEntity<CategoryDTO> response = restTemplate.exchange(url, HttpMethod.GET, request, CategoryDTO.class);
	    
		return response.getBody();
	}

}
