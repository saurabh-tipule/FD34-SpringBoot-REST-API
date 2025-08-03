package com.cjc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cjc.app.model.Employee;
import com.cjc.app.model.Laptop;
import com.cjc.app.repository.EmployeeRepository;
import com.cjc.app.repository.LaptopRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		Laptop lap = laptopRepository.findById(1).get();

		System.out.println("Laptop Id :" + lap.getLid());
		System.out.println("Laptop Name :" + lap.getLapName());
		System.out.println("Laptop Color :" + lap.getColor());
		System.out.println("Laptop Price :" + lap.getPrice());

		System.out.println("Employee Id :" + lap.getEmp().getEid());
		System.out.println("Employee Name :" + lap.getEmp().getEname());
		System.out.println("Employee Designation :" + lap.getEmp().getDesignation());
		System.out.println("Employee Salary :" + lap.getEmp().getSalary());

	}

	private static void insertRecord(LaptopRepository laptopRepository) {
		Laptop lap = new Laptop();
		lap.setLid(1);
		lap.setLapName("Asus");
		lap.setColor("Navy");
		lap.setPrice(52000);

		Employee emp = new Employee();
		emp.setEid(1001);
		emp.setEname("John");
		emp.setDesignation("Tester");
		emp.setSalary(40000);

		// assign laptop to Employee
		emp.setLap(lap);

		// assign employee to laptop
		lap.setEmp(emp);

		// save Object in Database
		laptopRepository.save(lap);
	}

}
