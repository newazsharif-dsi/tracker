package com.activity.tracker.user.controller;

import com.activity.tracker.model.Activity;
import com.activity.tracker.model.Employee;
import com.activity.tracker.user.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActivityController extends BaseController {

    @Autowired
    TeamService teamService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ActivityService activityService;

    @Autowired
    ProductTypeService productTypeService;


    @GetMapping("/activity/create")
    public String getCreate(ModelMap model, @RequestParam(value = "id", required = false) Integer id,
                            @RequestParam(value = "employeeId", required = false) Integer employeeId,
                            @RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "success", required = false) String success) {
        Activity activity = new Activity();

        //TODO:: Have questions which type should be here

        if (employeeId != null) {
            Employee employee = employeeService.findById(employeeId);
            activity.setEmployee(employee);
        }
        if (id != null) {
            activity = activityService.findById(id);
        }


        model.addAttribute("activity", activity);
        model.addAttribute("productTypes", productTypeService.getAll());
        model.addAttribute("employees", employeeService.getAll());

        return route(model, "user/activity/create");
    }

    @PostMapping("/activity/create")
    public String postCreate(@ModelAttribute Activity activity) {
        try {
            //TODO:: need validation
            activity.setTotalAchievement(activity.getNoOfAchievements() * activity.getAchievementAmount());
            activityService.save(activity);

        } catch (Exception ex) {
            return "redirect:/activity/create?error=true";
        }
        return "redirect:/activity/create?id=" + activity.getId() + "&employeeId = " + activity.getEmployee().getId() + "&success=true";
    }


    @GetMapping("/activity/activityList")
    public String getList(ModelMap model, @RequestParam(value = "employeeId", required = false) Integer employeeId) {

        model.addAttribute("activityList", activityService.getAll());
        return route(model, "user/activity/activityList");
    }
}
