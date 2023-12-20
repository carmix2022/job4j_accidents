package ru.job4j.accidents.repository;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
@Repository
public class AccidentMem {
    private static final AccidentMem INSTANCE = new AccidentMem();
    private final AtomicInteger nextId = new AtomicInteger(0);
    private final Map<Integer, Accident> accidents = new ConcurrentHashMap<>();

    private AccidentMem() {
        save(new Accident(0, "name1", "description1", "address1"));
        save(new Accident(0, "name2", "description2", "address2"));
        save(new Accident(0, "name3", "description3", "address3"));
        save(new Accident(0, "name4", "description4", "address4"));
    }

    public static AccidentMem getInstance() {
        return INSTANCE;
    }

    public Accident save(Accident accident) {
        accident.setId(nextId.incrementAndGet());
        accidents.put(accident.getId(), accident);
        return accident;
    }

    public Collection<Accident> findAll() {
        return accidents.values();
    }
}
