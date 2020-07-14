package com.example.test.entity;

import java.util.LinkedHashMap;
import java.util.Map;

public class CpuTemplateCriteria {

    private LinkedHashMap<String, String> sortItemMap;
    private Map<String, Object> extFields;

    public LinkedHashMap<String, String> getSortItemMap() {
        return sortItemMap;
    }

    public void setSortItemMap(LinkedHashMap<String, String> sortItemMap) {
        this.sortItemMap = sortItemMap;
    }

    public Map<String, Object> getExtFields() {
        return extFields;
    }

    public void setExtFields(Map<String, Object> extFields) {
        this.extFields = extFields;
    }
}
