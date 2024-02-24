package com.example.aluno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aluno.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
