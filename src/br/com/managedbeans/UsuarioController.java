package br.com.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.beans.Usuario;
import br.com.sessionbeans.UsuarioIT;

@ManagedBean
public class UsuarioController {

	@EJB
	private UsuarioIT dao;
	
	private Usuario usuario;
	
	public UsuarioController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init(){
		this.usuario = new Usuario();
	}
	
	public void addUsuario(){
		dao.addUsuario(this.usuario);
		this.usuario = new Usuario();
	}
	
	public List<Usuario> listUsuarios(){
		return dao.listUsuarios();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
}
