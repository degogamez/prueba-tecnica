package co.com.prueba.tecnica.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Entidad Cliente
 * 
 * @author diego.gamez
 *
 */
@Entity
public class Cliente extends Base {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Debe ingresar un nombre")
	@Size(max = 50, message = "Nombre debe tener maximo 50 caracteres")
	private String nombre;
	
	@NotBlank(message = "Debe ingresar un direccion")
	@Size(max = 100, message = "Direccion debe tener maximo 100 caracteres")
	private String direccion;
	
	@NotBlank(message = "Debe ingresar un ciudad")
	@Size(max = 30, message = "Ciudad debe tener maximo 30 caracteres")
	private String ciudad;
	
	@NotBlank(message = "Debe ingresar un telefono")
	@Size(max = 20, message = "Telefono debe tener maximo 20 caracteres")
	private String telefono;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}