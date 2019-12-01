package domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name = "Orders")
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderSatus status;

}
