package br.com.sessionbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.beans.Usuario;

@Stateless
@Local(UsuarioIT.class)
public class UsuarioDao implements UsuarioIT{

	@PersistenceContext(unitName="jdbc/uploadblob")
	EntityManager em;
	
	@Override
	public void addUsuario(Usuario usuario) {
		em.persist(usuario);
	}

	@Override
	public Usuario findUsuario(int id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public List<Usuario> listUsuarios() {
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		Query query = em.createQuery("");
		usuarios = query.getResultList();
		
		return usuarios;
	}

}
