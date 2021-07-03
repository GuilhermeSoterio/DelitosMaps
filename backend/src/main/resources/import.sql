INSERT INTO tb_victim (age, genre) VALUES (25, 'female');
INSERT INTO tb_victim (age, genre) VALUES (18, 'female');
INSERT INTO tb_victim (age, genre) VALUES (42, 'male');
INSERT INTO tb_victim (age, genre) VALUES (19, 'male');

INSERT INTO tb_crime (type_crime, victim_id) VALUES ('Roubo', 1);
INSERT INTO tb_crime (type_crime, victim_id) VALUES ('Furto', 2);
INSERT INTO tb_crime (type_crime, victim_id) VALUES ('Agressão', 3);
INSERT INTO tb_crime (type_crime, victim_id) VALUES ('Invasão de Domicílio', 4);


INSERT INTO tb_occurrence (alone, day_of_the_Week, description, felonious_description, latitude, longitude, moment, crime_id, victim_id) VALUES (TRUE, 'Segunda-feira', 'Estava voltando da faculdade', 'Homem branco alto de boné rosa', -27.2104339, -27.2104339, TIMESTAMP WITH TIME ZONE '2020-07-21T20:59:19Z', 1, 1);