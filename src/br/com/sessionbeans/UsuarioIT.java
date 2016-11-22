package br.com.sessionbeans;

import java.util.List;

import br.com.beans.Usuario;

public interface UsuarioIT {

	void addUsuario(Usuario usuario);
	
	Usuario findUsuario(int id);
	
	List<Usuario> listUsuarios();
	
}
