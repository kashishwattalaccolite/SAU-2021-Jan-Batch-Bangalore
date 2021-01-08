drop database worldcup;
create database worldcup;
use worldcup;
create table batsmen(bat_id int primary key,bat_name varchar(20), runs int, matches int);
create table bowlers(bowl_id int primary key, bowl_name varchar(20), wickets int, matches int);
create table teams(team_id int primary key, team_name varchar(20), matches int, total_score int);
create table matches(match_id int primary key, team1_id int, team2_id int, team1_score int, team2_score int);

insert into batsmen values(1, "Rohit", 214, 2);
insert into batsmen values(2, "Matt", 256, 2);
insert into batsmen values(3, "Shreyas", 191, 2);
insert into batsmen values(4, "Andrew", 160, 2);
insert into batsmen values(5, "Steve", 125, 2);
insert into batsmen values(6, "Jos", 165, 2);
insert into batsmen values(7, "Shahid", 149, 2);

insert into bowlers values(1, "Ravi", 4, 2);
insert into bowlers values(2, "Trent", 8, 2);
insert into bowlers values(3, "Adam", 6, 2);
insert into bowlers values(4, "Zaheer", 11, 2);
insert into bowlers values(5, "Josh", 9, 2);
insert into bowlers values(6, "Jaspreet", 11, 2);
insert into bowlers values(7, "Ben", 10, 2);

insert into teams values(1, "India", 2, 460);
insert into teams values(2, "Aus", 2, 560);
insert into teams values(3, "Eng", 2, 480);
insert into teams values(4, "Pak", 2, 400);
insert into teams values(5, "NZ", 2, 700);
insert into teams values(6, "SL", 2, 390);

insert into matches values(1, 1, 2, 210, 320);
insert into matches values(2, 1, 3, 250, 250);
insert into matches values(3, 2, 3, 240, 230);
insert into matches values(4, 4, 5, 220, 400);
insert into matches values(5, 4, 6, 180, 175);
insert into matches values(6, 5, 6, 300, 215);

select * from batsmen order by runs desc limit 5;

select * from bowlers order by wickets desc limit 5;

select total_score/matches as team_avg, team_name from teams;

drop procedure if exists highest_score;
Delimiter $$
create procedure highest_score(in country varchar(20), out qty int)
begin
declare qty1 int;
declare qty2 int;
select max(team1_score) into qty1 from matches inner join teams on matches.team1_id=teams.team_id where teams.team_name=country;
select max(team2_score) into qty2 from matches inner join teams on matches.team2_id=teams.team_id where teams.team_name=country; 
select if(qty1 is null, 0, qty1) into qty1; 
select if(qty2 is null, 0, qty2) into qty2; 
select greatest(qty1, qty2) into qty;
end $$
Delimiter ;

call highest_score("India",@ans);
select @ans;
