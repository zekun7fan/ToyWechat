package org.example.commonUtils.entity;

import java.util.ArrayList;
import java.util.List;

public class FriendExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table friend
     *
     * @mbg.generated Wed Jul 27 19:27:45 EDT 2022
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table friend
     *
     * @mbg.generated Wed Jul 27 19:27:45 EDT 2022
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table friend
     *
     * @mbg.generated Wed Jul 27 19:27:45 EDT 2022
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend
     *
     * @mbg.generated Wed Jul 27 19:27:45 EDT 2022
     */
    public FriendExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend
     *
     * @mbg.generated Wed Jul 27 19:27:45 EDT 2022
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend
     *
     * @mbg.generated Wed Jul 27 19:27:45 EDT 2022
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend
     *
     * @mbg.generated Wed Jul 27 19:27:45 EDT 2022
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend
     *
     * @mbg.generated Wed Jul 27 19:27:45 EDT 2022
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend
     *
     * @mbg.generated Wed Jul 27 19:27:45 EDT 2022
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend
     *
     * @mbg.generated Wed Jul 27 19:27:45 EDT 2022
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend
     *
     * @mbg.generated Wed Jul 27 19:27:45 EDT 2022
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend
     *
     * @mbg.generated Wed Jul 27 19:27:45 EDT 2022
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend
     *
     * @mbg.generated Wed Jul 27 19:27:45 EDT 2022
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table friend
     *
     * @mbg.generated Wed Jul 27 19:27:45 EDT 2022
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table friend
     *
     * @mbg.generated Wed Jul 27 19:27:45 EDT 2022
     */
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andFriendIdIsNull() {
            addCriterion("friend_id is null");
            return (Criteria) this;
        }

        public Criteria andFriendIdIsNotNull() {
            addCriterion("friend_id is not null");
            return (Criteria) this;
        }

        public Criteria andFriendIdEqualTo(String value) {
            addCriterion("friend_id =", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotEqualTo(String value) {
            addCriterion("friend_id <>", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdGreaterThan(String value) {
            addCriterion("friend_id >", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdGreaterThanOrEqualTo(String value) {
            addCriterion("friend_id >=", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLessThan(String value) {
            addCriterion("friend_id <", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLessThanOrEqualTo(String value) {
            addCriterion("friend_id <=", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLike(String value) {
            addCriterion("friend_id like", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotLike(String value) {
            addCriterion("friend_id not like", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdIn(List<String> values) {
            addCriterion("friend_id in", values, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotIn(List<String> values) {
            addCriterion("friend_id not in", values, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdBetween(String value1, String value2) {
            addCriterion("friend_id between", value1, value2, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotBetween(String value1, String value2) {
            addCriterion("friend_id not between", value1, value2, "friendId");
            return (Criteria) this;
        }

        public Criteria andTopicIdIsNull() {
            addCriterion("topic_id is null");
            return (Criteria) this;
        }

        public Criteria andTopicIdIsNotNull() {
            addCriterion("topic_id is not null");
            return (Criteria) this;
        }

        public Criteria andTopicIdEqualTo(String value) {
            addCriterion("topic_id =", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotEqualTo(String value) {
            addCriterion("topic_id <>", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThan(String value) {
            addCriterion("topic_id >", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdGreaterThanOrEqualTo(String value) {
            addCriterion("topic_id >=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThan(String value) {
            addCriterion("topic_id <", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLessThanOrEqualTo(String value) {
            addCriterion("topic_id <=", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdLike(String value) {
            addCriterion("topic_id like", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotLike(String value) {
            addCriterion("topic_id not like", value, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdIn(List<String> values) {
            addCriterion("topic_id in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotIn(List<String> values) {
            addCriterion("topic_id not in", values, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdBetween(String value1, String value2) {
            addCriterion("topic_id between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andTopicIdNotBetween(String value1, String value2) {
            addCriterion("topic_id not between", value1, value2, "topicId");
            return (Criteria) this;
        }

        public Criteria andHideMyselfIsNull() {
            addCriterion("hide_myself is null");
            return (Criteria) this;
        }

        public Criteria andHideMyselfIsNotNull() {
            addCriterion("hide_myself is not null");
            return (Criteria) this;
        }

        public Criteria andHideMyselfEqualTo(Boolean value) {
            addCriterion("hide_myself =", value, "hideMyself");
            return (Criteria) this;
        }

        public Criteria andHideMyselfNotEqualTo(Boolean value) {
            addCriterion("hide_myself <>", value, "hideMyself");
            return (Criteria) this;
        }

        public Criteria andHideMyselfGreaterThan(Boolean value) {
            addCriterion("hide_myself >", value, "hideMyself");
            return (Criteria) this;
        }

        public Criteria andHideMyselfGreaterThanOrEqualTo(Boolean value) {
            addCriterion("hide_myself >=", value, "hideMyself");
            return (Criteria) this;
        }

        public Criteria andHideMyselfLessThan(Boolean value) {
            addCriterion("hide_myself <", value, "hideMyself");
            return (Criteria) this;
        }

        public Criteria andHideMyselfLessThanOrEqualTo(Boolean value) {
            addCriterion("hide_myself <=", value, "hideMyself");
            return (Criteria) this;
        }

        public Criteria andHideMyselfIn(List<Boolean> values) {
            addCriterion("hide_myself in", values, "hideMyself");
            return (Criteria) this;
        }

        public Criteria andHideMyselfNotIn(List<Boolean> values) {
            addCriterion("hide_myself not in", values, "hideMyself");
            return (Criteria) this;
        }

        public Criteria andHideMyselfBetween(Boolean value1, Boolean value2) {
            addCriterion("hide_myself between", value1, value2, "hideMyself");
            return (Criteria) this;
        }

        public Criteria andHideMyselfNotBetween(Boolean value1, Boolean value2) {
            addCriterion("hide_myself not between", value1, value2, "hideMyself");
            return (Criteria) this;
        }

        public Criteria andBlockOppositeIsNull() {
            addCriterion("block_opposite is null");
            return (Criteria) this;
        }

        public Criteria andBlockOppositeIsNotNull() {
            addCriterion("block_opposite is not null");
            return (Criteria) this;
        }

        public Criteria andBlockOppositeEqualTo(Boolean value) {
            addCriterion("block_opposite =", value, "blockOpposite");
            return (Criteria) this;
        }

        public Criteria andBlockOppositeNotEqualTo(Boolean value) {
            addCriterion("block_opposite <>", value, "blockOpposite");
            return (Criteria) this;
        }

        public Criteria andBlockOppositeGreaterThan(Boolean value) {
            addCriterion("block_opposite >", value, "blockOpposite");
            return (Criteria) this;
        }

        public Criteria andBlockOppositeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("block_opposite >=", value, "blockOpposite");
            return (Criteria) this;
        }

        public Criteria andBlockOppositeLessThan(Boolean value) {
            addCriterion("block_opposite <", value, "blockOpposite");
            return (Criteria) this;
        }

        public Criteria andBlockOppositeLessThanOrEqualTo(Boolean value) {
            addCriterion("block_opposite <=", value, "blockOpposite");
            return (Criteria) this;
        }

        public Criteria andBlockOppositeIn(List<Boolean> values) {
            addCriterion("block_opposite in", values, "blockOpposite");
            return (Criteria) this;
        }

        public Criteria andBlockOppositeNotIn(List<Boolean> values) {
            addCriterion("block_opposite not in", values, "blockOpposite");
            return (Criteria) this;
        }

        public Criteria andBlockOppositeBetween(Boolean value1, Boolean value2) {
            addCriterion("block_opposite between", value1, value2, "blockOpposite");
            return (Criteria) this;
        }

        public Criteria andBlockOppositeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("block_opposite not between", value1, value2, "blockOpposite");
            return (Criteria) this;
        }

        public Criteria andInChattingIsNull() {
            addCriterion("in_chatting is null");
            return (Criteria) this;
        }

        public Criteria andInChattingIsNotNull() {
            addCriterion("in_chatting is not null");
            return (Criteria) this;
        }

        public Criteria andInChattingEqualTo(Boolean value) {
            addCriterion("in_chatting =", value, "inChatting");
            return (Criteria) this;
        }

        public Criteria andInChattingNotEqualTo(Boolean value) {
            addCriterion("in_chatting <>", value, "inChatting");
            return (Criteria) this;
        }

        public Criteria andInChattingGreaterThan(Boolean value) {
            addCriterion("in_chatting >", value, "inChatting");
            return (Criteria) this;
        }

        public Criteria andInChattingGreaterThanOrEqualTo(Boolean value) {
            addCriterion("in_chatting >=", value, "inChatting");
            return (Criteria) this;
        }

        public Criteria andInChattingLessThan(Boolean value) {
            addCriterion("in_chatting <", value, "inChatting");
            return (Criteria) this;
        }

        public Criteria andInChattingLessThanOrEqualTo(Boolean value) {
            addCriterion("in_chatting <=", value, "inChatting");
            return (Criteria) this;
        }

        public Criteria andInChattingIn(List<Boolean> values) {
            addCriterion("in_chatting in", values, "inChatting");
            return (Criteria) this;
        }

        public Criteria andInChattingNotIn(List<Boolean> values) {
            addCriterion("in_chatting not in", values, "inChatting");
            return (Criteria) this;
        }

        public Criteria andInChattingBetween(Boolean value1, Boolean value2) {
            addCriterion("in_chatting between", value1, value2, "inChatting");
            return (Criteria) this;
        }

        public Criteria andInChattingNotBetween(Boolean value1, Boolean value2) {
            addCriterion("in_chatting not between", value1, value2, "inChatting");
            return (Criteria) this;
        }

        public Criteria andValidIsNull() {
            addCriterion("valid is null");
            return (Criteria) this;
        }

        public Criteria andValidIsNotNull() {
            addCriterion("valid is not null");
            return (Criteria) this;
        }

        public Criteria andValidEqualTo(Boolean value) {
            addCriterion("valid =", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotEqualTo(Boolean value) {
            addCriterion("valid <>", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThan(Boolean value) {
            addCriterion("valid >", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("valid >=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThan(Boolean value) {
            addCriterion("valid <", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThanOrEqualTo(Boolean value) {
            addCriterion("valid <=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidIn(List<Boolean> values) {
            addCriterion("valid in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotIn(List<Boolean> values) {
            addCriterion("valid not in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidBetween(Boolean value1, Boolean value2) {
            addCriterion("valid between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("valid not between", value1, value2, "valid");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table friend
     *
     * @mbg.generated do_not_delete_during_merge Wed Jul 27 19:27:45 EDT 2022
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table friend
     *
     * @mbg.generated Wed Jul 27 19:27:45 EDT 2022
     */
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