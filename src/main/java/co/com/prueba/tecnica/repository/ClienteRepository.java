package co.com.prueba.tecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.prueba.tecnica.entity.Cliente;

/**
 * Repositorio de Cliente
 * 
 * @author diego.gamez
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}