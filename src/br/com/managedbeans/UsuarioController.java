package br.com.managedbeans;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import com.sun.prism.Image;

import br.com.beans.Usuario;
import br.com.sessionbeans.UsuarioIT;

@ManagedBean
public class UsuarioController {

	@EJB
	private UsuarioIT dao;
	
	private Usuario usuario;
	private UploadedFile file;
	
	
	public UsuarioController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init(){
		this.usuario = new Usuario();
	}
	
	public void addUsuario() throws IOException{
		byte[] arquivo = file.getContents();
		this.usuario.setFoto(arquivo);
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

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
	
	
	
	
}
