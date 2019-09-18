package com.imooc.bigdata.hos;

import com.imooc.bigdata.hos.mybatis.HosDataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@SuppressWarnings("deprecation")
@EnableAutoConfiguration(exclude = MongoAutoConfiguration.class)
@Configuration
@ComponentScan({"com.imooc.bigdata.*"})
@SpringBootApplication
@Import({HosDataSourceConfig.class, HosServerBeanConfiguration.class})
@MapperScan("com.imooc.bigdata")
public class HosServerApp implements CommandLineRunner{

  @Autowired
  private ApplicationContext context;


  public static void main(String[] args) {
    SpringApplication.run(HosServerApp.class, args);
  }


  @Override
  public void run(String... args) throws Exception {

  }
}
