/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.facade.dominio;

import taller.facade.access.IOrderRepository;

/**
 *
 * @author DAAC
 */
public class OrderFacade {
    private Order order;
    
    public void addDish(Dish dish, int i) {
        order.addDish(dish,i); 
    }

    public void createOrder(Customer customer) {
       order = new Order(customer); 
    }

    public Order getOrder() {
        return this.order;
    }

    public int calculateTotal() {
        return order.calculateTotal(); 
    }

    public int totalDishes() {
        return order.getDetails().size();
    }

    void cancelOrder() {
        order.setState(State.CANCELLED);
    }

    public void changeState(State state) {
        order.setState(state);
    }

    public void save(IOrderRepository repo) {
        repo.save(order);
    }
}
