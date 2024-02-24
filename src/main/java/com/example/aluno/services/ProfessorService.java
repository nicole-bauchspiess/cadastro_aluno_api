package com.example.aluno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aluno.entities.Professor;
import com.example.aluno.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
	
	public List<Professor> findAll(){
	 return professorRepository.findAll();
	}
	
	public Professor findById(Integer id) {
		Optional<Professor> obj = professorRepository.findById(id);
		return obj.get();
	}
}
