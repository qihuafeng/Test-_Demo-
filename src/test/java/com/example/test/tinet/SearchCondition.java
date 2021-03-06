package com.example.test.tinet;

import java.io.Serializable;

/**
 * @Author ShineQi
 * @Date 2020/11/12 11:09
 */
public class SearchCondition implements Serializable{


        private String name;

        private String key;

        private Integer condition;

        private String value;

        // kryo序列化用
        public SearchCondition() {}

        public SearchCondition(String name, Integer condition, String value) {
            this.name = name;
            this.condition = condition;
            this.value = value;
        }

        public SearchCondition(String name, String key, String value) {
            this.name = name;
            this.key = key;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getKey() {
            return key;
        }

        public Integer getCondition() {
            return condition;
        }

        public void setCondition(Integer condition) {
            this.condition = condition;
        }

        public String getValue() {
            return value;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"name\":\"")
                    .append(name).append('\"');
            sb.append(",\"key\":\"")
                    .append(key).append('\"');
            sb.append(",\"condition\":")
                    .append(condition);
            sb.append(",\"value\":\"")
                    .append(value).append('\"');
            sb.append('}');
            return sb.toString();
        }
    }

