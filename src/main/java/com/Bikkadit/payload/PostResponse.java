package com.Bikkadit.payload;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class PostResponse {
	
	private List<PostDto> content;
	private int pageno;
	private int pagesize;
	private long totalElement;
	private int totalpages;
	private boolean lastpage;
	

}
