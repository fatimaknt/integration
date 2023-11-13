package integration.integration.VoterRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import integration.integration.elections.Electeur;

public interface electeurRepository extends JpaRepository<Electeur, String>{

    // Electeur findById(String name);
    
}
