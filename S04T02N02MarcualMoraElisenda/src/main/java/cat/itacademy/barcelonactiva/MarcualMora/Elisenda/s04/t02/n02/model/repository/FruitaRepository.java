package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n02.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s04.t02.n02.model.domain.Fruita;

@Repository
public interface FruitaRepository extends JpaRepository<Fruita, Integer> {
	
	
	/*
	 * podriamos definir metodos de busqueda personalizados:
	 * por ejemplo si contiene cantidad:
	 * List<Fruita> findByQuantitatQuilos(int quantitatQuilos);
	 */
	

	/*
	 * Ahora podemos usar los métodos de JpaRepository:
	 * save(), findOne(), findById(), findAll(), count(), delete(), deleteById()…
	 * sin implementar estos métodos.
	 */
}