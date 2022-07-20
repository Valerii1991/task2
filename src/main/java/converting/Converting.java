package converting;

public class Converting {
    public static  int convertFromStringToInt(String s) {
        try{
            return Integer.valueOf(s);
        }
        catch (NumberFormatException e){
            return -1;
        }
    }

    public static double convertFromStringToDouble(String s){
        try{
            return Double.valueOf(s);
        }
        catch (NumberFormatException e){
            return 0;
        }
    }
}
