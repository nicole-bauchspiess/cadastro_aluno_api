package com.example.aluno.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.aluno.entities.Aluno;
import com.example.aluno.entities.Professor;
import com.example.aluno.repositories.AlunoRepository;
import com.example.aluno.repositories.ProfessorRepository;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	
	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private ProfessorRepository professorRepository;

	@Override
	public void run(String... args) throws Exception {
		Aluno a1 = new Aluno(null, "Nicole", "nicoleb3007@gmail.com", "47 988210696", LocalDate.parse("2003-07-30"), "black");
		alunoRepository.saveAll(Arrays.asList(a1));
		Professor p1 = new Professor(null, "Vanderlei", "vanderlei@gmail.com", "47 988210774", LocalDate.parse("1969-09-09"));
		professorRepository.saveAll(Arrays.asList(p1));
		
	}

}
