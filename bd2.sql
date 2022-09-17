create table STUDENTS(
    ID INT,
    NAME varchar2(20),
    EMAIL VARCHAR2(40));
    
create table Raza(
       id  number generated always  as identity primary key,
       nombre varchar2(50),
       habitat varchar2(50),
       Etimologia varchar2(500)  
    );
    
drop table Personaje;
create table Personaje(
    id  number generated always  as identity primary key,
    nombre varchar2(100),
    genero varchar2(20),
    Ciudad_residencia varchar2(50),
    Familia varchar2(50),
    enemigo number(1,0),
    raza_id number,
    CONSTRAINT fk_raza
    FOREIGN KEY (raza_id)
    REFERENCES raza(id)
    );
create table Juego(
    id  number generated always  as identity primary key,
    nombre varchar2(100),
    Consolas varchar2(200),
    fecha_Publicacion date,
    linea_cronologica varchar2(50)
    );

create table Personaje_Juego(
    personaje_id number,
    juego_id number,
    CONSTRAINT fk_personaje
    FOREIGN KEY (personaje_id)
    REFERENCES personaje(id),
    CONSTRAINT fk_juego
    FOREIGN KEY (juego_id)
    REFERENCES juego(id)
);

create table Raza_Juego(
    raza_id number,
    juego_id number,
    CONSTRAINT fk_raza2
    FOREIGN KEY (raza_id)
    REFERENCES raza(id),
    CONSTRAINT fk_juego2
    FOREIGN KEY (juego_id)
    REFERENCES juego(id)
);
 alter table raza
  modify etimologia varchar2(500);
  
INSERT INTO raza (nombre,habitat,etimologia) VALUES ('Hyliano','Hyrule','deriva del nombre de su deidad protectora');
insert into personaje (nombre,genero,ciudad_residencia,familia,enemigo,raza_id) values ('Link','Masculino','Hyrule','Smith',0,4);
insert into juego (nombre,consolas,fecha_publicacion,linea_cronologica) values ('The legend of Zelda: Ocarina Of time','Nintendo 64,Nintndo 3ds',TO_DATE('21/11/1998','DD/MM/YYYY'),'linea principal');
insert into personaje_juego values (22,2);
insert into raza_juego values (4,2);

select * from personaje;
select * from raza;
select * from juego;
select * from personaje_juego;
select * from raza_juego;
commit;

ALTER TABLE personaje 
ADD fecha_registro date;

create or replace NONEDITIONABLE TRIGGER TRG_FECHA_PERSONAJE 
BEFORE INSERT ON PERSONAJE FOR EACH ROW
BEGIN
   :NEW.FECHA_REGISTRO := SYSDATE;
END;

create or replace NONEDITIONABLE Procedure Pr_Consulta_Personajes_X_Juego (P_Juego Number, C_Personajes Out Sys_Refcursor) As 
Begin

    Open C_Personajes For Select A.personaje_id, b.nombre From PERSONAJE_JUEGO A, PERSONAJE B
    Where  a.personaje_id =  b.id
    AND A.juego_id= P_Juego;
End Pr_Consulta_Personajes_X_Juego;


INSERT INTO "SYSTEM"."JUEGO" (NOMBRE, CONSOLAS, FECHA_PUBLICACION, LINEA_CRONOLOGICA) VALUES ('The Legend of Zelda: Majora''s Mask', 'Nintendo 64,Nintndo 3ds', TO_DATE('2000-04-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Heroe Triunfante');
INSERT INTO "SYSTEM"."JUEGO" (NOMBRE, CONSOLAS, FECHA_PUBLICACION, LINEA_CRONOLOGICA) VALUES ('The Legend of Zelda: The Minish Cap', 'GBA,Nintendo 3DS', TO_DATE('2004-09-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Linea Principal');
INSERT INTO "SYSTEM"."JUEGO" (NOMBRE, CONSOLAS, FECHA_PUBLICACION, LINEA_CRONOLOGICA) VALUES ('The Legend of Zelda: A Link Between Worlds', 'Nintendo 3DS', TO_DATE('2013-10-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Fracaso del Heroe');

INSERT INTO "SYSTEM"."RAZA" (NOMBRE, HABITAT, ETIMOLOGIA) VALUES ('Minish', 'Bosque Minish', 'La palabra "minish" es una palabra arcaica que significa disminuir o atenuar');
INSERT INTO "SYSTEM"."RAZA" (NOMBRE, HABITAT, ETIMOLOGIA) VALUES ('Goron', 'Hyrule', 'El nombre Goron procede de la onomatopeya japonesa Goro goro, usada para expresar el sonido de una roca rodando, lo que hace referencia a la forma deLos Goron de rodar como una roca y a sus propiedades de roca.');

INSERT INTO "SYSTEM"."PERSONAJE" (NOMBRE, GENERO, CIUDAD_RESIDENCIA, FAMILIA, ENEMIGO, RAZA_ID) VALUES ('Daruk', 'Masculino', 'Ciudad Goron', 'Yunobo', '0', '42');
INSERT INTO "SYSTEM"."PERSONAJE" (NOMBRE, GENERO, CIUDAD_RESIDENCIA, FAMILIA, ENEMIGO, RAZA_ID) VALUES ('Princesa Ruto', 'Femenino', 'Lago Hylia', 'Rey Zoro XVI', '0', '21');
INSERT INTO "SYSTEM"."PERSONAJE" (NOMBRE, GENERO, CIUDAD_RESIDENCIA, FAMILIA, ENEMIGO, RAZA_ID) VALUES ('Ezero', 'Masculino', 'Mundo Minish', 'Desconocido', '0', '41');
  