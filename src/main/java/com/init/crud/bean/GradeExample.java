package com.init.crud.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GradeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GradeExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andGradeIdIsNull() {
            addCriterion("grade_id is null");
            return (Criteria) this;
        }

        public Criteria andGradeIdIsNotNull() {
            addCriterion("grade_id is not null");
            return (Criteria) this;
        }

        public Criteria andGradeIdEqualTo(Integer value) {
            addCriterion("grade_id =", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotEqualTo(Integer value) {
            addCriterion("grade_id <>", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdGreaterThan(Integer value) {
            addCriterion("grade_id >", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("grade_id >=", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdLessThan(Integer value) {
            addCriterion("grade_id <", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdLessThanOrEqualTo(Integer value) {
            addCriterion("grade_id <=", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdIn(List<Integer> values) {
            addCriterion("grade_id in", values, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotIn(List<Integer> values) {
            addCriterion("grade_id not in", values, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdBetween(Integer value1, Integer value2) {
            addCriterion("grade_id between", value1, value2, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("grade_id not between", value1, value2, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeDepIsNull() {
            addCriterion("grade_dep is null");
            return (Criteria) this;
        }

        public Criteria andGradeDepIsNotNull() {
            addCriterion("grade_dep is not null");
            return (Criteria) this;
        }

        public Criteria andGradeDepEqualTo(String value) {
            addCriterion("grade_dep =", value, "gradeDep");
            return (Criteria) this;
        }

        public Criteria andGradeDepNotEqualTo(String value) {
            addCriterion("grade_dep <>", value, "gradeDep");
            return (Criteria) this;
        }

        public Criteria andGradeDepGreaterThan(String value) {
            addCriterion("grade_dep >", value, "gradeDep");
            return (Criteria) this;
        }

        public Criteria andGradeDepGreaterThanOrEqualTo(String value) {
            addCriterion("grade_dep >=", value, "gradeDep");
            return (Criteria) this;
        }

        public Criteria andGradeDepLessThan(String value) {
            addCriterion("grade_dep <", value, "gradeDep");
            return (Criteria) this;
        }

        public Criteria andGradeDepLessThanOrEqualTo(String value) {
            addCriterion("grade_dep <=", value, "gradeDep");
            return (Criteria) this;
        }

        public Criteria andGradeDepLike(String value) {
            addCriterion("grade_dep like", value, "gradeDep");
            return (Criteria) this;
        }

        public Criteria andGradeDepNotLike(String value) {
            addCriterion("grade_dep not like", value, "gradeDep");
            return (Criteria) this;
        }

        public Criteria andGradeDepIn(List<String> values) {
            addCriterion("grade_dep in", values, "gradeDep");
            return (Criteria) this;
        }

        public Criteria andGradeDepNotIn(List<String> values) {
            addCriterion("grade_dep not in", values, "gradeDep");
            return (Criteria) this;
        }

        public Criteria andGradeDepBetween(String value1, String value2) {
            addCriterion("grade_dep between", value1, value2, "gradeDep");
            return (Criteria) this;
        }

        public Criteria andGradeDepNotBetween(String value1, String value2) {
            addCriterion("grade_dep not between", value1, value2, "gradeDep");
            return (Criteria) this;
        }

        public Criteria andGradeGradeIsNull() {
            addCriterion("grade_grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeGradeIsNotNull() {
            addCriterion("grade_grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeGradeEqualTo(Double value) {
            addCriterion("grade_grade =", value, "gradeGrade");
            return (Criteria) this;
        }

        public Criteria andGradeGradeNotEqualTo(Double value) {
            addCriterion("grade_grade <>", value, "gradeGrade");
            return (Criteria) this;
        }

        public Criteria andGradeGradeGreaterThan(Double value) {
            addCriterion("grade_grade >", value, "gradeGrade");
            return (Criteria) this;
        }

        public Criteria andGradeGradeGreaterThanOrEqualTo(Double value) {
            addCriterion("grade_grade >=", value, "gradeGrade");
            return (Criteria) this;
        }

        public Criteria andGradeGradeLessThan(Double value) {
            addCriterion("grade_grade <", value, "gradeGrade");
            return (Criteria) this;
        }

        public Criteria andGradeGradeLessThanOrEqualTo(Double value) {
            addCriterion("grade_grade <=", value, "gradeGrade");
            return (Criteria) this;
        }

        public Criteria andGradeGradeIn(List<Double> values) {
            addCriterion("grade_grade in", values, "gradeGrade");
            return (Criteria) this;
        }

        public Criteria andGradeGradeNotIn(List<Double> values) {
            addCriterion("grade_grade not in", values, "gradeGrade");
            return (Criteria) this;
        }

        public Criteria andGradeGradeBetween(Double value1, Double value2) {
            addCriterion("grade_grade between", value1, value2, "gradeGrade");
            return (Criteria) this;
        }

        public Criteria andGradeGradeNotBetween(Double value1, Double value2) {
            addCriterion("grade_grade not between", value1, value2, "gradeGrade");
            return (Criteria) this;
        }

        public Criteria andGradeMonthIsNull() {
            addCriterion("grade_month is null");
            return (Criteria) this;
        }

        public Criteria andGradeMonthIsNotNull() {
            addCriterion("grade_month is not null");
            return (Criteria) this;
        }

        public Criteria andGradeMonthEqualTo(Date value) {
            addCriterionForJDBCDate("grade_month =", value, "gradeMonth");
            return (Criteria) this;
        }

        public Criteria andGradeMonthNotEqualTo(Date value) {
            addCriterionForJDBCDate("grade_month <>", value, "gradeMonth");
            return (Criteria) this;
        }

        public Criteria andGradeMonthGreaterThan(Date value) {
            addCriterionForJDBCDate("grade_month >", value, "gradeMonth");
            return (Criteria) this;
        }

        public Criteria andGradeMonthGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("grade_month >=", value, "gradeMonth");
            return (Criteria) this;
        }

        public Criteria andGradeMonthLessThan(Date value) {
            addCriterionForJDBCDate("grade_month <", value, "gradeMonth");
            return (Criteria) this;
        }

        public Criteria andGradeMonthLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("grade_month <=", value, "gradeMonth");
            return (Criteria) this;
        }

        public Criteria andGradeMonthIn(List<Date> values) {
            addCriterionForJDBCDate("grade_month in", values, "gradeMonth");
            return (Criteria) this;
        }

        public Criteria andGradeMonthNotIn(List<Date> values) {
            addCriterionForJDBCDate("grade_month not in", values, "gradeMonth");
            return (Criteria) this;
        }

        public Criteria andGradeMonthBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("grade_month between", value1, value2, "gradeMonth");
            return (Criteria) this;
        }

        public Criteria andGradeMonthNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("grade_month not between", value1, value2, "gradeMonth");
            return (Criteria) this;
        }

        public Criteria andGradeRemarkIsNull() {
            addCriterion("grade_remark is null");
            return (Criteria) this;
        }

        public Criteria andGradeRemarkIsNotNull() {
            addCriterion("grade_remark is not null");
            return (Criteria) this;
        }

        public Criteria andGradeRemarkEqualTo(String value) {
            addCriterion("grade_remark =", value, "gradeRemark");
            return (Criteria) this;
        }

        public Criteria andGradeRemarkNotEqualTo(String value) {
            addCriterion("grade_remark <>", value, "gradeRemark");
            return (Criteria) this;
        }

        public Criteria andGradeRemarkGreaterThan(String value) {
            addCriterion("grade_remark >", value, "gradeRemark");
            return (Criteria) this;
        }

        public Criteria andGradeRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("grade_remark >=", value, "gradeRemark");
            return (Criteria) this;
        }

        public Criteria andGradeRemarkLessThan(String value) {
            addCriterion("grade_remark <", value, "gradeRemark");
            return (Criteria) this;
        }

        public Criteria andGradeRemarkLessThanOrEqualTo(String value) {
            addCriterion("grade_remark <=", value, "gradeRemark");
            return (Criteria) this;
        }

        public Criteria andGradeRemarkLike(String value) {
            addCriterion("grade_remark like", value, "gradeRemark");
            return (Criteria) this;
        }

        public Criteria andGradeRemarkNotLike(String value) {
            addCriterion("grade_remark not like", value, "gradeRemark");
            return (Criteria) this;
        }

        public Criteria andGradeRemarkIn(List<String> values) {
            addCriterion("grade_remark in", values, "gradeRemark");
            return (Criteria) this;
        }

        public Criteria andGradeRemarkNotIn(List<String> values) {
            addCriterion("grade_remark not in", values, "gradeRemark");
            return (Criteria) this;
        }

        public Criteria andGradeRemarkBetween(String value1, String value2) {
            addCriterion("grade_remark between", value1, value2, "gradeRemark");
            return (Criteria) this;
        }

        public Criteria andGradeRemarkNotBetween(String value1, String value2) {
            addCriterion("grade_remark not between", value1, value2, "gradeRemark");
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