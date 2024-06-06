package com.edubridge.myacapp.main;
import java.util.List;
import java.util.Scanner;

import javax.xml.crypto.Data;

import com.edubridge.myacapp.model.ac;
import com.edubridge.myacapp.model.ac;
import com.edubridge.myacapp.service.acService;
import com.edubridge.myacapp.service.acServiceImpl;

public class acMainApp {
	
	
	
		public static void main(String[] args) {
			
			acServiceImpl service = new acServiceImpl();
			ac c = null;
			
			
			Scanner in = new Scanner(System.in);
			int Option;
			do {
				System.out.println("Welcome to ac app");
				System.out.println("**********************");
				System.out.println("1. Add ac");
				System.out.println("2. View ac");
				System.out.println("3. Serch ac");
				System.out.println("4. update ac");
				System.out.println("5. Delete ac");
				System.out.println("6. Delete all acs");
				System.out.println("0. Exit");
				System.out.println("Please choose the option");

				Option = in.nextInt();
				switch (Option) {
				case 1:
					System.out.println("Add new ac");
					System.out.println("---------------");
					System.out.println("please enter id : ");
					int id = in.nextInt();

					System.out.println("please enter name : ");
					String name = in.next();
					System.out.println("please enter cost  : ");
					float cost = in.nextFloat();
					System.out.println("please enter dop");
				    String dop = in.next();
				    System.out.println("please enter colour");
				    String colour = in.next();
				    
					c = new ac();
					c.setId(id);
					c.setName(name);
					c.setCost(cost);
					c.setDop(dop);
					c.setColour(colour);
					
					int status = service.addac(c);
					if(status== 1) {
						System.out.println("new ac added!");
					}else {
						System.out.println("something is wrong!");
					}
					
					break;
				case 2:
					System.out.println("view  ac");
					List<ac> acs= service.findac();
					
					System.out.println("NAME\tCOST\tDOP\tCOLOUR");
					System.out.println("----\t-----\t-----\t");
					
					for(ac ac:acs) {
						System.out.println(ac.getName()+"\t"+ac.getCost()+"\t"+ac.getDop()+"\t"+ac.getColour());
					}
					break;
				case 3:
					System.out.println("Search ac");
					System.out.println("please enter ac name : ");
					String searchname = in.next();
					ac searchac = service.findacByName(searchname);
					if (searchac !=null) {
						System.out.println("id:"+searchac.getId());
						System.out.println("id:"+searchac.getName());
						System.out.println("id:"+searchac.getCost());
						System.out.println("id:"+searchac.getDop());
						System.out.println("id:"+searchac.getColour());

						

					}else {
						System.out.println("no ac found!");
					}
					break;
				case 4:
					System.out.println("Update ac");
					System.out.println("-------------------");
					
					System.out.println("please enter ac name : ");
					searchname = in.next();
					searchac =service.findacByName(searchname);
					
					if(searchac !=null ) {
						
						//displaying existing contact details
						System.out.println("id:"+searchac.getId());
						System.out.println("id:"+searchac.getName());
						System.out.println("id:"+searchac.getCost());
						System.out.println("id:"+searchac.getDop());
						System.out.println("id:"+searchac.getColour());

						//perform update operation
						
						System.out.println("please enter updated name : ");
						 name = in.next();
						System.out.println("please enter updated cost : ");
						cost = in.nextFloat();
						System.out.println("please enter updated dop");
						dop =  in.next();
						
						System.out.println("please enter updated colour");
						colour = in.next();
						
						ac updateac = new ac();
						
						updateac.setName(name);
						updateac.setCost(cost);
						updateac.setDop(dop);
						updateac.setColour(colour);
						updateac.setId(searchac.getId());

						
						int updateStatus = service.updateac(updateac);
						if(updateStatus ==1) {
							System.out.println("ac updated succesfully");
						}else {
							System.out.println("something is wrong!");
						}
						
					}else {
						System.out.println("no ac found with name");
					}
					
					
					break;
				case 5:
					System.out.println("Delete ac");
					
					System.out.println("please enter ac name : ");
					searchname = in.next();
					
					searchac = service.findacByName(searchname);
					
					if(searchac !=null) {
						int deleteStatus = service.deleteacByName(searchname);
						if(deleteStatus ==1) {
							System.out.println("ac deleted succefully");
						}else {
							System.out.println("something is wrong!");
						}
					}else {
						System.out.println("no ac found!");
					}
					
					break;
				case 6:
					System.out.println(" are you sure Delete All acs?[y/n]");
				
					String deleteConfrimstatus = in.next();
					if(deleteConfrimstatus.equalsIgnoreCase("y")) {
					service.deleteAllacs();
					
					System.out.println("all ac deleted!");
					
					
					}
					break;
				case 0:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Option");
					break;

				}

			} while (Option != 0);

		}

	}



