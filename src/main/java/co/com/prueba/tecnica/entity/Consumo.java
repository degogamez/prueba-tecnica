package co.com.prueba.tecnica.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

/**
 * Entidad Consumo
 * 
 * @author diego.gamez
 *
 */
@Entity
public class Consumo extends Base {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fecha;
	
	private String descripcion;
	
	@NumberFormat(pattern = "#,###,###,###.##")
	private String monto;
	
	@OneToOne
	@JoinColumn(name="id_tarjeta")
	private Tarjeta tarjeta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
}