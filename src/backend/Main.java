package backend;
/**
 * Created by Valtteri on 7.7.2017.
 */
public class Main {
    public static void main(String[] args){
        /*AmicaDecoder test = new AmicaDecoder();
        try {
            Restaurant alvari = test.parseJSON("fi", "0190");
            System.out.println(alvari.getName());

            for(DayMenu dm: alvari.getDayMenus()){
                for(LunchOption lo: dm.getLunchOptions()){


                   for (String component : lo.getComponents()) {
                      System.out.println(component);
                   }
                   System.out.println("\n----------------------\n");
                }
                System.out.println("NEW DAY");
            }*/

        try{
           new Test();
           SodexoDecoder test = new SodexoDecoder();
           Restaurant cs = test.parseJSON("fi","142");

           for(DayMenu dm: cs.getDayMenus()){
               for(LunchOption lo: dm.getLunchOptions()){
                   for(String component: lo.getComponents()){
                       System.out.println(component);
                   }
                   System.out.println("\n----------------------\n");
               }
               System.out.println("NEW DAY");
           }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
