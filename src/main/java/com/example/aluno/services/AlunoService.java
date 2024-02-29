package com.example.aluno.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aluno.entities.Aluno;
import com.example.aluno.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;

	public List<Aluno> findAll(){
		return alunoRepository.findAll();
	}
	
	public Aluno findById(Integer id) {
		Optional<Aluno> obj = alunoRepository.findById(id);
		return obj.get();
	}
	
	public Aluno update(Integer id, Aluno obj) {
		Aluno a = alunoRepository.getReferenceById(id);
		updateData(a, obj);
		return alunoRepository.save(obj);
		
	}
	
	public void updateData(Aluno a, Aluno obj) {
		a.setName(obj.getName());
		a.setCpf(obj.getCpf());
		a.setBirthday(obj.getBirthday());
		a.setEmail(obj.getEmail());
		a.setPhone(obj.getPhone());
	}
	
}
