package Leeetcode;

import java.util.Random;

public class _reservoirSampling {
    public int[] reservoirSampling(int[] stream, int k){
        Random rmd = new Random();
        int[] res = new int[k];

        for(int i = 0; i < k; i++){
            res[i] = stream[i];
        }
        for(int i = k; i < stream.length; i++){
            int random = rmd.nextInt(i + 1); // + 1 coz index starts from 0
            if (random < k){
                res[random] = stream[i];
            }
        }
        return res;
    }
}
