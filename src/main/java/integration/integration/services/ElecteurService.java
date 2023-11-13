package integration.integration.services;

import java.util.List;
import java.util.Optional;

import javax.swing.text.PasswordView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import integration.integration.VoterRepository.electeurRepository;
import integration.integration.elections.Electeur;

@Service
public class ElecteurService {
    @Autowired
    private electeurRepository electeurRepository;
//pour le cryptage du mot de pass

    // public ResponseEntity<String> enregisterElecteur(electeurEntity electeur){
    //     if(electeurRepository.existsById(electeur.getVoterById())){
    //         return ResponseEntity.badRequest().body("Un electeur avec cet id existe deja dans la bd");
    //     }
         // Cryptez le mot de passe avant de l'enregistrer dans la base de données

         // Enregistrez l'électeur dans la base de données
    //      electeurRepository.save(electeur);
 
    //      return ResponseEntity.ok("Enregistré avec succès");
    // }

    public List<Electeur> listerElecteurs() {
        return electeurRepository.findAll();
    }
   
// Enregistrer un nouvel électeur
public ResponseEntity<String> enregisterElecteur(Electeur electeur) {
    // Ajoutez la logique pour vérifier les doublons, crypter le mot de passe, etc.
    electeurRepository.save(electeur);
    return ResponseEntity.ok("Enregistré avec succès");
}

  // Récupérer un électeur par son ID
  public Electeur getElecteurById(String voterId) {
    Optional<Electeur> optionalElecteur = electeurRepository.findById(voterId);
    return optionalElecteur.orElse(null);
}

// Mettre à jour les informations d'un électeur
public ResponseEntity<String> mettreAJourElecteur(String voterId, Electeur electeur) {
    // Ajoutez la logique de mise à jour, vérification d'existence, etc.
    if (electeurRepository.existsById(voterId)) {
        electeurRepository.save(electeur);
        return ResponseEntity.ok("Mise à jour réussie et bravo");
    } else {
        return ResponseEntity.notFound().build();
    }
}

 // Supprimer un électeur
 public ResponseEntity<String> supprimerElecteur(String voterId) {
    if (electeurRepository.existsById(voterId)) {
        electeurRepository.deleteById(voterId);
        return ResponseEntity.ok("Notre Suppression est réussie et bravo ");
    } else {
        return ResponseEntity.notFound().build();
    }
}

//private BCryptPasswordEncoder passwordEncoder;

public String authentifierElecteur(AuthentificationRequest authRequest) {
    // Récupérez l'électeur par son ID (voterId) depuis la base de données
    Optional<Electeur> electeur = electeurRepository.findById(authRequest.getVoterId());

    // Vérifiez si l'électeur existe et si le mot de passe correspond
    if (electeur != null) {
        // Générez et retournez le token JWT (JSON Web Token)
        return generateJwtToken(electeur);
    }

    // Retournez null si l'authentification a échoué
    return null;
}

private String generateJwtToken(Optional<Electeur> electeur) {
    return null;
}}
