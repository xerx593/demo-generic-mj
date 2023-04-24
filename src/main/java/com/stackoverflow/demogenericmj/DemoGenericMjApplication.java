package com.stackoverflow.demogenericmj;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.stackoverflow.demogenericmj.model.Dep;
import com.stackoverflow.demogenericmj.model.Emp;
import com.stackoverflow.demogenericmj.repo.BaseRepository;

@SpringBootApplication
public class DemoGenericMjApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGenericMjApplication.class, args);
	}

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    CallbackImpl<Emp> callbackEmp(BaseRepository<Emp> repo) {
        return new CallbackImpl<>(repo);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    CallbackImpl<Dep> callbackDep(BaseRepository<Dep> repo) {
        return new CallbackImpl<>(repo);
    }
}
