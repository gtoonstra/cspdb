drop database zebra;

create database zebra;

use zebra;

create table house (
    house_id int primary key,
    house_name varchar( 50 )
);

create table color (
    color_id int primary key,
    color_name varchar( 50 )
);

create table nationality (
	nat_id int primary key,
	nat_name varchar( 50 ) 
);

create table drink (
    drink_id int primary key,
    drink_name varchar( 50 )
);

create table smoke (
    smoke_id int primary key,
    smoke_name varchar( 50 )
);

create table pet ( 
    pet_id int primary key,
    pet_name varchar( 50 )
);

create table house_relations (
    rel_id	 int primary key,
    house_id int,
    color_id int,
    nat_id   int,
    drink_id int,
    smoke_id int,
    pet_id   int
);

CREATE INDEX id_house USING BTREE ON house_relations( house_id );
CREATE INDEX id_color USING BTREE ON house_relations( color_id );
CREATE INDEX id_nat USING BTREE ON house_relations( nat_id );
CREATE INDEX id_drink USING BTREE ON house_relations( drink_id );
CREATE INDEX id_smoke USING BTREE ON house_relations( smoke_id );
CREATE INDEX id_pet USING BTREE ON house_relations( pet_id );

create table rel_next_rel (
   rel_id_1 int,
   rel_id_2 int,
   PRIMARY KEY( rel_id_1, rel_id_2 )
);

create table tuple (
    house_id int primary key,
    color_id int,
    nat_id   int,
    drink_id int,
    smoke_id int,
    pet_id   int
);

create table solution (
	solution_id int,
	score int,
    house_id int,
    color_id int,
    nat_id   int,
    drink_id int,
    smoke_id int,
    pet_id   int,
    PRIMARY KEY( solution_id, house_id )
);

insert into house( house_id, house_name ) values ( 1, 'house_1' );
insert into house( house_id, house_name ) values ( 2, 'house_2' );
insert into house( house_id, house_name ) values ( 3, 'house_3' );
insert into house( house_id, house_name ) values ( 4, 'house_4' );
insert into house( house_id, house_name ) values ( 5, 'house_5' );

insert into color( color_id, color_name ) values ( 1, 'red' );
insert into color( color_id, color_name ) values ( 2, 'green' );
insert into color( color_id, color_name ) values ( 3, 'ivory' );
insert into color( color_id, color_name ) values ( 4, 'yellow' );
insert into color( color_id, color_name ) values ( 5, 'blue' );

insert into nationality( nat_id, nat_name ) values ( 1, 'Englishman' );
insert into nationality( nat_id, nat_name ) values ( 2, 'Ukrainian' );
insert into nationality( nat_id, nat_name ) values ( 3, 'Spaniard' );
insert into nationality( nat_id, nat_name ) values ( 4, 'Norwegian' );
insert into nationality( nat_id, nat_name ) values ( 5, 'Japanese' );

insert into drink( drink_id, drink_name ) values ( 1, 'coffee' );
insert into drink( drink_id, drink_name ) values ( 2, 'tea' );
insert into drink( drink_id, drink_name ) values ( 3, 'milk' );
insert into drink( drink_id, drink_name ) values ( 4, 'orange_juice' );
insert into drink( drink_id, drink_name ) values ( 5, 'water' );

insert into smoke( smoke_id, smoke_name ) values ( 1, 'Old_Gold' );
insert into smoke( smoke_id, smoke_name ) values ( 2, 'Kool' );
insert into smoke( smoke_id, smoke_name ) values ( 3, 'Chesterfield' );
insert into smoke( smoke_id, smoke_name ) values ( 4, 'Lucky_Strike' );
insert into smoke( smoke_id, smoke_name ) values ( 5, 'Parliaments' );

insert into pet( pet_id, pet_name ) values ( 1, 'dog' );
insert into pet( pet_id, pet_name ) values ( 2, 'snails' );
insert into pet( pet_id, pet_name ) values ( 3, 'fox' );
insert into pet( pet_id, pet_name ) values ( 4, 'horse' );
insert into pet( pet_id, pet_name ) values ( 5, 'zebra' );

insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 1,  NULL,    1,    1, NULL, NULL, NULL );
insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 2,  NULL, NULL,    3, NULL, NULL,    1 );
insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 3,  NULL,    2, NULL,    1, NULL, NULL );
insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 4,  NULL, NULL,    2,    2, NULL, NULL );
insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 5,  NULL, NULL, NULL, NULL,    1,    2 );
insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 6,  NULL,    4, NULL, NULL,    2, NULL );
insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 7,  NULL, NULL, NULL,    4,    4, NULL ); 
insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 8,  NULL, NULL,    5, NULL,    5, NULL );
insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 9,     3, NULL, NULL,    3, NULL, NULL );
insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 10,    1, NULL,    4, NULL, NULL, NULL );

insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 11, NULL,    2, NULL, NULL, NULL, NULL );
insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 12, NULL,    3, NULL, NULL, NULL, NULL );

insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 13, NULL, NULL, NULL, NULL,    3, NULL );
insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 14, NULL, NULL, NULL, NULL, NULL,    3 );

insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 15, NULL, NULL, NULL, NULL,    2, NULL );
insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 16, NULL, NULL, NULL, NULL, NULL,    4 );

insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 17, NULL, NULL,    4, NULL, NULL, NULL );
insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 18, NULL,    5, NULL, NULL, NULL, NULL );

insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 19, NULL, NULL, NULL,    5, NULL, NULL );
insert into house_relations( rel_id, house_id, color_id, nat_id, drink_id, smoke_id, pet_id ) values ( 20, NULL, NULL, NULL, NULL, NULL,    5 );

insert into rel_next_rel( rel_id_1, rel_id_2 ) values ( 13, 14 );
insert into rel_next_rel( rel_id_1, rel_id_2 ) values ( 14, 13 );

insert into rel_next_rel( rel_id_1, rel_id_2 ) values ( 15, 16 );
insert into rel_next_rel( rel_id_1, rel_id_2 ) values ( 16, 15 );

insert into rel_next_rel( rel_id_1, rel_id_2 ) values ( 17, 18 );
insert into rel_next_rel( rel_id_1, rel_id_2 ) values ( 18, 17 );

insert into rel_next_rel( rel_id_1, rel_id_2 ) values ( 11, 12 );
insert into rel_next_rel( rel_id_1, rel_id_2 ) values ( 12, 11 );

select s.solution_id, s.score, h.house_name, c.color_name, n.nat_name, d.drink_name, sm.smoke_name, pet.pet_name
from house h, color c, nationality n, drink d, smoke sm, pet pet, solution s 
where s.house_id = h.house_id and s.color_id = c.color_id and s.nat_id = n.nat_id and s.drink_id = d.drink_id and
s.smoke_id = sm.smoke_id and s.pet_id = pet.pet_id
order by s.score, s.solution_id asc;