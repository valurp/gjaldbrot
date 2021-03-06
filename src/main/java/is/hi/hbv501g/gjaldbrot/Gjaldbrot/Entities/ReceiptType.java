package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities;
import java.awt.Color;


/**
 * A small class containing an implementation of the enum Type, as well as a method for
 * color coding each type
 */

public class ReceiptType {
    public enum Type{
        MATARINNKAUP,
        FATNADUR,
        VEITINGASTADUR,
        SKEMMTUN_OG_AFTREYING,
        AFENGI,
        TOBAK
    }

    /**
     * A simple method providing colors for receipt types
     * @param type is the receipt type
     * @return color associated with receipt type
     * @throws Exception if given type does not exist
     */
    public static Color TypeColor(Type type) throws Exception {
        switch (type) {
            case MATARINNKAUP:
                return Color.BLUE;
            case FATNADUR:
                return Color.GREEN;
            case VEITINGASTADUR:
                return Color.YELLOW;
            case SKEMMTUN_OG_AFTREYING:
                return Color.RED;
            case AFENGI:
                return Color.PINK;
            case TOBAK:
                return Color.BLACK;
            default:
                break;
        }
        throw new Exception("Inputted type does not belong to enum Type");
    }

    /**
     * Einfalt fall sem leyfir heiltölum að vera túlkaðar sem Type
     * @param i heiltala frá 1-6
     * @return Type
     */
    public static Type intToType(int i){
        switch (i){
            case 0:
                return Type.MATARINNKAUP;
            case 1:
                return Type.FATNADUR;
            case 2:
                return Type.VEITINGASTADUR;
            case 3:
                return Type.SKEMMTUN_OG_AFTREYING;
            case 4:
                return Type.AFENGI;
            case 5:
                return Type.TOBAK;
            default:
                break;
        }
        return null;
    }
    /**
     * Einfalt fall sem túlkar type sem heiltölur
     * @param t Type af type type
     * @return i
     */
    public static int typeToInt(Type t){
        switch (t){
            case MATARINNKAUP:
                return 0;
            case FATNADUR:
                return 1;
            case VEITINGASTADUR:
                return 2;
            case SKEMMTUN_OG_AFTREYING:
                return 3;
            case AFENGI:
                return 4;
            case TOBAK:
                return 5;
            default:
                break;
        }
        return 0;
    }

    public static void main(String[] args){
        System.out.println("Hello world");
    }
}
