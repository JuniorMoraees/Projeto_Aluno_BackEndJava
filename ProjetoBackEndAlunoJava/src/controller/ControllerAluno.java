package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import entity.Aluno;
import repository.RepositoryAluno;

@RestController
@CrossOrigin
public class ControllerAluno {
	
	@Autowired
	RepositoryAluno repository;
	
	@GetMapping("/")
	public String Aluno(){
		return "Bem Vindo";
	}
	
//	@GetMapping(path = "/{id}")
//	public ResponseEntity<?> findById(@PathVariable Long id){
//		return repository.findById(id).map(record -> ResponseEntity.ok().body(record)
//				).orElse(ResponseEntity.notFound().build());
//	}
	
	
	@GetMapping("/aluno")
	public List<Aluno>findAll(){
		return repository.findAll();
	}
	
	@PostMapping(value = "/aluno", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void gravar(@RequestBody Aluno aluno) {
		repository.save(aluno);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody Aluno aluno){
		return repository.findById(id).map(record ->{
			record.setNome(aluno.getNome());
			record.setProfessor(aluno.getProfessor());
			record.setMateria(aluno.getMateria());
			record.setTrimestre1(aluno.getTrimestre1());
			record.setTrimestre2(aluno.getTrimestre2());
			record.setTrimestre3(aluno.getTrimestre3());
			record.setTrimestre4(aluno.getTrimestre4());
			aluno.gerarMedia();
			aluno.gerarSituação();
			Aluno updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.badRequest().build());
	}
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> delete(@PathVariable Long id){
		return repository.findById(id).map(record ->{
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.badRequest().build());
	}
}
