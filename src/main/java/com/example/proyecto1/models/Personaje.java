package com.example.proyecto1.models;


import javax.persistence.*;

@Entity
@Table(name = "Personaje")
public class Personaje {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Nombre;
    private String Genero;
    private String Ciudad_residencia;
    private String Familia;
    private int Enemigo;
    private int Raza_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
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
        return Raza_id;
    }

    public void setRazaid(int razaid) {
        Raza_id = razaid;
    }

    public String getEnemigoS() {
        if(Enemigo == 1)
            return "SI";
        return "NO";
    }
    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", nombre='" + Nombre + '\'' +
                ", Genero='" + Genero + '\'' +
                ", Ciudad_residencia='" + Ciudad_residencia + '\'' +
                ", Familia='" + Familia + '\'' +
                ", Enemigo=" + Enemigo +
                ", Raza_id=" + Raza_id +
                '}';
    }
}