package integration.integration.VoterRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import integration.integration.elections.CandidateEntity;

public interface candidatRepository extends JpaRepository<CandidateEntity, Long>{
         
}
