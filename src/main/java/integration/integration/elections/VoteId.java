package integration.integration.elections;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class VoteId implements Serializable {

    @Column(name = "electeur_id")
    private Long electeurId;

    @Column(name = "candidat_id")
    private Long candidatId;

    public Long getElecteurId() {
        return electeurId;
    }

    public void setElecteurId(Long electeurId) {
        this.electeurId = electeurId;
    }

    public Long getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(Long candidatId) {
        this.candidatId = candidatId;
    }



}