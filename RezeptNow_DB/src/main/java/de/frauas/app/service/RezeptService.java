package de.frauas.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import de.frauas.app.model.Rezept;

// interface, das alle Methoden beinhlatet, die
//zum Verwaltem der Daten nötig sind
public interface RezeptService {
	List<Rezept> getAllRezept();

	void SaveRezept(Rezept rezept);

	Rezept getRezeptById(int id);

	void deleteRezeptById(int id);

}
