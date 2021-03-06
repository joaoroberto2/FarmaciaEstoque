package br.farmacia.estoque.controller;

import java.util.HashMap;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import br.farmacia.estoque.application.Util;
import br.farmacia.estoque.model.TipoUsuario;
import br.farmacia.estoque.model.Usuario;

@Named
@ViewScoped
public class UsuarioController extends Controller<Usuario>  {

	private static final long serialVersionUID = 4689020451003580454L;

	public UsuarioController() {
		super(null);
	}
	
	public void limpar() {
		setEntity(null);
	}

	@Override
	public Usuario getEntity() {
		if (entity == null)
			entity = new Usuario();
		return entity;
	}
	
	@Override
	public Usuario incluir() {
		String senhaEncriptada = Util.encrypt(getEntity().getSenha());
		getEntity().setSenha(senhaEncriptada);
		
		return super.incluir();
	}
	
	@Override
	public Usuario alterar() {
		String senhaEncriptada = Util.encrypt(getEntity().getSenha());
		getEntity().setSenha(senhaEncriptada);
		
		return super.alterar();
	}
	
	
	public void abrirListagemUsuario() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false); // nao permite redimencionar
        options.put("draggable", false); // nao permite arrastar
        options.put("modal", true); // abrir como modal
        options.put("width", "80%");
        options.put("height", "500");
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        PrimeFaces.current().dialog().openDynamic("listagemusuario", options, null);
    }
     
    public void usuarioSelecionado(SelectEvent event) {
        Usuario usuario = (Usuario) event.getObject();
        setEntity(usuario);
    }
    
	public TipoUsuario[] getVetorTipoUsuario() {
		return TipoUsuario.values();
	}
	
}
