package com.fedorov.spring.rest;

import com.fedorov.spring.rest.configuration.MyConfig;
import com.fedorov.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class App 
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication",
                Communication.class);

        
        List<Employee> allEmployees = communication.getAllEmployees();
        System.out.println(allEmployees);

        Employee empById = communication.getEmployee(1);
        System.out.println(empById);

        Employee emp = new Employee("Sveta2", "Sokolova2",
                "IT", 1600);
        emp.setId(4); // вносим изменения в существующую строку, иначе будет создана новая строка
        communication.saveEmployee(emp);

         communication.deleteEmployee(7);

    }
}
