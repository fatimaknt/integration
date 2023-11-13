package integration.integration.elections;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vote")
public class Vote implements Serializable {

    @EmbeddedId

    @ManyToOne
    @JoinColumn(name = "electeur_id")
    private Electeur electeur;

    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private CandidateEntity candidat;


    public Electeur getElecteur() {
        return electeur;
    }

    public void setElecteur(Electeur electeur) {
        this.electeur = electeur;
    }

    public CandidateEntity getCandidat() {
        return candidat;
    }

    public void setCandidat(CandidateEntity candidat) {
        this.candidat = candidat;
    }

    
}
