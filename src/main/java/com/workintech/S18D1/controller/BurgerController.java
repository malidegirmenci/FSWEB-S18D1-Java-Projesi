package com.workintech.S18D1.controller;

import com.workintech.S18D1.dao.BurgerDao;


import com.workintech.S18D1.entity.BreadType;
import com.workintech.S18D1.entity.Burger;
import com.workintech.S18D1.util.BurgerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/burgers")
public class BurgerController {
    private final BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger) {
        BurgerValidation.checkName(burger.getName());
        return burgerDao.save(burger);
    }

    @GetMapping("/{id}")
    public Burger findById(@PathVariable long id) {
        return burgerDao.findById(id);
    }

    @GetMapping
    public List<Burger> findAll() {
        return burgerDao.findAll();
    }

    @PutMapping
    public Burger update(@RequestBody Burger burger) {

        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable long id) {
        return burgerDao.remove(id);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable String breadType){
        BreadType bt = BreadType.valueOf(breadType);
        return burgerDao.findByBreadType(bt);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable Integer price){
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable String content){
        return burgerDao.findByContent(content);
    }

}
