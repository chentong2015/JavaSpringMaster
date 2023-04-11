package demo.services;

import demo.entity.User;
import demo.transaction.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserCrudService {

    private UserCrudRepository repository;

    @Autowired
    public UserCrudService(UserCrudRepository repository) {
        this.repository = repository;
    }

    public Page<User> findAllByNameAndEmail(Pageable pageable) {
        return repository.findAllByNameAndEmail("name1", "test@test.com", pageable);
    }
}
