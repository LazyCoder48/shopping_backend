package com.shop.dto;

import java.util.Date;

public class RegisterUser {

    private String contactNumber;
    private String userPassword;
    private String firstName;
    private String lastName;
    private String userType;
    private Date createdOn;
    private boolean userActive;

    /**
     * @return the contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * @param contactNumber
     *            the contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * @return the userPassword
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userPassword
     *            the userPassword to set
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType
     *            the userType to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @return the createdOn
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * @param createdOn
     *            the createdOn to set
     */
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * @return the userActive
     */
    public boolean isUserActive() {
        return userActive;
    }

    /**
     * @param userActive
     *            the userActive to set
     */
    public void setUserActive(boolean userActive) {
        this.userActive = userActive;
    }

    @Override
    public String toString() {
        return "RegisterUser [" + (contactNumber != null ? "contactNumber=" + contactNumber + ", " : "") + (userPassword != null ? "userPassword=" + userPassword + ", " : "")
            + (firstName != null ? "firstName=" + firstName + ", " : "") + (lastName != null ? "lastName=" + lastName + ", " : "") + (userType != null ? "userType=" + userType + ", " : "")
            + (createdOn != null ? "createdOn=" + createdOn + ", " : "") + "userActive=" + userActive + "]";
    }

}
