package com.example.connectingoracle.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.connectingoracle.domain.model.Employees;
import com.example.connectingoracle.domain.repository.EmployeesRepository;

/**
 * HelloWorldController
 */
public class HelloWorldController {

    /**
     * 労働者Repository
     */
    @Autowired
    EmployeesRepository employeesRepository;


    /**
     *
     *
     * @param model ?
     * @return
     */
    @RequestMapping(name = "/", method = RequestMethod.GET)
    public String helloWorld(Model model) {
        model.addAttribute("message", "こんにちは世界");

        System.out.println("[START] ORALCEに接続して従業員データを取得します。");
        Page<Employees> emps = employeesRepository.findAll(new PageRequest(0, 10));
        for (Employees emp : emps) {
            System.out.println(emp.getId() + " : " + emp.getName() + " : " + emp.getEmail());
        }
        System.out.println("[END  ] ORALCEに接続して従業員データを取得します。");

        return "index";
    }

    @RequestMapping(name = "/", method = RequestMethod.POST)
    public String nameToMessage(@RequestParam("name") String name, Model model) {
        model.addAttribute("message", "こんにちは" + name + "さん");

        return "index";
    }
}
