package net.idrok.shopping;

import net.idrok.shopping.entity.Role;
import net.idrok.shopping.entity.User;
import net.idrok.shopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@SpringBootApplication
public class ShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);

		
	}
	@Autowired
	UserRepository userRepository;
	@PostConstruct
	public void definePrimaryAdmin(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if(userRepository.findByLogin("admin123").isEmpty()){
			User user = new User();
			user.setFirstName("Adminstration");
			user.setLogin("admin123");
			user.setPassword(encoder.encode("admin123"));
			user.setActive(true);
			user.setRegTime(LocalDateTime.now());
			user.setRole(Role.ADMIN);
			userRepository.save(user);



		}


	}
	
}
