package seleniumframe.datafiles;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumFrameworkTutorial.A_05jsonconcept;
public class A_01javaJsonMethods extends A_05jsonconcept {
	
	public List<HashMap<String, String>> jsonDataReaders(String path) throws IOException {
		
//which will read json file it will scan the content of json and convert that into string variable	
		
//01.)read or convert json to string
	String jsontoString = 	FileUtils.readFileToString(new File(path), 
			StandardCharsets.UTF_8);
	
//02.)read or convert string to hashmap by jackson Databind(imp)
	
	ObjectMapper mapper = new ObjectMapper();
	
	 List<HashMap<String, String>> data= mapper.readValue(jsontoString, new TypeReference<List<HashMap<String,String>>>() {});
	 return data;

}
}

