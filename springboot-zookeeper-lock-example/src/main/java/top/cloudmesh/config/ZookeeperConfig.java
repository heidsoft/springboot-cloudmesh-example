package top.cloudmesh.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZookeeperConfig {

    /**
     * 创建 CuratorFramework 对象并连接 Zookeeper
     *
     * @param zookeeperProperties 从 Spring 容器载入 zookeeperProperties Bean 对象，读取连接 ZK 的参数
     * @return CuratorFramework
     */
    @Bean(initMethod = "start")
    public CuratorFramework curatorFramework(ZookeeperProperties zookeeperProperties) {
        return CuratorFrameworkFactory.newClient(
                "127.0.0.1:2181",
                30000,
                10000,
                new RetryNTimes(5,
                        5000));
    }

}