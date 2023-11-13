package integration.integration.elections;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import integration.integration.services.candidatServcice;

@RestController
@RequestMapping("/api/candidates")
public class candidatController {

    @Autowired
    private candidatServcice candidatServcice;

    @GetMapping
    public ResponseEntity<List<CandidateEntity>> getCandidates() {
        List<CandidateEntity> candidats = candidatServcice.getAllCandidateEntities();
        return ResponseEntity.ok(candidats);

    }

    @PostMapping("/register")
    public ResponseEntity<String> enregistrerCandidat(@RequestBody CandidateEntity candidat) {
        return candidatServcice.enregistrerCandidat(candidat);
    }

    @GetMapping("/{candidatId}")
    public ResponseEntity<CandidateEntity> getCandidatById(@PathVariable Long candidatId) {
        Optional<CandidateEntity> candidat = candidatServcice.getCandidatById(candidatId);
        return candidat.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{candidatId}")
    public ResponseEntity<String> updateCandidat(@PathVariable Long candidatId, @RequestBody CandidateEntity modifCandidat) {
        return candidatServcice.ModCandidat(candidatId, modifCandidat);
    }

    @DeleteMapping("/{candidatId}")
    public ResponseEntity<String> deleteCandidat(@PathVariable Long candidatId) {
        return candidatServcice.SuppCandidat(candidatId);
    }
}
