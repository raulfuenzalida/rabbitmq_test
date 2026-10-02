package duoc.cn1.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Consumidor (Receiver) - Recibe mensajes de la cola 'hello'
 */
@Component
public class Receiver {

    /**
     * Listener básico que recibe el contenido del mensaje
     */
    @RabbitListener(queues = "hello")
    public void receiveMessage(String message) {
        try {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS"));
            System.out.println("[" + timestamp + "] [✓] Mensaje recibido: '" + message + "'");
        } catch (Exception e) {
            System.err.println("[✗] Error procesando mensaje: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * Método alternativo que recibe el mensaje con contexto avanzado
     */
    /*
    @RabbitListener(queues = "hello")
    public void receiveMessageAdvanced(String message,
                                       org.springframework.amqp.core.Message rawMessage,
                                       org.springframework.amqp.rabbit.core.Channel channel) throws Exception {
        try {
            System.out.println("[✓] Mensaje recibido: '" + message + "'");
            System.out.println(" - Content-Type: " + rawMessage.getMessageProperties().getContentType());
            System.out.println(" - Timestamp: " + rawMessage.getMessageProperties().getTimestamp());
        } catch (Exception e) {
            System.err.println("[✗] Error: " + e.getMessage());
            throw e;
        }
    }
    */
}