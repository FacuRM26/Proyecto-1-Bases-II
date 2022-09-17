DECLARE
  P_JUEGO NUMBER;
  C_PERSONAJES Sys_Refcursor;
  v_id_personaje number;
  V_NOM_PERSONAJE VARCHAR2(50);
BEGIN
  P_JUEGO := 4;

  PR_CONSULTA_PERSONAJES_X_JUEGO(P_JUEGO,C_PERSONAJES
  );
  
  
   LOOP
      FETCH C_PERSONAJES INTO v_id_personaje, V_NOM_PERSONAJE;
      EXIT WHEN C_PERSONAJES%NOTFOUND;
         -- process the data
       dbms_output.put_line('Id del personaje: '|| v_id_personaje ||' Nombre personaje: '||V_NOM_PERSONAJE );
   END LOOP;
   
END;
