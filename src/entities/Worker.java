package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department departament;
	private List<HourContract> contrats = new ArrayList<>();
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department departament) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartament() {
		return departament;
	}

	public void setDepartament(Department departament) {
		this.departament = departament;
	}

	public List<HourContract> getContrats() {
		return contrats;
	}

	public void AddContract(HourContract contract) {
		contrats.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contrats.remove(contract);
	}
	
	public double income(Integer year, Integer month) {
		double sum = baseSalary;
		Calendar calendar = Calendar.getInstance();
		for(HourContract c : contrats) {
			calendar.setTime(c.getDate()); //pegando a data do contrato
			int c_year = calendar.get(Calendar.YEAR); //pegando o ano e passando para a variavel
			int c_month = 1 + calendar.get(Calendar.MONTH);// pegando o mês e passando para a variavel
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
}
