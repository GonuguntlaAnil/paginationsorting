package com.anil;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.anil.entity.Employee;
import com.anil.repo.EmployeeRepo;

@SpringBootApplication
public class PaginationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctc=SpringApplication.run(PaginationApplication.class, args);
		EmployeeRepo obj = ctc.getBean(EmployeeRepo.class);
		
		
		//sorting descending order using findall(Sort sort) method
		
		Sort desc = Sort.by("empSalary").descending();
		List<Employee> emps = obj.findAll(desc);
		
		emps.forEach(System.out::println);
		
		System.out.println();
		
		
		//pagination with sorting using findall(pageno,pagesize,sortobj);
		 
		
		PageRequest of = PageRequest.of(0,5,desc);
		Page<Employee> all = obj.findAll(of);
		List<Employee> empss = all.getContent();
		empss.forEach(System.out::println);
		
		
		
		
	}

}
