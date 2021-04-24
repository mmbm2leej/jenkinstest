package com.countryapp.assignment.controller;


import com.countryapp.assignment.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;

import java.util.*;

import com.countryapp.assignment.services.CountryService;

@Controller
public class HomeController
{

    @Autowired
    CountryService cServ;

    @RequestMapping(value="/", method = RequestMethod.GET)  // what request methdo here, its get
    public String welcome(Model model)
    {
        List<Country> resList = cServ.getCountryList();
        model.addAttribute("country", new Country());
        model.addAttribute("countries", resList);

        return "index";
    }

    @RequestMapping(value="/{country_name}",method = RequestMethod.GET)  // what request methdo here, its get
    public String getInfo(@PathVariable(name="country_name") String name, Model model)
    {
        Country res = cServ.getCountry(name);

        model.addAttribute("country", res);
        return "getinfo";
    }

    //this is for the page
    @RequestMapping(value="/addnew",method = RequestMethod.GET)
    public String showCountryForm(Model model)
    {
        Country c = new Country();
        model.addAttribute(c);
        return "newcountry";
    }

    @RequestMapping(value="/newsave",method = RequestMethod.POST)
    public String saveCountryNew(@Valid @ModelAttribute("country") Country c,
                              BindingResult bindRes, Model model)
    {
        if (bindRes.hasErrors()) {
                model.addAttribute(c);
                return "newcountry";
        } else {
            cServ.saveCountry(c);
            return "redirect:/";
        }
    }

    @RequestMapping(value="/editsave",method = RequestMethod.POST)
    public String saveCountryEdit(@Valid @ModelAttribute("country") Country c,
                              BindingResult bindRes, Model model)
    {
        if (bindRes.hasErrors()) {
            model.addAttribute(c);
            return "edit_country";
        } else {
            cServ.saveCountry(c);
            return "redirect:/";
        }
    }
/*
    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("user") User user,
                             BindingResult bindingResult, Model model) {
        System.out.println(user);

        if (bindingResult.hasErrors()) {
            List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
            model.addAttribute("listProfession", listProfession);

            return "register_form";
        } else {
            return "register_success";
        }
    }
*/
    @RequestMapping("/edit/{country_id}")
    public ModelAndView showEditPage(@PathVariable(name="country_id") Long id)
    {
        ModelAndView mav = new ModelAndView("edit_country");
        Country c = cServ.findByID(id);
        mav.addObject("country",c);
        return mav;
    }

    /*

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditEmployeePage(@PathVariable(name="id") long id)
    {
        ModelAndView mav = new ModelAndView("edit_employee");
        Employee e = empService.get(id);
        mav.addObject("employee",e);
        return mav;
    }


     */

}
