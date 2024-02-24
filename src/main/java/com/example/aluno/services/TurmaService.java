package com.example.aluno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aluno.entities.Turma;
import com.example.aluno.repositories.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;

	public List<Turma> findAll(){
		return turmaRepository.findAll();
	}
	
	public Turma findById(Integer id) {
		Optional<Turma> obj = turmaRepository.findById(id);
		return obj.get();
	}
}
