package co.com.prueba.tecnica.rest;

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
import co.com.prueba.tecnica.repository.ClienteRepository;

@RestController
@RequestMapping(path = "/clientes", 
produces = MediaType.APPLICATION_JSON_VALUE, 
consumes = MediaType.APPLICATION_JSON_VALUE)
public class ClientesController {

	private final ClienteRepository clienteRepository;
	
	@Autowired
	public ClientesController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> consultarClientes(){
		List<Cliente> clientes = this.clienteRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	@GetMapping(path = "/{idCliente}")
	public ResponseEntity<Cliente> consultarCliente(@PathVariable Integer idCliente){
		Cliente cliente = this.clienteRepository.getOne(idCliente);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{idCliente}")
	public ResponseEntity<Object> eliminarCliente(@PathVariable Integer idCliente){
		Cliente cliente = this.clienteRepository.getOne(idCliente);
		this.clienteRepository.delete(cliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> crearCliente(@RequestBody @Valid Cliente cliente){
		this.clienteRepository.save(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{idCliente}")
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer idCliente, 
			@RequestBody @Valid Cliente cliente){
		cliente.setId(idCliente);
		this.clienteRepository.save(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
}