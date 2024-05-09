package com.hwq.builder;

import com.alibaba.druid.pool.DruidDataSource;
import com.hwq.io.Resources;
import com.hwq.session.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @author HWQ
 * @date 2024/5/9 23:27
 * @description
 */
public class XMLConfigBuilder {
    private Configuration configuration;

    public XMLConfigBuilder() {
        this.configuration = new Configuration();
    }

    public Configuration parse(InputStream inputStream) throws DocumentException {
        // 将Document转换为Document对象
        Document document = new SAXReader().read(inputStream);
        // 获取根节点，对于sqlMapConfig.xml来说就是<Configuration>标签
        Element rootElement = document.getRootElement();

        // ---------解析数据库配置文件----------
        List<Element> propertyList = rootElement.selectNodes("//property");
        Properties properties = new Properties();
        for (Element element : propertyList) {
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            properties.setProperty(name, value);
        }
        // 创建数据源对象(默认Druid)
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(properties.getProperty("driverClassName"));
        dataSource.setUrl(properties.getProperty("url"));
        dataSource.setUsername(properties.getProperty("username"));
        dataSource.setPassword(properties.getProperty("password"));
        // 将创建好的数据源添加到Configuration对象中
        configuration.setDataSource(dataSource);

        // --------解析映射配置文件---------

        /**
         * 1.获取映射配置文件路径
         * 2.根据路径进行映射文件的加载解析
         * 封装到MapperStatement，存入到configuration的map集合中
         */
        List<Element> mapperList = rootElement.selectNodes("//mapper");
        for (Element element : mapperList) {
            String resource = element.attributeValue("resource");
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            // todo: 根据resource解析mapper.xml文件
        }
        return configuration;
    }
}
