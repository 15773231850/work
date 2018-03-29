package com.test2;

import org.junit.Test;

public class PropertiesUtilTest {

    @Test
    public void testGet() {
        PropertiesUtil prop = new PropertiesUtil("config.properties");
        System.out.println(prop.get("prot"));
    }

}