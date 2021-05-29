package Item_Feather;


class Ghost extends Thread {

    private static boolean played = false;

    public static void checkghost() {
        played = false;
    }

    public void run() {
               
        while (true) {
            while(played){ 
                 } 
            try {
                                                                
                Thread.sleep((int) (Math.random() +120000 ) + 180000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ghostgame g1 = new ghostgame();
            played =true;

        }

    }
}
