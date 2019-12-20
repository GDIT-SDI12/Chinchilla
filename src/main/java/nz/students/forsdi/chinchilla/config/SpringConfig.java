package nz.students.forsdi.chinchilla.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("nz.students.forsdi.chinchilla.controllers")
public class SpringConfig {
}
