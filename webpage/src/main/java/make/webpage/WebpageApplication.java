package make.webpage;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import com.p6spy.engine.spy.P6SpyOptions;
import make.webpage.service.CustomP6spySqlFormat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class WebpageApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebpageApplication.class, args);
	}

	@Bean
	Hibernate5Module hibernate5Module(){
		Hibernate5Module hibernate5Module = new Hibernate5Module();
		//hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true);
		return hibernate5Module;
	}
	@Configuration
	public class P6spyLogMessageFormatConfiguration {
		@PostConstruct
		public void setLogMessageFormat() {
			P6SpyOptions.getActiveInstance().setLogMessageFormat(CustomP6spySqlFormat.class.getName());
		}
	}
}
