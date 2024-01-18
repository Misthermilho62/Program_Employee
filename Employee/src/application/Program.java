package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> list = new ArrayList<Employee>();
		
		System.out.print("Enter the number of employees: ");
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			System.out.println("Employee #" + (i + 1) + " data:");
			System.out.print("Outsourced (y/n)? ");
			char resp = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String nameEmployee = sc.nextLine();
			System.out.print("Hours: ");
			int hoursEmployee = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHourEmployee = sc.nextDouble();
			if (resp == 'y') {
				System.out.print("Additional charge: ");
				double additionalChargeOutsourcedEmployee = sc.nextDouble();
				list.add(new OutsourcedEmployee(nameEmployee, hoursEmployee, valuePerHourEmployee, additionalChargeOutsourcedEmployee));
				
			} else {
				list.add(new Employee(nameEmployee, hoursEmployee, valuePerHourEmployee));
				
			}
			
		}
		
		System.out.println();
		System.out.println("PAYMENTS:");
		for (Employee emp : list) {
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
		}
		
		
		sc.close();

	}

}
