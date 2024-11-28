/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemanomina.application;

/**
 *
 * @author Francis Leantony
 */
public class app {
    public double CalcularEmpleadoHoras(double horastrabajadas, double sueldoporhora){
        double total = 0;
        if(horastrabajadas <= 40){
                        total = sueldoporhora * horastrabajadas;
                    }else if(horastrabajadas > 40){
                        total = (sueldoporhora * 40) + (sueldoporhora * 1.5 * (horastrabajadas - 40));
                    }
        return total;
    }
    
    public double CalcularEmpleadoComision(double ventabruta, double tarifa){
        double total = ventabruta * tarifa;
        return total;
    }
    
    public double CalcularEmpleadoComisionSalario(double ventasbrutas, double tarifa, double salariobase){
        double total = (ventasbrutas * tarifa) + salariobase + (salariobase * 0.10);
        return total;
    }
}
