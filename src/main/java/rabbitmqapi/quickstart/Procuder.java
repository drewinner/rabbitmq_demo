package rabbitmqapi.quickstart;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Procuder {
    public static void main(String[] args) throws Exception {

        //1. 创建一个ConnectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("10.2.124.199");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        //2. 通过连接工厂创建连接
        Connection connection = connectionFactory.newConnection();
        //3. 通过 connection创建一个Channel
        Channel channel = connection.createChannel();
        //4. 通过channel发送消息
        for (int i = 0; i < 10; i++) {
            String msg = "Hello RabbitMQ! " + i;
            channel.basicPublish("", "test001", null, msg.getBytes());
        }
        //5. 关闭相关连接
        channel.close();
        connection.close();
    }
}
