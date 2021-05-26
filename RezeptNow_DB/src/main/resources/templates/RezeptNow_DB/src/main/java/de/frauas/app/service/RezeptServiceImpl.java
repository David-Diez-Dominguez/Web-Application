package de.frauas.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.frauas.app.model.Rezept;
import de.frauas.app.repository.RezeptRepository;

//implmentiert interface RezeptService
//definiert Methoden zum Managen von DB
@Service
public class RezeptServiceImpl implements RezeptService {

	// rezeptRepository wird mittels injectio neingefügt
	@Autowired
	private RezeptRepository rezeptRepository;

	// gibt liste aller einträge der DB aus
	@Override
	public List<Rezept> getAllRezept() {
		// findall()= gibt alls einträge aus die er unter der
		// repository finden kann
		return rezeptRepository.findAll();

	}

	@Override
	public void SaveRezept(Rezept rezept) {
		this.rezeptRepository.save(rezept);
	}

	@Override
	public Rezept getRezeptById(int id) {
		Optional<Rezept> optional = rezeptRepository.findById(id);
		Rezept rezept = null;
		if (optional.isPresent()) {
			rezept = optional.get();
		} else {
			throw new RuntimeException("Rezept mit id " + id + " nicht gefunden");
		}
		return rezept;
	}

	@Override
	public void deleteRezeptById(int id) {
		this.rezeptRepository.deleteById(id);
	}

}
