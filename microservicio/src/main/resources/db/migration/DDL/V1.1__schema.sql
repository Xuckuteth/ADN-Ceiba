create table cliente (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 estado varchar(45) not null,
 primary key (id)
);

create table pelicula (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 formato varchar(45) not null,
 primary key (id)
);

create table alquiler (
 id int(11) not null auto_increment,
 cliente int not null,
 pelicula int not null,
 fecha_alquiler date not null,
 fecha_devolucion date not null,
 valor varchar(45) not null,
 primary key (id),
 foreign key(cliente) references cliente(id),
 foreign key(pelicula) references pelicula(id)
);