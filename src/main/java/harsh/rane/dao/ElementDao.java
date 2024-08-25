package harsh.rane.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import harsh.rane.entity.ElementEntity;
import harsh.rane.repository.ElementRepository;

@Component
public class ElementDao {

	@Autowired
	ElementRepository elementRepository;
	
	public List<ElementEntity> getElements()
	{
		return elementRepository.findAll();
	}
	
	public ElementEntity addElements(ElementEntity element)
	{
		return elementRepository.save(element);
	}
}
