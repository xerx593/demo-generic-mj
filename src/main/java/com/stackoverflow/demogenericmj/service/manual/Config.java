package com.stackoverflow.demogenericmj.service.manual;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stackoverflow.demogenericmj.CallbackImpl;
import com.stackoverflow.demogenericmj.model.Dep;
import com.stackoverflow.demogenericmj.model.Emp;

@Configuration
public class Config {

    @Bean
    AbstractServiceImpl<Emp> empService1(
            @Autowired ObjectProvider<CallbackImpl<Emp>> empCallback) {
        return new AbstractServiceImpl<>() {
            @Override
            protected CallbackImpl<Emp> callback() {
                return empCallback.getIfAvailable();
            }
        };
    }

    @Bean
    AbstractServiceImpl<Dep> depService1(
            @Autowired ObjectProvider<CallbackImpl<Dep>> depCallback) {
        return new AbstractServiceImpl<>() {
            @Override
            protected CallbackImpl<Dep> callback() {
                return depCallback.getIfAvailable();
            }
        };
    }
}
