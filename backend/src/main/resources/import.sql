INSERT INTO tb_victim (age, genre) VALUES (25, 'female');
INSERT INTO tb_victim (age, genre) VALUES (18, 'female');
INSERT INTO tb_victim (age, genre) VALUES (42, 'male');
INSERT INTO tb_victim (age, genre) VALUES (19, 'male');
INSERT INTO tb_victim (age, genre) VALUES (29, 'male');
INSERT INTO tb_victim (age, genre) VALUES (16, 'female');
INSERT INTO tb_victim (age, genre) VALUES (17, 'male');

INSERT INTO tb_crime (type_crime) VALUES ('Roubo');
INSERT INTO tb_crime (type_crime) VALUES ('Furto');
INSERT INTO tb_crime (type_crime) VALUES ('Agressão');
INSERT INTO tb_crime (type_crime) VALUES ('Invasão de Domicílio');
INSERT INTO tb_crime (type_crime) VALUES ('Vandalismo');

INSERT INTO tb_occurrence (crime_id, victim_id, alone, day_of_the_Week, description, felonious_description, latitude, longitude, moment, district) VALUES (1, 1, TRUE, 'Segunda-feira', 'Estava voltando da faculdade', 'Homem branco alto de boné rosa', -27.2104339, -27.2104339, TIMESTAMP WITH TIME ZONE '2020-07-21T20:59:19Z', 1);
INSERT INTO tb_occurrence (crime_id, victim_id, alone, day_of_the_Week, description, felonious_description, latitude, longitude, moment, district) VALUES (2, 2, FALSE, 'Terça-feira', 'Estava voltando da faculdade', 'Homem branco alto de boné rosa', -27.2104339, -27.2104339, TIMESTAMP WITH TIME ZONE '2020-07-21T20:59:19Z', 2);
INSERT INTO tb_occurrence (crime_id, victim_id, alone, day_of_the_Week, description, felonious_description, latitude, longitude, moment, district) VALUES (3, 3, FALSE, 'Quarta-feira', 'Estava voltando da faculdade', 'Homem branco alto de boné rosa', -27.2104339, -27.2104339, TIMESTAMP WITH TIME ZONE '2020-07-21T20:59:19Z', 3);
INSERT INTO tb_occurrence (crime_id, victim_id, alone, day_of_the_Week, description, felonious_description, latitude, longitude, moment, district) VALUES (4, 4, TRUE, 'Quinta-feira', 'Estava voltando da faculdade', 'Homem branco alto de boné rosa', -27.2104339, -27.2104339, TIMESTAMP WITH TIME ZONE '2020-07-21T20:59:19Z', 4);