package com.blog.app.builder;

public enum MessageProperties {
	USER_ALREADY_PRESENT("User Is Already Present!"),
	ID_NOT_FOUND("User Not Found!"),
	REGISTRATION_SUCCESSFUL("Registration Successfull."),
	FETCH_ALL_USERS("All Users Fetched Successfully!"),
	FETCHED_USER("User Fetched Successfully"),
	UPDATEED_USER("User Updated Successfully!"),
	DELETED_USER("User Deleted Succcessfully!"),
	
	DELETED_CATEGORY("Category Is Deleted Successfully!"),
	CREATED_CATEGORY("Category Is Saved Successfully!"),
	UPDATED_CATEGORY("Category Is Updated Successfully!"),
	FETCHED_ALL_CATEGORY("All Categories are Fetched Successfully!"),
	FETCHED_CATEGORY("Category Is Fetched Successfully"),
	
	;
	private String message;

    MessageProperties(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
