package com.init.crud.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecordExample() {
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

        public Criteria andRecIdIsNull() {
            addCriterion("rec_id is null");
            return (Criteria) this;
        }

        public Criteria andRecIdIsNotNull() {
            addCriterion("rec_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecIdEqualTo(Integer value) {
            addCriterion("rec_id =", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdNotEqualTo(Integer value) {
            addCriterion("rec_id <>", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdGreaterThan(Integer value) {
            addCriterion("rec_id >", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rec_id >=", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdLessThan(Integer value) {
            addCriterion("rec_id <", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdLessThanOrEqualTo(Integer value) {
            addCriterion("rec_id <=", value, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdIn(List<Integer> values) {
            addCriterion("rec_id in", values, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdNotIn(List<Integer> values) {
            addCriterion("rec_id not in", values, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdBetween(Integer value1, Integer value2) {
            addCriterion("rec_id between", value1, value2, "recId");
            return (Criteria) this;
        }

        public Criteria andRecIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rec_id not between", value1, value2, "recId");
            return (Criteria) this;
        }

        public Criteria andRecItemIdIsNull() {
            addCriterion("rec_item_id is null");
            return (Criteria) this;
        }

        public Criteria andRecItemIdIsNotNull() {
            addCriterion("rec_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecItemIdEqualTo(Integer value) {
            addCriterion("rec_item_id =", value, "recItemId");
            return (Criteria) this;
        }

        public Criteria andRecItemIdNotEqualTo(Integer value) {
            addCriterion("rec_item_id <>", value, "recItemId");
            return (Criteria) this;
        }

        public Criteria andRecItemIdGreaterThan(Integer value) {
            addCriterion("rec_item_id >", value, "recItemId");
            return (Criteria) this;
        }

        public Criteria andRecItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rec_item_id >=", value, "recItemId");
            return (Criteria) this;
        }

        public Criteria andRecItemIdLessThan(Integer value) {
            addCriterion("rec_item_id <", value, "recItemId");
            return (Criteria) this;
        }

        public Criteria andRecItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("rec_item_id <=", value, "recItemId");
            return (Criteria) this;
        }

        public Criteria andRecItemIdIn(List<Integer> values) {
            addCriterion("rec_item_id in", values, "recItemId");
            return (Criteria) this;
        }

        public Criteria andRecItemIdNotIn(List<Integer> values) {
            addCriterion("rec_item_id not in", values, "recItemId");
            return (Criteria) this;
        }

        public Criteria andRecItemIdBetween(Integer value1, Integer value2) {
            addCriterion("rec_item_id between", value1, value2, "recItemId");
            return (Criteria) this;
        }

        public Criteria andRecItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rec_item_id not between", value1, value2, "recItemId");
            return (Criteria) this;
        }

        public Criteria andRecDepartmentNameIsNull() {
            addCriterion("rec_department_name is null");
            return (Criteria) this;
        }

        public Criteria andRecDepartmentNameIsNotNull() {
            addCriterion("rec_department_name is not null");
            return (Criteria) this;
        }

        public Criteria andRecDepartmentNameEqualTo(String value) {
            addCriterion("rec_department_name =", value, "recDepartmentName");
            return (Criteria) this;
        }

        public Criteria andRecDepartmentNameNotEqualTo(String value) {
            addCriterion("rec_department_name <>", value, "recDepartmentName");
            return (Criteria) this;
        }

        public Criteria andRecDepartmentNameGreaterThan(String value) {
            addCriterion("rec_department_name >", value, "recDepartmentName");
            return (Criteria) this;
        }

        public Criteria andRecDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("rec_department_name >=", value, "recDepartmentName");
            return (Criteria) this;
        }

        public Criteria andRecDepartmentNameLessThan(String value) {
            addCriterion("rec_department_name <", value, "recDepartmentName");
            return (Criteria) this;
        }

        public Criteria andRecDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("rec_department_name <=", value, "recDepartmentName");
            return (Criteria) this;
        }

        public Criteria andRecDepartmentNameLike(String value) {
            addCriterion("rec_department_name like", value, "recDepartmentName");
            return (Criteria) this;
        }

        public Criteria andRecDepartmentNameNotLike(String value) {
            addCriterion("rec_department_name not like", value, "recDepartmentName");
            return (Criteria) this;
        }

        public Criteria andRecDepartmentNameIn(List<String> values) {
            addCriterion("rec_department_name in", values, "recDepartmentName");
            return (Criteria) this;
        }

        public Criteria andRecDepartmentNameNotIn(List<String> values) {
            addCriterion("rec_department_name not in", values, "recDepartmentName");
            return (Criteria) this;
        }

        public Criteria andRecDepartmentNameBetween(String value1, String value2) {
            addCriterion("rec_department_name between", value1, value2, "recDepartmentName");
            return (Criteria) this;
        }

        public Criteria andRecDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("rec_department_name not between", value1, value2, "recDepartmentName");
            return (Criteria) this;
        }

        public Criteria andRecDateIsNull() {
            addCriterion("rec_date is null");
            return (Criteria) this;
        }

        public Criteria andRecDateIsNotNull() {
            addCriterion("rec_date is not null");
            return (Criteria) this;
        }

        public Criteria andRecDateEqualTo(Date value) {
            addCriterionForJDBCDate("rec_date =", value, "recDate");
            return (Criteria) this;
        }

        public Criteria andRecDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("rec_date <>", value, "recDate");
            return (Criteria) this;
        }

        public Criteria andRecDateGreaterThan(Date value) {
            addCriterionForJDBCDate("rec_date >", value, "recDate");
            return (Criteria) this;
        }

        public Criteria andRecDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rec_date >=", value, "recDate");
            return (Criteria) this;
        }

        public Criteria andRecDateLessThan(Date value) {
            addCriterionForJDBCDate("rec_date <", value, "recDate");
            return (Criteria) this;
        }

        public Criteria andRecDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("rec_date <=", value, "recDate");
            return (Criteria) this;
        }

        public Criteria andRecDateIn(List<Date> values) {
            addCriterionForJDBCDate("rec_date in", values, "recDate");
            return (Criteria) this;
        }

        public Criteria andRecDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("rec_date not in", values, "recDate");
            return (Criteria) this;
        }

        public Criteria andRecDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rec_date between", value1, value2, "recDate");
            return (Criteria) this;
        }

        public Criteria andRecDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("rec_date not between", value1, value2, "recDate");
            return (Criteria) this;
        }

        public Criteria andRecRemarkIsNull() {
            addCriterion("rec_remark is null");
            return (Criteria) this;
        }

        public Criteria andRecRemarkIsNotNull() {
            addCriterion("rec_remark is not null");
            return (Criteria) this;
        }

        public Criteria andRecRemarkEqualTo(String value) {
            addCriterion("rec_remark =", value, "recRemark");
            return (Criteria) this;
        }

        public Criteria andRecRemarkNotEqualTo(String value) {
            addCriterion("rec_remark <>", value, "recRemark");
            return (Criteria) this;
        }

        public Criteria andRecRemarkGreaterThan(String value) {
            addCriterion("rec_remark >", value, "recRemark");
            return (Criteria) this;
        }

        public Criteria andRecRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("rec_remark >=", value, "recRemark");
            return (Criteria) this;
        }

        public Criteria andRecRemarkLessThan(String value) {
            addCriterion("rec_remark <", value, "recRemark");
            return (Criteria) this;
        }

        public Criteria andRecRemarkLessThanOrEqualTo(String value) {
            addCriterion("rec_remark <=", value, "recRemark");
            return (Criteria) this;
        }

        public Criteria andRecRemarkLike(String value) {
            addCriterion("rec_remark like", value, "recRemark");
            return (Criteria) this;
        }

        public Criteria andRecRemarkNotLike(String value) {
            addCriterion("rec_remark not like", value, "recRemark");
            return (Criteria) this;
        }

        public Criteria andRecRemarkIn(List<String> values) {
            addCriterion("rec_remark in", values, "recRemark");
            return (Criteria) this;
        }

        public Criteria andRecRemarkNotIn(List<String> values) {
            addCriterion("rec_remark not in", values, "recRemark");
            return (Criteria) this;
        }

        public Criteria andRecRemarkBetween(String value1, String value2) {
            addCriterion("rec_remark between", value1, value2, "recRemark");
            return (Criteria) this;
        }

        public Criteria andRecRemarkNotBetween(String value1, String value2) {
            addCriterion("rec_remark not between", value1, value2, "recRemark");
            return (Criteria) this;
        }

        public Criteria andRecPersonIsNull() {
            addCriterion("rec_person is null");
            return (Criteria) this;
        }

        public Criteria andRecPersonIsNotNull() {
            addCriterion("rec_person is not null");
            return (Criteria) this;
        }

        public Criteria andRecPersonEqualTo(String value) {
            addCriterion("rec_person =", value, "recPerson");
            return (Criteria) this;
        }

        public Criteria andRecPersonNotEqualTo(String value) {
            addCriterion("rec_person <>", value, "recPerson");
            return (Criteria) this;
        }

        public Criteria andRecPersonGreaterThan(String value) {
            addCriterion("rec_person >", value, "recPerson");
            return (Criteria) this;
        }

        public Criteria andRecPersonGreaterThanOrEqualTo(String value) {
            addCriterion("rec_person >=", value, "recPerson");
            return (Criteria) this;
        }

        public Criteria andRecPersonLessThan(String value) {
            addCriterion("rec_person <", value, "recPerson");
            return (Criteria) this;
        }

        public Criteria andRecPersonLessThanOrEqualTo(String value) {
            addCriterion("rec_person <=", value, "recPerson");
            return (Criteria) this;
        }

        public Criteria andRecPersonLike(String value) {
            addCriterion("rec_person like", value, "recPerson");
            return (Criteria) this;
        }

        public Criteria andRecPersonNotLike(String value) {
            addCriterion("rec_person not like", value, "recPerson");
            return (Criteria) this;
        }

        public Criteria andRecPersonIn(List<String> values) {
            addCriterion("rec_person in", values, "recPerson");
            return (Criteria) this;
        }

        public Criteria andRecPersonNotIn(List<String> values) {
            addCriterion("rec_person not in", values, "recPerson");
            return (Criteria) this;
        }

        public Criteria andRecPersonBetween(String value1, String value2) {
            addCriterion("rec_person between", value1, value2, "recPerson");
            return (Criteria) this;
        }

        public Criteria andRecPersonNotBetween(String value1, String value2) {
            addCriterion("rec_person not between", value1, value2, "recPerson");
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