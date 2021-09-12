package br.com.fiap.webshift.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.webshift.model.UsuarioModel;
import br.com.fiap.webshift.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public ResponseEntity<List<UsuarioModel>> findAll() {
		List<UsuarioModel> lista = usuarioRepository.findAll();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> findById(@PathVariable("id") int id) {
		if (usuarioRepository.existsById(id)) {
			UsuarioModel model = usuarioRepository.findById(id).get();
			return ResponseEntity.ok(model);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/{id}")
	public ResponseEntity<UsuarioModel> update(@PathVariable("id") int codigoUsuario,
			@RequestBody UsuarioModel usuarioModel) {

		if (usuarioRepository.existsById(codigoUsuario)) {
			usuarioModel.setId(codigoUsuario);
			usuarioRepository.save(usuarioModel);

			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") int id) {
		usuarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
