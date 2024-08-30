package com.example.demo_park_api.service;

import org.springframework.stereotype.Service;

import com.example.demo_park_api.entity.Usuario;
import com.example.demo_park_api.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor /*Essa é uma anotação do lombok ela serve para que o lombok crie um método
construtor com a variavel usuarioRepository, assim o spring faz a injeção de dependências via método construtor*/
@Service /*Essa anotação transforma a minha classe em um bean que começa a ser gerenciado pelo spring*/
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	@Transactional /*Essa anotação indica que o Spring vai tomar conta da parte refeente a transação ele cuida do recurso
	para abrir, fechar e gerenciar a transação do método SAVE*/
	/*O método save é disponibilidado pela interface JPA Respository*/
	public Usuario salvar(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
	}

}
