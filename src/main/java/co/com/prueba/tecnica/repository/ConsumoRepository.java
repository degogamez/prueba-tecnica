package co.com.prueba.tecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.prueba.tecnica.entity.Consumo;

/**
 * Respositorio de Consumo
 * 
 * @author diego.gamez
 *
 */
public interface ConsumoRepository extends JpaRepository<Consumo, Integer> {

}