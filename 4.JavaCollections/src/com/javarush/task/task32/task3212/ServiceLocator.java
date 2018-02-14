package com.javarush.task.task32.task3212;

import com.javarush.task.task32.task3212.contex.InitialContext;
import com.javarush.task.task32.task3212.service.Service;

import java.util.Objects;


public class ServiceLocator {
    private static Cache cache = new Cache();
    private static InitialContext context = new InitialContext();

    public static Service getService(String jndiName) {
        Service result = cache.getService(jndiName);
        if (Objects.isNull(result))
            result = (Service) context.lookup(jndiName);
        cache.addService(result);
        return result;
    }
}
