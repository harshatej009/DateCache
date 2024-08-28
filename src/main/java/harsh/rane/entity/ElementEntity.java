package harsh.rane.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@Entity
@Data
@Table(name = "element")
@JsonPropertyOrder({ "effective_date", "element_name" })
@JsonIgnoreProperties({ "element_ctgy_name" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ElementEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int element_id;
	private String element_name;
	private String element_ctgy_name;
	@JsonProperty("date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date effective_date;
	@JsonIgnore
	private String element_skey;
	
	public ElementEntity (int id, String name, String cat, Date date, String skey) {
		
		this.element_name = name;
		this.element_ctgy_name = cat;
		this.element_skey = skey;
		this.effective_date = date;
	}
	
}
