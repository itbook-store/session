package com.itbook.session.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

/**
 * @author 노수연
 * @since 1.0
 */
@Configuration
@EnableJdbcHttpSession
public class HttpSessionConfig {
}
