package project.dto;

import lombok.Data;

@Data
public class CommentDto {		   
	private int commentIdx;		   
	private String commentContents;
	private String commentCreatedId;
	private String commentCreatedDt;
	private String commentUpdatedDt;
	private String commentDeletedYn;
	private int boardIdx;
}
