package com.example.crrv.Controller;


import com.example.crrv.Entity.diagnostico;
import com.example.crrv.Service.diagnosticoServiceIMPL.dSIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CRUDRepo")
public class Controlador {
    @Autowired
private dSIMPL impl;

    @GetMapping
    @RequestMapping (value= "Consultardiagnosticos",method = RequestMethod.GET)
    public ResponseEntity<?> Consultardiagnosticos(){
        List<diagnostico> Listadiagnostico=this.impl.Consultardiagnostico();
        return ResponseEntity.ok(Listadiagnostico);

    }


    @PostMapping

    @RequestMapping (value= "Creardiagnosticos",method = RequestMethod.POST)
    public ResponseEntity<?> Crearardiagnosticos(@RequestBody diagnostico diagnostico){
        diagnostico diagnosticocreado =this.impl.Creardiagnostico(diagnostico);
        return ResponseEntity.status(HttpStatus.CREATED).body(diagnosticocreado);

    }
    @PutMapping
    @RequestMapping (value= "Modificardiagnosticos",method = RequestMethod.PUT)
    public ResponseEntity<?> Modificardiagnosticos(@RequestBody diagnostico diagnostico){
        diagnostico diagnosticomodificado =this.impl.Modificardiagnostico(diagnostico);
        return ResponseEntity.status(HttpStatus.CREATED).body(diagnosticomodificado);

    }

    @GetMapping
    @RequestMapping (value= "Buscardiagnostico/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> Buscardiagnostico(@PathVariable int id){
        diagnostico diagnostico =this.impl.Buscardiagnostico(id);
        return ResponseEntity.ok(diagnostico);

    }
    @DeleteMapping
    @RequestMapping (value= "Eliminardiagnostico/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> Eliminardiagnostico(@PathVariable int id){
        this.impl.Eliminardiagnostico(id);
        return ResponseEntity.ok().build();

    }

}
