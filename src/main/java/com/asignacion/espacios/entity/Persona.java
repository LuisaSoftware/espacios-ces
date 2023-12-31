package com.asignacion.espacios.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPersona;
	
	private String identificacion;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String email;
	private Date fechaCreacion;
	private String usuario;
	private String contrasena;
	private boolean indHabilitado;
	
	//===================================CONSTRUCTOR===========================================
	public Persona() {
		super();
		fechaCreacion = new Date();
		indHabilitado = true;
	}
	
	
	//========================== MAPEO OTAS ENTIDADES ===========================================
	@OneToOne (mappedBy = "persona", fetch = FetchType.LAZY)
	private PersonaEstudiante personaEstudiante;
	
	@OneToOne (mappedBy = "persona", fetch = FetchType.LAZY)
	private PersonaDocente personaDocente;
	
	@OneToMany (mappedBy = "persona", fetch = FetchType.LAZY)
	private List<PersonaPerfil> personaPerfil;
	
	
	//===============================GET Y SET=====================================================
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public boolean isIndHabilitado() {
		return indHabilitado;
	}
	public void setIndHabilitado(boolean indHabilitado) {
		this.indHabilitado = indHabilitado;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public PersonaEstudiante getPersonaEstudiante() {
		return personaEstudiante;
	}
	public void setPersonaEstudiante(PersonaEstudiante personaEstudiante) {
		this.personaEstudiante = personaEstudiante;
	}
	
	public PersonaDocente getPersonaDocente() {
		return personaDocente;
	}
	public void setPersonaDocente(PersonaDocente personaDocente) {
		this.personaDocente = personaDocente;
	}
	public List<PersonaPerfil> getPersonaPerfil() {
		return personaPerfil;
	}
	public void setPersonaPerfil(List<PersonaPerfil> personaPerfil) {
		this.personaPerfil = personaPerfil;
	}
	
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", identificacion=" + identificacion + ", primerNombre="
				+ primerNombre + ", segundoNombre=" + segundoNombre + ", primerApellido=" + primerApellido
				+ ", segundoApellido=" + segundoApellido + ", email=" + email + ", fechaCreacion=" + fechaCreacion
				+ ", usuario=" + usuario + ", contrasena=" + contrasena + ", indHabilitado=" + indHabilitado
				+ ", personaEstudiante=" + personaEstudiante + ", personaDocente=" + personaDocente + "]";
	}
	
	
}
