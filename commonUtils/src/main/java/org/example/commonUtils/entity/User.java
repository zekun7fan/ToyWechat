package org.example.commonUtils.entity;

import java.time.LocalDateTime;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_id
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.bio
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    private String bio;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.sex
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    private Byte sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.email
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.avatar_url
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    private String avatarUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.background_url
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    private String backgroundUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.create_time
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    private LocalDateTime createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_id
     *
     * @return the value of user.user_id
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_id
     *
     * @param userId the value for user.user_id
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.name
     *
     * @return the value of user.name
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.name
     *
     * @param name the value for user.name
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.bio
     *
     * @return the value of user.bio
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public String getBio() {
        return bio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.bio
     *
     * @param bio the value for user.bio
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.sex
     *
     * @return the value of user.sex
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.sex
     *
     * @param sex the value for user.sex
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.email
     *
     * @return the value of user.email
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.email
     *
     * @param email the value for user.email
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.avatar_url
     *
     * @return the value of user.avatar_url
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.avatar_url
     *
     * @param avatarUrl the value for user.avatar_url
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.background_url
     *
     * @return the value of user.background_url
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.background_url
     *
     * @param backgroundUrl the value for user.background_url
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.create_time
     *
     * @return the value of user.create_time
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.create_time
     *
     * @param createTime the value for user.create_time
     *
     * @mbg.generated Sun May 22 12:57:06 EDT 2022
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}