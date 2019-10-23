package org.mentor.spring.controller;

import org.mentor.spring.model.User;
import org.mentor.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MyController {

    private UserService userService;

    @Autowired
    public void setFilmService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView userForm() {
        ModelAndView modelAndView = new ModelAndView();
        List list = userService.listData();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("usertable");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public ModelAndView deleteUser(@RequestParam String id) {
        userService.deleteUser(id);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/admin/create", method = RequestMethod.POST)
    public ModelAndView createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.GET)
    public ModelAndView updateUser(@RequestParam String id) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.getUserById(id);
        modelAndView.addObject("id", id);
        modelAndView.addObject("newName", user.getName());
        modelAndView.addObject("newPassword", user.getPassword());
        modelAndView.addObject("role", user.getRole());
        modelAndView.setViewName("update");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return new ModelAndView("redirect:/");
    }
}
