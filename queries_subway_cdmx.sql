/*  * Name: Luis Mauricio Hernandez Rodriguez * Username: hernanluis * ID: 300412504 */
/* Some queries are different to what was requested 
because they make more sense this way for this particular
subway system. Anyway they illustrate the same requested concepts  */

/* Selects stops from a route*/
select stops.stop_id as "STOP ID",stop_name as "STOP NAME", 
zone_name as "ZONE", last_stop as "LAST STOP ID", next_stop as "NEXT STOP ID",
route_name as "ROUTE" from stops join zones join routes inner join
connections on stops.stop_id=connections.stop_id and
connections.route_id=12 and routes.route_id=connections.route_id and
zones.zone_id=stops.stop_zone order by zones.zone_id;

/*Affected stops*/
select stop_name as  "STOP NAME" ,dis_name as  "DISRUPTION NAME", 
dis_startD as  "START DAY",dis_startM  "START MONTH",dis_startY  "START YEAR",
dis_endD  "END DAY",dis_endM  "END MONTH",dis_endY  "END YEAR" from 
stops inner join disruptions on 
stops.stop_id=disruptions.dis_stop;

/*NEVER AFFECTED STOPS*/
select stop_name as  "STOP NAME" from 
stops where stops.stop_id not in
(select disruptions.dis_stop from disruptions);

/*Most affected routes*/
select count(*) as "NUMBER OF DISRUPTIONS",
	case
		when disruptions.dis_route=1 then 
		(select route_name from routes where routes.route_id=1)
		when disruptions.dis_route=2 then 
		(select route_name from routes where routes.route_id=2)
		when disruptions.dis_route=3 then
		(select route_name from routes where routes.route_id=3)
		when disruptions.dis_route=4 then 
		(select route_name from routes where routes.route_id=4)
		when disruptions.dis_route=5 then 
		(select route_name from routes where routes.route_id=5)
		when disruptions.dis_route=6 then 
		(select route_name from routes where routes.route_id=6)
		when disruptions.dis_route=7 then 
		(select route_name from routes where routes.route_id=7)
		when disruptions.dis_route=8 then 
		(select route_name from routes where routes.route_id=8)
		when disruptions.dis_route=9 then 
		(select route_name from routes where routes.route_id=9)
		when disruptions.dis_route=10 then 
		(select route_name from routes where routes.route_id=10)
		when disruptions.dis_route=11 then 
		(select route_name from routes where routes.route_id=11)
		when disruptions.dis_route=12 then 
		(select route_name from routes where routes.route_id=12)
		end as "ROUTE NAME"
		from disruptions 
		group by "ROUTE NAME"
		order by  "NUMBER OF DISRUPTIONS" desc limit 5;

		/*Least affected routes*/
select count(*) as "NUMBER OF DISRUPTIONS",
	case
		when disruptions.dis_route=1 then 
		(select route_name from routes where routes.route_id=1)
		when disruptions.dis_route=2 then 
		(select route_name from routes where routes.route_id=2)
		when disruptions.dis_route=3 then
		(select route_name from routes where routes.route_id=3)
		when disruptions.dis_route=4 then 
		(select route_name from routes where routes.route_id=4)
		when disruptions.dis_route=5 then 
		(select route_name from routes where routes.route_id=5)
		when disruptions.dis_route=6 then 
		(select route_name from routes where routes.route_id=6)
		when disruptions.dis_route=7 then 
		(select route_name from routes where routes.route_id=7)
		when disruptions.dis_route=8 then 
		(select route_name from routes where routes.route_id=8)
		when disruptions.dis_route=9 then 
		(select route_name from routes where routes.route_id=9)
		when disruptions.dis_route=10 then 
		(select route_name from routes where routes.route_id=10)
		when disruptions.dis_route=11 then 
		(select route_name from routes where routes.route_id=11)
		when disruptions.dis_route=12 then 
		(select route_name from routes where routes.route_id=12)
		end as "ROUTE NAME"
		from disruptions 
		group by "ROUTE NAME"
		order by  "NUMBER OF DISRUPTIONS" asc limit 5;
		
/*AFFECTED ROUTES AND STOPS  SINCE 2013*/
select stop_name as  "STOP NAME",route_name as "ROUTE NAME",dis_name as  "DISRUPTION NAME", 
dis_startD as  "START DAY",dis_startM  "START MONTH",dis_startY  "START YEAR",
dis_endD  "END DAY",dis_endM  "END MONTH",dis_endY  "END YEAR" from routes join 
stops inner join disruptions on 
stops.stop_id=disruptions.dis_stop and disruptions.dis_startY>2012
and routes.route_id=disruptions.dis_route;

		
	





