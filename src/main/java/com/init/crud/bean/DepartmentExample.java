package com.init.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class DepartmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DepartmentExample() {
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

        public Criteria andDepIdIsNull() {
            addCriterion("dep_id is null");
            return (Criteria) this;
        }

        public Criteria andDepIdIsNotNull() {
            addCriterion("dep_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepIdEqualTo(Integer value) {
            addCriterion("dep_id =", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotEqualTo(Integer value) {
            addCriterion("dep_id <>", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThan(Integer value) {
            addCriterion("dep_id >", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dep_id >=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThan(Integer value) {
            addCriterion("dep_id <", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThanOrEqualTo(Integer value) {
            addCriterion("dep_id <=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdIn(List<Integer> values) {
            addCriterion("dep_id in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotIn(List<Integer> values) {
            addCriterion("dep_id not in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdBetween(Integer value1, Integer value2) {
            addCriterion("dep_id between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dep_id not between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNull() {
            addCriterion("dep_name is null");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNotNull() {
            addCriterion("dep_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepNameEqualTo(String value) {
            addCriterion("dep_name =", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotEqualTo(String value) {
            addCriterion("dep_name <>", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThan(String value) {
            addCriterion("dep_name >", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThanOrEqualTo(String value) {
            addCriterion("dep_name >=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThan(String value) {
            addCriterion("dep_name <", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThanOrEqualTo(String value) {
            addCriterion("dep_name <=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLike(String value) {
            addCriterion("dep_name like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotLike(String value) {
            addCriterion("dep_name not like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameIn(List<String> values) {
            addCriterion("dep_name in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotIn(List<String> values) {
            addCriterion("dep_name not in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameBetween(String value1, String value2) {
            addCriterion("dep_name between", value1, value2, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotBetween(String value1, String value2) {
            addCriterion("dep_name not between", value1, value2, "depName");
            return (Criteria) this;
        }

        public Criteria andDepScoreIsNull() {
            addCriterion("dep_score is null");
            return (Criteria) this;
        }

        public Criteria andDepScoreIsNotNull() {
            addCriterion("dep_score is not null");
            return (Criteria) this;
        }

        public Criteria andDepScoreEqualTo(Double value) {
            addCriterion("dep_score =", value, "depScore");
            return (Criteria) this;
        }

        public Criteria andDepScoreNotEqualTo(Double value) {
            addCriterion("dep_score <>", value, "depScore");
            return (Criteria) this;
        }

        public Criteria andDepScoreGreaterThan(Double value) {
            addCriterion("dep_score >", value, "depScore");
            return (Criteria) this;
        }

        public Criteria andDepScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("dep_score >=", value, "depScore");
            return (Criteria) this;
        }

        public Criteria andDepScoreLessThan(Double value) {
            addCriterion("dep_score <", value, "depScore");
            return (Criteria) this;
        }

        public Criteria andDepScoreLessThanOrEqualTo(Double value) {
            addCriterion("dep_score <=", value, "depScore");
            return (Criteria) this;
        }

        public Criteria andDepScoreIn(List<Double> values) {
            addCriterion("dep_score in", values, "depScore");
            return (Criteria) this;
        }

        public Criteria andDepScoreNotIn(List<Double> values) {
            addCriterion("dep_score not in", values, "depScore");
            return (Criteria) this;
        }

        public Criteria andDepScoreBetween(Double value1, Double value2) {
            addCriterion("dep_score between", value1, value2, "depScore");
            return (Criteria) this;
        }

        public Criteria andDepScoreNotBetween(Double value1, Double value2) {
            addCriterion("dep_score not between", value1, value2, "depScore");
            return (Criteria) this;
        }

        public Criteria andDepRankIsNull() {
            addCriterion("dep_rank is null");
            return (Criteria) this;
        }

        public Criteria andDepRankIsNotNull() {
            addCriterion("dep_rank is not null");
            return (Criteria) this;
        }

        public Criteria andDepRankEqualTo(Integer value) {
            addCriterion("dep_rank =", value, "depRank");
            return (Criteria) this;
        }

        public Criteria andDepRankNotEqualTo(Integer value) {
            addCriterion("dep_rank <>", value, "depRank");
            return (Criteria) this;
        }

        public Criteria andDepRankGreaterThan(Integer value) {
            addCriterion("dep_rank >", value, "depRank");
            return (Criteria) this;
        }

        public Criteria andDepRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("dep_rank >=", value, "depRank");
            return (Criteria) this;
        }

        public Criteria andDepRankLessThan(Integer value) {
            addCriterion("dep_rank <", value, "depRank");
            return (Criteria) this;
        }

        public Criteria andDepRankLessThanOrEqualTo(Integer value) {
            addCriterion("dep_rank <=", value, "depRank");
            return (Criteria) this;
        }

        public Criteria andDepRankIn(List<Integer> values) {
            addCriterion("dep_rank in", values, "depRank");
            return (Criteria) this;
        }

        public Criteria andDepRankNotIn(List<Integer> values) {
            addCriterion("dep_rank not in", values, "depRank");
            return (Criteria) this;
        }

        public Criteria andDepRankBetween(Integer value1, Integer value2) {
            addCriterion("dep_rank between", value1, value2, "depRank");
            return (Criteria) this;
        }

        public Criteria andDepRankNotBetween(Integer value1, Integer value2) {
            addCriterion("dep_rank not between", value1, value2, "depRank");
            return (Criteria) this;
        }

        public Criteria andDepRemarkIsNull() {
            addCriterion("dep_remark is null");
            return (Criteria) this;
        }

        public Criteria andDepRemarkIsNotNull() {
            addCriterion("dep_remark is not null");
            return (Criteria) this;
        }

        public Criteria andDepRemarkEqualTo(String value) {
            addCriterion("dep_remark =", value, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkNotEqualTo(String value) {
            addCriterion("dep_remark <>", value, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkGreaterThan(String value) {
            addCriterion("dep_remark >", value, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("dep_remark >=", value, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkLessThan(String value) {
            addCriterion("dep_remark <", value, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkLessThanOrEqualTo(String value) {
            addCriterion("dep_remark <=", value, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkLike(String value) {
            addCriterion("dep_remark like", value, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkNotLike(String value) {
            addCriterion("dep_remark not like", value, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkIn(List<String> values) {
            addCriterion("dep_remark in", values, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkNotIn(List<String> values) {
            addCriterion("dep_remark not in", values, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkBetween(String value1, String value2) {
            addCriterion("dep_remark between", value1, value2, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepRemarkNotBetween(String value1, String value2) {
            addCriterion("dep_remark not between", value1, value2, "depRemark");
            return (Criteria) this;
        }

        public Criteria andDepNumberIsNull() {
            addCriterion("dep_number is null");
            return (Criteria) this;
        }

        public Criteria andDepNumberIsNotNull() {
            addCriterion("dep_number is not null");
            return (Criteria) this;
        }

        public Criteria andDepNumberEqualTo(Integer value) {
            addCriterion("dep_number =", value, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberNotEqualTo(Integer value) {
            addCriterion("dep_number <>", value, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberGreaterThan(Integer value) {
            addCriterion("dep_number >", value, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("dep_number >=", value, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberLessThan(Integer value) {
            addCriterion("dep_number <", value, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberLessThanOrEqualTo(Integer value) {
            addCriterion("dep_number <=", value, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberIn(List<Integer> values) {
            addCriterion("dep_number in", values, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberNotIn(List<Integer> values) {
            addCriterion("dep_number not in", values, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberBetween(Integer value1, Integer value2) {
            addCriterion("dep_number between", value1, value2, "depNumber");
            return (Criteria) this;
        }

        public Criteria andDepNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("dep_number not between", value1, value2, "depNumber");
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