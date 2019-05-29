/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import contract.ControllerOrder;
import controller.Controller;
import model.Model;
import view.View;

import java.util.TreeMap;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
        final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        view.setController(controller);


        //controller.control();
        //controller.orderPerform(ControllerOrder.);
        while (true)
        {
            try {

                Thread.sleep(1000);
            }catch (InterruptedException e)
            {
                System.out.println("test");
            }
            model.update();
        }
    }
}

//test,
