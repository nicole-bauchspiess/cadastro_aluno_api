package com.example.aluno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aluno.entities.Professor;
import com.example.aluno.repositories.ProfessorRepository;
import com.example.aluno.services.exceptions.ResourceNotFoundException;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
	
	public List<Professor> findAll(){
	 return professorRepository.findAll();
	}
	
	public Professor findById(Integer id) {
		Optional<Professor> obj = professorRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Professor update(Integer id, Professor obj) {
		Professor p = professorRepository.getReferenceById(id);
		updateData(p, obj);
		return professorRepository.save(obj);
		
	}
	
	public void updateData(Professor p, Professor obj) {
		p.setName(obj.getName());
		p.setCpf(obj.getCpf());
		p.setBirthday(obj.getBirthday());
		p.setEmail(obj.getEmail());
		p.setPhone(obj.getPhone());
	}
	
}
