//package org.example.message_service.dao;
//
//
//import co.elastic.clients.elasticsearch.ElasticsearchClient;
//import co.elastic.clients.json.jackson.JacksonJsonpMapper;
//import co.elastic.clients.transport.ElasticsearchTransport;
//import co.elastic.clients.transport.endpoints.BooleanResponse;
//import co.elastic.clients.transport.rest_client.RestClientTransport;
//import org.apache.http.HttpHost;
//import org.elasticsearch.client.RestClient;
//import org.example.commonUtils.dto.Message;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class SearchClient {
//
//
//    private final ElasticsearchClient client;
//
//    public SearchClient(){
//        // Create the low-level client
//        RestClient restClient = RestClient.builder(
//                new HttpHost("localhost", 9200)).build();
//
//// Create the transport with a Jackson mapper
//        ElasticsearchTransport transport = new RestClientTransport(
//                restClient, new JacksonJsonpMapper());
//
//// And create the API client
//        client = new ElasticsearchClient(transport);
//    }
//
//
//
//    public void addMessage(Message message){
//
//    }
//
//
//}
