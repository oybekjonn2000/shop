package net.idrok.shopping;

import io.jsonwebtoken.*;

import net.idrok.shopping.entity.Role;
import net.idrok.shopping.entity.User;
import net.idrok.shopping.repository.UserRepository;
import net.idrok.shopping.security.JwtUtil;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@SpringBootApplication
public class ShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);

		
	}
	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	final Logger LOG = LoggerFactory.getLogger(ShoppingApplication.class.getName());

	@PostConstruct
	public void definePrimaryAdmin(){

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
	@Autowired
	JwtUtil jwtUtil;

	@PostConstruct
	public  void JWTsinov(){
//		String jwt = Jwts.builder()
//				.setSubject("admin123")
//				.setIssuedAt(Date.from(Instant.now()))
//				.claim("ism" ,"Oybek")
//				.claim("Role", "admin")
//				.signWith(SignatureAlgorithm.HS256, "salom")
//				.compact();
//		LOG.info(jwt);
//
//
//		String jwt2 = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbjEyMyIsImlhdCI6MTY0OTEzMTE3MCwiaXNtIjoiT3liZWsiLCJSb2xlIjoiYWRtaW4ifQ.SfuiZ1660tQyUzxAoYKxkGbegXBF7xc-NEoUMT7Znks";
//
//		Jws<Claims> claims=	Jwts.parser()
//				.setSigningKey("salom")
//				.parseClaimsJws(jwt2);
//		LOG.info("Subject:=>"+claims.getBody().getSubject());
//
	String token = jwtUtil.generateToken("admin123", "admin");
	LOG.info(token);
	LOG.info("LOgin:" + jwtUtil.getLogin(token));
	LOG.info("Role:" + jwtUtil.getRole(token));
	}
	
}
