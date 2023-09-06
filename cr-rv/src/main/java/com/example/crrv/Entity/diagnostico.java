package com.example.crrv.Entity;

import javax.persistence.*;

@Entity
@Table(name="tarea")
public class diagnostico {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")

    private int id;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="estado")
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
