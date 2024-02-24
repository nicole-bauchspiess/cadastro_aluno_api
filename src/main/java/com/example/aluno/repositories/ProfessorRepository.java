package com.example.aluno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.aluno.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

}
