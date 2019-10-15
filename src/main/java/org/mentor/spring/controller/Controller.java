package org.mentor.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class Controller {

    @RequestMapping (value = "/", method = RequestMethod.GET)
    public ModelAndView  userForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/WEB-INF/index.jsp");
        return modelAndView;
    }
}
