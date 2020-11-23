/*
 * Class: DynamoDataSourceConfiguration
 *
 * Created on Nov 23, 2020
 *
 * (c) Copyright Swiss Post Solutions Ltd, unpublished work
 * All use, disclosure, and/or reproduction of this material is prohibited
 * unless authorized in writing.  All Rights Reserved.
 * Rights in this program belong to:
 * Swiss Post Solution.
 * Floor 4-5-8, ICT Tower, Quang Trung Software City
 */
package vn.minhtran.vom.vbm.infra.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

@Configuration
public class DynamoDBDataSourceConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "amazon.aws")
    AwsProperties awsProperties() {
        return new AwsProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "amazon.dynamodb")
    DynamoDBProperties dynamoDBProperties() {
        return new DynamoDBProperties();
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(
            amazonAWSCredentials());

        String endpoint = dynamoDBProperties().getEndpoint();
        if (endpoint != null && !endpoint.isEmpty()) {
            amazonDynamoDB.setEndpoint(endpoint);
        }

        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentials amazonAWSCredentials() {
        return new BasicAWSCredentials(awsProperties().getAccesskey(),
            awsProperties().getSecretkey());
    }
}
