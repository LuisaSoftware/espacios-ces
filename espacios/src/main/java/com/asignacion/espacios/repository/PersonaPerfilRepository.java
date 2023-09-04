package com.asignacion.espacios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asignacion.espacios.entity.PersonaPerfil;

public interface PersonaPerfilRepository extends JpaRepository<PersonaPerfil, Integer> {
	
	List<PersonaPerfil> findByIndHabilitadoAndPerfil_IdPerfil(boolean indHabilitado, int idPerfil);
	
}