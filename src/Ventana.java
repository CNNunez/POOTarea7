// Imports
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Ventana extends JFrame implements ActionListener{
    // Buttons
    JButton btn_1;
    JButton btn_2;
    JButton btn_3;

    // Variables
    boolean press_1 = false;
    boolean press_2 = false;

    public Ventana(){
        super("Restaurant Window"); // para ponerle titulo
        // Detalles de ventana
        int width = 300;
        int height = 190;

        // Crear ventana
        //JFrame ventana = new JFrame(nombreVentana);
        this.setPreferredSize(new DimensionUIResource(width, height));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Llenar la ventana
        agregarComponentes();

        // Acomoda el tamano y ver la ventana
        this.pack();
        this.setVisible(true);
        
    }



    private void agregarComponentes(){
        this.setLayout(null);

                //--------------------------------------------------------------------
        btn_1 = new JButton("Boton 1");
        btn_1.setBounds(50,25+40*0,200,25);//.setBounds(x, y, width, height)
        this.add(btn_1);
        
        btn_1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try{
                    if(press_1 == false ){
                        press_1 = true;
                    }
                    else if(press_1 == true ){
                        throw new Exception("Este boton ya fue presionado. Vuelva a empezar!");
                    }
                }
                catch(Exception e1){
                    System.out.println("Error boton 1:" + e1);
                    press_1 = false;
                    press_2 = false;
                }
            }
        });

        //--------------------------------------------------------------------
        btn_2 = new JButton("Boton 2");
        btn_2.setBounds(50,25+40*1,200,25);//.setBounds(x, y, width, height)
        this.add(btn_2);

        btn_2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try{
                    if ((press_1 == true) & (press_2 == false)){
                        press_2 = true;
                    }
                    else if(press_2 == true ){
                        throw new Exception("Este boton ya fue presionado. Vuelva a empezar!");
                    }
                    else{
                        throw new Exception("El boton no fue presionado en el orden correcto. Vuelva a empezar!");
                    }
                }
                catch(Exception e1){
                    System.out.println("Error boton 2:" + e1);
                    press_1 = false;
                    press_2 = false;
                }
            }
        });

        //--------------------------------------------------------------------
        btn_3 = new JButton("Boton 3");
        btn_3.setBounds(50,25+40*2,200,25);//.setBounds(x, y, width, height)
        this.add(btn_3);

        btn_3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try{
                    if ((press_1 == true) & (press_2 == true)){
                        System.out.println(" ** Los botones se presionaron en el orden correcto. Vuelva a empezar");
                    }
                    else{
                        throw new Exception("El boton no fue presionado en el orden correcto. Vuelva a empezar!");
                    }
                }
                catch(Exception e1){
                    System.out.println("Error boton 3:" + e1);
                }
                finally{
                    press_1 = false;
                    press_2 = false;
                }
            }
        });
    }
}