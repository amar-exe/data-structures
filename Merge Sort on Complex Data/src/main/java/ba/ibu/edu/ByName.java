package ba.ibu.edu;

import java.util.Comparator;

public class ByName implements Comparator<IPAddress> {

    @Override
    public int compare(IPAddress v, IPAddress w){
        return v.getCityName().compareTo(w.getCityName());
    }
}
