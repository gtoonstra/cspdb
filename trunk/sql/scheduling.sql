drop database scheduling;

create database scheduling;

use scheduling;

create table course (
    course_id	int primary key,
    course_name varchar( 50 ),
    frequency   int
);

create table professor (
    prof_id     int primary key,
    prof_name 	varchar( 50 )
);

create table room (
    room_id    int primary key,
    room_name  varchar( 50 )
);

create table faculty (
	faculty_id  int primary key
);

create table timeslot (
    timeslot_id int primary key,
    slot_name   varchar( 50 )
);

create table student (
    student_id int primary key,
    student_name varchar( 50 )
);

create table student_has_course (
    student_id int,
    course_id int
);

create table prof_can_lecture_course (
    prof_id int,
    course_id int
); 

create table faculty_provides_course (
    faculty_id int,
    course_id int
);

create table faculty_has_room (
	faculty_id int,
	room_id int
);

create table prof_not_available (
    prof_id int,
    timeslot_id int
);

create table room_in_use (
    room_id int,
    timeslot_id int
);

create table course_at_time (
    course_id int,
    timeslot_id int
);

create table professor_lectures_at_time (
    prof_id int,
    timeslot_id int
);

create table course_provided (
    course_id int,
    num_times int
);

create table tuple (
    room_id int,
    course_id int,
    prof_id int,
    timeslot_id int
);

create table solution (
	solution_id int,
	score int,
    room_id int,
    course_id int,
    prof_id int,
    timeslot_id int	
);

insert into course( course_id, course_name, frequency ) values ( 1, "Databases", 1 );
insert into course( course_id, course_name, frequency ) values ( 2, "Physics", 2 );
insert into course( course_id, course_name, frequency ) values ( 3, "Cognitive Psychology", 2 );

insert into course_provided( course_id, num_times ) values ( 1, 0 );
insert into course_provided( course_id, num_times ) values ( 2, 0 );
insert into course_provided( course_id, num_times ) values ( 3, 0 );

insert into professor( prof_id, prof_name ) values ( 1, "Smith" );
insert into professor( prof_id, prof_name ) values ( 2, "Jones" );

insert into room( room_id, room_name ) values ( 1, "R101" );
insert into room( room_id, room_name ) values ( 2, "R202" );
insert into room( room_id, room_name ) values ( 3, "R303" );
insert into room( room_id, room_name ) values ( 4, "Auditorium" );

insert into faculty( faculty_id ) values ( 1 );
insert into faculty( faculty_id ) values ( 2 );
insert into faculty( faculty_id ) values ( 3 );

insert into timeslot( timeslot_id, slot_name ) values ( 1, "A" );
insert into timeslot( timeslot_id, slot_name ) values ( 2, "B" );
insert into timeslot( timeslot_id, slot_name ) values ( 3, "C" );
insert into timeslot( timeslot_id, slot_name ) values ( 4, "D" );

insert into student( student_id, student_name ) values ( 1, "Abel" );
insert into student( student_id, student_name ) values ( 2, "Ben" );
insert into student( student_id, student_name ) values ( 3, "Cibelle" );

insert into student_has_course( student_id, course_id ) values ( 1, 1 );
insert into student_has_course( student_id, course_id ) values ( 1, 2 );
insert into student_has_course( student_id, course_id ) values ( 2, 1 );
insert into student_has_course( student_id, course_id ) values ( 2, 3 );
insert into student_has_course( student_id, course_id ) values ( 3, 3 );

insert into prof_can_lecture_course( prof_id, course_id ) values ( 1, 1 );
insert into prof_can_lecture_course( prof_id, course_id ) values ( 1, 2 );
insert into prof_can_lecture_course( prof_id, course_id ) values ( 2, 2 );
insert into prof_can_lecture_course( prof_id, course_id ) values ( 2, 3 );

insert into faculty_provides_course( faculty_id, course_id ) values ( 1, 1 );
insert into faculty_provides_course( faculty_id, course_id ) values ( 2, 2 );
insert into faculty_provides_course( faculty_id, course_id ) values ( 3, 3 );

insert into faculty_has_room( faculty_id, room_id ) values ( 2, 1 );
insert into faculty_has_room( faculty_id, room_id ) values ( 1, 2 );
insert into faculty_has_room( faculty_id, room_id ) values ( 3, 3 );
insert into faculty_has_room( faculty_id, room_id ) values ( 1, 4 );
insert into faculty_has_room( faculty_id, room_id ) values ( 3, 4 );

insert into prof_not_available( prof_id, timeslot_id ) values ( 1, 1 );
insert into prof_not_available( prof_id, timeslot_id ) values ( 2, 4 );

select s.solution_id, s.score, r.room_name, c.course_name, p.prof_name, t.slot_name 
from room r, course c, professor p, timeslot t, solution s 
where s.room_id = r.room_id and s.course_id = c.course_id and s.prof_id = p.prof_id and s.timeslot_id = t.timeslot_id
order by s.score, s.solution_id asc;
		
