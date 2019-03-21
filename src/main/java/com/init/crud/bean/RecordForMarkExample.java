package com.init.crud.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RecordForMarkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecordForMarkExample() {
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

        public Criteria andRfmIdIsNull() {
            addCriterion("rfm_id is null");
            return (Criteria) this;
        }

        public Criteria andRfmIdIsNotNull() {
            addCriterion("rfm_id is not null");
            return (Criteria) this;
        }

        public Criteria andRfmIdEqualTo(Integer value) {
            addCriterion("rfm_id =", value, "rfmId");
            return (Criteria) this;
        }

        public Criteria andRfmIdNotEqualTo(Integer value) {
            addCriterion("rfm_id <>", value, "rfmId");
            return (Criteria) this;
        }

        public Criteria andRfmIdGreaterThan(Integer value) {
            addCriterion("rfm_id >", value, "rfmId");
            return (Criteria) this;
        }

        public Criteria andRfmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rfm_id >=", value, "rfmId");
            return (Criteria) this;
        }

        public Criteria andRfmIdLessThan(Integer value) {
            addCriterion("rfm_id <", value, "rfmId");
            return (Criteria) this;
        }

        public Criteria andRfmIdLessThanOrEqualTo(Integer value) {
            addCriterion("rfm_id <=", value, "rfmId");
            return (Criteria) this;
        }

        public Criteria andRfmIdIn(List<Integer> values) {
            addCriterion("rfm_id in", values, "rfmId");
            return (Criteria) this;
        }

        public Criteria andRfmIdNotIn(List<Integer> values) {
            addCriterion("rfm_id not in", values, "rfmId");
            return (Criteria) this;
        }

        public Criteria andRfmIdBetween(Integer value1, Integer value2) {
            addCriterion("rfm_id between", value1, value2, "rfmId");
            return (Criteria) this;
        }

        public Criteria andRfmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rfm_id not between", value1, value2, "rfmId");
            return (Criteria) this;
        }

        public Criteria andRfmEmpNameIsNull() {
            addCriterion("rfm_emp_name is null");
            return (Criteria) this;
        }

        public Criteria andRfmEmpNameIsNotNull() {
            addCriterion("rfm_emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andRfmEmpNameEqualTo(String value) {
            addCriterion("rfm_emp_name =", value, "rfmEmpName");
            return (Criteria) this;
        }

        public Criteria andRfmEmpNameNotEqualTo(String value) {
            addCriterion("rfm_emp_name <>", value, "rfmEmpName");
            return (Criteria) this;
        }

        public Criteria andRfmEmpNameGreaterThan(String value) {
            addCriterion("rfm_emp_name >", value, "rfmEmpName");
            return (Criteria) this;
        }

        public Criteria andRfmEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("rfm_emp_name >=", value, "rfmEmpName");
            return (Criteria) this;
        }

        public Criteria andRfmEmpNameLessThan(String value) {
            addCriterion("rfm_emp_name <", value, "rfmEmpName");
            return (Criteria) this;
        }

        public Criteria andRfmEmpNameLessThanOrEqualTo(String value) {
            addCriterion("rfm_emp_name <=", value, "rfmEmpName");
            return (Criteria) this;
        }

        public Criteria andRfmEmpNameLike(String value) {
            addCriterion("rfm_emp_name like", value, "rfmEmpName");
            return (Criteria) this;
        }

        public Criteria andRfmEmpNameNotLike(String value) {
            addCriterion("rfm_emp_name not like", value, "rfmEmpName");
            return (Criteria) this;
        }

        public Criteria andRfmEmpNameIn(List<String> values) {
            addCriterion("rfm_emp_name in", values, "rfmEmpName");
            return (Criteria) this;
        }

        public Criteria andRfmEmpNameNotIn(List<String> values) {
            addCriterion("rfm_emp_name not in", values, "rfmEmpName");
            return (Criteria) this;
        }

        public Criteria andRfmEmpNameBetween(String value1, String value2) {
            addCriterion("rfm_emp_name between", value1, value2, "rfmEmpName");
            return (Criteria) this;
        }

        public Criteria andRfmEmpNameNotBetween(String value1, String value2) {
            addCriterion("rfm_emp_name not between", value1, value2, "rfmEmpName");
            return (Criteria) this;
        }

        public Criteria andRfmMonthIsNull() {
            addCriterion("rfm_month is null");
            return (Criteria) this;
        }

        public Criteria andRfmMonthIsNotNull() {
            addCriterion("rfm_month is not null");
            return (Criteria) this;
        }

        public Criteria andRfmMonthEqualTo(Date value) {
            addCriterionForJDBCDate("rfm_month =", value, "rfmMonth");
            return (Criteria) this;
        }

        public Criteria andRfmMonthNotEqualTo(Date value) {
            addCriterionForJDBCDate("rfm_month <>", value, "rfmMonth");
            return (Criteria) this;
        }

        public Criteria andRfmMonthGreaterThan(Date value) {
            addCriterionForJDBCDate("rfm_month >", value, "rfmMonth");
            return (Criteria) this;
        }

        public Criteria andRfmMonthGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rfm_month >=", value, "rfmMonth");
            return (Criteria) this;
        }

        public Criteria andRfmMonthLessThan(Date value) {
            addCriterionForJDBCDate("rfm_month <", value, "rfmMonth");
            return (Criteria) this;
        }

        public Criteria andRfmMonthLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rfm_month <=", value, "rfmMonth");
            return (Criteria) this;
        }

        public Criteria andRfmMonthIn(List<Date> values) {
            addCriterionForJDBCDate("rfm_month in", values, "rfmMonth");
            return (Criteria) this;
        }

        public Criteria andRfmMonthNotIn(List<Date> values) {
            addCriterionForJDBCDate("rfm_month not in", values, "rfmMonth");
            return (Criteria) this;
        }

        public Criteria andRfmMonthBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rfm_month between", value1, value2, "rfmMonth");
            return (Criteria) this;
        }

        public Criteria andRfmMonthNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rfm_month not between", value1, value2, "rfmMonth");
            return (Criteria) this;
        }

        public Criteria andRfmDepNameIsNull() {
            addCriterion("rfm_dep_name is null");
            return (Criteria) this;
        }

        public Criteria andRfmDepNameIsNotNull() {
            addCriterion("rfm_dep_name is not null");
            return (Criteria) this;
        }

        public Criteria andRfmDepNameEqualTo(String value) {
            addCriterion("rfm_dep_name =", value, "rfmDepName");
            return (Criteria) this;
        }

        public Criteria andRfmDepNameNotEqualTo(String value) {
            addCriterion("rfm_dep_name <>", value, "rfmDepName");
            return (Criteria) this;
        }

        public Criteria andRfmDepNameGreaterThan(String value) {
            addCriterion("rfm_dep_name >", value, "rfmDepName");
            return (Criteria) this;
        }

        public Criteria andRfmDepNameGreaterThanOrEqualTo(String value) {
            addCriterion("rfm_dep_name >=", value, "rfmDepName");
            return (Criteria) this;
        }

        public Criteria andRfmDepNameLessThan(String value) {
            addCriterion("rfm_dep_name <", value, "rfmDepName");
            return (Criteria) this;
        }

        public Criteria andRfmDepNameLessThanOrEqualTo(String value) {
            addCriterion("rfm_dep_name <=", value, "rfmDepName");
            return (Criteria) this;
        }

        public Criteria andRfmDepNameLike(String value) {
            addCriterion("rfm_dep_name like", value, "rfmDepName");
            return (Criteria) this;
        }

        public Criteria andRfmDepNameNotLike(String value) {
            addCriterion("rfm_dep_name not like", value, "rfmDepName");
            return (Criteria) this;
        }

        public Criteria andRfmDepNameIn(List<String> values) {
            addCriterion("rfm_dep_name in", values, "rfmDepName");
            return (Criteria) this;
        }

        public Criteria andRfmDepNameNotIn(List<String> values) {
            addCriterion("rfm_dep_name not in", values, "rfmDepName");
            return (Criteria) this;
        }

        public Criteria andRfmDepNameBetween(String value1, String value2) {
            addCriterion("rfm_dep_name between", value1, value2, "rfmDepName");
            return (Criteria) this;
        }

        public Criteria andRfmDepNameNotBetween(String value1, String value2) {
            addCriterion("rfm_dep_name not between", value1, value2, "rfmDepName");
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