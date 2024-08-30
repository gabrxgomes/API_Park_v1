package com.example.demo_park_api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "usuarios") /*Essaa anotação define que essa classe existira no meu banco de dados em forma de uma tabela*/
public class Usuario implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "username", nullable = false, unique = true, length = 100)
	private String username;
	
	
	@Column(name = "password", nullable = false, length = 200)
	private String password;
	
	
	@Enumerated(EnumType.STRING) /*Essa anotação passa um parametro string onde ele transforma o nome da constante
	 em uma string "Role" mas salvando no banco de dados com o valor da sua posição*/
	@Column(name = "role", nullable = false, length = 25)
	private Role role;
	
	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao;
	
	@Column(name = "data_modificacao")
	private LocalDateTime dataModificacao;
	
	@Column(name = "criado_por")
	private String criadoPor;
	
	@Column(name = "modificado_por")
	private String modificadoPor;
	
	public enum Role {
		ROLE_ADMIN, ROLE_CLIENTE
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario usuario = (Usuario) obj;
		return Objects.equals(id, usuario.id);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + "]";
	}
	
	
	

}
