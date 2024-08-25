package harsh.rane.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ElementEntity {

	@Id
	private int element_id;
	private String element_name;
	private String element_ctgy_name;
	private Date effective_date;
	private String element_skey;
}
