package br.edu.facthus.jpa.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.facthus.jpa.bean.ContatosBean;
import br.edu.facthus.jpa.entity.Contato;

@Named
@ViewScoped
public class IndexView implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static final Logger logger = 
			Logger.getLogger(IndexView.class.getName());
	
	@Inject
	private ContatosBean contatosBean;
	
	private Contato contato = new Contato();
	
	private List<Contato> listaContatos = new ArrayList<Contato>();
	
	private String nomePesquisa;
	
	public void salva() {
		if (contato.getId() == null) {
			contatosBean.cadastra(contato);
			contato = new Contato();
			FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Contato cadastrado com sucesso!"));
		} else {
			contatosBean.atualiza(contato);
			FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("Contato atualizado com sucesso!"));
		}
	}
	
	public void lista() {
		listaContatos = contatosBean.lista();
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(String.format("%d contato(s) encontrado(s).", 
						listaContatos.size())));
	}
	
	public void atualiza(Contato contato) {
		this.contato = contato;
	}
	
	public void remove(Contato contato) {
		try {
			contatosBean.remove(contato);
			listaContatos = new ArrayList<Contato>();
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Contato removido com sucesso!"));
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Ocorreu um erro ao remover o contato."));
		}
	}
	
	public void pesquisa() {
		if (nomePesquisa == null || nomePesquisa.isBlank()) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("É necessário informar um nome para pesquisa."));
			return;
		}
		
		listaContatos = contatosBean.buscaPorNome(nomePesquisa);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(String.format("%d contato(s) encontrado(s).", 
						listaContatos.size())));
	}

	public ContatosBean getContatosBean() {
		return contatosBean;
	}

	public void setContatosBean(ContatosBean contatosBean) {
		this.contatosBean = contatosBean;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getListaContatos() {
		return listaContatos;
	}

	public void setListaContatos(List<Contato> listaContatos) {
		this.listaContatos = listaContatos;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}
		
}
