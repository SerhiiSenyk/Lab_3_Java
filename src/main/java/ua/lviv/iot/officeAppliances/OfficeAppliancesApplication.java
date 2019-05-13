package ua.lviv.iot.officeAppliances;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ua.lviv.iot.officeAppliances.models.Color;
import ua.lviv.iot.officeAppliances.models.Material;
import ua.lviv.iot.officeAppliances.models.Stapler;
import ua.lviv.iot.officeAppliances.models.StationeryKnife;
import ua.lviv.iot.officeAppliances.repositories.StaplerRepository;
import ua.lviv.iot.officeAppliances.repositories.StationeryKnifeRepository;

@SpringBootApplication
public class OfficeAppliancesApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfficeAppliancesApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoStapler(StaplerRepository repository) {
        return (args) -> {
            repository.save(new Stapler(0.7, 2, 26.0, new Color(0, 0, 0), 100.0,
                    "Buromax", Material.METAL_PLUS_PLASTIC));
            repository.findAll().forEach(officeAppliance -> System.out.println(officeAppliance));
        };
    }

    @Bean
    public CommandLineRunner demoStationeryKnife(StationeryKnifeRepository repository) {
        return (args) -> {
            repository.save(new StationeryKnife(2.0, 50.0, new Color(128, 128, 128), 0.2, "ABC", Material.METAL));
            repository.findAll().forEach(officeAppliance -> System.out.println(officeAppliance));
        };
    }

}
