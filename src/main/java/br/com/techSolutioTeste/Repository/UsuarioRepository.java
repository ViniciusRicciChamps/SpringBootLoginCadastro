package br.com.techSolutioTeste.Repository;


import org.springframework.data.repository.CrudRepository;

import br.com.techSolutioTeste.Model.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario, String> {

	Usuario findByLoginUsuario(String loginUsuario);
	
}
