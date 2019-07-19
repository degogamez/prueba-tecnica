package co.com.prueba.tecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.prueba.tecnica.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}