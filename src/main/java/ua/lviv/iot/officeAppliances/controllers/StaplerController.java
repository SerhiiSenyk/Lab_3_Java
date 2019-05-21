/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.lviv.iot.officeAppliances.controllers;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.officeAppliances.models.Material;
import ua.lviv.iot.officeAppliances.models.Stapler;
import ua.lviv.iot.officeAppliances.repositories.StaplerRepository;

/**
 *
 * @author Serhii-PC
 */
//  .   ____          _            __ _ _
// /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
//( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
// \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
//  '  |____| .__|_| |_|_| |_\__, | / / / /
// =========|_|==============|___/=/_/_/_/
//Лабораторна №9
//Дана лабораторна присвячена розробці першого рест-сервісу з використанням мови  Java з 
//використанням бібліотеки JAR-RS Інформацію про REST можна взяти з вікі 
//
//
//1)Задачею 9 лаборатоної є створити REST  сервіс для одного з класів ,створених у
//лабораторній роботі 3 (наприклад для класу алігатор ),в котрому реалізовані CRUD-опрації
//(Get/Post/Put/Delete)над ресурсом
//2)Операція get має використовувати id в url-запиту :/resources/aligator/20
//3)Для реалізацї REST сервісу базовий клас з 3 лаби слід розширити полем ID (типу Integer)
//та добавити set/get методи
//4)Методи класу Service мають використовувати код 8 лаби для збереження та пошукку даних в 
//табличках бази даних.
//5)Стандартні плагіни
//6)Пул реквест
//7)ПРИ оголошенні атрибутів в класі Service слід використовувати інтерфейси рівня доступу до даних 
//,а не реалізацію де це можливо
@RestController
public class StaplerController {

    @Autowired
    private StaplerRepository staplerRepository;

    //Get всіх у базі даних
    @RequestMapping(value = "/stapler", method = RequestMethod.GET)
    public List<Stapler> getAllStaplers() {
        List<Stapler> staplerList = new LinkedList<>();
        staplerRepository.findAll().forEach(staplerList::add);
        if (staplerList.isEmpty()){
            return null;
        } else {
            return staplerList;
        }
    }

    //GET  по ID
    @RequestMapping(value = "/stapler/{id}", method = RequestMethod.GET)
    public Stapler getStapler(@PathVariable Integer id) {
        if (staplerRepository.findById(id).isPresent()) {
            return staplerRepository.findById(id).get();
        } else {
            return null;
        }
    }

    //ПОСТ - збереження одного обєкта в базі даних
    @RequestMapping(value = "/stapler", method = RequestMethod.POST)
    public Stapler postStapler(@RequestBody Stapler stapler) {
        return staplerRepository.save(stapler);
    }

    //PUT
    @RequestMapping(value = "/stapler/{id}", method = RequestMethod.PUT)
    public Stapler replaceStapler(@RequestBody Stapler newStapler, @PathVariable Integer id) {
        return staplerRepository.findById(id)
                .map(oldStapler -> {//якщо є така id то перезаписуємо її
                    oldStapler.setColor(newStapler.getColor());
                    oldStapler.setMaterial(newStapler.getMaterial());
                    oldStapler.setPower(newStapler.getPower());
                    oldStapler.setPrice(newStapler.getPrice());
                    oldStapler.setProducer(newStapler.getProducer());
                    oldStapler.setStaplesSize(newStapler.getStaplesSize());
                    oldStapler.setWeight(newStapler.getWeight());
                    return staplerRepository.save(oldStapler);
                }).orElseGet(() -> {//інакше записуємо по новій  id
                    return staplerRepository.save(newStapler);
                });
               
    }

    //DELETE - видалення  обєкта по id
    @RequestMapping(value = "/stapler/{id}", method = RequestMethod.DELETE)
    public void deleteStapler(@PathVariable Integer id) {
        if (staplerRepository.findById(id).isPresent()) {
            staplerRepository.deleteById(id);
        }
    }
 
}
