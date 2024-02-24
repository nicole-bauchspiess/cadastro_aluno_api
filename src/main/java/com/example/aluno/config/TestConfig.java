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
		Professor p1 = new Professor(null, "19100000000","Vanderlei", "vanderlei@gmail.com", "47 988210774", LocalDate.parse("1969-09-09"));
		Professor p2 = new Professor(null, "1911100000", "Julia", "julia@gmail.com", "47 12345678", LocalDate.parse("1998-03-18"));
		
		Aluno a1 = new Aluno(null, "05897594937", "Nicole","nicoleb3007@gmail.com", "47 988210696", LocalDate.parse("2003-07-30"));
		Aluno a2 = new Aluno(null, "05224597937","Lucas", "lucas@gmail.com", "47 988210562", LocalDate.parse("2000-06-10"));
		alunoRepository.saveAll(Arrays.asList(a1,a2));
		
		
		professorRepository.saveAll(Arrays.asList(p1,p2));
		
	}

}
