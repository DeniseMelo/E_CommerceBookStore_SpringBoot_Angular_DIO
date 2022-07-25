package LerEssencial.EcommerceLivros.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import LerEssencial.EcommerceLivros.Models.Livros;



@Repository
public interface LivrosRepository  extends JpaRepository<Livros , Integer>{
	
	Optional<Livros> findByNome(String nome);
	Optional<Livros> findByAutor(String nome);
	
	

}