# c:\xampp\mysql\bin\mysql -uroot --default_character_set=utf8 < "C:\Users\Karlo\Documents\Zavrsni rad\JambDB.sql"

drop database if exists JambDB;
create database JambDB;
use JambDB;



create table igrac(
    sifra int not null primary key auto_increment,
    ime varchar(50) not null,
    prezime varchar(50) not null,
    korisnickoIme varchar(50) not null
);


create table partija(
    sifra int not null primary key auto_increment,
    dolje int,
    gore int,
    sloboda int,
    najava int,
    rucno int
);

create table igra(
    igrac int,
    partija int
);

create table kolona(
    sifra int not null primary key auto_increment,
    jedan tinyint,
    dva tinyint,
    tri tinyint,
    cetiri tinyint,
    pet tinyint,
    sest tinyint,
    maximum tinyint,
    minimum tinyint,
    dvaPara tinyint,
    skala tinyint,
    full tinyint,
    poker tinyint,
    jamb tinyint
);

alter table igra add foreign key (igrac) references igrac(sifra);
alter table igra add foreign key (partija) references partija(sifra);

alter table partija add foreign key (dolje) references kolona(sifra);
alter table partija add foreign key (gore) references kolona(sifra);
alter table partija add foreign key (sloboda) references kolona(sifra);
alter table partija add foreign key (najava) references kolona(sifra);
alter table partija add foreign key (rucno) references kolona(sifra);



insert into igrac (ime,prezime,korisnickoIme) 
    values ('Karlo','Kapl','KKaplo'),
    ('Mirko','Maslarić','Mirko123'),
    ('Vanja','Dobša','Vanjci'),
    ('Petar','Murati','Pera'),
    ('Vlaho','Kravarščan','Vlaho33');

insert into kolona(jedan,dva,tri,cetiri,pet,sest,maximum,minimum,dvaPara,skala,full,poker,jamb)
    values(5,10,15,20,25,30,30,5,32,45,58,64,80);
