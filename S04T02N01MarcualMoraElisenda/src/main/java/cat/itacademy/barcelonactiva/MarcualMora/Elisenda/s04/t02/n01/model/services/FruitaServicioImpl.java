package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n01.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n01.model.domain.Fruita;
import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n01.model.repository.FruitaRepository;

@Service
public class FruitaServicioImpl implements FruitaServices {
	
	//private final FruitaRepository fruitaRepository;
	
	@Autowired
	FruitaRepository fruitaRepository;

	@Override
	public Fruita addFruita(Fruita fruita) {
		return fruitaRepository.save(fruita);
	}

	@Override
	public List<Fruita> getAllFruita() {
		return fruitaRepository.findAll();
	}

	@Override
	public Optional<Fruita> getOneFruita(Integer idFruita) {
		return fruitaRepository.findById(idFruita);
	}

	@Override
	public Fruita updateFruita(Integer idFruita, Fruita updateFruita) {
		Fruita fruitaBuscada = fruitaRepository.findById(idFruita).get();
		fruitaBuscada.setNom(updateFruita.getNom());
		fruitaBuscada.setQuantitatQuilos(updateFruita.getQuantitatQuilos());
		return fruitaRepository.save(updateFruita);
	}

	@Override
	public boolean deleteFruita(Integer idFruita) {
		try {
			fruitaRepository.deleteById(idFruita);
			return true;
		}catch(Exception e) {
			return false;
		}
	}


}
