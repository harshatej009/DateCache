package harsh.rane.dao;

import org.springframework.stereotype.Component;

import harsh.rane.model.Element;

@Component
public class ElementDao {


	public Element getElements()
	{
		return  Element.builder()
				.element_id("1").element_name("Ferrari")
				.element_skey("car")
				.element_ctgy_name("sports car")
				.build();
		
	}
}
