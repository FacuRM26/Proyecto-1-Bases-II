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
    