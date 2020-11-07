package taller.facade.dominio;


import taller.facade.access.IOrderRepository;
import taller.facade.access.Factory;
import taller.facade.dominio.State;
import taller.facade.dominio.Customer;
import taller.facade.dominio.Dish;
import taller.facade.dominio.OrderFacade;

/*
 * Cliente que llama a los servicios de la facada
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class Main {
    
    public static void main(String[] args) {
        OrderFacade facade = new OrderFacade();
        facade.createOrder(new Customer(1, "Carlos Sanchez", "Calle 12 No. 12-12 BarrioCaldas", "3115677899", "Popayán"));
        facade.addDish(new Dish(1, "Hamburguesa vegetariana", 5000), 2);
        facade.addDish(new Dish(2, "Hamburguesa sencilla", 4000), 3);
        facade.addDish(new Dish(3, "Jugo hit", 1000), 2);
        System.out.println("Pedido creado");
        facade.changeState(State.CONFIRMED);
        System.out.println("Se cambio el estado a " + facade.getOrder().getState());
        facade.changeState(State.DISPACHED);
        System.out.println("Se cambio el estado a " + facade.getOrder().getState());
        facade.changeState(State.FINALIZED);
        System.out.println("Se cambio el estado a " + facade.getOrder().getState());
        System.out.println("El valor total del pedido es: " + facade.calculateTotal());
        System.out.println("Total de platos pedidos: " + facade.totalDishes());
        System.out.println("Pedido grabado con éxito en la base de datos");
        IOrderRepository repo = Factory.getInstance().getRepository("default");
        facade.save(repo);
        System.out.println("Pedido grabado con éxito en la base de datos");
 }
}

