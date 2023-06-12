package com.example.case_study_module3.controller;

import com.example.case_study_module3.model.Employee;
import com.example.case_study_module3.model.infomation.employee.Division;
import com.example.case_study_module3.model.infomation.employee.Education;
import com.example.case_study_module3.model.infomation.employee.Position;
import com.example.case_study_module3.service.EmployeeService;
import com.example.case_study_module3.service.EmployeeServiceImpl;
import com.example.case_study_module3.until.InputUntil;
import com.example.case_study_module3.until.RegexLibrary;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = {"/Employees", ""})
public class EmployeeServlet extends HttpServlet implements RegexLibrary {
    EmployeeService service = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "update":
                showUpdateForm(request,response);
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            case "search":
//                searchUserForm(request,response);
                break;
            default:
                listEmployee(request, response);
                break;
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = service.findById(id);
        request.setAttribute("employee",employee);
        request.setAttribute("positions", service.positionAll());
        request.setAttribute("educations", service.educationAll());
        request.setAttribute("divisions", service.divisionAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/update.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        service.delete(id);
        try {
            response.sendRedirect("/Employees");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("positions", service.positionAll());
        request.setAttribute("educations", service.educationAll());
        request.setAttribute("divisions", service.divisionAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = service.findALL();
        List<Position> positions = service.positionAll();
        List<Education> educations = service.educationAll();
        List<Division> divisions = service.divisionAll();
        request.setAttribute("employees", employees);
        request.setAttribute("positions", positions);
        request.setAttribute("educations", educations);
        request.setAttribute("divisions", divisions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "update":
                updateEmployee(request,response);
                break;
            case "delete":
                break;
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        boolean result = false;
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idcard");
        double salary = 0;
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int education = Integer.parseInt(request.getParameter("education"));
        int division = Integer.parseInt(request.getParameter("division"));
        if (name.isEmpty()||name.length()>50) {
            result = true;
            request.getSession().setAttribute("errorName","Enter the wrong name!");
        }
        if (birthday.isEmpty()){
            result = true;
            request.getSession().setAttribute("errorDate","Enter the wrong date!");
        }
        if (InputUntil.inputRegex(idCard,IDCARD)){
            result = true;
            request.getSession().setAttribute("errorIdCard","Enter the wrong id card!");
        }
        if(InputUntil.inputDouble(request.getParameter("salary"))){
            result = true;
            request.getSession().setAttribute("errorSalary","Enter the wrong salary!");
        }else {
            salary = Double.parseDouble(request.getParameter("salary"));
        }
        if(InputUntil.inputRegex(phone,PHONE_NUMBER)){
            result = true;
            request.getSession().setAttribute("errorPhone", "Enter the wrong phone!");
        }
        if(InputUntil.inputRegex(email,EMAIL_REGEX)){
            result = true;
            request.getSession().setAttribute("errorEmail", "Enter the wrong email!");
        }
        if(address.length() <= 0){
            result = true;
            request.getSession().setAttribute("errorPhone", "Enter the wrong address!");
        }
        if (result){
            try {
                response.sendRedirect("/Employees?action=create");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, education, division);
            service.update(id,employee);
            try {
                response.sendRedirect("/Employees");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        boolean result = false;
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idcard");
        double salary = 0;
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int position = Integer.parseInt(request.getParameter("position"));
        int education = Integer.parseInt(request.getParameter("education"));
        int division = Integer.parseInt(request.getParameter("division"));
        if (name.isEmpty()||name.length()>50) {
            result = true;
            request.getSession().setAttribute("errorName","Enter the wrong name!");
        }
        if (birthday.isEmpty()){
            result = true;
            request.getSession().setAttribute("errorDate","Enter the wrong date!");
        }
        if (InputUntil.inputRegex(idCard,IDCARD)){
            result = true;
            request.getSession().setAttribute("errorIdCard","Enter the wrong id card!");
        }
        if(InputUntil.inputDouble(request.getParameter("salary"))){
            result = true;
            request.getSession().setAttribute("errorSalary","Enter the wrong salary!");
        }else {
            salary = Double.parseDouble(request.getParameter("salary"));
        }
        if(InputUntil.inputRegex(phone,PHONE_NUMBER)){
            result = true;
            request.getSession().setAttribute("errorPhone", "Enter the wrong phone!");
        }
        if(InputUntil.inputRegex(email,EMAIL_REGEX)){
            result = true;
            request.getSession().setAttribute("errorEmail", "Enter the wrong email!");
        }
        if(address.length() <= 0){
            result = true;
            request.getSession().setAttribute("errorPhone", "Enter the wrong address!");
        }
        if (result){
            try {
                response.sendRedirect("/Employees?action=update");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            Employee employee = new Employee(1, name, birthday, idCard, salary, phone, email, address, position, education, division);
            service.save(employee);
            try {
                response.sendRedirect("/Employees");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
