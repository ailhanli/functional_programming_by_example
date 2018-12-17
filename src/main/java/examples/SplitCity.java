package examples;
import static java.util.stream.Collectors.toSet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;

public class SplitCity {
	public static void main(String[] args) throws IOException {

		String groupCode= args[0];
		if(groupCode==null){
			System.err.println("Please enter group code as command line parameter and make sure that existing and city_group.txt under the group directory");
			return;
		}
	
		Set<String> existingCities = Files
				.lines(Paths.get("..\\city_pair\\"+groupCode+"\\existing_cities.txt"))
				.collect(toSet());
		
		try(PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get("C:\\Users\\abdullah.ilhanli\\Desktop\\city_pair\\"+groupCode+"\\result.sql")))){
		
			Files
			.lines(Paths.get("..\\city_pair\\"+groupCode+"\\city_pair.txt"))
			.flatMap(a->Arrays.stream(new String[] {a.substring(0, 3), a.substring(3, 6)}))
			.distinct()
			.filter(c->!existingCities.contains(c))
			.sorted()
			.map(s->"insert into table1 (a ,b,c)  values ('"+groupCode+"','"+s+"',my_s.nextval);")
			.forEach(pw::println);
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}