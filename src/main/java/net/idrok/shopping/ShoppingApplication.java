package net.idrok.shopping;
import net.idrok.shopping.entity.*;
import net.idrok.shopping.repository.UserRepository;
import net.idrok.shopping.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.annotation.PostConstruct;

import java.time.LocalDateTime;


@SpringBootApplication
public class ShoppingApplication {



	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);

		
	}

	 private final UserRepository userRepository;
	public ShoppingApplication(UserRepository userRepository, PasswordEncoder encoder, JwtUtil jwtUtil) {
		this.userRepository = userRepository;
		this.encoder = encoder;
		this.jwtUtil = jwtUtil;
	}

	private final PasswordEncoder encoder;

	final Logger LOG = LoggerFactory.getLogger(ShoppingApplication.class.getName());

	@PostConstruct
	public void definePrimaryAdmin(){

		if(userRepository.findByLogin("admin").isEmpty()){
			User user = new User();
			user.setFirstName("oybek");
			user.setLastName("botirov");
			user.setLogin("admin123");
			user.setPassword(encoder.encode("admin123"));
			user.setActive(true);
			user.setRegTime(LocalDateTime.now());
			user.setRole(Role.ADMIN);
			userRepository.save(user);

			ProductCategory productCategory = new ProductCategory();
			productCategory.setCategoryName("telefon");
			Discount discount = new Discount();
			discount.setPercent("50");
			Brand brand = new Brand();
			brand.setName("samsung");



		}


	}

	private final JwtUtil jwtUtil;

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
