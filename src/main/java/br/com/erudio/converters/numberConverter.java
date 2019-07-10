package br.com.erudio.converters;

public  class numberConverter {
    public static  Double ConvertToDouble(String strNumber){
        if(strNumber==null) return 0D;
        String number = strNumber.replaceAll(",",".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 1D;

    }
    public static boolean isNumeric(String strNumber){
        if(strNumber==null){
            return false;
        }
        String number = strNumber.replaceAll(",",".");
        return number.matches("^[0-9]+$");
    }
}