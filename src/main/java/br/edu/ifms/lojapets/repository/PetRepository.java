package br.edu.ifms.lojapets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.lojapets.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer>{

}
