package com.example.proyecto1;

public class Personaje_Juego {
    private int juego_id ;
    private int personaje_id;

    public int getId_juego() {
        return juego_id;
    }

    public void setId_juego(int id_juego) {
        this.juego_id = id_juego;
    }

    public int getId_personaje() {
        return personaje_id;
    }

    public void setId_personaje(int id_personaje) {
        this.personaje_id = id_personaje;
    }

    @Override
    public String toString() {
        return "Personaje_Juego{" +
                "id_juego=" + juego_id +
                ", personaje_id=" + personaje_id +
                '}';
    }
}
