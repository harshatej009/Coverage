package harsh.rane.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

import harsh.rane.model.Patient;
import harsh.rane.service.JsonParse;

@RestController
public class ProducerController
{

	@Autowired
	private KafkaTemplate<String,Object> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplateString;
	
	@Autowired 
	private JsonParse jsonparse;
	
	private static final Logger LOGGER = LogManager.getLogger(ProducerController.class);
	
	@GetMapping("/produceJson")       
	public void Produce()
	{
		Patient patient=jsonparse.getLocalJson();
//		JsonObject patient=new JsonObject();
//		patient.addProperty("pid", "2");
//		patient.addProperty("aid", "1");
//		patient.addProperty("name", "Rony");
//		patient.addProperty("surname", "Rane");
//		
//		JsonObject address=new JsonObject();
//		address.addProperty("aid", "1");
//		address.addProperty("cid", "101");
//		address.addProperty("city", "Dubai");
//		address.addProperty("state", "Maharashtra");
//		
//		JsonObject contact=new JsonObject();
//		contact.addProperty("cid", "101");
//		contact.addProperty("contact_no", "7972976298");
//		contact.addProperty("emailIdd", "h.rane@infosys.com");
			
		kafkaTemplate.send("topicP",patient); 
		LOGGER.info("json message1 has been sent");
		LOGGER.info("message is patient");
		
			
	} 
	
	@GetMapping("/produceString")       //8085 port
	public void ProduceString()
	{
			kafkaTemplateString.send("topic2","INFOSYS BANGALORE"); 
			kafkaTemplateString.send("topic3","INFOSYS PUNE"); 
			
			LOGGER.info("StringMessage has been sent");
	} 
	
}

