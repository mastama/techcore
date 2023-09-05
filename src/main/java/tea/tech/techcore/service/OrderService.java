package tea.tech.techcore.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tea.tech.techcore.dto.OrderLineItemsDto;
import tea.tech.techcore.dto.OrderRequest;
import tea.tech.techcore.entity.Order;
import tea.tech.techcore.entity.OrderLineItems;
import tea.tech.techcore.repository.OrderRepository;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest request) {
        log.info("Start placeOrder");
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = request.getOrderLineRequestListDto()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemsList(orderLineItems);
        //save to db
        log.info("Start save to db");
        orderRepository.save(order);
        log.info("End placeOrder and save to db");
    }

    private OrderLineItems mapToDto(OrderLineItemsDto requestDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(requestDto.getPrice());
        orderLineItems.setQuantity(requestDto.getQuantity());
        orderLineItems.setSkuCode(requestDto.getSkuCode());
        return orderLineItems;
    }
}
