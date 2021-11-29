package com.entirequeueconsumer;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import com.predictions.*;
import com.predictiontype.*;

public class EntireQueueConsumer{
	
	public static List<Prediction> consumePredictions(String queueName, String predictionType) throws IOException, TimeoutException{
		ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("localhost");
        Connection conn=factory.newConnection();
        Channel channel=conn.createChannel();
        List<Prediction> predictions=new ArrayList();
        Gson gson=new Gson();        
        long messageCount=channel.messageCount(queueName);
        boolean autoAck=true;
        while(messageCount>0){
        	if(PredictionType.valueOf(predictionType).equals(PredictionType.NOT_YET_PLAYED_PREDICTION)){
                predictions.add(gson.fromJson(new String(channel.basicGet(queueName, autoAck)
                		.getBody()), Prediction.class));
        	} else {
        		predictions.add(gson.fromJson(new String(channel.basicGet(queueName, autoAck)
                		.getBody()), AlreadyPlayedPrediction.class));
        	}
            messageCount=channel.messageCount(queueName);
        }
        //predictions.forEach(System.out::println);
        channel.close();
        conn.close();
        return predictions;
	}
}