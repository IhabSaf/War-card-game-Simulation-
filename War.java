package simulation.src.main.java;
import java.util.ArrayList;

class War {
    private ArrayList<Integer> deck;

    public War(ArrayList<Integer> deck) {
        this.deck = deck;
    }

    public int drawCard(ArrayList<Integer> stack) {
         int myCard;
          myCard= stack.get(0);
          return myCard;
    }

    public int simulateGame() {
        /// ...
        int score = 0;
        ArrayList<ArrayList<Integer>> A$B = card_delen(deck);
        ArrayList<Integer> A = A$B.get(0);  //Lijst van speler A
        ArrayList<Integer> B = A$B.get(1);  //Lijst van speler B.
        boolean simulating = true;
        while (simulating){
            if(A.isEmpty()){return -1;}
            if(B.isEmpty()){return 1;}
            if(A.isEmpty() && B.isEmpty()){return  0;}
            if(drawCard(A) > drawCard(B)){
                 A.add(B.get(0));
                 A.add(A.get(0));
                 B.remove(0);
                 A.remove(0);
            }
            else if(drawCard(A) < drawCard(B)){
                B.add(B.get(0));
                B.add(A.get(0));
                A.remove(0);
                B.remove(0);
            }
            else if(drawCard(A) == drawCard(B)){
                //verklaar oorlog
                int cards = 3;
                while (true){
                    if(A.size() < cards){return  -1;}
                    if(B.size() < cards){return  1;}
                    if(A.size() < cards && B.size() <cards){return  0;}
                    if(A.get(cards) > B.get(cards)){
                        for(int x=0; x < cards; x++){
                            A.add(B.get(0));
                            A.add(A.get(0));
                            B.remove(0);
                            A.remove(0);
                        }
                        break;
                    }
                    else if(A.get(cards) < B.get(cards)){
                        for(int x=0; x < cards; x++){
                            B.add(B.get(0));
                            B.add(A.get(0));
                            B.remove(0);
                            A.remove(0);
                        }
                        break;
                    }
                    else if(A.get(cards) == B.get(cards)){
                        cards += 4;
                    }
                }
            }

        }


        return score;
    }

    public static int findWinner(ArrayList<Integer> deck) {
        War w = new War(deck);
        return w.simulateGame();
    }

    @Override
    public String toString() {
        return
                 this.deck.toString();

    }

    public ArrayList<ArrayList<Integer>>card_delen(ArrayList<Integer> deck) {
        /**
         * Deze mothode deelt de deck door 2 players A en B, maakt list of lists daarin list[0] is A en List[1] is B
         */
        ArrayList<ArrayList<Integer>> players = new ArrayList<ArrayList<Integer>>(); // list of lists
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        for (int ind = 0; ind < deck.size(); ind++) {
            if (ind % 2 == 0){
                A.add(deck.get(ind)); //Even nummer van de index voor A

            } else {
                B.add(deck.get(ind)); // Odd nummer van de index voor B
            }
        }
        players.add(A);
        players.add(B);
        return players;
    }





    public static void main(String[] args) {
        ArrayList<Integer> arl = new ArrayList<Integer>();
        arl.add(1);
        arl.add(22);
        arl.add(-2);

        System.out.println("Arraylist contains: " + arl.toString());


        // print the result
    }
}