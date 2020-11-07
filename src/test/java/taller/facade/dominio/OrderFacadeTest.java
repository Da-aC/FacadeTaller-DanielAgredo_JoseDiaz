/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.facade.dominio;


import taller.facade.dominio.Customer;
import taller.facade.dominio.Dish;
import taller.facade.dominio.OrderFacade;
import taller.facade.dominio.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DAAC
 */
public class OrderFacadeTest {
 @Test
 public void testCreateOrder() {
 OrderFacade facade = new OrderFacade();
 facade.createOrder(new Customer(1, "Carlos Sanchez", "Calle 12 No. 12-12 BarrioCaldas", "3115677899", "Popayán"));
 facade.addDish(new Dish(1, "Hamburguesa vegetariana", 5000), 2);
 facade.addDish(new Dish(2, "Hamburguesa sencilla ", 4000), 3);
 facade.addDish(new Dish(3, "Jugo hit ", 1000), 2);
 assertEquals("Hamburguesa vegetariana", facade.getOrder().getDetails().get(0).getDish().getName());
 assertEquals(State.NEW, facade.getOrder().getState());
 facade.changeState(State.FINALIZED);
 assertEquals(State.FINALIZED, facade.getOrder().getState());
 assertEquals(3, facade.totalDishes());
 assertEquals(25500, facade.calculateTotal());
 facade.cancelOrder();
 facade.changeState(State.CANCELLED);
 }
}
