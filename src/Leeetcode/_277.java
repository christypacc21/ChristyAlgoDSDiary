package Leeetcode;

public class _277 {
    // * there may be either no or 1 celebrity there. * if there is celebrity(abbr: C), everyone know him and he does  not know anyone.
    public static int _277(int n){
        if(n < 2) return -1; // coz you are not the celebrity

        int res = 0; //assume the first person is the celebrity
        for(int i = 1; i < n; i++){
            if(knows(res, i)) {
                res = i; // if res knows i , then res must not be the C(coz C does not know anyone). so we assign "res" to i (coz i was known by someone (tho we dunno yet if i knows anyone else))
            }
        }

        // now variable "res" represents the only last possibility of the potential C (the 最後希望)
        // now, we already know that res is know by a person((his i) - 1), and res does not know anyone after his (i)(eg n is 8 and his i is 3, then we know he dunno i=4,5,6,7(starts from 0 so last one is n-1)).
        // But we not sure yet if res fulfill the requirement to be a C. so do the following:
        for( int i = 0; i < n; i++){
            if (res != i && (knows(res, i) || !knows(i, res))){ // current person(i) is not res && (res X know the current person(i) || the current person(i) dunno him), then res is not a C.
                return -1;
            }
        }
        return res;
    }

    public static boolean knows(int a,int b){ // just a quick func made by ting for testing
        if(b == 5){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(_277(10));
    }
}
