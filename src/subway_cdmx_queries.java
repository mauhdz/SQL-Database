/* 
 * Name: Luis Mauricio Hernandez Rodriguez
 * Username: hernanluis
 * ID: 300412504
 */

import java.sql.*;
public class subway_cdmx_queries {

	public static void main(String[] args) {

		String url = "jdbc:sqlite:final_sub.sqlite"; 
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			
			//Selects all stops that have had disruptions
			System.out.println("STOPS THAT HAVE HAD DISRUPTIONS:");
			System.out.println("................................................................................");
			String query1 = "select stop_name as  \"STOP NAME\" ,dis_name as  \"DISRUPTION NAME\","
					+ "dis_startD as  \"START DAY\",dis_startM  \"START MONTH\",dis_startY  \"START YEAR\","
					+ "dis_endD  \"END DAY\",dis_endM  \"END MONTH\",dis_endY  \"END YEAR\" from "
					+ "stops inner join disruptions on stops.stop_id=disruptions.dis_stop";
			
			ResultSet rs1 = stmt.executeQuery(query1);
			System.out.println(String.format("%-25s|","STOP NAME") + " " + String.format("%-13s|","DISRUPTION NAME") +
					" " + String.format("%-3s|", "START DAY") + " " +  String.format("%-3s|","START MONTH" + " " + 
							String.format("%-3s|","START YEAR" + " " + String.format("|%-3s|", "END DAY") + " " +
									String.format("%-3s|","END MONTH") + " " + String.format("%-3s","END YEAR"))));	
			System.out.println("................................................................................");
			while (rs1.next()) {
				String stopName = rs1.getString("STOP NAME");
				String disName = rs1.getString("DISRUPTION NAME");
				int dis_startD= rs1.getInt("START DAY");
				int dis_startM= rs1.getInt("START MONTH");
				int dis_startY= rs1.getInt("START YEAR");
				int dis_endD= rs1.getInt("END DAY");
				int dis_endM= rs1.getInt("END MONTH");
				int dis_endY= rs1.getInt("END YEAR");
				System.out.println(String.format("%-25s|",stopName) + " " + String.format("%-13s|", disName) + 
						" " + String.format("%-3s|", dis_startD) + " " +  String.format("%-3s|",dis_startM) + " " + 
						String.format("%-3s|",dis_startY + " " + String.format("|%-3s|", dis_endD) + " " +
								String.format("%-3s|",dis_endM) + " " +  String.format("%-3s",dis_endY)));
			}
			System.out.println("................................................................................");
			//Selects all stops that have never had disruptions
			String query2 ="select stop_name as  \"STOP NAME\" from stops where"
					+ " stops.stop_id not in (select disruptions.dis_stop from disruptions)";
			ResultSet rs2 = stmt.executeQuery(query2);
			System.out.println("STOPS THAT HAVE NEVER HAD DISRUPTIONS:");
			System.out.println("................................................................................");
			System.out.println(String.format("%-25s|","STOP NAME"));	
			System.out.println("................................................................................");
			while (rs2.next()) {
				String stopName = rs2.getString("STOP NAME");
				System.out.println(String.format("%-25s|",stopName));
			}
			
			System.out.println("................................................................................");
			
		/*	//AFECTED STOPS SINCE 2013 
		
			System.out.println("AFECTED STOPS SINCE 2013 :");
			System.out.println("................................................................................");
			
			String query3 = AFFECTED ROUTES AND STOPS  SINCE 2013
					"select stop_name as  \"STOP NAME\",route_name as \"ROUTE NAME\",dis_name as  \"DISRUPTION NAME\", "
					+ "dis_startD as  \"START DAY\",dis_startM  \"START MONTH\",dis_startY  \"START YEAR\","
					+ "dis_endD  \"END DAY\",dis_endM  \"END MONTH\",dis_endY  \"END YEAR\" from routes join "
					+ "stops inner join disruptions on stops.stop_id=disruptions.dis_stop and"
					+ " disruptions.dis_startY>2012 and routes.route_id=disruptions.dis_route";
			
			ResultSet rs3 = stmt.executeQuery(query1);
			
			System.out.println(String.format("%-25s|","STOP NAME") + " " + 	String.format("%-13s|","ROUTE NAME") + ""
			+ String.format("%-13s|","DISRUPTION NAME") + " " + String.format("%-3s|", "START DAY") + " " + 
			String.format("%-3s|","START MONTH" + " " + String.format("%-3s|","START YEAR" + " " + 
			String.format("|%-3s|", "END DAY") + " " +
			String.format("%-3s|","END MONTH") + " " + String.format("%-3s","END YEAR"))));	
			
			System.out.println("................................................................................");
			
			while (rs3.next()) {
				String stopName = rs3.getString("STOP NAME");
				String disRoute = rs3.getString( "ROUTE NAME");
				String disName = rs3.getString("DISRUPTION NAME");
				int dis_startD= rs3.getInt("START DAY");
				int dis_startM= rs3.getInt("START MONTH");
				int dis_startY= rs3.getInt("START YEAR");
				int dis_endD= rs3.getInt("END DAY");
				int dis_endM= rs3.getInt("END MONTH");
				int dis_endY= rs3.getInt("END YEAR");
				System.out.println(String.format("%-25s|",stopName) + " " +String.format("%-13s|", disRoute) + " " + 
				String.format("%-13s|", disName) + " " + String.format("%-3s|", dis_startD) + " " + 
				String.format("%-3s|",dis_startM) + " " + String.format("%-3s|",dis_startY + " " + 
				String.format("|%-3s|", dis_endD) + " " + String.format("%-3s|",dis_endM) + " " +
				String.format("%-3s",dis_endY)));
			}
			
			System.out.println("................................................................................");*/
			
		/*	//Selects all stops that have never had disruptions
			String query4 = "select count(*) as \"NUMBER OF DISRUPTIONS\","
					+ "case"
					+ "when disruptions.dis_route=1 then"
					+ "(select route_name from routes where routes.route_id=1)"
					+ "when disruptions.dis_route=2 then"
					+ "(select route_name from routes where routes.route_id=2)"
					+ "when disruptions.dis_route=3 then"
					+ "(select route_name from routes where routes.route_id=3)"
					+ "when disruptions.dis_route=4 then"
					+ "(select route_name from routes where routes.route_id=4)"
					+ "when disruptions.dis_route=5 then"
					+ "(select route_name from routes where routes.route_id=5)"
					+ "when disruptions.dis_route=6 then"
					+ "(select route_name from routes where routes.route_id=6)"
					+ "when disruptions.dis_route=7 then"
					+ "(select route_name from routes where routes.route_id=7)"
					+ "when disruptions.dis_route=8 then"
					+ "(select route_name from routes where routes.route_id=8)"
					+ "when disruptions.dis_route=9 then"
					+ "(select route_name from routes where routes.route_id=9)"
					+ "when disruptions.dis_route=10 then"
					+ "(select route_name from routes where routes.route_id=10)"
					+ "when disruptions.dis_route=11 then"
					+ "(select route_name from routes where routes.route_id=11)"
					+ "when disruptions.dis_route=12 then"
					+ "(select route_name from routes where routes.route_id=12)"
					+ "end as \"ROUTE NAME\""
					+ "from disruptions"
					+ "group by \"ROUTE NAME\""
					+ "order by  \"NUMBER OF DISRUPTIONS\" desc limit 5";
					
			ResultSet rs4 = stmt.executeQuery(query4);
			System.out.println("TOP 5 OF ROUTES WITH MOST DISRUPTIONS:");
			System.out.println("................................................................................");
			//System.out.println(String.format("%-25s|","STOP NAME"));	
			System.out.println("................................................................................");
			while (rs4.next()) {
				int numberDis = rs4.getInt("NUMBER OF DISRUPTIONS" );
				String routeName=rs4.getString("ROUTE NAME"); 
				System.out.println(String.format("%-25s|",numberDis) + String.format("%-25s|",routeName));
			}*/
		}
		catch (SQLException e) {
			e.printStackTrace(); }	
	}

}


