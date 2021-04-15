package com.example.es.config;

//import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.client.RestClients;

import java.net.InetAddress;

/**
 * @program: es
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2021-03-22 15:05
 **/
@Configuration
public class ElasticSearchConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchConfig.class);

    /**
     * elk集群地址
     */
    //@Value("${elasticsearch.ip}")
    private String hostName;

    /**
     * 端口
     */
    //@Value("${elasticsearch.port}")
    private String port;

    /**
     * 集群名称
     */
    //@Value("${elasticsearch.cluster.name}")
    private String clusterName;

    /**
     * 连接池
     */
    //@Value("${elasticsearch.pool}")
    private String poolSize;

    /**
     * Bean name default  函数名字
     *
     * @return
     */
    //@Bean(name = "transportClient")
    /*public TransportClient transportClient() {
        LOGGER.info("Elasticsearch初始化开始。。。。。");
        TransportClient transportClient = null;
        try {
            // 配置信息
            Settings esSetting = Settings.builder()
                    .put("cluster.name", clusterName) //集群名字
                    .put("client.transport.sniff", true)//增加嗅探机制，找到ES集群
                    .put("thread_pool.search.size", Integer.parseInt(poolSize))//增加线程池个数，暂时设为5
                    .build();
            //配置信息Settings自定义
            //transportClient = new PreBuiltTransportClient(esSetting);
            TransportAddress transportAddress = new TransportAddress(InetAddress.getByName(hostName), Integer.valueOf(port));
            transportClient.addTransportAddresses(transportAddress);
        } catch (Exception e) {
            LOGGER.error("elasticsearch TransportClient create error!!", e);
        }
        return transportClient;
    }*/

    /*@Bean
    RestHighLevelClient elasticsearchClient() {
        ClientConfiguration configuration = ClientConfiguration.builder()
                .connectedTo("101.37.159.158:9300")
                //.withConnectTimeout(Duration.ofSeconds(5))
                //.withSocketTimeout(Duration.ofSeconds(3))
                //.useSsl()
                //.withDefaultHeaders(defaultHeaders)
                //.withBasicAuth(username, password)
                // ... other options
                .build();
        RestHighLevelClient client = RestClients.create(configuration).rest();
        return client;
    }*/

}
