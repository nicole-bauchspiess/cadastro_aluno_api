package com.example.aluno.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aluno.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

	
	public List<Aluno> findByNameContainingIgnoreCase(String namePart);
}
