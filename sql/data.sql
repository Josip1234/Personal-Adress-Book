INSERT INTO sex(name) VALUES('Male');
INSERT INTO sex(name) VALUES('Female');
INSERT INTO country(name,alpha_2,alpha_3) VALUES('Croatia','HR','HRV');
INSERT INTO country(name,alpha_2,alpha_3) VALUES('Brazil','BR','BRA');
INSERT INTO country(name,alpha_2,alpha_3) VALUES('Germany','DE','DEU');
INSERT INTO country(name,alpha_2,alpha_3) VALUES('Spain','ES','ESP');
INSERT INTO country(name,alpha_2,alpha_3) VALUES('Mexico','MX','MEX');
INSERT INTO city(name,zip_code, country_id) VALUES('Sao Paulo','01000-000',2);
INSERT INTO city(name,zip_code, country_id) VALUES('Požega','34000',1);
INSERT INTO city(name,zip_code, country_id) VALUES('Munchen','80331',3);
INSERT INTO city(name,zip_code, country_id) VALUES('Monterrey','64000',5);
INSERT INTO city(name,zip_code, country_id) VALUES('Barcelona','08001',4);
INSERT INTO address(street,street_no,city_id) VALUES('Sveti avlija','53',2);
INSERT INTO address(street,street_no,city_id) VALUES('Allianzstrasse','21',3);
INSERT INTO address(street,street_no,city_id) VALUES('Camp Nou','1',5);
INSERT INTO contact(first_name,last_name,phone,email,sex_id,address_id) VALUES('Josip','Bošnjak','+385915842146','josip.bosnjak584@gmail.com',1,1);
INSERT INTO contact(first_name,last_name,phone,email,sex_id,address_id) VALUES('Marija','Marković','+38534282888','mmarkovic@hotmail.com',2,1);
INSERT INTO contact(first_name,last_name,phone,email,sex_id,address_id) VALUES('Sussane','Hofer','+412569845145','shofer@de.com',2,2);
INSERT INTO contact(first_name,last_name,phone,email,sex_id,address_id) VALUES('Emanuel','Munoz','+2369855412','munobarca@espana.es',1,3);