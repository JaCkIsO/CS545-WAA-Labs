/**
 * 
 */
package com.students.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author B.Pirasanth
 *
 */
public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@Digits(integer = 3, fraction = 0, message = "This must be at most {2} digits")
	@Min(value = 100, message = "Cannot be less than {1}")
	@Max(value = 999, message = "Cannot be greater than {1}")
 	private Integer area;
	@NotNull
	@Digits(integer = 3, fraction = 0, message = "This must be at most {2} digits")
	@Min(value = 100, message = "Cannot be less than {1}")
	@Max(value = 999, message = "Cannot be greater than {1}")
 	private Integer prefix;
	@NotNull
	@Digits(integer = 4, fraction = 0, message = "This must be at most {2} digits")
	@Min(value = 1000, message = "Cannot be less than {1}")
	@Max(value = 9999, message = "Cannot be greater than {1}")
 	private Integer number;
	

 
	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

 	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getPrefix() {
		return prefix;
	}

	public void setPrefix(Integer prefix) {
		this.prefix = prefix;
	}
}
