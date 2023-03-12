package com.duyhung.util;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class FormUtil {
    public static <T> T toEntity(Class<T> tClass, HttpServletRequest request)  {
        T object = null;
        try {
            object =  tClass.getDeclaredConstructor().newInstance();
            BeanUtils.populate(object,request.getParameterMap());
        }  catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return object;
    }
}
