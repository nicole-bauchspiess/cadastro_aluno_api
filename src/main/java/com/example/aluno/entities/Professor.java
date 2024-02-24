package com.example.aluno.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb-professor")
public class Professor extends Pessoa implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnore
	@OneToMany(mappedBy = "professor")
	private List<Turma> turmas = new ArrayList<>();
	
	
	public Professor() {
		
	}


	public Professor(Integer id, String cpf, String name, String email, String phone, LocalDate birthday) {
		super();
		this.id = id;
		this.setCpf(cpf);
		this.setName(name);
		this.setEmail(email);
		this.setPhone(phone);
		this.setBirthday(birthday);
	}

	
	
}
