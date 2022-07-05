package br.com.techSolutioTeste.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.techSolutioTeste.Model.Usuario;
import br.com.techSolutioTeste.Repository.UsuarioRepository;


@Repository
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository ur;
	
	@Override
	public UserDetails loadUserByUsername(String loginUsuario) throws UsernameNotFoundException {
		Usuario usuario = ur.findByUsuario(loginUsuario);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		// TODO Auto-generated method stub
		return usuario;
	}

}
