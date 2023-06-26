package project.dto;

import lombok.Data;

@Data					
public class BoardDto {		   
	private int boardIdx;		   
	private String boardTitle;
	private String boardContents;
	private int boardHitCnt;
	private String boardCreatedId;
	private String boardCreatedDt;
	private String boardUpdatedDt;
	private String boardUpdatedId;
	
	
}
