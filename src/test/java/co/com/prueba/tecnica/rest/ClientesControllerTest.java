package co.com.prueba.tecnica.rest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.prueba.tecnica.entity.Cliente;
import co.com.prueba.tecnica.repository.ClienteRepository;

/**
 * Pruebas unitarias
 * de Controlador
 * de Clientes
 * 
 * @author diego.gamez
 *
 */
@RunWith(SpringRunner.class)
public class ClientesControllerTest {

	@Test
	public void testActualizarCliente() throws Exception {
		Integer idCliente = 1;
		
		String ciudad = "ciudad";
		String direccion = "direccion";
		String nombre = "nombre";
		String telefono = "telefono";
		
		Cliente cliente = new Cliente();
		
		cliente.setCiudad(ciudad);
		cliente.setDireccion(direccion);
		cliente.setNombre(nombre);
		cliente.setTelefono(telefono);
		
		ClienteRepository clienteRepository = mock(ClienteRepository.class);
		
		ClientesController clientesController = new ClientesController(clienteRepository);
		
		ResponseEntity<Cliente> respuesta = clientesController.actualizarCliente(idCliente, cliente);
		
		Cliente clienteRespuesta = respuesta.getBody();
		HttpStatus estadoRespuesta = respuesta.getStatusCode();
		
		assertTrue(estadoRespuesta.equals(HttpStatus.OK));
		assertTrue(idCliente.equals(clienteRespuesta.getId()));
		assertTrue(ciudad.equals(clienteRespuesta.getCiudad()));
		assertTrue(direccion.equals(clienteRespuesta.getDireccion()));
		assertTrue(nombre.equals(clienteRespuesta.getNombre()));
		assertTrue(telefono.equals(clienteRespuesta.getTelefono()));
	}
	
	@Test
	public void testCrearCliente() throws Exception {
		Integer idCliente = 1;
		String ciudad = "ciudad";
		String direccion = "direccion";
		String nombre = "nombre";
		String telefono = "telefono";
		
		Cliente cliente = new Cliente();
		
		cliente.setCiudad(ciudad);
		cliente.setDireccion(direccion);
		cliente.setNombre(nombre);
		cliente.setTelefono(telefono);
		cliente.setId(idCliente);
		
		ClienteRepository clienteRepository = mock(ClienteRepository.class);
		
		ClientesController clientesController = new ClientesController(clienteRepository);
		
		ResponseEntity<Cliente> respuesta = clientesController.crearCliente(cliente);
		
		Cliente clienteRespuesta = respuesta.getBody();
		HttpStatus estadoRespuesta = respuesta.getStatusCode();
		
		assertTrue(estadoRespuesta.equals(HttpStatus.CREATED));
		assertTrue(idCliente.equals(clienteRespuesta.getId()));
		assertTrue(ciudad.equals(clienteRespuesta.getCiudad()));
		assertTrue(direccion.equals(clienteRespuesta.getDireccion()));
		assertTrue(nombre.equals(clienteRespuesta.getNombre()));
		assertTrue(telefono.equals(clienteRespuesta.getTelefono()));
	}
	
	@Test
	public void testEliminarCliente() throws Exception {
		Integer idCliente = 1;
		Cliente cliente = new Cliente();
		
		ClienteRepository clienteRepository = mock(ClienteRepository.class);
		
		when(clienteRepository.getOne(idCliente)).thenReturn(cliente);
		
		ClientesController clientesController = new ClientesController(clienteRepository);
		
		ResponseEntity<Object> respuesta = clientesController.eliminarCliente(idCliente);
		
		HttpStatus estadoRespuesta = respuesta.getStatusCode();
		
		assertTrue(estadoRespuesta.equals(HttpStatus.OK));
	}
	
	@Test
	public void testConsultarCliente() throws Exception {
		Integer idCliente = 1;
		Cliente cliente = new Cliente();
		cliente.setId(idCliente);
		
		ClienteRepository clienteRepository = mock(ClienteRepository.class);
		
		when(clienteRepository.getOne(idCliente)).thenReturn(cliente);
		
		ClientesController clientesController = new ClientesController(clienteRepository);
		
		ResponseEntity<Cliente> respuesta = clientesController.consultarCliente(idCliente);
		
		HttpStatus estadoRespuesta = respuesta.getStatusCode();
		Cliente clienteRespuesta = respuesta.getBody();
		
		assertTrue(estadoRespuesta.equals(HttpStatus.OK));
		assertTrue(clienteRespuesta.getId().equals(idCliente));
	}
	
	@Test
	public void testConsultarClientes() throws Exception {
		Integer idCliente1 = 1;
		Integer idCliente2 = 2;
		
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		
		cliente1.setId(idCliente1);
		cliente2.setId(idCliente2);
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		ClienteRepository clienteRepository = mock(ClienteRepository.class);
		
		when(clienteRepository.findAll(new Sort(Sort.Direction.ASC, "id"))).thenReturn(clientes);
		
		ClientesController clientesController = new ClientesController(clienteRepository);
		
		ResponseEntity<List<Cliente>> respuesta = clientesController.consultarClientes();
		
		HttpStatus estadoRespuesta = respuesta.getStatusCode();
		List<Cliente> clientesRespuesta = respuesta.getBody();
		
		assertTrue(estadoRespuesta.equals(HttpStatus.OK));
		assertTrue(clientesRespuesta.size() == clientes.size());
	}
}