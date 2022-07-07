package br.com.techSolutioTeste.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.techSolutioTeste.Model.Usuario;
import br.com.techSolutioTeste.Repository.UsuarioRepository;


@Service
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByLogin(username);
		
		if(usuario == null) {
			
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		// TODO Auto-generated method stub
		return usuario;
	}

}
