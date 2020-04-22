package com.activity.tracker.user.controller;

import com.activity.tracker.model.Activity;
import com.activity.tracker.model.Employee;
import com.activity.tracker.user.service.ActivityService;
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
public class ActivityController extends BaseController{

    @Autowired
    TeamService teamService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ActivityService activityService;


    @GetMapping("/activity/create")
    public String getCreate(ModelMap model, @RequestParam(value = "id", required = false) Integer id,
                            @RequestParam(value = "employeeId", required = false) Integer employeeId,
                            @RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "success", required = false) String success) {
        Employee employee = new Employee();
        Activity activity = new Activity();
        if(employeeId != null) {
             employee = employeeService.findById(employeeId);
        }
        if(id != null) {
             activity = activityService.findById(id);
        }

        model.addAttribute("employee", employee);
        model.addAttribute("activity", activity);
        model.addAttribute("employees", employeeService.getAll());
        return route( model, "user/employee/create");
    }

    @PostMapping("/activity/create")
    public String postCreate(@ModelAttribute Activity activity ) {
        try {
            activityService.save(activity);
            ModelMap model = new ModelMap();

        } catch (Exception ex){
            return "redirect:/employee/create?error=true";
        }
        return "redirect:/employee/create?id="+activity.getId()+"&employeeId = "+ activity.getEmployee().getId() +"&success=true";
    }
}
