package com.albertojbe.simpleecommerce.utils;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;


public class DozerMapper {
    private static final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <T, D> D parseObject(T source, Class<D> destiny){
        return mapper.map(source, destiny);
    }

    public static <T, D> List<D> parseListOfObjects(List<T> source, Class<D> destiny){
        List<D> destinyList = new ArrayList<>();
        for(T obj : source){
            destinyList.add(parseObject(obj, destiny));
        }
        return destinyList;
    }
}
