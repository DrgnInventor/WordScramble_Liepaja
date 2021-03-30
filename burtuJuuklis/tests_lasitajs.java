package burtuJuuklis;

public class tests_lasitajs {
    
    public static void main(String[] args){
    Lasitajs ls = new Lasitajs();
    String[] temp_test = ls.lasiVardus();

    for (int i = 0; i < temp_test.length; i++){
        System.out.println(temp_test[i]);
    }
}
}
