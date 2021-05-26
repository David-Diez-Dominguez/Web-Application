package de.frauas.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.frauas.app.model.Rezept;
@Repository
// stellt CRUD operationen für Datenbanekn zur verfügung
// mit Hilfe von JpaRepository
public interface RezeptRepository extends JpaRepository<Rezept, Integer>  {
	

}
