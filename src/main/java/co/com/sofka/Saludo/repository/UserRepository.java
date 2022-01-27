package co.com.sofka.Saludo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.com.sofka.Saludo.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
	public UserModel findByNombre(String name);
}