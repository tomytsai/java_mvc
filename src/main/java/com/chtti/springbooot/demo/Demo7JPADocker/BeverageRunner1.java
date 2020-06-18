package com.chtti.springbooot.demo.Demo7JPADocker;

import com.chtti.springbooot.demo.Demo7JPADocker.beans.Beverage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class BeverageRunner1 implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(BeverageRunner1.class.getSimpleName());
    @Autowired
    MyBeverageCRUDRepository repository;
    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("start to test beerage repository");
        insertSomeData();
        loadSomeData();
        loadAllData();
        loadDataByPage();
        loadDataByLike();
        loadDataByContaining();
        //deleteAndCheckCount();

    }

    private void loadDataByContaining(){
        LOGGER.info("find detail with milk");
        repository.findByDetailContaining("milk").forEach(b -> LOGGER.info("with milk:{}",b));
        LOGGER.info("find detail with hot");
        repository.findByDetailContaining("hot").forEach(b -> LOGGER.info("with hot:{}",b));

    }

    private void loadDataByLike(){
        LOGGER.info("find hot");
        repository.findByTitleLike("hot%")
                .forEach(beverage -> LOGGER.info("hot prefix:{}",beverage));
        LOGGER.info("find cold");
        repository.findByTitleLike("cold%")
                .forEach(beverage -> LOGGER.info("hot prefix:{}",beverage));


    }
    private void loadDataByPage(){
        LOGGER.info("load data by page");
        PageRequest pr1 =  PageRequest.of(0,4);
        repository.findAll(pr1).forEach(beverage -> {
            LOGGER.info("#{} page:{}", pr1.getPageNumber(), beverage);
        });
        Pageable pageable = pr1.next();
        repository.findAll(pageable).forEach(beverage -> {
            LOGGER.info("#{} page:{}", pageable.getPageNumber(), beverage);
        });


    }

    public void loadSomeData(){
        LOGGER.info("find all americano only");
        repository.findMatchByTitle("americano")
                .forEach(beverage -> LOGGER.info("americano only ==>{}",beverage));
    }

    private void deleteAndCheckCount(){
        LOGGER.info("before delete, count={}",repository.count());
        repository.deleteAll();
        LOGGER.info("after delete, count={}",repository.count());
    }

    private void loadAllData(){
        LOGGER.info("find all data");
        repository.findAll().forEach(beverage -> LOGGER.info("get a record==>{}",beverage));
    }

    private void insertSomeData(){
        repository.save(new Beverage("americano","ice black coffee without milk"));
        repository.save(new Beverage("americano","hot black coffee without milk"));
        repository.save(new Beverage("hot latte","espresso with 60% milk"));
        repository.save(new Beverage("ice latte","espresso with 60% milk"));
        repository.save(new Beverage("hot assam black tea","normal black tea"));
        repository.save(new Beverage("cold assam black tea","normal black tea"));
        repository.save(new Beverage("hot milk tea","black tea with hot milk"));
        repository.save(new Beverage("cold milk tea","black tea with cold milk"));
    }
}
