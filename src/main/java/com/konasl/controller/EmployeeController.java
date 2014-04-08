package com.konasl.controller;

import com.konasl.model.Employee;
import com.konasl.util.RestURIConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * Handles requests for the Employee service.
 */
@Controller
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    Map<Integer, Employee> empData = new HashMap<Integer, Employee>();

    @RequestMapping(value = RestURIConstants.DUMMY_EMP, method = RequestMethod.GET)
    public
    @ResponseBody
    Employee getDummyEmployee() {
        logger.info("Start getDummyEmployee");
        Employee emp = new Employee();
        emp.setId(9999);
        emp.setName("Dummy");
        emp.setCreatedDate(new Date());
        empData.put(9999, emp);
        return emp;
    }

    @RequestMapping(value = RestURIConstants.GET_EMP, method = RequestMethod.GET)
    public
    @ResponseBody
    Employee getEmployee(@PathVariable("id") int empId) {
        logger.info("Start getEmployee. ID=" + empId);

        return empData.get(empId);
    }

    @RequestMapping(value = RestURIConstants.GET_ALL_EMP, method = RequestMethod.GET)
    public
    @ResponseBody
    List<Employee> getAllEmployees() {
        logger.info("Start getAllEmployees.");
        List<Employee> emps = new ArrayList<Employee>();
        Set<Integer> empIdKeys = empData.keySet();
        for (Integer i : empIdKeys) {
            emps.add(empData.get(i));
        }
        return emps;
    }

    @RequestMapping(value = RestURIConstants.CREATE_EMP, method = RequestMethod.POST)
    public
    @ResponseBody
    Employee createEmployee(@RequestBody Employee emp) {
        logger.info("Start createEmployee.");
        emp.setCreatedDate(new Date());
        empData.put(emp.getId(), emp);
        return emp;
    }

    @RequestMapping(value = RestURIConstants.DELETE_EMP, method = RequestMethod.PUT)
    public
    @ResponseBody
    Employee deleteEmployee(@PathVariable("id") int empId) {
        logger.info("Start deleteEmployee.");
        Employee emp = empData.get(empId);
        empData.remove(empId);
        return emp;
    }

}