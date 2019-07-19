package co.com.prueba.tecnica.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Clase base
 * para configurar
 * caracteristicas comunes
 * a todas las entidades
 * 
 * @author diego.gamez
 *
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(Include.NON_NULL)
public class Base {
}