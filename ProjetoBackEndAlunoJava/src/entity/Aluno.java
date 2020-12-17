package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="aluno")
public class Aluno implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	@NotNull
	private String nome;
	@Column
	@NotNull
	private String professor;
	@Column
	@NotNull
	private String materia;
	@Column
	@NotNull
	private Double trimestre1;
	@Column
	@NotNull
	private Double trimestre2;
	@Column
	@NotNull
	private Double trimestre3;
	@Column
	@NotNull
	private Double trimestre4;
	@Column
	private Double media =0.;
	@Column
	private String situacao;
	
	public Aluno() {
	}

	public Aluno(Long id, String nome, String professor, String materia, Double trimestre1, Double trimestre2,
			Double trimestre3, Double trimestre4) {
		super();
		this.id = id;
		this.nome = nome;
		this.professor = professor;
		this.materia = materia;
		this.trimestre1 = trimestre1;
		this.trimestre2 = trimestre2;
		this.trimestre3 = trimestre3;
		this.trimestre4 = trimestre4;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", professor=" + professor + ", materia=" + materia + ", trimestre1="
				+ trimestre1 + ", trimestre2=" + trimestre2 + ", trimestre3=" + trimestre3 + ", trimestre4="
				+ trimestre4 + ", media=" + media + ", situacao=" + situacao + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Double getTrimestre1() {
		return trimestre1;
	}

	public void setTrimestre1(Double trimestre1) {
		this.trimestre1 = trimestre1;
	}

	public Double getTrimestre2() {
		return trimestre2;
	}

	public void setTrimestre2(Double trimestre2) {
		this.trimestre2 = trimestre2;
	}

	public Double getTrimestre3() {
		return trimestre3;
	}

	public void setTrimestre3(Double trimestre3) {
		this.trimestre3 = trimestre3;
	}

	public Double getTrimestre4() {
		return trimestre4;
	}

	public void setTrimestre4(Double trimestre4) {
		this.trimestre4 = trimestre4;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public void gerarMedia() {
		this.media = (this.trimestre1 + this.trimestre2 + this.trimestre3 + this.trimestre4)/4;
	}
	
	public void gerarSituação() {
		if(this.media >= 7) {
			this.situacao = "Aprovado";
		}else if(this.media <= 4){
			this.situacao = "Reprovado";
		}else {
			this.situacao = "Em Recuperação";
		}
	}
	

}
