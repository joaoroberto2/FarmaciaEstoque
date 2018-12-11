package br.farmacia.estoque.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Tabela_Cliente")
public class PessoaCliente extends PessoaFisica {

	private static final long serialVersionUID = -3763771903748482697L;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	private Sexo sexo;
	private CorPeleHumana corPeleHumana;


	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public CorPeleHumana getCorPeleHumana() {
		return corPeleHumana;
	}

	public void setCorPeleHumana(CorPeleHumana corPeleHumana) {
		this.corPeleHumana = corPeleHumana;
	}


}
