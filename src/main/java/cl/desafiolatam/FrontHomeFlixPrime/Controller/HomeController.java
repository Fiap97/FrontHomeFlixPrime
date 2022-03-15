package cl.desafiolatam.FrontHomeFlixPrime.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import cl.desafiolatam.FrontHomeFlixPrime.Model.Datos;
import cl.desafiolatam.FrontHomeFlixPrime.Service.CategoryService;
import cl.desafiolatam.FrontHomeFlixPrime.Service.FilmCategoryService;
import cl.desafiolatam.FrontHomeFlixPrime.dto.CategoryDTO;
import cl.desafiolatam.FrontHomeFlixPrime.dto.FilmCategoryDTO;



@Controller
public class HomeController {

	
	@Autowired
	private CategoryService categoryService;
/*	@Autowired
	private FilmService filmService;*/
	@Autowired
	private FilmCategoryService filmCategoriaService;
	
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("home");
		
		List<CategoryDTO> categorias= categoryService.findAll();
		
		modelAndView.addObject("categorias",categorias);
		return modelAndView;
	}
	
	@GetMapping("/buscar")
	public ModelAndView buscar(Model model,@ModelAttribute("datos") Datos datos){
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		System.out.println("Categoria= "+datos.getId_categoria()+"  "+"Tiulo= "+datos.getPalabra());
		
		String palabra = datos.getPalabra();
		
		Long idCategoria = datos.getId_categoria();
		
		List<CategoryDTO> categorias= categoryService.findAll();
		
	//	List<FilmDTO> films = filmService.findAll();
		
		
		List<FilmCategoryDTO> filmCategorias = filmCategoriaService.findByCategoryAndTitle(idCategoria, palabra);
		
		
		
		
	//	List<FilmCategoryDTO> filmCategoriasEncontradas = new ArrayList<FilmCategoryDTO>();
				
		
	//	 Set<FilmDTO> peliculasEncontradas = new HashSet<FilmDTO>();
		 
	//	 List<FilmDTO> peliculasEncontradasFinal = new ArrayList<FilmDTO>();
		
	//	 Set<FilmCategoryDTO> fcSet = new HashSet<>();
		 
		 CategoryDTO categoria = new CategoryDTO();
		 
		for(CategoryDTO cat : categorias) {
			if(cat.getCategory_id()==idCategoria) {
				categoria=cat;
			}
		}
		 
	/*	 
		 for(FilmCategoryDTO fc : filmCategorias) {
			 if(fc.getCategory_id()==idCategoria) {
				 filmCategoriasEncontradas.add(fc);
			 }
		 }
		 /* 
		 Long [] idsFilms = new Long[filmCategoriasEncontradas.size()];
		 
		 System.out.println(filmCategoriasEncontradas.size());
		
		 int i=0;
		 
		 for(FilmCategoryDTO fc : filmCategoriasEncontradas) {
				idsFilms[i]=fc.getFilm_id();
				System.out.println(idsFilms[i]);
				i++;
		 }/* 
		 for(int i =0 ; i<=filmCategorias.size() ; i++) {
			 System.out.println("Film id: "+idsFilms[i]);
		 }
		
		 
		 for(int j=0; j<peliculasEncontradasFinal.size() ; j++) {
			 for(FilmDTO film : films) {
				 if(film.getFilm_id()==idsFilms[j]) {
					 peliculasEncontradasFinal.add(film);
				 }
			 }
		 }
		 
		 System.out.println( peliculasEncontradasFinal.size());
		
		 for(FilmCategoryDTO fc : filmCategoriasEncontradas) {
			 for(FilmDTO film : films) {
				 if(film.getFilm_id()==fc.getFilm_id()) {
					 if(film.getTitle().contains(palabra)){
						 peliculasEncontradasFinal.add(film);
						 System.out.println(film.getTitle());
					}
				 }
			 }
			
		 }
		/*
		 for(FilmDTO film : peliculasEncontradasFinal) {
			 System.out.println("Film id: "+film.getFilm_id()+"  "+"Film title : "+film.getTitle());
		 }
		 
		 /*
		 
		 for(FilmCategoryDTO fc : filmCategoriasEncontradas) {
			 System.out.println("Categoria id: "+fc.getCategory_id()+"  "+"Film id: "+fc.getFilm_id());
		 }
		
		for(FilmCategoryDTO fc : filmCategorias){
			for(FilmDTO film : films) {
				if(fc.getCategory_id()==idCategoria ){
		//			System.out.println("Title "+film.getTitle());
		//			System.out.println("Film "+fc.getFilm_id());
		//			System.out.println("CATEGORIA "+fc.getCategory_id());
					fcSet.add(fc);
				}
			}
			
		}
		
		for(FilmCategoryDTO fc : fcSet){
			for(FilmDTO film : films) {
				if(film.getFilm_id()==fc.getFilm_id()) {
					peliculasEncontradas.add(film);
				}
			}
		}
		/*
		for(FilmDTO film : films) {
			for(FilmCategoryDTO fc : filmCategoriasEncontradas) {
				if(fc.getFilm_id()==film.getFilm_id()) {
					peliculasEncontradas.add(film);
				}
			}
		}
		&& film.getTitle().contains(palabra)
		
		for(FilmCategoryDTO filmCategory : filmCategoriasEncontradas) {
			if(film.getTitle().contains(palabra)) {
				peliculasEncontradasFinal.add(film);
			}
		}
		
		for(FilmDTO film : peliculasEncontradas) {
			System.out.println("Title "+film.getTitle());
		}
		
		for(FilmCategoryDTO fc : filmCategorias){
			for(FilmDTO pEncontrada : peliculasEncontradas) {
				if(pEncontrada.getTitle().contains(palabra)) {
					peliculasEncontradasFinal.add(pEncontrada);
			//		System.out.println("Film   " +pEncontrada.getTitle()+"  "+"id categoria   "+ fc.getCategory_id() );
				}
				//System.out.println("Film "+fc.getFilm_id());
				//System.out.println("CATEGORIA "+fc.getCategory_id());
			}
			
		}
	*/
		
//		modelAndView.addObject("peliculas",filmCategorias);
		modelAndView.addObject("filmCategorys",filmCategorias);
		modelAndView.addObject("categorias",categorias);
		modelAndView.addObject("categoria",categoria);
	//	modelAndView.addObject("palabra",palabra);


		
		return modelAndView;
	}
	
}
