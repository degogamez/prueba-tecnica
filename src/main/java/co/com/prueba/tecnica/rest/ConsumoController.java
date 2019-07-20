package co.com.prueba.tecnica.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.prueba.tecnica.repository.ConsumoRepository;
import co.com.prueba.tecnica.repository.TarjetaRepository;
import io.swagger.annotations.Api;

/**
 * Recurso consumos
 * 
 * @author diego.gamez
 *
 */
@RestController
@RequestMapping(path = "/consumos", 
produces = MediaType.APPLICATION_JSON_VALUE, 
consumes = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Consumos Controller", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConsumoController {
	
	private final ConsumoRepository consumoRepository;
	private final TarjetaRepository tarjetaRepository;
	
	@Autowired
	public ConsumoController(ConsumoRepository consumoRepository,
			TarjetaRepository tarjetaRepository) {
		this.consumoRepository = consumoRepository;
		this.tarjetaRepository = tarjetaRepository;
	}
}