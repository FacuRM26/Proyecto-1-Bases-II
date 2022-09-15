package com.example.proyecto1.models;


import javax.persistence.*;

@Entity
@Table(name = "Personaje")
public class Personaje {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String Genero;
    private String Ciudad_residencia;
    private String Familia;
    private int Enemigo;
    private int raza_id;

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

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getCiudad_residencia() {
        return Ciudad_residencia;
    }

    public void setCiudad_residencia(String ciudad_residencia) {
        Ciudad_residencia = ciudad_residencia;
    }

    public String getFamilia() {
        return Familia;
    }

    public void setFamilia(String familia) {
        Familia = familia;
    }

    public int getEnemigo() {
        return Enemigo;
    }

    public void setEnemigo(int enemigo) {
        Enemigo = enemigo;
    }

    public int getRazaid() {
        return raza_id;
    }

    public void setRazaid(int razaid) {
        raza_id = razaid;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", Genero='" + Genero + '\'' +
                ", Ciudad_residencia='" + Ciudad_residencia + '\'' +
                ", Familia='" + Familia + '\'' +
                ", Enemigo=" + Enemigo +
                ", Raza_id=" + raza_id +
                '}';
    }
}