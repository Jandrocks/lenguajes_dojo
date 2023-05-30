package com.alemeza.lenguajes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alemeza.lenguajes.models.LenguajeModelo;
import com.alemeza.lenguajes.repositories.LenguajeRepo;

@Service
public class LenguajeServ {
	
	@Autowired
	private LenguajeRepo lenguajerepo;
	
	//lee 
	public List<LenguajeModelo> allLenguajes(){
		return lenguajerepo.findAll();
	}
	
	//crea
	public LenguajeModelo createLenguaje (LenguajeModelo lengu ) {
		return lenguajerepo.save(lengu);
	}
	
	// encontrar un lenguaje por el id //busca
		public LenguajeModelo findLangById(Long id) {
			Optional<LenguajeModelo> optionalLang = lenguajerepo.findById(id);
			if (optionalLang.isPresent()) {
				return optionalLang.get();
			} else {
				return null;
			}
		}
	// actualiza
		public LenguajeModelo updateLang(LenguajeModelo lengu) {
			LenguajeModelo actualizarLenguaje = findLangById(lengu.getId());
			actualizarLenguaje.setId(lengu.getId());
			actualizarLenguaje.setName(lengu.getName());
			actualizarLenguaje.setNameCreator(lengu.getNameCreator());
			actualizarLenguaje.setVersion(lengu.getVersion());
			lenguajerepo.save(actualizarLenguaje);
			return actualizarLenguaje;
		}

	// borra
		public void deleteLenguaje(Long id) {
			Optional<LenguajeModelo> optionalLang = lenguajerepo.findById(id);
			if (optionalLang.isPresent()) {
				lenguajerepo.deleteById(id);
			}
		}
}
