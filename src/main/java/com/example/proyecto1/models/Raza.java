package com.example.proyecto1.models;


import javax.persistence.*;

@Entity
@Table(name = "raza")
public class Raza {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String habitat;
    private String etimologia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getEtimologia() {
        return etimologia;
    }

    public void setEtimologia(String etimologia) {
        this.etimologia = etimologia;
    }

    @Override
    public String toString() {
        return "Raza{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", habitat='" + habitat + '\'' +
                ", etimologia='" + etimologia + '\'' +
                '}';
    }
}
