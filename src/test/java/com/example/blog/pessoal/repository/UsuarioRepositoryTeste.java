package com.example.blog.pessoal.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.example.blog.pessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTeste {
    
	@Autowired
	private  UsuarioRepository usuarioRepository;
	
	@BeforeAll
	  void start() {

	       Usuario usuario = new Usuario(0, "Regina Rodrigues","regina@email.com.br", "123456789" );

            if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
            	usuarioRepository.save(usuario);
            
            usuario = new Usuario(0, "Ruth Carolina","ruthcarolina@email.com.br", "123456787" );

            if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
            	usuarioRepository.save(usuario);
            
            usuario = new Usuario(0, "Maria Isabel","zazabel@email.com.br", "101010100" );

            if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
            	usuarioRepository.save(usuario);
            
            usuario = new Usuario(0, "Rudá","ruda@email.com.br", "123456788" );

            if(!usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent())
            	usuarioRepository.save(usuario);
	}
	
	@Test
	@DisplayName("💾 Retorna Nome")
	    public void findByRetornaNome() {
		
		  Usuario usario = usuarioRepository.findByNome("Regina Rodrigues");
		  assertTrue(usario.getNome().equals("Regina Rodrigues"));
	}
	
	@Test
	@DisplayName("💾 Retorna 3 Usuários")
	  public void findAllByNomeContainingIgnoreCaseRetornaTresUsuarios() {
		
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Rodrigues");
		assertEquals(3, listaDeUsuarios.size());
	
	}
	
	@AfterAll
	public void end() {
		
		System.out.println("Teste Finalizado");
	}
	
	
	
	
}
