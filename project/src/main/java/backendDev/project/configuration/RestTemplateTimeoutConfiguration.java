package backendDev.project.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestTemplateTimeoutConfiguration {

    //el tiempo maximo del test veryslow es 30000
    static final int TIMEOUT = 28000;


    @Bean
    RestTemplate restTemplateTimeoutWithRequestFactory() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(TIMEOUT);
        requestFactory.setReadTimeout(TIMEOUT);

        return new RestTemplate(requestFactory);
    }

}
