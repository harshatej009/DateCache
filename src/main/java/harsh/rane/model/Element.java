package harsh.rane.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Component
@JsonPropertyOrder({ "effective_date", "element_name" })
public class Element {
	
	private String element_name;
	private String element_ctgy_name;
	private String effective_date;
	@JsonAlias({ "skey" })
	private String element_skey;

	private Specifications specifications;
	
	@Autowired
	public Element(Specifications specs)
	{
		this.specifications = specs;
		System.err.println("value is set "+this.specifications.getEngineType());
	}	
}
