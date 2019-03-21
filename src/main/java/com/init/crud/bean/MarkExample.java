package com.init.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class MarkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MarkExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMarkIdIsNull() {
            addCriterion("mark_id is null");
            return (Criteria) this;
        }

        public Criteria andMarkIdIsNotNull() {
            addCriterion("mark_id is not null");
            return (Criteria) this;
        }

        public Criteria andMarkIdEqualTo(Integer value) {
            addCriterion("mark_id =", value, "markId");
            return (Criteria) this;
        }

        public Criteria andMarkIdNotEqualTo(Integer value) {
            addCriterion("mark_id <>", value, "markId");
            return (Criteria) this;
        }

        public Criteria andMarkIdGreaterThan(Integer value) {
            addCriterion("mark_id >", value, "markId");
            return (Criteria) this;
        }

        public Criteria andMarkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark_id >=", value, "markId");
            return (Criteria) this;
        }

        public Criteria andMarkIdLessThan(Integer value) {
            addCriterion("mark_id <", value, "markId");
            return (Criteria) this;
        }

        public Criteria andMarkIdLessThanOrEqualTo(Integer value) {
            addCriterion("mark_id <=", value, "markId");
            return (Criteria) this;
        }

        public Criteria andMarkIdIn(List<Integer> values) {
            addCriterion("mark_id in", values, "markId");
            return (Criteria) this;
        }

        public Criteria andMarkIdNotIn(List<Integer> values) {
            addCriterion("mark_id not in", values, "markId");
            return (Criteria) this;
        }

        public Criteria andMarkIdBetween(Integer value1, Integer value2) {
            addCriterion("mark_id between", value1, value2, "markId");
            return (Criteria) this;
        }

        public Criteria andMarkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mark_id not between", value1, value2, "markId");
            return (Criteria) this;
        }

        public Criteria andMarkItemIsNull() {
            addCriterion("mark_item is null");
            return (Criteria) this;
        }

        public Criteria andMarkItemIsNotNull() {
            addCriterion("mark_item is not null");
            return (Criteria) this;
        }

        public Criteria andMarkItemEqualTo(String value) {
            addCriterion("mark_item =", value, "markItem");
            return (Criteria) this;
        }

        public Criteria andMarkItemNotEqualTo(String value) {
            addCriterion("mark_item <>", value, "markItem");
            return (Criteria) this;
        }

        public Criteria andMarkItemGreaterThan(String value) {
            addCriterion("mark_item >", value, "markItem");
            return (Criteria) this;
        }

        public Criteria andMarkItemGreaterThanOrEqualTo(String value) {
            addCriterion("mark_item >=", value, "markItem");
            return (Criteria) this;
        }

        public Criteria andMarkItemLessThan(String value) {
            addCriterion("mark_item <", value, "markItem");
            return (Criteria) this;
        }

        public Criteria andMarkItemLessThanOrEqualTo(String value) {
            addCriterion("mark_item <=", value, "markItem");
            return (Criteria) this;
        }

        public Criteria andMarkItemLike(String value) {
            addCriterion("mark_item like", value, "markItem");
            return (Criteria) this;
        }

        public Criteria andMarkItemNotLike(String value) {
            addCriterion("mark_item not like", value, "markItem");
            return (Criteria) this;
        }

        public Criteria andMarkItemIn(List<String> values) {
            addCriterion("mark_item in", values, "markItem");
            return (Criteria) this;
        }

        public Criteria andMarkItemNotIn(List<String> values) {
            addCriterion("mark_item not in", values, "markItem");
            return (Criteria) this;
        }

        public Criteria andMarkItemBetween(String value1, String value2) {
            addCriterion("mark_item between", value1, value2, "markItem");
            return (Criteria) this;
        }

        public Criteria andMarkItemNotBetween(String value1, String value2) {
            addCriterion("mark_item not between", value1, value2, "markItem");
            return (Criteria) this;
        }

        public Criteria andMarkGenreIsNull() {
            addCriterion("mark_genre is null");
            return (Criteria) this;
        }

        public Criteria andMarkGenreIsNotNull() {
            addCriterion("mark_genre is not null");
            return (Criteria) this;
        }

        public Criteria andMarkGenreEqualTo(String value) {
            addCriterion("mark_genre =", value, "markGenre");
            return (Criteria) this;
        }

        public Criteria andMarkGenreNotEqualTo(String value) {
            addCriterion("mark_genre <>", value, "markGenre");
            return (Criteria) this;
        }

        public Criteria andMarkGenreGreaterThan(String value) {
            addCriterion("mark_genre >", value, "markGenre");
            return (Criteria) this;
        }

        public Criteria andMarkGenreGreaterThanOrEqualTo(String value) {
            addCriterion("mark_genre >=", value, "markGenre");
            return (Criteria) this;
        }

        public Criteria andMarkGenreLessThan(String value) {
            addCriterion("mark_genre <", value, "markGenre");
            return (Criteria) this;
        }

        public Criteria andMarkGenreLessThanOrEqualTo(String value) {
            addCriterion("mark_genre <=", value, "markGenre");
            return (Criteria) this;
        }

        public Criteria andMarkGenreLike(String value) {
            addCriterion("mark_genre like", value, "markGenre");
            return (Criteria) this;
        }

        public Criteria andMarkGenreNotLike(String value) {
            addCriterion("mark_genre not like", value, "markGenre");
            return (Criteria) this;
        }

        public Criteria andMarkGenreIn(List<String> values) {
            addCriterion("mark_genre in", values, "markGenre");
            return (Criteria) this;
        }

        public Criteria andMarkGenreNotIn(List<String> values) {
            addCriterion("mark_genre not in", values, "markGenre");
            return (Criteria) this;
        }

        public Criteria andMarkGenreBetween(String value1, String value2) {
            addCriterion("mark_genre between", value1, value2, "markGenre");
            return (Criteria) this;
        }

        public Criteria andMarkGenreNotBetween(String value1, String value2) {
            addCriterion("mark_genre not between", value1, value2, "markGenre");
            return (Criteria) this;
        }

        public Criteria andMarkContentIsNull() {
            addCriterion("mark_content is null");
            return (Criteria) this;
        }

        public Criteria andMarkContentIsNotNull() {
            addCriterion("mark_content is not null");
            return (Criteria) this;
        }

        public Criteria andMarkContentEqualTo(String value) {
            addCriterion("mark_content =", value, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentNotEqualTo(String value) {
            addCriterion("mark_content <>", value, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentGreaterThan(String value) {
            addCriterion("mark_content >", value, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentGreaterThanOrEqualTo(String value) {
            addCriterion("mark_content >=", value, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentLessThan(String value) {
            addCriterion("mark_content <", value, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentLessThanOrEqualTo(String value) {
            addCriterion("mark_content <=", value, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentLike(String value) {
            addCriterion("mark_content like", value, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentNotLike(String value) {
            addCriterion("mark_content not like", value, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentIn(List<String> values) {
            addCriterion("mark_content in", values, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentNotIn(List<String> values) {
            addCriterion("mark_content not in", values, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentBetween(String value1, String value2) {
            addCriterion("mark_content between", value1, value2, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkContentNotBetween(String value1, String value2) {
            addCriterion("mark_content not between", value1, value2, "markContent");
            return (Criteria) this;
        }

        public Criteria andMarkScoreIsNull() {
            addCriterion("mark_score is null");
            return (Criteria) this;
        }

        public Criteria andMarkScoreIsNotNull() {
            addCriterion("mark_score is not null");
            return (Criteria) this;
        }

        public Criteria andMarkScoreEqualTo(Double value) {
            addCriterion("mark_score =", value, "markScore");
            return (Criteria) this;
        }

        public Criteria andMarkScoreNotEqualTo(Double value) {
            addCriterion("mark_score <>", value, "markScore");
            return (Criteria) this;
        }

        public Criteria andMarkScoreGreaterThan(Double value) {
            addCriterion("mark_score >", value, "markScore");
            return (Criteria) this;
        }

        public Criteria andMarkScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("mark_score >=", value, "markScore");
            return (Criteria) this;
        }

        public Criteria andMarkScoreLessThan(Double value) {
            addCriterion("mark_score <", value, "markScore");
            return (Criteria) this;
        }

        public Criteria andMarkScoreLessThanOrEqualTo(Double value) {
            addCriterion("mark_score <=", value, "markScore");
            return (Criteria) this;
        }

        public Criteria andMarkScoreIn(List<Double> values) {
            addCriterion("mark_score in", values, "markScore");
            return (Criteria) this;
        }

        public Criteria andMarkScoreNotIn(List<Double> values) {
            addCriterion("mark_score not in", values, "markScore");
            return (Criteria) this;
        }

        public Criteria andMarkScoreBetween(Double value1, Double value2) {
            addCriterion("mark_score between", value1, value2, "markScore");
            return (Criteria) this;
        }

        public Criteria andMarkScoreNotBetween(Double value1, Double value2) {
            addCriterion("mark_score not between", value1, value2, "markScore");
            return (Criteria) this;
        }

        public Criteria andMarkMethodIsNull() {
            addCriterion("mark_method is null");
            return (Criteria) this;
        }

        public Criteria andMarkMethodIsNotNull() {
            addCriterion("mark_method is not null");
            return (Criteria) this;
        }

        public Criteria andMarkMethodEqualTo(String value) {
            addCriterion("mark_method =", value, "markMethod");
            return (Criteria) this;
        }

        public Criteria andMarkMethodNotEqualTo(String value) {
            addCriterion("mark_method <>", value, "markMethod");
            return (Criteria) this;
        }

        public Criteria andMarkMethodGreaterThan(String value) {
            addCriterion("mark_method >", value, "markMethod");
            return (Criteria) this;
        }

        public Criteria andMarkMethodGreaterThanOrEqualTo(String value) {
            addCriterion("mark_method >=", value, "markMethod");
            return (Criteria) this;
        }

        public Criteria andMarkMethodLessThan(String value) {
            addCriterion("mark_method <", value, "markMethod");
            return (Criteria) this;
        }

        public Criteria andMarkMethodLessThanOrEqualTo(String value) {
            addCriterion("mark_method <=", value, "markMethod");
            return (Criteria) this;
        }

        public Criteria andMarkMethodLike(String value) {
            addCriterion("mark_method like", value, "markMethod");
            return (Criteria) this;
        }

        public Criteria andMarkMethodNotLike(String value) {
            addCriterion("mark_method not like", value, "markMethod");
            return (Criteria) this;
        }

        public Criteria andMarkMethodIn(List<String> values) {
            addCriterion("mark_method in", values, "markMethod");
            return (Criteria) this;
        }

        public Criteria andMarkMethodNotIn(List<String> values) {
            addCriterion("mark_method not in", values, "markMethod");
            return (Criteria) this;
        }

        public Criteria andMarkMethodBetween(String value1, String value2) {
            addCriterion("mark_method between", value1, value2, "markMethod");
            return (Criteria) this;
        }

        public Criteria andMarkMethodNotBetween(String value1, String value2) {
            addCriterion("mark_method not between", value1, value2, "markMethod");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}