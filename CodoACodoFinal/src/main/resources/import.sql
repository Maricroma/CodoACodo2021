INSERT INTO role (name) VALUES ('ROLE_USER');
INSERT INTO role (name) VALUES ('ROLE_ADMIN');

INSERT INTO user (username,password,name,dni) values ('admin','$2a$10$sKkMPOADHPSGrtzLerUUBeSPIyX77DDUUe7M9ofKFLF4.YQ.W9J0m','Juanito Say',32100009);
INSERT INTO user (username,password,name,dni) values ('user','$2a$10$sKkMPOADHPSGrtzLerUUBeSPIyX77DDUUe7M9ofKFLF4.YQ.W9J0m','Juanito Say',32100008);

INSERT INTO users_roles (id_user, id_role) VALUES (1,2);
INSERT INTO users_roles (id_user, id_role) VALUES (1,1);

INSERT INTO users_roles (id_user, id_role) VALUES (2,1);

