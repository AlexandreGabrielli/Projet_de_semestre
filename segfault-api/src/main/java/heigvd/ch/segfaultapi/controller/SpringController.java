package heigvd.ch.segfaultapi.controller;

import heigvd.ch.segfaultapi.model.Utilisateur;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Utilisateur")
public class SpringController {

    @GetMapping
    public ResponseEntity<Utilisateur> getUser(){

        Utilisateur user = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return  new ResponseEntity<Utilisateur>(user, HttpStatus.OK);
    }
}
