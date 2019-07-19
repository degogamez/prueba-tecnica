package co.com.prueba.tecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.prueba.tecnica.entity.Tarjeta;

/**
 * Repository de Tarjeta
 * 
 * @author diego.gamez
 *
 */
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {

}