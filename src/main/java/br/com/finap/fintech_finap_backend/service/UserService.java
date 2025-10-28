package br.com.finap.fintech_finap_backend.service;

import br.com.finap.fintech_finap_backend.model.User;
import br.com.finap.fintech_finap_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User searchById(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("user not found");
        }
    }

    public List<User> searchAll() {
        return (List<User>) userRepository.findAll();
    }

    public User delete(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            userRepository.delete(user.get());
        } else {
            throw new RuntimeException("user not found");
        }
        return null;
    }

    public User update(Long id, User user) {
        Optional<User> currentUser = userRepository.findById(user.getUserId());
        if (currentUser.isPresent()) {
            return userRepository.save(currentUser.get());
        } else {
            throw new RuntimeException("user not found");
        }
    }
}
