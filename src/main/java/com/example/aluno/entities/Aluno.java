package com.example.aluno.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="tb-aluno")
public class Aluno extends Pessoa implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@ManyToMany
	@JoinTable(name = "tb-turma-aluno", joinColumns = @JoinColumn(name= "aluno-id"), 
	inverseJoinColumns = @JoinColumn(name = "turma-id"))
	private List<Turma> turmas = new ArrayList<>();
	
	
	
	public Aluno() {
		
	}
	
	public Aluno(Integer id, String cpf, String name, String email, String phone, LocalDate birthday) {
		super();
		this.id = id;
		this.setCpf(cpf);
		this.setName(name);
		this.setEmail(email);
		this.setPhone(phone);
		this.setBirthday(birthday);
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void addTurma(Turma turma) {
		this.turmas.add(turma);
		turma.getAlunos().add(this);
	}
	
}
