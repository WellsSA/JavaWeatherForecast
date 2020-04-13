package br.usjt.javaweatherforecast.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.javaweatherforecast.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	public User findOneByLoginAndPassword(String login, String password);
}
