package divinae;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by david on 21/11/2016.
 */
public class Partie {
    private static Partie ourInstance = null;

    public static Partie getInstance()
    {
       if(ourInstance==null)
       {
           ourInstance=new Partie();
       }
        return ourInstance;
    }

    private Partie()
    {
        System.out.println("Partie créée");
    }
}
