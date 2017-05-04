/**
 * Created by GozdeDogan on 30.04.2017.
 */
import java.util.NavigableMap;

public class hw7_131044019 {
    public static void main(String args[]){
        final Boolean q2 = Q2Test();
    }


    /**
     * Aynı keyden bir tane olacak sekilde implement edildi.
     * mesela edremit bir tane eklenir.
     * 2. edremit eklendiginde sadece value degisir.
     * @return
     */
    public static Boolean Q2Test(){
        System.out.println("\n\nTEST Q2>>>>>>>>>\n");
        HashMap<String,String> turkey=new HashTableChaining<String,String>();
        turkey.put("edremit","balikesir");
        turkey.put("edremit", "van");
        turkey.put("kemalpasa","bursa");
        turkey.put("kemalpasa","izmir");
        turkey.put("ortakoy","istanbul");//we assume a district
        turkey.put("ortakoy","aksaray");
        turkey.put("ortakoy","corum");
        turkey.put("pinarbasi","kastamonu");
        turkey.put("pinarbasi","kayseri");
        turkey.put("eregli","konya");
        turkey.put("eregli","tekirdag");
        turkey.put("eregli","zonguldak");
        turkey.put("golbasi", "adiyaman");
        turkey.put("golbasi", "ankara");
        turkey.put("biga", "canakkale");
        turkey.put("kecioren", "ankara");

        System.out.println("size:" + turkey.size());
        //System.out.println("\nElements:\n" + turkey.toString());
        System.out.println("\nget(\"kemalpasa\") : " + turkey.get("kemalpasa"));
        System.out.println("\nget(\"gebze\") : " + turkey.get("gebze"));
        System.out.println("\nput(\"biga\", \"bursa\") : " + turkey.put("biga", "bursa"));
        System.out.println("size:" + turkey.size());
        System.out.println("\nput(\"fsm\", \"bursa\") : " + turkey.put("fsm", "bursa"));
        System.out.println("size:" + turkey.size());
        //System.out.println("\nElements:\n" + turkey.toString());
        System.out.println("\nremove(\"kecioren\") : " + turkey.remove("kecioren"));
        System.out.println("size:" + turkey.size());
        System.out.println("\nremove(\"gebze\") : " + turkey.remove("gebze"));
        System.out.println("size:" + turkey.size() + "\n\n");
        //System.out.println("\nElements:\n" + turkey.toString());


        return Boolean.TRUE;
    }
}
