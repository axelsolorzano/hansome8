package gradiente;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import javax.swing.JOptionPane;

public class agentegradiante extends Agent{
    
    helperaritmetic ha = new helperaritmetic();
    
    boolean zira=ha.cuadrado();
    double b0=ha.getB0();
    double b1=ha.getB1();
    
  /*  public void displayGradienteEquation(){
        
        System.out.println("                               ┌                ┐");
        System.out.println("                               │ a/aB0 ƒ(B0,B1) │");
        System.out.println("Gradient Equation ▼ƒ(B0, B1) =│                │");
        System.out.println("                               │ a/aB1 ƒ(B0,B1) │");
        System.out.println("                               └                ┘");
        
    }//Fin public void displayRegressioEquation*/
    
    public void Error(){
        
        System.out.println("Error: " + String.format("%.7f", ha.getError()));
        
    }//Error
    
    public double prediccion(){
        
        double n=Float.parseFloat(JOptionPane.showInputDialog("Ingresa El Valor a Predecir"));
        double prediccion=b0+b1*n; 
        System.out.println("Predict: " + prediccion);
        
        return prediccion;
    }//prediccion
    
    @Override
    protected void setup(){
        
        System.out.println("Agent " + getLocalName() + " Started.");
        addBehaviour(new MyOneShotBehaviour());
        
    }//Fin protected void setup
    
    private class MyOneShotBehaviour extends OneShotBehaviour{
        
        @Override
        public void action(){
            
            agentegradiante g = new agentegradiante();
            
           // GR.displayGradienteEquation();
            g.Error();
            g.prediccion();
            
        }//Fin public void action
    
        @Override
        public int onEnd(){
            
            myAgent.doDelete();
            return super.onEnd();
            
        }//Fin public int onDelete 
    }//MyOneShotBehaviour
}//agentegradiante