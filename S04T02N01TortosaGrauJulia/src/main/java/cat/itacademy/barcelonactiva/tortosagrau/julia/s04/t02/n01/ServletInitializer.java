package cat.itacademy.barcelonactiva.tortosagrau.julia.s04.t02.n01;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(S04T02N01TortosaGrauJuliaApplication.class);
	}

}
