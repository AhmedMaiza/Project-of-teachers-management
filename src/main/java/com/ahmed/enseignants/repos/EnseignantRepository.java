package com.ahmed.enseignants.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ahmed.enseignants.entities.Enseignant;
import com.ahmed.enseignants.entities.Specilate;


public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
	
	List<Enseignant> findByNomEnseignant(String nom);
	List<Enseignant> findByNomEnseignantContains(String nom);
	List<Enseignant> findByOrderByNomEnseignantAsc();
	
	@Query("select e from Enseignant e where e.nomEnseignant like %?1 and e.salaireEnseignant > ?2")
	List<Enseignant> findByNomSalaire (String nom, Double salaire);
	
	/*@Query("select e from Enseignant e where e.nomEnseignant like %:nom and e.salaireEnseignant > :salaire")
	List<Enseignant> findByNomSalaire (@Param("nom") String nom,@Param("salaire") Double salaire);*/
	
	@Query("select e from Enseignant e where e.specilate = ?1") 
	List<Enseignant> findBySpecilate (Specilate specilate);

	List<Enseignant> findBySpecilateIdSpe(Long id);
	
	@Query("select e from Enseignant e order by e.nomEnseignant ASC, e.salaireEnseignant DESC")
	List<Enseignant> trierEnseignantsNomsSalaire ();
	
	
}