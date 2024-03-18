package com.example.aluno.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.aluno.entities.Aluno;
import com.example.aluno.services.AlunoService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value ="/alunos")
public class AlunoResource {

	@Autowired
	private AlunoService service;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Aluno> update(@PathVariable Integer id, @RequestBody Aluno aluno) {
		aluno =service.update(id, aluno);
		return ResponseEntity.ok().body(aluno);
	}
	
	@PostMapping()
	public ResponseEntity<Aluno> insert(@RequestBody Aluno aluno){
		aluno = service.insert(aluno);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(aluno.getId()).toUri();
		return ResponseEntity.created(uri).body(aluno);
	}
	
	@GetMapping(value = "/{namePart}")
	public ResponseEntity<List<Aluno>> findByName(@PathVariable String namePart){
		List<Aluno> list = service.findByName(namePart);
		return ResponseEntity.ok().body(list);
	}
}
