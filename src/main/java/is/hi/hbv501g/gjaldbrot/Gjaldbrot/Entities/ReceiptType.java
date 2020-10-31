package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities;

import javafx.scene.paint.Color;

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
    public Color TypeColor(Type type) throws Exception {
        switch (type) {
            case MATARINNKAUP:
                return Color.DARKBLUE;
            case FATNADUR:
                return Color.DARKGREEN;
            case VEITINGASTADUR:
                return Color.YELLOW;
            case SKEMMTUN_OG_AFTREYING:
                return Color.DARKRED;
            case AFENGI:
                return Color.MEDIUMPURPLE;
            case TOBAK:
                return Color.SADDLEBROWN;
            default:
                break;
        }
        throw new Exception("Inputted type does not belong to enum Type");
    }
    public static void main(String[] args){
        System.out.println("Hello world");
    }
}
