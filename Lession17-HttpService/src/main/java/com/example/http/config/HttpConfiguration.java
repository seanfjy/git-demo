package com.example.http.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.example.http.service.AlbumsService;
import com.example.http.service.TodoService;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Configuration(proxyBeanMethods = false)
public class HttpConfiguration {

    // 创建服务接口的代理对象,基于WebClient
    @Bean
    public TodoService requestService() {

        WebClient webClient = WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();

        // 创建代理工厂
        HttpServiceProxyFactory proxyFactory =
            HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();

        // 创建某个接口的代理服务
        return proxyFactory.createClient(TodoService.class);
    }

    // 创建代理
    /*    @Bean
    public AlbumsService albumsService(){
        WebClient webClient = WebClient.create();
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();
    
        return proxyFactory.createClient(AlbumsService.class);
    }*/

    // 定制http服务
    @Bean
    public AlbumsService albumsService() {

        HttpClient httpClient = HttpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10)// 连接时间
            .doOnConnected(connection -> {
                connection.addHandlerLast(new ReadTimeoutHandler(10));// 读超时
                connection.addHandlerLast(new WriteTimeoutHandler(10));// 写超时
            });
        // 设置异常

        WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient))
            .defaultStatusHandler(HttpStatusCode::isError, clientResponse -> {
                System.out.println("********WebClient请求异常**********");
                return Mono.error(new RuntimeException("请求异常" + clientResponse.statusCode().value()));
            }).build();

        HttpServiceProxyFactory proxyFactory =
            HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();

        return proxyFactory.createClient(AlbumsService.class);
    }

}
