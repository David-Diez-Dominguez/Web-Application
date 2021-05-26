package de.frauas.app.setup;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.frauas.app.model.Rezept;
import de.frauas.app.repository.RezeptRepository;

@Component
public class FillInitialData {

	@Autowired
	private RezeptRepository rezeptRepository;

	@PostConstruct
	public void init() {
		this.fillRezept();
	}

	private void fillRezept() {
		Rezept rezept1 = new Rezept("RezeptName", "Zutat", "Beschreibung");

		try {
			rezeptRepository.save(rezept1);
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
