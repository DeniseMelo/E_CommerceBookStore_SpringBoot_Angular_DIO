package LerEssencial.EcommerceLivros.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LerEssencial.EcommerceLivros.Models.Livros;
import LerEssencial.EcommerceLivros.Repositories.LivrosRepository;

@Service
public class LivrosService {
    
	 @Autowired
	 LivrosRepository livrosRepository;
	 
	 
	 public List<Livros> mostrarTodosLivros(){
		 return  livrosRepository.findAll();
	 }
	 
	 public Livros mostrarLivroId(Integer idLivro) {
	        Optional<Livros> livro = livrosRepository.findById(idLivro);
	        return livro.orElseThrow();
	    }
	 
	 public Livros mostrarLivroNome(String nome) {
	        Optional<Livros> livro = livrosRepository.findByNome(nome );
	        return livro.orElseThrow();
	    }
	 
	 public Livros mostrarAutor(String autor) {
	        Optional<Livros> nomeAutor = livrosRepository.findByAutor(autor );
	        return nomeAutor.orElseThrow();
	    }
	 
	 public Livros inserirLivro(Livros livro){
	        livro.setIdLivro(null);
	        return livrosRepository.save(livro);
	    }

	    public Livros editarLivro(Livros livro) {
	    	mostrarLivroId(livro.getIdLivro());
	        return livrosRepository.save(livro);
	    }

	    public void excluirLivro (Integer idLivro) {
	        mostrarLivroId(idLivro);
	        livrosRepository.deleteById(idLivro);
	    }
	 
}
