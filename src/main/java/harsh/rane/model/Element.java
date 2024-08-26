package harsh.rane.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
public class Element {
	
	private String element_name;
	private String element_ctgy_name;
	private String effective_date;
	private String element_skey;

}
