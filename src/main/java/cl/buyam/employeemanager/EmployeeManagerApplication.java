package cl.buyam.employeemanager;

import cl.buyam.employeemanager.model.Employee;
import cl.buyam.employeemanager.repo.EmployeeRepo;
import cl.buyam.employeemanager.service.EmployeeService;
//import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
//import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;

//import java.util.Arrays;
//import java.util.Collections;
import java.util.List;
//import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
@RestController
public class EmployeeManagerApplication {

	@Autowired
	private EmployeeService employeeService;

	//@Autowired
	//private EmployeeRepo employeeRepo;

	/*public EmployeeManagerApplication(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}*/

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagerApplication.class, args);
	}

	@Bean
	@RequestMapping("/getAllEmployees")
	public Supplier<List<Employee>> getAllEmployees() {
		System.out.println("Getting all employees 1.");
		return employeeService::findAllEmployees;
		//return () -> employeeRepo.findAll();
	}

	/*@Bean
	public Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> getAll() {

		return value -> {
			APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
			responseEvent.setBody(value.getBody());
			responseEvent.setStatusCode(201);
			responseEvent.setHeaders(Collections.singletonMap("Content-type", "application/json"));
			return responseEvent;
		};
	}*/

	/*@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://employeemanager-dev.s3-website-sa-east-1.amazonaws.com",
				"http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin",
				"Content-Type", "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept",
				"Authorization", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}*/
}
