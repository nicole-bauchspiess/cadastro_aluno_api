package com.example.aluno.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb-turma")
public class Turma implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String dayAtWeek;
	private String hour;
	
	@ManyToOne
	@JoinColumn(name = "professor-id")
	private Professor professor;

	@ManyToMany(mappedBy = "turmas")
	private List<Aluno> alunos = new ArrayList<>();
	
	public Turma(Integer id, String dayAtWeek, String hour, Professor professor) {
		super();
		this.id = id;
		this.dayAtWeek = dayAtWeek;
		this.hour = hour;
		this.professor = professor;
	}
	
	
	public Integer getId() {
		return id;
	}
	
	
	public List<Aluno> getAlunos() {
		return alunos;
	}


	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public String getDayAtWeek() {
		return dayAtWeek;
	}
	public void setDayAtWeek(String dayAtWeek) {
		this.dayAtWeek = dayAtWeek;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		return Objects.equals(id, other.id);
	}
	
	
	public void addAluno(Aluno aluno) {
		this.alunos.add(aluno);
		aluno.getTurmas().add(this);
	}
	
}
