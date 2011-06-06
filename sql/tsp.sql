drop database tsp;

create database tsp;

use tsp;

create table city (
	id 			int primary key,
	x   		int,
	y   		int,
	city_name 	varchar( 50 )
);

create table city_distance (
	id_1		int,
	id_2		int,
	distance	float,
	primary key( id_1, id_2 )
);

create table city_visited (
	id			int primary key,
	visited		int
);

create table route (
	id_1		int,
	id_2		int,
	distance	float,
	primary key( id_1, id_2 )
);

insert into city( id, x, y, city_name ) values ( 1,  4, 10, 'Amsterdam' );
insert into city( id, x, y, city_name ) values ( 2,  0,  5, 'Hague' );
insert into city( id, x, y, city_name ) values ( 3,  2,  0, 'Rotterdam' );
insert into city( id, x, y, city_name ) values ( 4, 10, 4, 'Utrecht' );

insert into city_distance( id_1, id_2, distance ) values ( 1, 2, 6.403 );
insert into city_distance( id_1, id_2, distance ) values ( 1, 3, 10.198 );
insert into city_distance( id_1, id_2, distance ) values ( 1, 4, 8.485 );
insert into city_distance( id_1, id_2, distance ) values ( 2, 1, 6.403 );
insert into city_distance( id_1, id_2, distance ) values ( 2, 3, 5.385 );
insert into city_distance( id_1, id_2, distance ) values ( 2, 4, 10.050 );
insert into city_distance( id_1, id_2, distance ) values ( 3, 1, 10.198 );
insert into city_distance( id_1, id_2, distance ) values ( 3, 2, 5.385 );
insert into city_distance( id_1, id_2, distance ) values ( 3, 4, 8.944 );
insert into city_distance( id_1, id_2, distance ) values ( 4, 1, 8.485 );
insert into city_distance( id_1, id_2, distance ) values ( 4, 2, 10.050 );
insert into city_distance( id_1, id_2, distance ) values ( 4, 3, 8.944 );

insert into city_visited( id, visited ) values ( 1, 0 );
insert into city_visited( id, visited ) values ( 2, 0 );
insert into city_visited( id, visited ) values ( 3, 0 );
insert into city_visited( id, visited ) values ( 4, 0 );
