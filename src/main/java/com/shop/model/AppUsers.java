package com.shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "users")
public class AppUsers {

    @Id
    private String contactNumber;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private String contactEmail;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private String userType;

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
     * @return the contactEmail
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * @param contactEmail
     *            the contactEmail to set
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
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

    @Override
    public String toString() {
        return "AppUsers [" + (contactNumber != null ? "contactNumber=" + contactNumber + ", " : "") + (firstName != null ? "firstName=" + firstName + ", " : "")
            + (lastName != null ? "lastName=" + lastName + ", " : "") + (contactEmail != null ? "contactEmail=" + contactEmail + ", " : "")
            + (userPassword != null ? "userPassword=" + userPassword + ", " : "") + (userType != null ? "userType=" + userType : "") + "]";
    }

}
