package center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*自动扫描 （接口或其他） ，默认扫包范围是本类*/
/*@EnableAutoConfiguration
@ComponentScan(basePackages = {"org.cyj.controller","org.cyj.controller2"} )*/
@SpringBootApplication
public class RunApp {

    public static void main(String[] args) {

        SpringApplication.run(RunApp.class,args);

    }

}
