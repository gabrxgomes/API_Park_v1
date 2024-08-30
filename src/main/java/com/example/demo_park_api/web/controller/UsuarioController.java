package com.example.demo_park_api.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_park_api.entity.Usuario;
import com.example.demo_park_api.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor/*Adicionando a anotação do Lombok*/

@RestController /*A anotação RestController mostra ao spring que essa classe é um bean gerenciado por ele
e um bean do tipo controller para uso de requisições do tipo REST*/
@RequestMapping("api/v1/usuarios") /*essa anotação me permite configurar o PATH(caminho/endpoint) de acesso a esse recurso 
que estamos criando (o caminho base)*/
public class UsuarioController {
	
	/*Vamos agora colocar a injeção de dependências para o nosso service*/
	private final UsuarioService usuarioService;
	
	
	/*Vamos adicionar o primeiro recurso do nosso controller para inserir um usuário*/
	/*esse método vai ter como retorno um objeto especifico do spring para trabalhar com REST,
	 * o ResponseEntity encapsula a minha resposta do endpoint, então a nossa resposta para a requisição
	 * vai ser um objeto do tipo usuario e depois esse obj vai ser transformado em um JSON e enviado para o cliente
	 * que fez essa requisição*/
	@PostMapping
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
		Usuario user = usuarioService.salvar(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	/*Agora vamos trabalhar um método que localiza o usuárrio pelo seu ID*/
	

}
