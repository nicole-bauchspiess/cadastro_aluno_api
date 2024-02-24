package com.example.aluno.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Pessoa {

	private Integer id;
	private String cpf; 
	private String name;
	private String email;
	private String phone;
	private LocalDate birthday;
	
	public Pessoa() {
		
	}
	
	
	public Pessoa(Integer id, String cpf, String name, String email, String phone, LocalDate birthday) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.birthday = birthday;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
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
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
