package br.com.finap.fintech_finap_backend.repository;

import br.com.finap.fintech_finap_backend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
