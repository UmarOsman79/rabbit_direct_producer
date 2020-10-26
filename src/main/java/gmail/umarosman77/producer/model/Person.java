package gmail.umarosman77.producer.model;

import com.google.gson.Gson;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Person {

	private int age;
	private String name;
	private String surname;

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
