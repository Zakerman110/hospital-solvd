package com.solvd.hospital.Classes;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.solvd.hospital.Interfaces.MyPredicate;
import org.apache.log4j.Logger;

import com.solvd.hospital.Exceptions.IncorrectRangeException;
import com.solvd.hospital.Exceptions.NotFoundException;

public class Transport extends Vehicle {

    private String model;
    private int year;
    private static final Logger LOGGER = Logger.getLogger(Transport.class);

    public Transport(int wheels, int seats, String licenseNumber, TreeMap<LocalDate, Double> fuelConsumptionPerDay, String model, int year) {
        super(wheels, seats, licenseNumber, fuelConsumptionPerDay);
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public TreeMap<LocalDate, Double> getLastDaysConsumption(int lastNDays) throws NotFoundException, IncorrectRangeException {
        if(getFuelConsumptionPerDay().isEmpty())
        {
            LOGGER.error("No fuel consumption data");
            throw new NotFoundException("No fuel consumption data");
        }
        int size = getFuelConsumptionPerDay().size();
        if(size < lastNDays)
        {
            LOGGER.error("Too many days inserted");
            throw new IncorrectRangeException("Too many days inserted", size);
        }
        long count = getFuelConsumptionPerDay().entrySet().size();
        Stream<Map.Entry<LocalDate, Double>> stream = getFuelConsumptionPerDay().entrySet().stream();

        Map<LocalDate, Double> result = stream.skip(count - lastNDays).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return new TreeMap<>(result);
    }

    public TreeMap<LocalDate, Double> getConsumption(MyPredicate predicate)
    {
        TreeMap<LocalDate, Double> result = new TreeMap<>();

        Stream<Map.Entry<LocalDate, Double>> stream = getFuelConsumptionPerDay().entrySet().stream();
        stream.forEach(s -> {
            if(predicate.test(s.getValue())) result.put(s.getKey(), s.getValue());
        });

        return result;
    }
}
