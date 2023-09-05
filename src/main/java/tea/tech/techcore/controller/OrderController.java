package tea.tech.techcore.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tea.tech.techcore.dto.OrderRequest;
import tea.tech.techcore.service.OrderService;

@RestController
@RequestMapping("/api/order")
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    @RequestMapping("/create")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest request) {
        log.info("Incoming placeOrder");
        orderService.placeOrder(request);
        log.info("Outgoint placeOrder");
        return "Order Placed Successfully";
    }
}
