package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Aluno;

public interface RepositoryAluno extends JpaRepository<Aluno, Long>{

}
