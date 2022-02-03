package controller;

import model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import repositories.SessionRepository;

import java.util.List;

@Controller
@RequestMapping("/api/v1/sessions")
public class SessionController {

    @Autowired
    private SessionRepository repository;

    public List<Session> list() {
        return repository.findAll();
    }

    public Session get(@PathVariable Long id) {
        return repository.getById(id);
    }

    public Session create(@RequestBody final Session session) {
        return repository.saveAndFlush(session);
    }
}
