package com.example.crrv.Service.diagnosticoServiceIMPL;



import com.example.crrv.Entity.diagnostico;
import com.example.crrv.Repository.diagnosticoRepo;
import com.example.crrv.Service.diagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class dSIMPL implements diagnosticoService {

    @Autowired
    private diagnosticoRepo repo;


    @Override
    public List<diagnostico> Consultardiagnostico() {
        return (List<diagnostico>) this.repo.findAll();
    }

    @Override
    public diagnostico Creardiagnostico(diagnostico diagnostico) {
        diagnostico.setDescripcion(diagnostico.getDescripcion());
        diagnostico.setEstado(diagnostico.getEstado());
        return this.repo.save(diagnostico);
    }

    @Override
    public diagnostico Modificardiagnostico(diagnostico diagnostico) {
        diagnostico existente = this.repo.findById(diagnostico.getId()).orElse(null);

        if (existente != null) {
            existente.setDescripcion(diagnostico.getDescripcion());
            existente.setEstado(diagnostico.getEstado());

            return this.repo.save(existente);
        } else {
            return null;
        }
    }

    @Override
    public diagnostico Buscardiagnostico(int id) {
        return this.repo.findById(id).get();
    }

    @Override
    public void Eliminardiagnostico(int id) {
        this.repo.deleteById(id);
    }

}
