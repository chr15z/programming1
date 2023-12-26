/*
    Aufgabe 4) Rekursion
*/
public class Aufgabe4 {

    private static int countNOrderedPairs(String text, int index) {
        int out = 0;
        if (text != null && text.length() > 0 && index >= 0 && index < text.length()-1){
            if (text.charAt(index)<=text.charAt(index+1)){
             out++;
            }
            out += countNOrderedPairs(text,index+1);
        }
        return out;

    }

    private static String shiftAllSignsRight(String text, char sign) {
        String in = text;
        if (text==null) return null;
        else if (text.contains(String.valueOf(sign))){
            text = text.replaceFirst(String.valueOf(sign), "");
            text = text.concat(String.valueOf(sign));
            if(!text.equals(in)){
                text = shiftAllSignsRight(text, sign);
            }
        }
        return text;

    }

    public static void main(String[] args) {
        String text = "bhhebegcmoqast";
        System.out.println(countNOrderedPairs(text, 0));
        System.out.println(countNOrderedPairs(text, 2));
        System.out.println(countNOrderedPairs(text, 5));
        System.out.println(countNOrderedPairs(text, 6));
        System.out.println(countNOrderedPairs(text, 8));
        System.out.println();

        System.out.println(shiftAllSignsRight("az3kj", 'z'));
        System.out.println(shiftAllSignsRight("kjdn{nd8xngs+d#k", 'n'));
        System.out.println(shiftAllSignsRight("", 'e'));
        System.out.println(shiftAllSignsRight("4", '4'));
        System.out.println(shiftAllSignsRight("ji)o3ie6pk(2i", 'i'));
        System.out.println(shiftAllSignsRight("nothing", 'x'));

        assert (countNOrderedPairs(text, 0) == 9);
        assert (countNOrderedPairs(text, 2) == 7);
        assert (countNOrderedPairs(text, 5) == 6);
        assert (countNOrderedPairs(text, 6) == 5);
        assert (countNOrderedPairs(text, 8) == 4);

        assert (shiftAllSignsRight("az3kj", 'z').equals("a3kjz"));
        assert (shiftAllSignsRight("kjdn{nd8xngs+d#k",'n').equals("kjd{d8xgs+d#knnn"));
        assert (shiftAllSignsRight("", 'e').equals(""));
        assert (shiftAllSignsRight("4", '4').equals("4"));
        assert (shiftAllSignsRight("ji)o3ie6pk(2i", 'i').equals("j)o3e6pk(2iii"));
        assert (shiftAllSignsRight("nothing", 'x').equals("nothing"));
    }
}
