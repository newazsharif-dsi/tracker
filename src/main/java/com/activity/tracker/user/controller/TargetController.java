package com.activity.tracker.user.controller;

import com.activity.tracker.model.Employee;
import com.activity.tracker.model.Target;
import com.activity.tracker.user.service.EmployeeService;
import com.activity.tracker.user.service.TargetService;
import com.activity.tracker.user.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class TargetController extends BaseController{


    @Autowired
    EmployeeService employeeService;


    @Autowired
    TeamService teamService;

    @Autowired
    TargetService targetService;


    @GetMapping("/target/create")
    public String getCreate(ModelMap model, @RequestParam(value = "id", required = false) Integer id,
                            @RequestParam(value = "employeeId", required = false) Integer employeeId,
                            @RequestParam(value = "teamId", required = false) Integer teamId) {

        Target target = new Target();
        if (employeeId != null) {
            Employee employee = employeeService.findById(employeeId);
            target.setEmployee(employee);
        }
        if (teamId != null) {
            Employee employee = employeeService.findById(employeeId);
            target.setEmployee(employee);
        }

        if (id != null) {
            target = targetService.findById(id);
        }

        model.addAttribute("target", target);
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("teams", teamService.getAllTeams());
        return route(model, "user/target/create");
    }

    @PostMapping("/target/create")
    public String postCreate(ModelMap model, @ModelAttribute Target target) {
        try {
            //TODO:: need validation

            targetService.save(target);

        } catch (Exception ex) {
            return "redirect:/target/create?error=true";
        }
        model.addAttribute("success", true);
        model.addAttribute("target", target);
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("teams", teamService.getAllTeams());
        return route(model, "user/target/create");
    }

}
