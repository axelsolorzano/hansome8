package gradiente;

import static java.lang.Math.pow;

public class helperaritmetic {
    
    dataset dato = new dataset();
    
    double[] x = dato.getx();
    double[] y = dato.gety();
    
    double b0 = 0;
    double b1 = 0;
    double a = 0.003;
    double error = 0;
    
    public double sacarB0(double b0, double b1){
        
        double sacarB0 = 0;
        
        for(int i=0;i<=9-1;i++){            
            sacarB0=+(y[i]-(b0+b1*x[i]));       
        }
        
        sacarB0=-2*sacarB0/9;       
        return sacarB0;       
    }//sacarB0
    
    public double sacarB1(double b0, double b1){
        
        double sacarB1=0;        
        for(int i=0;i<=9-1;i++){
            
            sacarB1=+x[i]*(y[i]-(b0+b1*x[i])); 
        }
       
        sacarB1=-2*sacarB1/9;
        return sacarB1;
    }//sacatB1
    
    public double err(double b0, double b1){
        
        double err = 0;
        
        for(int i = 0; i <= 9-1; i++){           
            err=pow((y[i]-(b0+b1*x[i])),2);           
        }
        
        err=1*err/9;
        
        return err;
        
    }//err
    
    public boolean cuadrado(){
        
        double nb0 = 0;
        double nb1 = 0;
        
        double err = this.err(nb0, nb1);
        
        double sarB0;
        double sarB1;
        
        while(err > a){
            
            sarB0=this.sacarB0(nb0, nb1);
            sarB1=this.sacarB0(nb0, nb1);
            
            nb0=nb0-sarB0*a;
            nb1=nb1-sarB1*a;
            
            err=this.err(nb0, nb1);
            
        }//Fin while
        
        b0 = nb0;
        b1 = nb1;
        error = err;
        
        return true;
        
    }//cuadrado
    
    public double getB0(){
        
        return b0;
    }//getB0
    
    public double getB1(){
        
        return b1; 
    }//getB1
    
    public double getError(){
        
        return error; 
    }//getError
}//helperaritmetic
