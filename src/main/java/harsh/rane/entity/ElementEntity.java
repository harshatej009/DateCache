package harsh.rane.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Builder
@NoArgsConstructor
@Entity
@Data
@Table(name = "element")
public class ElementEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int element_id;
	private String element_name;
	private String element_ctgy_name;
	private Date effective_date;
	private String element_skey;
	
	public ElementEntity (int id, String name, String cat, Date date, String skey) {
		
		this.element_name = name;
		this.element_ctgy_name = cat;
		this.element_skey = skey;
		this.effective_date = date;
	}
	
}
