package com.elastic.helper.tools;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ESUpdateWrapper<T> implements Serializable {

    private Map<String,Object> fieldMap =new HashMap<>();

    private String docId;

    private String index;

    public ESUpdateWrapper<T> add(ESFunction<T, ?> lambda, Object object){
        String fieldName=SerializedLambdaUtils.convertToFieldName(lambda);
        fieldMap.put(fieldName,object);
        return this;
    }


    public ESUpdateWrapper<T> docId(String id){
        this.docId=id;
        return this;
    }

    public ESUpdateWrapper<T> index(String index){
        this.index=index;
        return this;
    }


    public String getIndex() {
        return index;
    }

    public String getDocId() {
        return docId;
    }

    public Map<String, Object> getFieldMap() {
        return fieldMap;
    }



}
