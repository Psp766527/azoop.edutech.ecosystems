package com.pradeep.emp.demo.commons;

/**
 * This class is responsible for managing common constants which is used many times in the code.
 */
public class Constants {

    /**
     * The student documentName which is going to address the Student Master.
     */
    public static final String studentCollectionName = "ms_student";

    /**
     *The teacher documentName which is going to address the Teacher Master.
     */
    public static final String teacherCollectionName = "ms_teacher";

    /**
     *The run time exception documentName which is going to address the Student Master.
     */
    public static final String exceptionCollectionName = "re_exception";

    /**
     * The email validation regex.Which will validate the email id of the user.
     */
    public static final String validEmailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * The phone validation regex.Which will validate the phone or mobile number.
     */
    public static final String validPhoneRegex = "^\\+?\\d[\\d ()-]{8,12}\\d$";

    /**
     * The password validation regex.Which will validate the password.
     */
    public static final String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*]).{8,}$";

    /**
     * The userName validation regex.Which will validate the userName.
     */
    public static final String userNameRegex = "^[a-zA-Z0-9._-]{3,}$";

}
