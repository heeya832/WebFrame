package kr.ac.hansung.csemall;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor 
@ToString
public class Offer {

	private int year;
	private int semester;
	private String code;
	private String name;
	private String division;
	private int credit;
	
}
