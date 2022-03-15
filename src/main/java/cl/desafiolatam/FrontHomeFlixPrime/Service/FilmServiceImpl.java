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

import cl.desafiolatam.FrontHomeFlixPrime.dto.FilmDTO;


@Service
public class FilmServiceImpl implements FilmService{


	@Value("${endpoints.film}")
	private String filmEndpoint;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Override
	public List<FilmDTO> findAll() {
		String url = filmEndpoint;

		// create headers
	    HttpHeaders headers = new HttpHeaders();

	    // create request
	    HttpEntity<?> request = new HttpEntity<Object>(headers);
	    
		
	    // make a request
	    ResponseEntity<List<FilmDTO>> response = restTemplate.exchange(url, HttpMethod.GET,request ,new ParameterizedTypeReference<List<FilmDTO>>() {});

	    System.out.println("Cantidad elementos: " + response.getBody().size());
	    
		return response.getBody();
	}

	@Override
	public FilmDTO findById(Long id) {
		String url = filmEndpoint + "/" + id;
		
	    // create headers
	    HttpHeaders headers = new HttpHeaders();

	    // create request
	    HttpEntity<?> request = new HttpEntity<Object>(headers);
	    
	    // make a request
	    ResponseEntity<FilmDTO> response = restTemplate.exchange(url, HttpMethod.GET, request, FilmDTO.class);
	    
		return response.getBody();
	}




}
