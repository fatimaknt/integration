package integration.integration.elections;

import java.util.List;

import org.apache.catalina.connector.Response;
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

import integration.integration.services.ElecteurService;

@RestController
@RequestMapping("/api/voters")
public class ElecteurController {

    @Autowired
    private ElecteurService electeurService;

    @PostMapping("/register")
    public ResponseEntity<String> enregisterElecteur(@RequestBody Electeur electeur){
        return electeurService.enregisterElecteur(electeur);

    }
//autentication
    @PostMapping("/login")
    // public ResponseEntity<String> authentifierElecteur(@RequestBody AuthentificationRequest authRequest) {
    //     String token = electeurService.authentifierElecteur(authRequest);
        
    //     if (token != null) {
    //         return ResponseEntity.ok(token);
    //     } else {
    //         return ResponseEntity.badRequest().body("Échec de l'authentification");
    //     }
    // }

    //lister
    @GetMapping
    public java.util.List<Electeur>getAllEmployees(){
        return electeurService.listerElecteurs();
    }
    
    // Récupérer un électeur pae id
    @GetMapping("/{voterId}")
    public ResponseEntity<Electeur> getElecteurById(@PathVariable String voterId) {
        Electeur electeur = electeurService.getElecteurById(voterId);
        if (electeur != null) {
            return ResponseEntity.ok(electeur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//mettre a jours
    @PutMapping("/{voterId}")
    public ResponseEntity<String> mettreAJourElecteur(@PathVariable String voterId, @RequestBody Electeur electeur) {
        ResponseEntity<String> response = electeurService.mettreAJourElecteur(voterId, electeur);
        return response;
    }

    // Supprimer mn electeur
    @DeleteMapping("/{voterId}")
    public ResponseEntity<String> supprimerElecteur(@PathVariable String voterId) {
        ResponseEntity<String> response = electeurService.supprimerElecteur(voterId);
        return response;
    }
}
