package com.konasl.controller;

import com.konasl.model.Employee;
import com.konasl.util.RestURIConstants;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

public class TestSpringRestExample {
    public static final String SERVER_URI = "http://localhost:8080";

    public static void main(String args[]){

        testGetDummyEmployee();
        System.out.println("*****");
        testCreateEmployee();
        System.out.println("*****");
        testGetEmployee();
        System.out.println("*****");
        testGetAllEmployee();
    }

    private static void testGetAllEmployee() {
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI+ RestURIConstants.GET_ALL_EMP, List.class);
        System.out.println(emps.size());
        for(LinkedHashMap map : emps){
            System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
        }
    }

    private static void testCreateEmployee() {
        RestTemplate restTemplate = new RestTemplate();
        Employee emp = new Employee();
        emp.setId(1);emp.setName("Pankaj Kumar");
        Employee response = restTemplate.postForObject(SERVER_URI+ RestURIConstants.CREATE_EMP, emp, Employee.class);
        printEmpData(response);
    }

    private static void testGetEmployee() {
        RestTemplate restTemplate = new RestTemplate();
        Employee emp = restTemplate.getForObject(SERVER_URI+"/rest/emp/1", Employee.class);
        printEmpData(emp);
    }

    private static void testGetDummyEmployee() {
        RestTemplate restTemplate = new RestTemplate();
        Employee emp = restTemplate.getForObject(SERVER_URI+ RestURIConstants.DUMMY_EMP, Employee.class);
        printEmpData(emp);
    }

    public static void printEmpData(Employee emp){
        System.out.println("ID="+emp.getId()+",Name="+emp.getName()+",CreatedDate="+emp.getCreatedDate());
    }
}