package main.exceptions;

public class UserException extends Exception{
    public static String USER_NOT_FOUND_EXCEPTION = "Could not find user";
    public static String USER_NOT_CREATED_EXCEPTION = "Could not create user";
    public static String USER_NOT_UPDATE_EXCEPTION = "Could not update user";

    public static String USER_NOT_DELETED_EXCEPTION = "Could not delete user";
    public UserException(String message){
        super(message);
    }
}
