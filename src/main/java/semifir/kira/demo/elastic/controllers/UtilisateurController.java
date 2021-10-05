package semifir.kira.demo.elastic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import semifir.kira.demo.elastic.models.Utilisateur;
import semifir.kira.demo.elastic.services.UtilisateurService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("users")
public class UtilisateurController {

    @Autowired
    private UtilisateurService service;

    @GetMapping("")
    public Iterable<Utilisateur> findAll(){
        Iterable<Utilisateur> resultPages = this.service.findAll();
        List<Utilisateur> result = new ArrayList<>();
        resultPages.forEach(result::add);
        return result;
    }

    @PostMapping("")
    public Utilisateur save(@RequestBody Utilisateur entity){
        return this.service.save(entity);
    }

}
