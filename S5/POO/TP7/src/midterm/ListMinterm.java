package midterm;

import java.util.ArrayList;

public class ListMinterm extends ArrayList<Minterm> {
    @Override
    public String toString() {
        if (size()==0) return "";
        int v=0; for(Minterm minterm : this)
            if (!minterm.isMarked) v++;
        if (v==0) return "";
        String res="[";
        for(Minterm minterm : this) {
            if (!minterm.isMarked) res = res +minterm+",";
        }
        return res.substring(0, res.length() - 1)+ "]";
        //return super.toString();
    }
}