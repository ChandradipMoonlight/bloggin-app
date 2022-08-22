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
	
	POST_CREATED("Post Saved Successfully!"),
	POST_UPDATED("Post Is Updated Successfully!"),
	POST_DELETED("Post Is Deleted Successfully!"),
	FETCHED_ALL_POSTS("All Posts are Fetched Successfully!"),
	FETCHED_POST("Post Is Fetched Successfully!"),
	IMAGE_UPLOADED("Image Uploaded Successfully!"),
	
	COMMENT_ADDED("Comment saved successfully!"),
	COMMENT_DELETED("Comment Deleted Successfully!"),
	COMMENT_UPDATED("Comment Updated Successfully!"),
	FETCHED_ALL_COMMENTS("All command fetched Successfully!"),
	FETCHED_POST_COMMENTS("Fetched All Comments For Post!"),
	
	;
	private String message;

    MessageProperties(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
