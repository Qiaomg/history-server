package net.shopin.history.config;

import net.shopin.history.config.interceptor.ResultTypeInterceptor;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title: DataSourceConfig
 * @description: 注入拦截器
 * @author: qmg
 * @date: 2020/6/11 17:19
 * @version: V1.0
 */
@Configuration
public class DataSourceConfig {
    @Bean
    ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.addInterceptor(new ResultTypeInterceptor());
            }
        };
    }
}
