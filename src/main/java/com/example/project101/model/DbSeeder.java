package com.example.project101.model;

import com.example.project101.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    AdminRepository adminRepository;



    @Override
    public void run(String... args) throws Exception {




        Admin dali = new Admin(
                "0966",
                "laameri",
                "mohamed",
                "mohamed@gmail.com",
                "45a6aaa"
        );

        Admin fares = new Admin(
                "0966",
                "benabd",
                "mohamed",
                "mohamed@gmail.com",
                "45a6aaa"
        );
        //drop collection

        adminRepository.deleteAll();

        //add

        List<Admin> admins = Arrays.asList(dali,fares);
        adminRepository.saveAll(admins);


    }}
