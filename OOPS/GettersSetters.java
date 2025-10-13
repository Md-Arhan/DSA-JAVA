public class GettersSetters {

    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.SetColor("blue");
        System.out.println(p1.getColor());
        p1.SetTip(5);
        System.out.println(p1.getTip());
    }
}

class Pen {
    //Prop + functions
    private String color;
    private int tip;

    String getColor(){           //getters
         return this.color;
    }

    int getTip(){               //getters
        return this.tip;
    }

    void SetColor(String newColor){      //setters
        this.color = newColor;   
    }

    void SetTip(int tip){              //setters
        /*->this.tip refers to the property defined under the class*/ 
        this.tip = tip  /*<- tip refers to the external variable which is defined under the parameters*/;
    }
}