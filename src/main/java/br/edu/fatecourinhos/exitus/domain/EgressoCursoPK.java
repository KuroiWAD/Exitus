package br.edu.fatecourinhos.exitus.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class EgressoCursoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "egresso_id")
	private Egresso egresso;

	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	public Egresso getEgresso() {
		return egresso;
	}

	public void setEgresso(Egresso egresso) {
		this.egresso = egresso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((egresso == null) ? 0 : egresso.hashCode());
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
		EgressoCursoPK other = (EgressoCursoPK) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (egresso == null) {
			if (other.egresso != null)
				return false;
		} else if (!egresso.equals(other.egresso))
			return false;
		return true;
	}

}
