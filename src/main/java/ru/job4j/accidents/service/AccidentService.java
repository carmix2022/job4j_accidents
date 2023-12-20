package ru.job4j.accidents.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.repository.AccidentMem;

import java.util.Collection;

@ThreadSafe
@Service
public class AccidentService {
    private final AccidentMem accidentRepository;

    public AccidentService(AccidentMem accidentRepository) {
        this.accidentRepository = accidentRepository;
    }

    public Collection<Accident> findAll() {
        return accidentRepository.findAll();
    }
}
