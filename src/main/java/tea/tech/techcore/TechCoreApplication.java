package tea.tech.techcore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tea.tech.techcore.entity.Inventory;
import tea.tech.techcore.repository.InventoryRepository;

@SpringBootApplication
public class TechCoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(TechCoreApplication.class, args);
	}

	//membuat dummy data inventory
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("kacamata_5D");
			inventory.setQuantity(50);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("kacamata_5D_blue");
			inventory1.setQuantity(0);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}

}
