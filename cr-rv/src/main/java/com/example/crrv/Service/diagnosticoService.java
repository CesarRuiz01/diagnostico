package com.example.crrv.Service;

import com.example.crrv.Entity.diagnostico;

import java.util.List;

public interface diagnosticoService {

    public List<diagnostico> Consultardiagnostico();

    public diagnostico Creardiagnostico(diagnostico diagnostico);

    public diagnostico Modificardiagnostico(diagnostico diagnostico);

    public diagnostico Buscardiagnostico(int id);

    public void  Eliminardiagnostico(int id);


}
