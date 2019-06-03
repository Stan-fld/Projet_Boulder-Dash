/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import contract.IModel;
import controller.Controller;
import entity.GameProperties;
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
        final IModel model = Controller.loadLevel(GameProperties.getInstance().getLevel());
        final View view = new View(model);
        final Controller controller = new Controller(view, model);
        view.setController(controller);


        //controller.control();
        //controller.orderPerform(ControllerOrder.);
        while (true)
        {
            try {
                Thread.sleep(10);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            controller.control();
        }
    }
}

//test,
