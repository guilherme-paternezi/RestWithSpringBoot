package br.com.bandtec.springbootrest.repository;

import br.com.bandtec.springbootrest.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}