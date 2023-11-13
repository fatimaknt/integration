package integration.integration.elections;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Electeurs")

public class Electeur {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String  name;
    @Column(nullable = false)
    private String voterid;
     private String nationalId;
        @Column(nullable = false)
    private String dateOfBirth;
    private String password;

    
    public Electeur(Long id, String name, String voterid, String nationalId, String dateOfBirth, String password) {
        this.id = id;
        this.name = name;
        this.voterid = voterid;
        this.nationalId = nationalId;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }

    
    public Electeur() {
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getVoterid() {
        return voterid;
    }
    public void setVoterid(String voterid) {
        this.voterid = voterid;
    }
    public String getNationalId() {
        return nationalId;
    }
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}
