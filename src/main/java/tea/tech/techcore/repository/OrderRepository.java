package tea.tech.techcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tea.tech.techcore.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
