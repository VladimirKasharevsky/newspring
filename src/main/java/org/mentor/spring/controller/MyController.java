package org.mentor.spring.controller;

import org.mentor.spring.model.User;
import org.mentor.spring.service.UserService;
import org.mentor.spring.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MyController {


    private UserService userService;

    @Autowired
    public void setFilmService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping (value = "/", method = RequestMethod.GET)
    public ModelAndView  userForm() {
        ModelAndView modelAndView = new ModelAndView();
        List list =  userService.listData();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("tableserv");
        return modelAndView;
    }

    @RequestMapping (value = "/admin/delete", method = RequestMethod.POST)
    public ModelAndView  deleteUser(@RequestParam String id) {
        userService.deleteUser(id);
        return userForm();
    }

    @RequestMapping (value = "/admin/create", method = RequestMethod.POST)
    public ModelAndView  createUser(@RequestParam String name, @RequestParam String pass, @RequestParam String role) {
        User user = new User(name, pass, role);
        userService.createUser(user);
        return userForm();
    }

    @RequestMapping (value = "/admin/update", method = RequestMethod.GET)
    public ModelAndView  updateUser(@RequestParam String id) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserById(id);
        modelAndView.addObject("id", id);
        modelAndView.addObject("newName", user.getName());
        modelAndView.addObject("newPassword", user.getPassword());
        modelAndView.addObject("role", user.getRole());
        modelAndView.setViewName("update");
        return modelAndView;
    }

    @RequestMapping (value = "/admin/update", method = RequestMethod.POST)
    public ModelAndView  updateUser(@RequestParam Long id, @RequestParam String newName, @RequestParam String newPassword, @RequestParam String role) {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User(id, newName, newPassword, role);
        userService.updateUser(user);
        return modelAndView;
    }
}
