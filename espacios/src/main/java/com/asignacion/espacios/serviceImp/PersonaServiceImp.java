package com.asignacion.espacios.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.asignacion.espacios.clases.Mensaje;
import com.asignacion.espacios.entity.Persona;
import com.asignacion.espacios.repository.PersonaRepository;
import com.asignacion.espacios.service.IPersonaService;

@Service
public class PersonaServiceImp implements IPersonaService {

	@Autowired
	PersonaRepository repoPersona;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	//NATIVO=======================================================================================================================
	//buscar persona por id
	public Persona buscarPersonaId(Integer idPersona) {
		Optional<Persona> optional = repoPersona.findById(idPersona);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	//listado de todas las personas
	public List<Persona> listarTodos() {
		return repoPersona.findAll();
	}

	//guardar o actualizar persona
	public void guardarPersona(Persona persona) {
		repoPersona.save(persona);
	}

	//guardar persona retornando datos
	public Persona guardarPersonaReturn(Persona persona) {
		persona = repoPersona.save(persona);
		return persona;
	}
	
	//REPOSITORY===================================================================================================================
	public Persona buscarPorDocumento(String documento) {
		Optional<Persona> optional = Optional.ofNullable(repoPersona.findByIdentificacion(documento));
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Persona buscarPorEmail(String email) {
		Optional<Persona> optional = Optional.ofNullable(repoPersona.findByEmail(email));
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	
	//METODOS Y LOGICA=============================================================================================================
	//Guardo validando el documento y el correo no estén repetidos
	public Mensaje guardarValidando(Persona persona) {
		if(persona.getIdPersona()== null) {
			//Registro nuevo
			Persona personaExist = buscarPorDocumento(persona.getIdentificacion());
			if(personaExist!=null) {
				return Mensaje.retornarMensaje(0, "msgD", "El documento ya está registrado");
			}
			personaExist = buscarPorEmail(persona.getEmail());
			if(personaExist!=null) {
				return Mensaje.retornarMensaje(0, "msgD", "El Email ya está registrado");
			}
			persona.setUsuario(persona.getEmail());
			persona.setContrasena(passwordEncoder.encode(persona.getIdentificacion()));
			persona = guardarPersonaReturn(persona);
			return Mensaje.retornarMensaje(1, "msgS", "Registro guardado correctamente");
		}else {
			//Actualizacion registro
			Persona personaExist = buscarPersonaId(persona.getIdPersona());
			persona.setUsuario(persona.getEmail());
			persona.setContrasena(personaExist.getContrasena());
			persona.setFechaCreacion(persona.getFechaCreacion());
			persona = guardarPersonaReturn(persona);
			return Mensaje.retornarMensaje(1, "msgS", "Registro actualizado correctamente");
		}
	}
}
