package com.example.proyecto1.models;

import javax.persistence.*;

@Entity
@Table(name = "Juego")
public class Juego {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre,consolas,fecha_publicacion,linea_cronologica;

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

    public String getConsolas() {
        return consolas;
    }

    public void setConsolas(String consolas) {
        this.consolas = consolas;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getLinea_cronologica() {
        return linea_cronologica;
    }

    public void setLinea_cronologica(String linea_cronologica) {
        this.linea_cronologica = linea_cronologica;
    }

    @Override
    public String toString() {
        return "Juego{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", consolas='" + consolas + '\'' +
                ", fecha_publicacion='" + fecha_publicacion + '\'' +
                ", linea_cronologica='" + linea_cronologica + '\'' +
                '}';
    }
}