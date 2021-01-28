package com.au.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean(name = "rectangle")
	public Rectangle rectangle() {
		return new Rectangle();
	}
	@Bean(name = "PointA")
	public Point pointAObj() {
		return new Point(5,5);
	}
	@Bean(name = "PointB")
	public Point pointBObj() {
		return new Point(5,25);
	}
	@Bean(name = "PointC")
	public Point pointCObj() {
		return new Point(25,25);
	}
	@Bean(name = "PointD")
	public Point pointDObj() {
		return new Point(25,5);
	}
}
