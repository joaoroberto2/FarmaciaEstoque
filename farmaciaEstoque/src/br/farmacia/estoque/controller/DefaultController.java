package br.farmacia.estoque.controller;

import java.io.Serializable;

import br.farmacia.estoque.application.Session;
import br.farmacia.estoque.application.Util;
import br.farmacia.estoque.model.Usuario;
import br.farmacia.estoque.validation.Validation;

public class DefaultController implements Serializable {

	private static final long serialVersionUID = 1007297527954376818L;
	
	private static final String userKey = "usuarioLogado";
	
	public Usuario getUsuarioLogado() {
		return (Usuario) Session.getInstance().getAttribute(userKey);
	}

	public void setUsuarioLogado(Usuario usuario) {
		Session.getInstance().setAttribute(userKey, usuario);
	}
	
	public void encerrarSessao() {
		Session.getInstance().invalidateSession();
		Util.redirect("login.xhtml");
	}
	
}
