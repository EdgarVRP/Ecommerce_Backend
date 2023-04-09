package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Example;
import com.example.repository.ExampleRepository;

@Service
public class ExampleService {

	private final ExampleRepository exampleRepository;

	@Autowired
	public ExampleService(ExampleRepository exampleRepository) {
		this.exampleRepository = exampleRepository;

	}

	// Get
	// Obtiene el elemento de la tabla
	public List<Example> getExamples() {
		return exampleRepository.findAll();
	}

	public Example getExample(Long id) {
		return exampleRepository.findById(id).orElseThrow(() -> new IllegalStateException("The element dont exist"));
	}

	// Post
	// Guarda un nuevo elemento
	public Example addExample(Example example) {
		return exampleRepository.save(example);
	}

	// Put
	// Busca el elemento para actualizarlo si no lo encuentra lo crea
	public Example updateExample(Example newExample, Long id) {
		return exampleRepository.findById(id)
				.map(example -> {
					example.setName(newExample.getName());
					example.setInfo(newExample.getInfo());
					return exampleRepository.save(example);
				})
				.orElseGet(() -> {
					return exampleRepository.save(newExample);
				});
	}

	//Actualiza algunos campos del elemento?
	//Transactional es como un commit si alfo falla regresa a su estado inicial
	@Transactional
	public void updateExample(Long id, String name, String info) {
		Example example = exampleRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("The element dont exist"));

		if ((name != null))
			if ((!name.isEmpty())) {
				example.setName(name);
			}

		if (info != null)
			if ((!info.isEmpty()) &&
					(!info.equals(example.getInfo()))) {
				example.setInfo(info);
			}
	}

	// Delete
	// Borra el elemento por id
	public void deleteExample(Long id) {
		exampleRepository.deleteById(id);
	}

}
