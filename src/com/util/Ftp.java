package com.util;

import java.util.Properties;
import com.util.Login;
import com.util.LoadProperties;

public class Ftp {
    public static void main(String[] args) {
        Properties properties = LoadProperties.getProperties();
        Login.login(properties);
    }
}