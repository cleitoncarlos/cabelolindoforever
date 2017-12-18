package br.com.vendas.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.vendas.enuns.GrupoPai;


@Entity
public class Grupo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6888930583441165868L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoGrupo;
	private Calendar dataCastro;
	private String nomeGrupo;
	private GrupoPai grupoPai;
	
	@OneToMany(mappedBy = "grupo", cascade = CascadeType.MERGE)
	private List<Produto> produto;
	
	
	public long getCodigoGrupo() {
		return codigoGrupo;
	}
	public void setCodigoGrupo(long codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}
	public Calendar getDataCastro() {
		return dataCastro;
	}
	public void setDataCastro(Calendar dataCastro) {
		this.dataCastro = dataCastro;
	}
	public String getNomeGrupo() {
		return nomeGrupo;
	}
	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}
	public GrupoPai getGrupoPai() {
		return grupoPai;
	}
	public void setGrupoPai(GrupoPai grupoPai) {
		this.grupoPai = grupoPai;
	}
	@Override
	public String toString() {
		return "Grupo [codigoGrupo=" + codigoGrupo + ", dataCastro=" + dataCastro + ", nomeGrupo=" + nomeGrupo
				+ ", grupoPai=" + grupoPai + ", produto=" + produto + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigoGrupo ^ (codigoGrupo >>> 32));
		result = prime * result + ((dataCastro == null) ? 0 : dataCastro.hashCode());
		result = prime * result + ((grupoPai == null) ? 0 : grupoPai.hashCode());
		result = prime * result + ((nomeGrupo == null) ? 0 : nomeGrupo.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		if (codigoGrupo != other.codigoGrupo)
			return false;
		if (dataCastro == null) {
			if (other.dataCastro != null)
				return false;
		} else if (!dataCastro.equals(other.dataCastro))
			return false;
		if (grupoPai != other.grupoPai)
			return false;
		if (nomeGrupo == null) {
			if (other.nomeGrupo != null)
				return false;
		} else if (!nomeGrupo.equals(other.nomeGrupo))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		return true;
	}
	
	
	
}
