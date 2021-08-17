package com.example.blog.pessoal.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioTeste {

	public Usuario usuario;
	public Usuario usuarioNulo = new Usuario();
	
	@Autowired
	  private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	  Validator validator = factory.getValidator();
	  
	  @BeforeEach
	  public void start() {
		  
		   usuario = new Usuario(0L, "Regina Rodrigues","regina@email.com.br", "123456789" );
		  
	  }

      @Test
      void testeValidaAtributos() {
    	  
    	  Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuario);
    	  
    	  System.out.println(violacao.toString());
    	  
    	  assertTrue(violacao.isEmpty());
    	  
      }
      
      @Test
      void testeNaoValidaAtributos() {
    	  
    	  Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuarioNulo);
    	  
    	  System.out.println(violacao.toString());
    	  
    	  assertFalse(violacao.isEmpty());
      }
	  
	  
	  
}
