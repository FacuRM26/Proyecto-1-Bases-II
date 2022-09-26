--Tablas
create table Raza(
       id  number generated always  as identity primary key,
       nombre varchar2(50),
       habitat varchar2(50),
       Etimologia varchar2(500) ,
       fecha_registro date
    );
create table Personaje(
    id  number generated always  as identity primary key,
    nombre varchar2(100),
    genero varchar2(20),
    Ciudad_residencia varchar2(50),
    Familia varchar2(50),
    enemigo number(1,0),
    raza_id number,
    fecha_registro date,
    CONSTRAINT fk_raza
    FOREIGN KEY (raza_id)
    REFERENCES raza(id)
    );
create table Juego(
    id  number generated always  as identity primary key,
    nombre varchar2(100),
    Consolas varchar2(200),
    fecha_Publicacion date,
    linea_cronologica varchar2(50),
    fecha_registro date
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
create table bitacora(
    id  number ,
    nom_tabla varchar2(100),
    nom_accion varchar2(200),
    campos_anteriores varchar2(2000),
    campos_nuevos varchar2(2000),
    fecha_cambio date,
    usuario varchar2(50)
    ); 
create table temp(
nombre_juego varchar2(50),
consolas_juego varchar2(50),
fecha_publicacion date,
nombre_personaje varchar2(50),
familia varchar2(50),
raza_id number
);
    
--Inserts
INSERT INTO raza (nombre,habitat,etimologia) VALUES ('Hyliano','Hyrule','deriva del nombre de su deidad protectora');
INSERT INTO "RAZA" (NOMBRE, HABITAT, ETIMOLOGIA) VALUES ('Minish', 'Bosque Minish', 'La palabra "minish" es una palabra arcaica que significa disminuir o atenuar');
INSERT INTO "RAZA" (NOMBRE, HABITAT, ETIMOLOGIA) VALUES ('Goron', 'Hyrule', 'El nombre Goron procede de la onomatopeya japonesa Goro goro, usada para expresar el sonido de una roca rodando, lo que hace referencia a la forma deLos Goron de rodar como una roca y a sus propiedades de roca.');
INSERT INTO "RAZA" (NOMBRE, HABITAT, ETIMOLOGIA) VALUES ('Demonio', 'Hyrule', 'Aunque la mayoría tienen una forma humanoide, los demonios poseen a menudo monstruosos atributos físicos');
INSERT INTO "RAZA" (NOMBRE, HABITAT, ETIMOLOGIA) VALUES ('Deku', 'Termina', 'El término Deku también se utiliza con frecuencia para referirse a ciertas plantas o productos en base a las plantas');
INSERT INTO "RAZA" (NOMBRE, HABITAT, ETIMOLOGIA) VALUES ('Gerudo', 'Valle Gerudo', 'Son una tribu de ladrones solitarios que está compuesta en su totalidad por mujeres.');
INSERT INTO "RAZA" (NOMBRE, HABITAT, ETIMOLOGIA) VALUES ('kokiris', 'Bosque Kokiri', 'Los nombres de los Kokiri, a excepción del de Saria, fueron creados por la composición de dos palabras del rango de solfeo musical "Do Re Mi Fa So La Si Do');

insert into personaje (nombre,genero,ciudad_residencia,familia,enemigo,raza_id) values ('Link','Masculino','Hyrule','Smith',0,4);
INSERT INTO "PERSONAJE" (NOMBRE, GENERO, CIUDAD_RESIDENCIA, FAMILIA, ENEMIGO, RAZA_ID) VALUES ('Daruk', 'Masculino', 'Ciudad Goron', 'Yunobo', '0', '42');
INSERT INTO "PERSONAJE" (NOMBRE, GENERO, CIUDAD_RESIDENCIA, FAMILIA, ENEMIGO, RAZA_ID) VALUES ('Princesa Ruto', 'Femenino', 'Lago Hylia', 'Rey Zoro XVI', '0', '21');
INSERT INTO "PERSONAJE" (NOMBRE, GENERO, CIUDAD_RESIDENCIA, FAMILIA, ENEMIGO, RAZA_ID) VALUES ('Ezero', 'Masculino', 'Mundo Minish', 'Desconocido', '0', '41');
INSERT INTO "PERSONAJE" (NOMBRE, GENERO, CIUDAD_RESIDENCIA, FAMILIA, ENEMIGO, RAZA_ID) VALUES ('Vaati', 'Masculino', 'Mundo Minish', 'Desconocida', '1', '41');
INSERT INTO "PERSONAJE" (NOMBRE, GENERO, CIUDAD_RESIDENCIA, FAMILIA, ENEMIGO, RAZA_ID) VALUES ('Princesa Deku', 'Femenino', 'Pantano del Sur', 'Rey Deku', '0', '82');
INSERT INTO "PERSONAJE" (NOMBRE, GENERO, CIUDAD_RESIDENCIA, FAMILIA, ENEMIGO, RAZA_ID) VALUES ('Saria', 'Femenino', 'Bosque Kokiri', 'Desconocida', '0', '84');
INSERT INTO "PERSONAJE" (NOMBRE, GENERO, CIUDAD_RESIDENCIA, FAMILIA, ENEMIGO, RAZA_ID) VALUES ('Urbosa', 'Femenino', 'Ciudadela Gerudo', 'Riju', '0', '83');
INSERT INTO "PERSONAJE" (NOMBRE, GENERO, CIUDAD_RESIDENCIA, FAMILIA, ENEMIGO, RAZA_ID) VALUES ('Ganondorf', 'Masculino', 'Valle Gerudo', 'Koume y Kotake', '1', '83');


INSERT INTO "JUEGO" (NOMBRE, CONSOLAS, FECHA_PUBLICACION, LINEA_CRONOLOGICA) VALUES ('The Legend of Zelda: Majora''s Mask', 'Nintendo 64,Nintndo 3ds', TO_DATE('2000-04-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Heroe Triunfante');
INSERT INTO "JUEGO" (NOMBRE, CONSOLAS, FECHA_PUBLICACION, LINEA_CRONOLOGICA) VALUES ('The Legend of Zelda: The Minish Cap', 'GBA,Nintendo 3DS', TO_DATE('2004-09-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Linea Principal');
INSERT INTO "JUEGO" (NOMBRE, CONSOLAS, FECHA_PUBLICACION, LINEA_CRONOLOGICA) VALUES ('The Legend of Zelda: A Link Between Worlds', 'Nintendo 3DS', TO_DATE('2013-10-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Fracaso del Heroe');
insert into juego (nombre,consolas,fecha_publicacion,linea_cronologica) values ('The legend of Zelda: Ocarina Of time','Nintendo 64,Nintndo 3ds',TO_DATE('21/11/1998','DD/MM/YYYY'),'linea principal');
INSERT INTO "JUEGO" (NOMBRE, CONSOLAS, FECHA_PUBLICACION, LINEA_CRONOLOGICA) VALUES ('The Legend of Zelda: Twilight Princess', 'Game Cube,Wii', TO_DATE('2006-12-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Heroe Triunfante');
INSERT INTO "JUEGO" (NOMBRE, CONSOLAS, FECHA_PUBLICACION, LINEA_CRONOLOGICA) VALUES ('The Legend of Zelda: The Wind Waker', 'Game Cube,Wii U', TO_DATE('2002-12-13 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Link Adulto');
INSERT INTO "JUEGO" (NOMBRE, CONSOLAS, FECHA_PUBLICACION, LINEA_CRONOLOGICA) VALUES ('The Legend of Zelda: Skyward Sword', 'Wii', TO_DATE('2011-11-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Linea principal');

insert into temp values('siu','muchas consolas',sysdate,'marco','adinerada',4);
insert into personaje_juego values (22,2);
INSERT INTO "PERSONAJE_JUEGO" (PERSONAJE_ID, JUEGO_ID) VALUES ('62', '2');
INSERT INTO "PERSONAJE_JUEGO" (PERSONAJE_ID, JUEGO_ID) VALUES ('62', '62');
INSERT INTO "PERSONAJE_JUEGO" (PERSONAJE_ID, JUEGO_ID) VALUES ('63', '22');
INSERT INTO "PERSONAJE_JUEGO" (PERSONAJE_ID, JUEGO_ID) VALUES ('66', '4');
INSERT INTO "PERSONAJE_JUEGO" (PERSONAJE_ID, JUEGO_ID) VALUES ('67', '4');
INSERT INTO "PERSONAJE_JUEGO" (PERSONAJE_ID, JUEGO_ID) VALUES ('65', '21');
INSERT INTO "PERSONAJE_JUEGO" (PERSONAJE_ID, JUEGO_ID) VALUES ('65', '2');

INSERT INTO "RAZA_JUEGO" (RAZA_ID, JUEGO_ID) VALUES ('84', '2');
INSERT INTO "RAZA_JUEGO" (RAZA_ID, JUEGO_ID) VALUES ('84', '4');
INSERT INTO "RAZA_JUEGO" (RAZA_ID, JUEGO_ID) VALUES ('82', '2');
INSERT INTO "RAZA_JUEGO" (RAZA_ID, JUEGO_ID) VALUES ('81', '62');
INSERT INTO "RAZA_JUEGO" (RAZA_ID, JUEGO_ID) VALUES ('83', '21');
INSERT INTO "RAZA_JUEGO" (RAZA_ID, JUEGO_ID) VALUES ('83', '4');
INSERT INTO RAZA_JUEGO" (RAZA_ID, JUEGO_ID) VALUES ('83', '2');

insert into raza_juego values (4,2);

--Funciones
--Obtener nombres de los personajes que pertenecen al juego con ese ID
create or replace Function Fc_Consulta_Personajes_X_Juego (P_Juego Number) return Sys_Refcursor is
    type ref_cursor is ref cursor;
    C_Personajes ref_cursor;
Begin
    Open C_Personajes For Select b.nombre From PERSONAJE_JUEGO A, PERSONAJE B
    Where  a.personaje_id =  b.id
    AND A.juego_id= P_Juego ;
    return C_Personajes;
End Fc_Consulta_Personajes_X_Juego;

--Obtener nombres de los personajes que pertenecen a la raza con ese ID
create or replace Function Fc_Consulta_Personaje_X_Raza (P_Raza Number) return Sys_Refcursor is
    type ref_cursor is ref cursor;
    C_Personajes ref_cursor;
Begin
    Open C_Personajes For Select b.nombre From PERSONAJE B
    Where  b.raza_id = P_Raza;
    return C_Personajes;
End Fc_Consulta_Personaje_X_Raza;

--Obtener nombres de los juegos que pertenecen al personaje con ese ID
create or replace Function Fc_Consulta_Juego_X_Personaje (P_personaje Number) return Sys_Refcursor is
    type ref_cursor is ref cursor;
    C_Juegos ref_cursor;
Begin
    Open C_Juegos For Select b.nombre From PERSONAJE_JUEGO A, Juego B
    Where  a.juego_id =  b.id
    AND A.personaje_id= P_personaje ;
    return C_Juegos;
End Fc_Consulta_Juego_X_Personaje;

--Obtener nombres de los juegos que pertenecen a la raza con ese ID
create or replace Function Fc_Consulta_Juego_X_Raza (P_raza Number) return Sys_Refcursor is
    type ref_cursor is ref cursor;
    C_Juegos ref_cursor;
Begin
    Open C_Juegos For Select b.nombre From Raza_JUEGO A, Juego B
    Where  a.juego_id =  b.id
    AND A.raza_id= P_raza ;
    return C_Juegos;
End Fc_Consulta_Juego_X_Raza ;

--Obtener nombres de las razas que pertenecen al juego con ese ID
create or replace Function Fc_Consulta_Raza_X_Juego (P_Juego Number) return Sys_Refcursor is
    type ref_cursor is ref cursor;
    C_Juegos ref_cursor;
Begin
    Open C_Juegos For Select b.nombre From Raza_JUEGO A, Raza B
    Where  a.raza_id =  b.id
    AND A.juego_id= P_Juego ;
    return C_Juegos;
End Fc_Consulta_Raza_X_Juego;

--Triggers
--Bitacora de los juegos
create or replace NONEDITIONABLE TRIGGER TRG_FECHA_JUEGO
BEFORE INSERT OR UPDATE OR DELETE ON JUEGO FOR EACH ROW
BEGIN
 if inserting then
    :NEW.FECHA_REGISTRO := SYSDATE;
   inSert INTO bitacora (id,Nom_tabla,NOM_accion,FECHA_CAMBIO, USUARIO, CAMPOS_NUEVOS)
   valueS (:new.id,'Juego','INSERCCION', SYSDATE, USER,
   'Nombre Juego: '|| :NEW.NOMBRE||' - Consolas: '||:NEW.CONSOLAS||' - Fecha_registro: '||:new.fecha_publicacion||' - Linea cronologica: '||:new.linea_cronologica);
 elsif updating then
   inSert INTO bitacora (id,Nom_tabla,NOM_accion,FECHA_CAMBIO, USUARIO, CAMPOS_ANTERIORES, CAMPOS_NUEVOS)
   valueS (:new.id,'Juego','ACTUALIZAR', SYSDATE, USER,
   'Nombre Juego: '|| :OLD.NOMBRE||' - Consolas: '||:OLD.CONSOLAS||' - Fecha_registro: '||:old.fecha_publicacion||' - Linea cronologica: '||:old.linea_cronologica,
   'Nombre Juego: '|| :NEW.NOMBRE||' - Consolas: '||:NEW.CONSOLAS||' - Fecha_registro: '||:new.fecha_publicacion||' - Linea cronologica: '||:new.linea_cronologica);
 elsif deleting then
   inSert INTO bitacora (id,Nom_tabla,NOM_accion,FECHA_CAMBIO, USUARIO, CAMPOS_ANTERIORES)
   valueS (:old.id,'Juego','ELIMINAR', SYSDATE, USER,
   'Nombre Juego: '|| :OLD.NOMBRE||' - Consolas: '||:OLD.CONSOLAS||' - Fecha_registro: '||:old.fecha_publicacion||' - Linea cronologica: '||:old.linea_cronologica);

 end if;

END;

--Bitacora de los personajes
create or replace NONEDITIONABLE TRIGGER TRG_FECHA_PERSONAJE 
BEFORE INSERT OR UPDATE OR DELETE ON Personaje FOR EACH ROW
BEGIN
 if inserting then
    :NEW.FECHA_REGISTRO := SYSDATE;
   inSert INTO bitacora (id,Nom_tabla,NOM_accion,FECHA_CAMBIO, USUARIO, CAMPOS_NUEVOS)
   valueS (:new.id,'Personaje','INSERCCION', SYSDATE, USER,
   'Nombre Personaje: '|| :NEW.NOMBRE||' - Genero: '||:NEW.genero||' - Ciudad_Residencia: '||:new.Ciudad_Residencia||' - Familia: '||:new.familia||' - Fecha_registro: '||:new.fecha_registro);
 
 elsif updating then
   inSert INTO bitacora (id,Nom_tabla,NOM_accion,FECHA_CAMBIO, USUARIO, CAMPOS_ANTERIORES, CAMPOS_NUEVOS)
   valueS (:new.id,'Personajes','ACTUALIZAR', SYSDATE, USER,
   'Nombre Personaje: '|| :old.NOMBRE||' - Genero: '||:old.genero||' - Ciudad_Residencia: '||:old.Ciudad_Residencia||' - Familia: '||:old.familia||' - Fecha_registro: '||:old.fecha_registro,
   'Nombre Personaje: '|| :NEW.NOMBRE||' - Genero: '||:NEW.genero||' - Ciudad_Residencia: '||:new.Ciudad_Residencia||' - Familia: '||:new.familia||' - Fecha_registro: '||:new.fecha_registro);

 elsif deleting then
   inSert INTO bitacora (id,Nom_tabla,NOM_accion,FECHA_CAMBIO, USUARIO, CAMPOS_ANTERIORES)
   valueS (:old.id,'Personaje','ELIMINAR', SYSDATE, USER,
  'Nombre Personaje: '|| :old.NOMBRE||' - Genero: '||:old.genero||' - Ciudad_Residencia: '||:old.Ciudad_Residencia||' - Familia: '||:old.familia||' - Fecha_registro: '||:old.fecha_registro);

 end if;

END;

--Bitacora de las Razas
create or replace NONEDITIONABLE TRIGGER TRG_FECHA_RAZA 
BEFORE INSERT OR UPDATE OR DELETE ON Raza FOR EACH ROW
BEGIN
 if inserting then
    :NEW.FECHA_REGISTRO := SYSDATE;
   inSert INTO bitacora (id,Nom_tabla,NOM_accion,FECHA_CAMBIO, USUARIO, CAMPOS_NUEVOS)
   valueS (:new.id,'Raza','INSERCCION', SYSDATE, USER,
   'Nombre Raza: '|| :NEW.NOMBRE||' - Habitat: '||:NEW.habitat||' - Etimologia: '||:new.etimologia||' - Fecha_registro: '||:new.fecha_registro);
 elsif updating then
   inSert INTO bitacora (id,Nom_tabla,NOM_accion,FECHA_CAMBIO, USUARIO, CAMPOS_ANTERIORES, CAMPOS_NUEVOS)
   valueS (:new.id,'Raza','ACTUALIZAR', SYSDATE, USER,
   'Nombre Raza: '|| :old.NOMBRE||' - Habitat: '||:old.habitat||' - Etimologia: '||:old.etimologia||' - Fecha_registro: '||:old.fecha_registro,
   'Nombre Raza: '|| :NEW.NOMBRE||' - Habitat: '||:NEW.habitat||' - Etimologia: '||:new.etimologia||' - Fecha_registro: '||:new.fecha_registro);
 elsif deleting then
   inSert INTO bitacora (id,Nom_tabla,NOM_accion,FECHA_CAMBIO, USUARIO, CAMPOS_ANTERIORES)
   valueS (:old.id,'Raza','ELIMINAR', SYSDATE, USER,
   'Nombre Raza: '|| :old.NOMBRE||' - Habitat: '||:old.habitat||' - Etimologia: '||:old.etimologia||' - Fecha_registro: '||:old.fecha_registro);

 end if;
END;

--Bitacora de personaje_juego
create or replace NONEDITIONABLE TRIGGER TRG_Personaje_Juego 
BEFORE INSERT OR UPDATE OR DELETE ON Personaje_Juego FOR EACH ROW
BEGIN
 if inserting then
   inSert INTO bitacora (id,Nom_tabla,NOM_accion,FECHA_CAMBIO, USUARIO, CAMPOS_NUEVOS)
   valueS (:new.personaje_id,'Personaje_Juego','INSERCCION', SYSDATE, USER,
   'Personaje Id: '|| :new.personaje_id ||' - Juego Id: '|| :new.juego_id);
 elsif updating then
   inSert INTO bitacora (id,Nom_tabla,NOM_accion,FECHA_CAMBIO, USUARIO, CAMPOS_ANTERIORES, CAMPOS_NUEVOS)
   valueS (:new.personaje_id,'Personaje_Juego','ACTUALIZAR', SYSDATE, USER,
    'Personaje Id: '|| :old.personaje_id ||' - Juego Id: '|| :old.juego_id,
    'Personaje Id: '|| :new.personaje_id ||' - Juego Id: '|| :new.juego_id);
 elsif deleting then
   inSert INTO bitacora (id,Nom_tabla,NOM_accion,FECHA_CAMBIO, USUARIO, CAMPOS_ANTERIORES)
   valueS (:old.personaje_id,'Personaje_Juego','ELIMINAR', SYSDATE, USER,
   'Personaje Id: '|| :old.personaje_id ||' - Juego Id: '|| :old.juego_id);

 end if;
END;

--Bitacora de raza_juego
create or replace NONEDITIONABLE TRIGGER TRG_raza_juego 
BEFORE INSERT OR UPDATE OR DELETE ON raza_juego FOR EACH ROW
BEGIN
 if inserting then
   inSert INTO bitacora (id,Nom_tabla,NOM_accion,FECHA_CAMBIO, USUARIO, CAMPOS_NUEVOS)
   valueS (:new.raza_id,'raza_juego','INSERCCION', SYSDATE, USER,
   'Personaje Id: '|| :new.raza_id ||' - Juego Id: '|| :new.juego_id);
 elsif updating then
   inSert INTO bitacora (id,Nom_tabla,NOM_accion,FECHA_CAMBIO, USUARIO, CAMPOS_ANTERIORES, CAMPOS_NUEVOS)
   valueS (:new.raza_id,'raza_juego','ACTUALIZAR', SYSDATE, USER,
    'Personaje Id: '|| :old.raza_id ||' - Juego Id: '|| :old.juego_id,
    'Personaje Id: '|| :new.raza_id ||' - Juego Id: '|| :new.juego_id);
 elsif deleting then
   inSert INTO bitacora (id,Nom_tabla,NOM_accion,FECHA_CAMBIO, USUARIO, CAMPOS_ANTERIORES)
   valueS (:old.raza_id,'raza_juego','ELIMINAR', SYSDATE, USER,
   'Personaje Id: '|| :old.raza_id ||' - Juego Id: '|| :old.juego_id);

 end if;
END;

--Indices
CREATE UNIQUE INDEX IDX_JUEGO_NOMBRE ON JUEGO (Nombre ASC);
CREATE UNIQUE INDEX IDX_PERSONAJE_NOMBRE ON PERSONAJE (Nombre ASC);
CREATE UNIQUE INDEX IDX_RAZA_NOMBRE ON RAZA (Nombre ASC);


--procedimientos

--Recorre tabla temp e inserta en las tablas respectivas los valores
CREATE OR REPLACE PROCEDURE normalize IS
    CURSOR temp_cursor IS SELECT * FROM Temp; 
BEGIN
    FOR temp_var IN temp_cursor LOOP
        insert into personaje (nombre,familia,raza_id) values (temp_var.nombre_personaje,temp_var.familia,temp_var.raza_id);
        insert into juego (nombre,consolas,fecha_publicacion) values(temp_var.nombre_juego,temp_var.consolas_juego,temp_var.fecha_publicacion);
        end loop;
END;

--Recibe id de juego y un string de personajes y los inserta en la tabla personaje_juego
create or replace NONEDITIONABLE Procedure Pr_Juego_Personaje (P_id_juego Number, P_personaje varchar2) Is
temp_personaje_id number(20);
temp_personaje_nombre varchar2(20);
contador number;
Begin
        for c in (select regexp_substr(P_personaje, '[^,]+', 1, level) as
        codigo 
        from dual
        connect by regexp_substr(P_personaje,'[^,]+', 1, level) is
        not null) loop
            select ID into temp_personaje_id  from personaje where nombre = trim(c.codigo);
            select count(*) into contador from personaje_juego where personaje_id=temp_personaje_id and juego_id=P_id_juego;
            if(contador=0)then
                insert into personaje_juego values(temp_personaje_id ,P_id_juego);
            end if;
            
        end loop;
        Exception
        when NO_DATA_FOUND then
            temp_personaje_nombre:='hola';

End  Pr_Juego_Personaje;

--Recibe id de juego y un string de raza y los inserta en la tabla raza_juego
create or replace NONEDITIONABLE Procedure Pr_Juego_Raza (P_id_juego Number, P_raza varchar2) Is
temp_raza_id number(20);
temp_raza_nombre varchar2(20);
contador number;
Begin
        for c in (select regexp_substr(P_raza, '[^,]+', 1, level) as
        codigo 
        from dual
        connect by regexp_substr(P_raza,'[^,]+', 1, level) is
        not null) loop
            select ID into temp_raza_id  from raza where nombre = trim(c.codigo);
            select count(*) into contador from raza_juego where raza_id=temp_raza_id and juego_id=P_id_juego;
            if(contador=0)then
                insert into raza_juego values(temp_raza_id ,P_id_juego);
            end if;
            
        end loop;
        Exception
        when NO_DATA_FOUND then
            temp_raza_nombre:='hola';

End Pr_Juego_Raza;

--Recibe id de personaje y un string de juegos y los inserta en la tabla personaje_juego
create or replace NONEDITIONABLE Procedure Pr_Personaje_Juego (P_id_personaje Number, P_juegos varchar2) Is
temp_juego_id number(20);
temp_juego_nombre varchar2(20);
contador number;
Begin
        for c in (select regexp_substr(P_juegos, '[^,]+', 1, level) as
        codigo 
        from dual
        connect by regexp_substr(P_juegos,'[^,]+', 1, level) is
        not null) loop
            select ID into temp_juego_id from juego where nombre = trim(c.codigo);
            select count(*) into contador from personaje_juego where personaje_id=P_id_personaje and juego_id=temp_juego_id;
            if(contador=0)then
            insert into personaje_juego values(P_id_personaje,temp_juego_id);
            end if;
            contador:=0;
        end loop;
        Exception
        when NO_DATA_FOUND then
            temp_juego_nombre:='hola';

End Pr_Personaje_Juego;

--Recibe id de raza y un string de juegos y los inserta en la tabla raza_juego
create or replace NONEDITIONABLE Procedure Pr_Raza_Juego (P_id_raza Number, P_juegos varchar2) Is
temp_juego_id number(20);
temp_juego_nombre varchar2(20);
contador number;
Begin
        for c in (select regexp_substr(P_juegos, '[^,]+', 1, level) as
        codigo 
        from dual
        connect by regexp_substr(P_juegos,'[^,]+', 1, level) is
        not null) loop
            select ID into temp_juego_id from juego where nombre = trim(c.codigo);
            select count(*) into contador from raza_juego where raza_id=P_id_raza and juego_id=temp_juego_id;
            if(contador=0)then
                insert into raza_juego values(P_id_raza,temp_juego_id);
            end if;

        end loop;
        Exception
        when NO_DATA_FOUND then
            temp_juego_nombre:='hola';

End Pr_Raza_Juego;


--Calls
call normalize();
call Pr_Personaje_Juego(51, 'The Legend of Zelda: The Minish Cap,The legend of Zelda: Ocarina Of time,The Legend of Zelda: Breath of the Wild');
call Pr_Juego_Personaje(23,'Link,Princesa Zelda');
call Pr_Juego_Raza(21, 'Zora,Goron,Hyliano');
call Pr_Raza_Juego(41,'The Legend of Zelda: The Minish Cap');

--Selects
Select count(*) "total" from  personaje_juego where personaje_id=53 and juego_id=22;

select * from raza;
select * from juego;
select * from personaje_juego;
select * from raza_juego;
commit;


/*Probar funciones
DECLARE
  P_JUEGO NUMBER;
  C_PERSONAJES Sys_Refcursor;
  v_id_personaje number;
  V_NOM_PERSONAJE varchar2(50);
BEGIN
  P_JUEGO := 4;

  C_PERSONAJES :=Fc_Consulta_Personaje_X_Raza(4);
  
  
   LOOP
      FETCH C_PERSONAJES INTO V_NOM_PERSONAJE;
      EXIT WHEN C_PERSONAJES%NOTFOUND;
       dbms_output.put_line('Nombre personaje: '||V_NOM_PERSONAJE );
   END LOOP;
   end;
   */
