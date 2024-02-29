package com.example.aluno.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aluno.entities.Professor;
import com.example.aluno.services.ProfessorService;

@RestController
@RequestMapping(value ="/professores")
public class ProfessorResource {

	@Autowired
	private ProfessorService service;
	
	@GetMapping
	public ResponseEntity<List<Professor>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Professor> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Professor> update(@PathVariable Integer id, @RequestBody Professor obj){
		Professor p = service.update(id, obj);
		return ResponseEntity.ok().body(p);
	}
	
	
	
}
