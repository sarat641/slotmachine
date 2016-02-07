package slotmachine.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import slotmachine.web.util.ApplicationConstants;

/**
 *
 * @author SARAT
 */
@Configuration
@ComponentScan(basePackages = {"slotmachine"}, excludeFilters = {
    @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {

    @Bean
    public DataSource dataSource() {

        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("db/sql/create-db.sql")
                .build();
        return db;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public MailSender mailSender(Environment env) {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.timeout", "8500");
        properties.setProperty("mail.transport.protocol", "smtp");
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(ApplicationConstants.MAILSERVER_HOST);
        mailSender.setPort(ApplicationConstants.MAILSERVER_PORT);
        mailSender.setUsername(ApplicationConstants.MAILSERVER_USERNAME);
        mailSender.setPassword(ApplicationConstants.MAILSERVER_PASSWORD);
        mailSender.setJavaMailProperties(properties);
        return mailSender;
    }
}
