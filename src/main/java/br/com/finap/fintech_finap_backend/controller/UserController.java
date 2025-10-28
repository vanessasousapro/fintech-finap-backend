package br.com.finap.fintech_finap_backend.controller;

import br.com.finap.fintech_finap_backend.model.User;
import br.com.finap.fintech_finap_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    // Método responsável criar um novo usuário no banco de dados
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    //Método reponsável por buscar usuários pelo Id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
     public User findById(@PathVariable Long id) {
        return userService.searchById(id);
     }

     // Método responsável por listas todos os usuários
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll() {
        return userService.searchAll();
    }

    // Método reponsável por apagar um usuário
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }

    // Método reponsável por atualizar um usuário
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userService.update(id, user);
    }
}
