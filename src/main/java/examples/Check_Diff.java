package examples;

import java.util.Arrays;

public class Check_Diff {

	//finding diff between two array
	public static void main(String[] args) {
		
		String[] original = {
				
				"  a                  NUMBER not null,",
				"  b                VARCHAR2(16 CHAR) not null,",
				"  c                     VARCHAR2(5 CHAR),",
				"  v            CHAR(1 CHAR),",				
		};
		
		String[] replica = {
				
				"  x                  NUMBER not null,",
				"  y                 VARCHAR2(16 CHAR),",
				"  a            CHAR(1 CHAR),",
				"  b            DATE,",
				"  c                  VARCHAR2(10 CHAR) not null,",
		};
		
		
		Arrays
		.stream(original)
		.map(String::trim)
		.map(s->s.split("\\s+")[0])
		//.peek(System.out::println)
		.filter(s-> 
					Arrays
					.stream(replica)
					.map(String::trim)
					.map(sp->sp.split("\\s+")[0])
					.filter(rp->rp.equals(s))
					//.peek(System.out::println)
					.findAny()
					.orElse(null)==null)
		.forEach(s->System.out.println(s));
	}
}