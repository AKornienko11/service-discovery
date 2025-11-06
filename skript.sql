create table links_properties (
id int8 primary key ,
url varchar

);

insert into  links_properties (id, url)
values (1, 'http://localhost:8084/api/user/get/'),
       (2, 'http://localhost:8084/api/user/create'),
       (3, 'http://localhost:8084/api/user/update'),
       (4, 'http://localhost:8084/api/user/delete/'),
       (5, 'http://localhost:8085/sending/send');