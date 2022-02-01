import java.util.ArrayList;

public class Greeting {
    public String greet(String[] names) {
        ArrayList<String> namesUpdated = new ArrayList<>();
        int strComma = -1;
        int strQuotes = -1;
        if(names != null){
            boolean quotePresent = checkForQuotes(names);
            if(quotePresent){
                for (int i = 0; i < names.length; i++) {
                    strQuotes = names[i].indexOf("\"");
                    if(strQuotes != -1){
                        String s = names[i].replace("\"","");
                        namesUpdated.add(s);
                    }else{
                        namesUpdated.add(names[i]);
                    }
                }
            }
            if(quotePresent == false){
                for (int i = 0; i < names.length; i++) {
                    strComma = names[i].indexOf(",");
                    if(strComma != -1){
                        String[] twoNames = names[i].split(" ");
                        namesUpdated.add(twoNames[0]);
                        namesUpdated.add(twoNames[1]);
                    }else{
                        namesUpdated.add(names[i]);
                    }
                }
            }
           names = new String[namesUpdated.size()];
            for (int i = 0; i < namesUpdated.size(); i++) {
                names[i] = namesUpdated.get(i);
            }
        }
        if(names == null){
            return "Hello, friend.";
        }
        else if(names.length == 1){
            if(isStringUppercase(names[0])){
                return "HELLO, " + names[0] + ".";
            }else{
                return "Hello, " + names[0] + ".";
            }
        }
        else{
            ArrayList<String> uppercase = new ArrayList<>();
            ArrayList<String> lowercase = new ArrayList<>();
            for (String s: names) {
                boolean upper = isStringUppercase(s);
                if(upper){
                    uppercase.add(s);
                }else{
                    lowercase.add(s);
                }
            }
            if(uppercase.size() == 0){
                int lengthOfArr = names.length;
                String returnable = "Hello, ";
                for (int i = 0; i < lengthOfArr; i++) {
                    if(i == (lengthOfArr - 2)){
                        returnable += names[i] + " and ";
                    }else if(i == lengthOfArr - 1){
                        returnable += names[i] + ".";
                    }else{
                        returnable += names[i] + ", ";
                    }
                }
                return returnable;
            }else if(lowercase.size() == 0) {
                int lower = lowercase.size();
                String returnable = "HELLO, ";
                for (int i = 0; i < lower; i++) {
                    if(i == (lower - 2)){
                        returnable += names[i] + " AND ";
                    }else if(i == lower - 1){
                        returnable += names[i] + "!";
                    }else{
                        returnable += names[i] + ", ";
                    }
                }
                return returnable;
            }else{
                int upper = uppercase.size();
                int lower = lowercase.size();
                String returnable = "Hello, ";
                for (int i = 0; i < lower; i++) {
                    if(i == (lower - 2)){
                        returnable += lowercase.get(i) + " and ";
                    }else if(i == lower - 1){
                        returnable += lowercase.get(i) + ".";
                    }else{
                        returnable += lowercase.get(i) + ", ";
                    }
                }
                for (int i = 0; i < upper; i++) {
                    if(i == 0 && uppercase.size() == 1){
                        returnable += " AND HELLO " + uppercase.get(i) + "!";
                    }else if(i == 0){
                        returnable += " AND HELLO " + uppercase.get(i);
                    }else if(i == upper - 1){
                        returnable += uppercase.get(i) + "!";
                    }else{
                        returnable += uppercase.get(i) + ", ";
                    }
                }
                return returnable;
            }
        }
    }

    public boolean isStringUppercase(String str){
        char[] charArray = str.toCharArray();
        for(int i=0; i < charArray.length; i++){
            if( !Character.isUpperCase( charArray[i] )) {
                return false;
            }
        }
        return true;
    }

    public boolean checkForQuotes(String[] names){
        int quoteCount = -1;
        for (int i = 0; i < names.length; i++) {
            quoteCount = names[i].indexOf("\"");
            if(quoteCount != -1){
                return true;
            }
        }
        return false;
    }
}
