package com.ttyc.test;

import org.junit.jupiter.api.Test;
import org.springframework.util.AntPathMatcher;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PathMatcherTests {
	private final AntPathMatcher pathMatcher = new AntPathMatcher();

	@Test
	public void testInclude() {
		assertThat(pathMatcher.match("/a/*", "/a/b")).isTrue();
		assertThat(pathMatcher.match("/a/b/c/*", "/a/b")).isTrue();
	}
}
