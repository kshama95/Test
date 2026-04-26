package org.bubududu;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/Details")
        ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee e = employeeService.createEmployee(employee);
        return new ResponseEntity<>(e, HttpStatus.CREATED);

    }
    @GetMapping("/{ssn}/SSN")
      public boolean getssn(@PathVariable int ssn){
        return true;
    }
    @PostMapping("/Get")
       ResponseEntity<Employee> CreateEmployeePost(@RequestBody Employee employee){
        System.out.println("inside post");
        Employee e =employeeService.CreateEmployeePost(employee);
        return new ResponseEntity<>(e,HttpStatus.CREATED);
    }
    @PostMapping("/Postdetails")
       ResponseEntity<Employee> CreateEmployeePostRtrn(@RequestBody Employee employee){
        System.out.println("inside post details"+employee.getEmployeeName());
        return new ResponseEntity<>(employee,HttpStatus.CREATED);

    }
    @PostMapping("/getOrder")
    ResponseEntity<Order> creategetOrder(@RequestBody Order order){
        System.out.println("Inside get oder");
        Order o =employeeService.CreateOrder(order);
        return new ResponseEntity<>(o,HttpStatus.CREATED);
    }
    @PostMapping("/PlaceOrder")
    ResponseEntity<Order> PlaceOrder(@RequestBody Order order) {
        System.out.println("Inside Place order");
        return new ResponseEntity<>(order,HttpStatus.CREATED);
    }
   // @GetMapping("/{employeeName}/PostName")
   //   public String getpol(@PathVariable String employeeName){
   //     return employeeName;
   // }



}

