package br.com.fiap.webshift.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.webshift.model.UsuarioModel;
import br.com.fiap.webshift.repository.UsuarioRepository;

@RestController
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/usuario")
	public ResponseEntity<List<UsuarioModel>> getAll() {

		List<UsuarioModel> lista = usuarioRepository.findAll();

		if (lista.isEmpty()) {
			return ResponseEntity.status(404).build();
		}

		return ResponseEntity.ok(lista);
	}

}
