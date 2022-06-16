package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Worker worker;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base salary: ");
		Double baseSalary = sc.nextDouble();
		
		worker = new Worker(workerName, WorkerLevel.valueOf(level), baseSalary, new Department(departmentName));
		
		System.out.print("How many contracts to this worker? ");
		int quant = sc.nextInt();
		sc.nextLine();
		for(int i=1; i<=quant; i++) {
			System.out.println("Enter contract #"+i+" data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date data = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			Integer hours = sc.nextInt();
			
			HourContract contract = new HourContract(data, valuePerHour, hours);
			worker.AddContract(contract);
			
		}
			
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		Date monthYear = sdf2.parse(sc.next());
		int month = monthYear.getMonth()+1;
		int	year = monthYear.getYear()+1900;
		Double income = worker.income(year, month);
		System.out.println("Name: "+ worker.getName());
		System.out.println("Departament: "+ worker.getDepartament().getName());
		System.out.printf("Income for "+month+"/"+year+": %.2f",income);
		sc.close();
	}

}
