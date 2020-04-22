package com.activity.tracker.user.controller;

import com.activity.tracker.model.Employee;
import com.activity.tracker.user.service.EmployeeService;
import com.activity.tracker.user.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController extends BaseController{

    @Autowired
    TeamService teamService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee/create")
    public String getCreate(ModelMap model, @RequestParam(value = "id", required = false) Integer id,
                            @RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "success", required = false) String success) {
        model.addAttribute("teams", teamService.getAllTeams());

        Employee employee = new Employee();
        if(id != null) {
             employee = employeeService.findById(id);
        }


        model.addAttribute("employee", employee);
        return route( model, "user/employee/create");
    }

    @PostMapping("/employee/create")
    public String postCreate(@ModelAttribute Employee employee ) {
        try {
            employeeService.save(employee);
            ModelMap model = new ModelMap();
        } catch (Exception ex){
            return "redirect:/employee/create?error=true";
        }
        return "redirect:/employee/create?id="+employee.getId()+"&success=true";
    }
}
