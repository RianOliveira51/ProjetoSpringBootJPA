package com.example.portaChamados.config;

import com.example.portaChamados.entities.Called;
import com.example.portaChamados.entities.Technicians;
import com.example.portaChamados.entities.User;
import com.example.portaChamados.entities.enums.CalledStatus;
import com.example.portaChamados.repositories.CalledRepository;
import com.example.portaChamados.repositories.TechniciansRepository;
import com.example.portaChamados.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("dev")
public class Config implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TechniciansRepository techniciansRepository;

    @Autowired
    private CalledRepository calledRepository;

    @Override
    public void run(String... args) throws Exception {

        calledRepository.deleteAll();
        userRepository.deleteAll();
        techniciansRepository.deleteAll();

        User user1 = new User(null, "Rian", "rian-oliveira", "1223434");
        User user2 = new User(null, "Maria", "maria-antonia", "4587");
        User user3 = new User(null, "zé", "jheitor-pagoto", "4578789");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));

        Technicians tec1 = new Technicians(null, "Diego", "diego-martins", "154878");
        Technicians tec2 = new Technicians(null, "Leonardo", "leonardo-mendonça", "154879");
        Technicians tec3 = new Technicians(null, "Jhonatan", "jhonanta", "787844");

        techniciansRepository.saveAll(Arrays.asList(tec1, tec2, tec3));

        Called cal1 = new Called(null, CalledStatus.Open, "Erro Protheus", user1, "");
        Called cal2 = new Called(null, CalledStatus.Closed, "Meu pc não liga", user2, "Problema era tomada");
        Called cal3 = new Called(null, CalledStatus.Open, "Esqueci minha senha", user3, "");
        Called cal4 = new Called(null, CalledStatus.Pendents, "Esqueci minha senha", user1, "Resetado senha");

        calledRepository.saveAll(Arrays.asList(cal1, cal2, cal3, cal4));

        cal4.setTechnicians(tec1);

        calledRepository.save(cal4);
    }
}
