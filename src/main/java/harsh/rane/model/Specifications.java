package harsh.rane.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Specifications {
	
	public String engineType; 
	public String transmission;
	
	public Specifications()
	{
		this.engineType = "Diesel";
		this.transmission = "Automatic";
	}

}
