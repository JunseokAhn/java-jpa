package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity @Getter @Setter  @Table(name = "ORDER_ITEM")
public class OrderItem {


    @Id @Column(name = "ORDER_ITEM_ID")
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne @JoinColumn(name = "ITEM_ID")
    private Item item;
    private int orderPrice;
    private int count;

}
