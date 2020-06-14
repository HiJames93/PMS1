package cn.james.pms_1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.james.pms_1.dao")
public class Pms1Application {

    public static void main(String[] args) {
        SpringApplication.run(Pms1Application.class, args);
    }

}
