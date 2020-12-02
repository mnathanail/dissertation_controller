package com.dissertation.controller.controller;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URI;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllerApplication.class, args);
	}

	@Bean("restTemplateBean")
	public RestTemplate getRestTemplate() {
		RestTemplate rt = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

		rt.setUriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:8081"));

		rt.setRequestFactory(new HttpComponentsClientHttpRequestFactory() {
			@Override
			protected HttpUriRequest createHttpUriRequest(HttpMethod httpMethod, URI uri) {
				if (HttpMethod.DELETE == httpMethod) {
					return new HttpEntityEnclosingDeleteRequest(uri);
				}
				return super.createHttpUriRequest(httpMethod, uri);
			}
		});

		return rt;
	}


	public static class HttpEntityEnclosingDeleteRequest extends HttpEntityEnclosingRequestBase {

		public HttpEntityEnclosingDeleteRequest(final URI uri) {
			super();
			setURI(uri);
		}

		@Override
		public String getMethod() {
			return "DELETE";
		}
	}

}