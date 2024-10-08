package harsh.rane.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import harsh.rane.entity.ElementEntity;
import harsh.rane.model.Element;

@Component
public class ElementToElementEntityTransformer implements Function<Element, ElementEntity>{
	
	@Autowired
	Element ele;

	@Override
	public ElementEntity apply(Element element) {
		String sDate = element.getEffective_date();
		System.err.println(ele);
		return ElementEntity.builder()
				 .element_ctgy_name(element.getElement_ctgy_name())
				 .element_name(element.getElement_name())
				 .element_skey(null)
				 .effective_date(getConvertedDate(sDate))
				 .build();
	}
	
	private Date getConvertedDate(String s)
	{
	try {
		return new SimpleDateFormat("MMddyyyy", Locale.ENGLISH).parse(s);
	} catch (ParseException e) {
		e.printStackTrace();
		return null;
	}
	}

}
