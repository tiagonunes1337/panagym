package org.springframework.samples.petclinic;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends ListCrudRepository<Matricula, Long> {
    //Repositorio do banco de dados
}