/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.facade.access;
import taller.facade.dominio.Order;

/**
 *
 * @author DAAC
 */
public interface IOrderRepository {

   public void save(Order order);
    
}
