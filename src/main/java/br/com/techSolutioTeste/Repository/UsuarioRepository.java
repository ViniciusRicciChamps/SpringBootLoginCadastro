package br.com.techSolutioTeste.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.techSolutioTeste.Model.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	//@Query("select u from Usuario u where u.login = ?1")
	public Usuario findByLogin(String login);

}
