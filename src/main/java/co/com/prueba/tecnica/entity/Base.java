package co.com.prueba.tecnica.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class Base {
}