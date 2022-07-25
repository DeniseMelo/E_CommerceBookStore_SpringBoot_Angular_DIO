package LerEssencial.EcommerceLivros.Controllers;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import LerEssencial.EcommerceLivros.Models.Livros;
import LerEssencial.EcommerceLivros.Services.LivrosService;

@CrossOrigin
@RestController
@RequestMapping("livraria")
public class LivrosController {
	
	@Autowired
	LivrosService livrosService;
    
	@GetMapping ("/livros")
	public List<Livros> mostrarTodosLivros(){
	    List<Livros> livros = livrosService.mostrarTodosLivros();
	    return livros;
	}
	
	@GetMapping ("/livros/id/{idLivro}")
	public ResponseEntity<Livros> 
	mostrarLivroId(@PathVariable Integer idLivro)
	{
		Livros livro = livrosService.mostrarLivroId(idLivro);
		return ResponseEntity.ok().body(livro);
	}
	
	@GetMapping ("/livros/nome/{nome}")
	public ResponseEntity<Livros> 
	mostrarLivroNome(@PathVariable String nome)
	{
		Livros livroNome = livrosService.mostrarLivroNome(nome);
		return ResponseEntity.ok().body(livroNome);
	}
	
	@GetMapping ("/livros/autor/{autor}")
	public ResponseEntity<Livros> 
	mostrarUmaExtensao(@PathVariable String autor)
	{
		Livros livroAutor = livrosService.mostrarAutor(autor);
		return ResponseEntity.ok().body(livroAutor);
	}
	
	 @PostMapping("/livro")
	    public ResponseEntity<Livros> inserirLivro(@RequestBody Livros livro) {
	        livro = livrosService.inserirLivro(livro);
	        URI novaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getIdLivro()).toUri();
	        return ResponseEntity.created(novaUri).body(livro);
	    }
	 
	  @PutMapping("/livro/{idLivro}")
	    public ResponseEntity<Livros> editarLivro(@PathVariable Integer idLivro, @RequestBody Livros livro) {
	        livro.setIdLivro(idLivro);
	        livro = livrosService.editarLivro(livro);
	        return ResponseEntity.noContent().build();
	    }

	    @DeleteMapping("/livro/{idLivro}")
	    public ResponseEntity<Void> excluirLivro(@PathVariable Integer idLivro){
	        livrosService.excluirLivro(idLivro);
	        return ResponseEntity.noContent().build();
	    }
	    
	 
	
	
}
