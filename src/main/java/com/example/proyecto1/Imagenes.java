package com.example.proyecto1;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "Imagenes")
public class Imagenes {
    @Id
    private int id;
    private int id_Imagen;
    private String localizacion;
    private String fecha;
}
