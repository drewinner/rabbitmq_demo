package rabbitmqapi.exchange.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ProducerFanoutExchange {
    public static void main(String[] args) throws Exception{
//1. 创建ConnectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("10.2.124.199");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        //2 创建Connection
        Connection connection = connectionFactory.newConnection();
        //3 创建Channel
        Channel channel = connection.createChannel();
        //4 声明
        String exchangeName = "test_fanout_exchange";
        //5 发送
        for(int i = 0; i < 10; i ++) {
            String msg = "Hello World RabbitMQ 4 FANOUT Exchange Message ..."+i;
            channel.basicPublish(exchangeName, "12221111", null , msg.getBytes());
        }
        channel.close();
        connection.close();
    }
}
