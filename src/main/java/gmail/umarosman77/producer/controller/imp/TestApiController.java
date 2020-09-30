package gmail.umarosman77.producer.controller.imp;

import gmail.umarosman77.producer.controller.TestApi;
import gmail.umarosman77.producer.model.Person;
import gmail.umarosman77.producer.service.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApiController implements TestApi {

	@Autowired
	RabbitMqSender rabbitMQSender;

	@Override
	public ResponseEntity<Void> testPost() {
		try {
			rabbitMQSender.send(Person.builder()
					.name("Mia")
					.surname("Jaffer")
					.build());
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
