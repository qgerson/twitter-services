package com.qgerson.criteriaservice.domain.model.entity;

public class Criteria extends BaseEntity<String, Object> {
    public enum CRITERIA_KEY {
        FOLLOWERS("followers"),
        LANGUAGE("languages"),
        HASHTAG( "hashtagTendencies");

        private final String value;

        CRITERIA_KEY( String value ){
            this.value = value;
        }

        public String getValue(){
            return this.value;
        }
    }
    public Criteria( String id, Object criteria) {
        super(id, criteria);
    }
}
