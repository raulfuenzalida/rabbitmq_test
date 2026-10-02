package duoc.cn1.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de RabbitMQ
 */
@Configuration
public class RabbitMQConfig {

    /**
     * Define la cola "hello"
     * 
     * durable=false: se borra si RabbitMQ se reinicia
     */
    @Bean
    public Queue helloQueue() {
        return new Queue("hello", false);
    }
}