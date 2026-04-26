package org.bubududu;

import ch.qos.logback.core.joran.conditional.ElseAction;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private RestTemplate restTemplate;//declaring as a global variable
    public EmployeeService(EmployeeRepository employeeRepository,RestTemplate restTemplate) //initialize the constructor(inject the dependency class)
    {
        this.employeeRepository = employeeRepository;
        this.restTemplate=restTemplate; //--assign it to ba global variable

    }
    public Employee createEmployee(Employee employee) {

        Employee e = null;
        System.out.println("employee " + employee.getJobStatusCode());
        System.out.println("employee " + employee.getEmployeeName());

        if (employee.getJobStatusCode().equals("A") &&
                (employee.getEmployeeName().equals("Kshama"))) {
           ResponseEntity rb = restTemplate.getForObject("http://localhost:8080/{ssn}/SSN", ResponseEntity.class, 777);
            System.out.println("Printing" + rb.getStatusCode());
            e = employeeRepository.save(employee);
        } else {
            e = new Employee();
        }
        return e;
    }
    public Employee CreateEmployeePost(Employee employee)
    {
     Employee emp =new Employee();
     emp.EmployeeID=852889;
     emp.employeeName="Kshama";
     emp.jobStatusCode="a";
     Employee response=restTemplate.postForObject("http://localhost:8080/Postdetails",emp,Employee.class);
        return emp;
    }
    public Order CreateOrder(Order order) {
        Order o = new Order();
        o.orderName = "SOAP";
        o.orderId = 1;
        try {
            Order response = restTemplate.postForObject("http://localhost:8080/Orderdetails", o, Order.class);
        }
        catch (Exception e){
            System.out.println(o.getOrderId());
            System.out.println(o.getOrderName());
        }
        return o;
    }
    }
  //  private RestTemplate restTemplate;
  //  public EmployeeService(RestTemplate restTemplate){
  //      this.restTemplate=restTemplate;



