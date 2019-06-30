package com.view;

import java.util.List;
import java.util.Scanner;

import com.bo.SearchBO;
import com.bo.SearchBoImpl;
import com.exception.BusinessException;
import com.model.Trainee;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to trainee search APP V1.0");
		System.out.println("======================================");

		int ch = 0;
		SearchBO searchBO=new SearchBoImpl();
		do {
			System.out.println("Search Trainee Menu");
			System.out.println("---------------------");
			System.out.println("1)By Id");
			System.out.println("2)By Name");
			System.out.println("3)By Salary");
			System.out.println("4)By Contact Number");
			System.out.println("5)By Gender");
			System.out.println("6)Exit");
			System.out.println("Enter your choice(1-6):");
			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.out
						.println("Invalid option please enter choice between 1 to 6");
			}
			switch (ch) {
			case 1:
				System.out.println("Enter trainee id");
				try{
				int id = Integer.parseInt(scanner.nextLine());
				//Code here for BO layer
				Trainee trainee=searchBO.getTraineeById(id);
				if(trainee!=null){
					System.out.println("trainee found with id "+id+" details are");
					System.out.println(trainee);
				}
				}catch (NumberFormatException e) {
					System.out.println("id should be only number... Please select your choice again");
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Enter name");
				String name = scanner.nextLine();
				List<Trainee> traineeNameList = null;
				try{
				    traineeNameList=searchBO.getTraineesByName(name);
				    if (traineeNameList!=null && traineeNameList.size()>0){
                        System.out.println("We found "+traineeNameList.size()+" no of trainee/s with name "+name);
                        for(Trainee t:traineeNameList){
                            System.out.println(t);
                        }
                    }
                }catch (BusinessException e){
				    System.out.println(e.getMessage());
                }
				break;
			case 3:
				System.out.println("Under progress");

				break;
			case 4:
				System.out.println("Under progress");

				break;
			case 5:
				System.out.println("Enter gender(m/M/f/F");
				String gender=scanner.nextLine();
				// code here for BO
				List<Trainee> traineeList=null;
				try {
					traineeList=searchBO.getTraineesByGender(gender);
					if(traineeList!=null && traineeList.size()>0){
						System.out.println("We found "+traineeList.size()+" no of trainee/s with gender "+gender);
						for(Trainee t:traineeList){
							System.out.println(t);
						}
					}
				} catch (BusinessException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6:
				System.out
						.println("Thankq for using trainee search app... see u soon :)");

				break;

			default:
				System.out
						.println("Invalid option please enter choice between 1 to 6");
				break;
			}

		} while (ch != 6);
	}

}
