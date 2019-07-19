package co.com.prueba.tecnica.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.prueba.tecnica.entity.Cliente;
import co.com.prueba.tecnica.entity.Tarjeta;
import co.com.prueba.tecnica.repository.ClienteRepository;
import co.com.prueba.tecnica.repository.TarjetaRepository;

/**
 * Recurso tarjetas
 * 
 * @author diego.gamez
 *
 */
@RestController
@RequestMapping(path = "/tarjetas", 
produces = MediaType.APPLICATION_JSON_VALUE, 
consumes = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Tarjetas Controller", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarjetaController {
	
	private final TarjetaRepository tarjetaRepository;
	private final ClienteRepository clienteRepository;
	
	@Autowired
	public TarjetaController(TarjetaRepository tarjetaRepository,
			ClienteRepository clienteRepository){
		this.tarjetaRepository = tarjetaRepository;
		this.clienteRepository = clienteRepository;
	}
	
	@GetMapping
	@ApiOperation(value = "Consultar todos las tarjetas", 
	notes = "Consulta todas las tarjetas almacenadas")
	public ResponseEntity<List<Tarjeta>> consultarTarjetas(){
		List<Tarjeta> tarjetas = this.tarjetaRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
		return new ResponseEntity<>(tarjetas, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{idTarjeta}")
	@ApiOperation(value = "Consultar una tarjeta", 
	notes = "Consulta la tarjeta de un id dado")
	public ResponseEntity<Tarjeta> consultarTarjeta(@PathVariable Integer idTarjeta){
		Tarjeta tarjeta = this.tarjetaRepository.getOne(idTarjeta);
		return new ResponseEntity<>(tarjeta, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{idTarjeta}")
	@ApiOperation(value = "Eliminar una tarjeta", 
	notes = "Elimina una tarjeta")
	public ResponseEntity<Object> eliminarTarjeta(@PathVariable Integer idTarjeta){
		Tarjeta tarjeta = this.tarjetaRepository.getOne(idTarjeta);
		this.tarjetaRepository.delete(tarjeta);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	@ApiOperation(value = "Crear una tarjeta", 
	notes = "Crea una tarjeta")
	public ResponseEntity<Tarjeta> crearTarjeta(@RequestBody @Valid Tarjeta tarjeta){
		Cliente cliente = this.clienteRepository.findById(tarjeta.getIdCliente()).get();
		tarjeta.setCliente(cliente);
		this.tarjetaRepository.save(tarjeta);
		tarjeta.setIdCliente(null);
		return new ResponseEntity<>(tarjeta, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{idTarjeta}")
	@ApiOperation(value = "Actualizar una tarjeta", 
	notes = "Actualiza una tarjeta")
	public ResponseEntity<Tarjeta> actualizarTarjeta(@PathVariable Integer idTarjeta, 
			@RequestBody @Valid Tarjeta tarjeta){
		Cliente cliente = this.clienteRepository.findById(tarjeta.getIdCliente()).get();
		
		tarjeta.setCliente(cliente);
		tarjeta.setId(idTarjeta);
		this.tarjetaRepository.save(tarjeta);
		
		tarjeta.setIdCliente(null);
		return new ResponseEntity<>(tarjeta, HttpStatus.OK);
	}
}