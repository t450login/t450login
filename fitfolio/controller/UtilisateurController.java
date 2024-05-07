package com.example.fitfolio.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.fitfolio.dto.AuthentificationDTO;
import com.example.fitfolio.dto.UtilisateurDTO;
import com.example.fitfolio.entity.Activite;
import com.example.fitfolio.entity.Repas;
import com.example.fitfolio.entity.Utilisateur;
import com.example.fitfolio.repository.ActiviteRepo;
import com.example.fitfolio.repository.RepasRepo;
import com.example.fitfolio.repository.UtilisateurRepo;
import com.example.fitfolio.repository.DateERepo;
import com.example.fitfolio.repository.PlanActiviteRepo;
import com.example.fitfolio.repository.PlanRepasRepo;
import com.example.fitfolio.service.UtilisateurService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/utilisateur")
public class UtilisateurController {

  
	@Autowired
    private ActiviteRepo activiteRepository;
    
    @Autowired
    private RepasRepo repasRepository;
    @Autowired
    private  PlanRepasRepo    planRepasRepo ;
    
    @Autowired
    private  PlanActiviteRepo   planActiviteRepo;
    
    @Autowired
    private  UtilisateurRepo   utilisateurRepo;
    


    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private DateERepo  dateERepo;
    

    @PostMapping(path = "/cherche")
    public ResponseEntity<Utilisateur> authentificationUtilisateur1(@RequestBody AuthentificationDTO authentificationDTO) {
        String email = authentificationDTO.getEmail();
        String motDePasse = authentificationDTO.getMotDePasse(); 
        Utilisateur utilisateur = utilisateurService.findByEmailAndMotdepasse(email, motDePasse); 
        
        if (utilisateur != null) {
            return ResponseEntity.ok(utilisateur);
        } else {
            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


     
    @PostMapping(path = "/saveleila")
    public ResponseEntity<Utilisateur> saveUtilisateurleila(@RequestBody UtilisateurDTO utilisateurDTO) {
    	System.out.println("Creation Utilisateur!");
       Utilisateur id = utilisateurService.addUtilisateurleila(utilisateurDTO);
        System.out.println("Creation Utilisateur excecuter!");
        return ResponseEntity.ok(id);
    }
    
    
    

@PostMapping(path = "/cherche1")
public ResponseEntity<Utilisateur> rechercheParEmail(@RequestBody AuthentificationDTO authentificationDTO) {
    String email = authentificationDTO.getEmail();
    Utilisateur utilisateur = utilisateurService.findByEmail(email);
    
    if (utilisateur != null ) {
        return ResponseEntity.ok(utilisateur);
    } else {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
    
   
  
  
    @PostMapping("/addPlanRepas")
    public ResponseEntity<String> addPlanRepas(@RequestBody Map<String, Object> request) {
        try {
            Integer matricule = (Integer) request.get("matricule");
            Utilisateur utilisateur = utilisateurService.findByMatricule(matricule.longValue());
            String objectif = utilisateurService.findObjectif(utilisateur);

            Long idDateU = utilisateur.getId_date().getIdDate();
            String DateD = utilisateur.getId_date().getDateDebut();
            String DateF = utilisateur.getId_date().getDateFin();

            LocalDate dateDebut = LocalDate.parse(DateD);
            LocalDate dateFin = LocalDate.parse(DateF);

            long nombreDeJours = dateFin.toEpochDay() - dateDebut.toEpochDay() + 1;

            List<Long> BreakfastIds = getRepasIds("Breakfast", objectif, DateD, DateF);
            List<Long> LunchIds = getRepasIds("Lunch", objectif, DateD, DateF);
            List<Long> DinnerIds = getRepasIds("Dinner", objectif, DateD, DateF);

            for (int i = 0; i < nombreDeJours; i++) {
                LocalDate date = dateDebut.plusDays(i);
                
                String dateString = date.toString();

            
                Long fkRepaId = BreakfastIds.get(i);     
                planRepasRepo.insertPlanRepas(dateString, idDateU, fkRepaId);

               
                fkRepaId = LunchIds.get(i);
                planRepasRepo.insertPlanRepas(dateString, idDateU, fkRepaId);

              
                fkRepaId = DinnerIds.get(i);
                planRepasRepo.insertPlanRepas(dateString, idDateU, fkRepaId); 
                
                System.out.println("idDateU " +idDateU);
                System.out.println("fkRepaId " +fkRepaId);
                System.out.println("dateString " +dateString);
            }

            return ResponseEntity.ok("Plan de repas ajouté avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Une erreur s'est produite lors de l'enregistrement du plan de repas.");
        }
    }

    
    

    public List<Long> getRepasIds(String categorie, String type, String debut, String fin) {
        LocalDate dateDebut = LocalDate.parse(debut);
        LocalDate dateFin = LocalDate.parse(fin);

        long nombreDeJours = dateFin.toEpochDay() - dateDebut.toEpochDay() + 1;
        List<Long> repasIds = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < nombreDeJours; i++) {
            List<Long> repasIdsForDay = repasRepository.findByCategorieAndType(categorie, type);
            if (!repasIdsForDay.isEmpty()) {
                Long repasId = repasIdsForDay.get(random.nextInt(repasIdsForDay.size()));
                repasIds.add(repasId);
            }
        }

        return repasIds;
    }
    
    
    
    
    
    @PostMapping("/fetchRepas")
    public ResponseEntity<List<Repas>> fetchRepa(@RequestBody Map<String, Object> request) {
        try {
            Integer matricule = (Integer) request.get("matricule");
            Utilisateur utilisateur = utilisateurService.findByMatricule(matricule.longValue());
            Long idDateU = utilisateur.getId_date().getIdDate();
            String Debut = utilisateur.getId_date().getDateDebut();
            String Fin = utilisateur.getId_date().getDateFin();
            String date = (String) request.get("date");
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            
            LocalDate dateCourante = LocalDate.parse(date, formatter);
            LocalDate datedebut = LocalDate.parse(Debut, formatter);
            LocalDate datefin = LocalDate.parse(Fin, formatter);
            
            LocalDate lundi = dateCourante.with(DayOfWeek.MONDAY);
            LocalDate dimanche = dateCourante.with(DayOfWeek.SUNDAY);
            String Stringlundi = lundi.toString();
            String Stringdimanche = dimanche.toString();
            
            List<Long> repasReferences = planRepasRepo.findRepasByDateRange(idDateU, Stringlundi, Stringdimanche);
            List<Repas> repasList = new ArrayList<>();
            
            for (Long repasRef : repasReferences) {
                Repas repas = repasRepository.findById(repasRef).orElse(null);
                if (repas != null) {
                    repasList.add(repas);
                }
            }
            
            int nbrRepasVide = 21 - repasReferences.size();
            
            if (ChronoUnit.WEEKS.between(datedebut,dateCourante) < 1) {
                for (int i = 0; i < nbrRepasVide; i++) {
                    repasList.add(0, new Repas());
                }
            }
            
            if (ChronoUnit.WEEKS.between(dateCourante, datefin) < 1) {
                for (int i = 0; i < nbrRepasVide; i++) {
                    repasList.add(new Repas());
                }
            }
            
            return ResponseEntity.ok(repasList);
        } catch (Exception e) {
           
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    
    
    @PostMapping("/fetchRepajour")
    public ResponseEntity<List<Repas>> fetchRepajour(@RequestBody Map<String, Object> request) {
        try {
            Integer matricule = (Integer) request.get("matricule");
            Utilisateur utilisateur = utilisateurService.findByMatricule(matricule.longValue());
            Long idDateU = utilisateur.getId_date().getIdDate();
            String date = (String) request.get("date");
            
      
            List<Long> repasReferences = planRepasRepo.findRepasByDateandDateJ(idDateU, date);
            List<Repas> repasList = new ArrayList<>();

            for (Long repasRef : repasReferences) {
                Repas repas = repasRepository.findById(repasRef).orElse(null);
                if (repas != null) {
                    repasList.add(repas);
                }
            }

            return ResponseEntity.ok(repasList);
        } catch (Exception e) {
          
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
    @PostMapping("/deleteRepas")
    public ResponseEntity<String> deletePlanRepas(@RequestBody Map<String, Object> request) {

        try {
        	
            Integer matricule = (Integer) request.get("matricule");
            Utilisateur utilisateur = utilisateurService.findByMatricule(matricule.longValue());
            Long idDateU = utilisateur.getId_date().getIdDate();
            planRepasRepo.deletePlanRepasByDateId(idDateU);
         	    
            return ResponseEntity.ok("Delete passed successfully.");
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete failed.");
        }
    }

    
  //activite
    
    
    
    
    @PostMapping("/addPlanActivite")
    public ResponseEntity<String> addPlanActivite(@RequestBody Map<String, Object> request) {
        try {
            Integer matricule = (Integer) request.get("matricule");
            Utilisateur utilisateur = utilisateurService.findByMatricule(matricule.longValue());
            String objectif = utilisateurService.findObjectif(utilisateur);

           
            Long idDateU = utilisateur.getId_date().getIdDate();
            String DateD = utilisateur.getId_date().getDateDebut();
            String DateF = utilisateur.getId_date().getDateFin();
            LocalDate dateDebut = LocalDate.parse(DateD);
            LocalDate dateFin = LocalDate.parse(DateF);

            long nombreDeJours = dateFin.toEpochDay() - dateDebut.toEpochDay() + 1;
            
            
            System.out.println("Test avant" );
            List<Long> activiteIds = getActiviteIds(objectif, DateD, DateF);
            System.out.println("idDateU " +activiteIds.get(1));
            for (int i = 0; i < nombreDeJours; i++) {
                LocalDate date = dateDebut.plusDays(i);
                String dateString = date.toString();

                Long fkRepaId = activiteIds.get(i);   
        
                planActiviteRepo.insertPlanActivite(dateString, idDateU, fkRepaId);
                

 
            }
            
            

            return ResponseEntity.ok("Plan de repas ajouté avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Une erreur s'est produite lors de l'enregistrement du plan de repas.");
        }
    }
    
    
    public List<Long> getActiviteIds( String type, String debut, String fin) {
        LocalDate dateDebut = LocalDate.parse(debut);
        LocalDate dateFin = LocalDate.parse(fin);

        long nombreDeJours = dateFin.toEpochDay() - dateDebut.toEpochDay() + 1;
        List<Long> activiteIds = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < nombreDeJours; i++) {
            List<Long> activiteIdsForDay = activiteRepository.findByType(type);
            if (!activiteIdsForDay.isEmpty()) {
                Long activiteId = activiteIdsForDay.get(random.nextInt(activiteIdsForDay.size()));
                activiteIds.add(activiteId);
            }
        }

        return activiteIds;
    }
    
    
    
    @PostMapping("/fetchActivite")
    public ResponseEntity<List<Activite>> fetchActivite(@RequestBody Map<String, Object> request) {
        try {
            Integer matricule = (Integer) request.get("matricule");
            Utilisateur utilisateur = utilisateurService.findByMatricule(matricule.longValue());
            Long idDateU = utilisateur.getId_date().getIdDate();
            String date = (String) request.get("date");
            String Debut = utilisateur.getId_date().getDateDebut();
            String Fin = utilisateur.getId_date().getDateFin();
            
            
             
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateCourante = LocalDate.parse(date, formatter);
            LocalDate datedebut = LocalDate.parse(Debut, formatter);
            LocalDate datefin = LocalDate.parse(Fin, formatter);
            
            LocalDate lundi = dateCourante.with(DayOfWeek.MONDAY);
            LocalDate dimanche = dateCourante.with(DayOfWeek.SUNDAY);
            String Stringlundi = lundi.toString();
            String Stringdimanche = dimanche.toString();
            
      
            List<Long> activiteReferences = planActiviteRepo.findActiviteByDateRange(idDateU,  Stringlundi,  Stringdimanche);
            List<Activite> activiteList = new ArrayList<>();

            for (Long activiteRef : activiteReferences) {
                Activite activite = activiteRepository.findById(activiteRef).orElse(null);
                if (activite != null) {
                	activiteList.add(activite);
                }
            }
             
            int nbrActiviteVide = 7 - activiteReferences.size();
            
            if (ChronoUnit.WEEKS.between(datedebut,dateCourante) < 1) {
                for (int i = 0; i < nbrActiviteVide; i++) {
                	activiteList.add(0, new Activite());
                }
            }
            
            if (ChronoUnit.WEEKS.between(dateCourante, datefin) < 1) {
                for (int i = 0; i < nbrActiviteVide; i++) {
                	activiteList.add(new Activite());
                }
            }
            
            
              

            return ResponseEntity.ok(activiteList);
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    

    @PostMapping("/fetchActivitejour")
    public ResponseEntity<List<Activite>> fetchActivitejour(@RequestBody Map<String, Object> request) {
        try {
            Integer matricule = (Integer) request.get("matricule");
            Utilisateur utilisateur = utilisateurService.findByMatricule(matricule.longValue());
            Long idDateU = utilisateur.getId_date().getIdDate();
            String date = (String) request.get("date");
            
      
            List<Long> activiteReferences = planActiviteRepo.findActiviteByDateandDateJ(idDateU, date);
            List<Activite> activiteList = new ArrayList<>();

            for (Long activiteRef : activiteReferences) {
                Activite activite = activiteRepository.findById(activiteRef).orElse(null);
                if (activite != null) {
                    activiteList.add(activite);
                }
            }

            return ResponseEntity.ok(activiteList);
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
   
    


    @PostMapping("/addDate")
    public ResponseEntity<Map<String, Long>> addDate(@RequestBody Map<String, Object> request) {
        Map<String, Long> response = new HashMap<>();

        try {
            Integer matricule = (Integer) request.get("matricule");
            String dateDebut = (String) request.get("dateDebut");
            String dateFin = (String) request.get("dateFin");
            dateERepo.addDate(dateDebut, dateFin, (long) matricule);
            Long idDate = dateERepo.findByMatricule((long) matricule);
            
            response.put("idDate", idDate);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    
    

    

@PostMapping("/dateE")
public ResponseEntity<String> updateUtilisateurDateE(@RequestBody Map<String, Object> request) {
   
	int matricule = (int) request.get("matricule");
      int dateE = (int) request.get("dateE");;

    try {
    	
   	 
        utilisateurRepo.updateUtilisateurDateE((long) dateE,(long)matricule);
        
        return ResponseEntity.ok("Update successful for user with matricule: " + matricule);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user with matricule: " + matricule);
    }
}




@PutMapping(path = "/edit")
public String editUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
	
	
    return utilisateurService.updateUtilisateurByMatricule(utilisateurDTO);
}



@PostMapping("/deleteActivite")
public ResponseEntity<String> deletePlanActivite(@RequestBody Map<String, Object> request) {

    try {
    	
        Integer matricule = (Integer) request.get("matricule");
        Utilisateur utilisateur = utilisateurService.findByMatricule(matricule.longValue());
        Long idDateU = utilisateur.getId_date().getIdDate();
        planActiviteRepo.deletePlanActiviteByDateId(idDateU);
     	    
        return ResponseEntity.ok("Delete passed successfully.");
    } catch (Exception e) {
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Delete failed.");
    }
}




}
    


    

    
    

