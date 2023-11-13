package integration.integration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import integration.integration.VoterRepository.candidatRepository;
import integration.integration.elections.CandidateEntity;
import jakarta.transaction.Transactional;

@Service
public class candidatServcice {
    @Autowired
    private candidatRepository candidatRepository;

    public List<CandidateEntity> getAllCandidateEntities(){
        return candidatRepository.findAll();
    }
// Méthode pour enregistrer un candidat
    public ResponseEntity<String> enregistrerCandidat(CandidateEntity candidat) {
        if (candidatRepository.existsById(candidat.getId())) {
            return ResponseEntity.badRequest().body("Un candidat avec cet ID existe déjà");
        }
        candidatRepository.save(candidat);
        return ResponseEntity.ok("Candidat enregistré avec succès");
    }

      // Méthode pour obtenir un candidat par son ID
      public Optional<CandidateEntity> getCandidatById(Long candidatId) {
        return candidatRepository.findById(candidatId);
    }

    // Méthode pour mettre à jour les informations d'un candidat
    public ResponseEntity<String> ModCandidat(Long candidatId, CandidateEntity candidat) {
        if (!candidatRepository.existsById(candidatId)) {
            return ResponseEntity.badRequest().body("Aucun candidat trouvé avec cet ID");
        }candidat.setId(candidatId);
        candidatRepository.save(candidat);

        return ResponseEntity.ok("Candidat mis à jour ");
    }
    // Méthode pour supprimer 
    public ResponseEntity<String> SuppCandidat(Long candidatId) {
        if (!candidatRepository.existsById(candidatId)) {
            return ResponseEntity.badRequest().body("Aucun candidat trouvé");
        }
        candidatRepository.deleteById(candidatId);

        return ResponseEntity.ok("Candidat supprimé avec succès");
    }

    
}