package io.github.kprasad99.otel.example.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.WebFilter;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.instrumentation.spring.webflux.v5_3.SpringWebfluxTelemetry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Configuration
//@ConditionalOnProperty(name = "management.otlp.tracing.endpoint")
public class WebFluxOtelConfiguration {

	@Bean
	public WebFilter otelFilter(OpenTelemetry telemetry) {
		log.info("Adding otel webfilter");
		return SpringWebfluxTelemetry.create(telemetry).createWebFilterAndRegisterReactorHook();
	}
	
}
