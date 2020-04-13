package br.usjt.javaweatherforecast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.javaweatherforecast.model.User;
import br.usjt.javaweatherforecast.repository.UserRepository;

@Service
public class LoginService {
	@Autowired
	private UserRepository usuarioRepository;
	
	public boolean login (User user) {
		return usuarioRepository.findOneByLoginAndPassword(user.getLogin(), user.getPassword()) != null;
	}
}