package exo1;

import java.util.*;

public class Room {
    private List<Card> Allcards = new ArrayList<>();
    //准备54张牌放进去
    {
        //准备点数
        String[] nums = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K","A", "2"};
        //准备花色
        String[] colors = {"♥", "♠", "♣", "♦"};
        //组合点数和花色成为牌对象。加入到集合中去
        for (String num : nums) {
            for (String color : colors) {
                Allcards.add(new Card(num, color));
            }
        }
//        Allcards.add(new Card("JOKER", "🤡"));
//        Allcards.add(new Card("JOKER", "👲"));
        Collections.addAll(Allcards, new Card("JOKER", "🤡"), new Card("JOKER", "👲"));
        System.out.println("新牌是："+ Allcards);
    }

    public void start() {
        Collections.shuffle(Allcards);
        System.out.println("洗牌后："+ Allcards);

        Map<String, List<Card>> playsers = new HashMap<>();
        List< Card> A =new ArrayList<>();
        playsers.put("白开水男孩", A);
        List< Card> B =new ArrayList<>();
        playsers.put("joker", B);
        List< Card> C =new ArrayList<>();
        playsers.put("啥啥都不会", C);
        for (int i = 0; i < Allcards.size()-3; i++) {
            Card card = Allcards.get(i);
            if (i % 3 == 0) {
                A.add(card);
            } else if (i % 3 == 1) {
                B.add(card);
            } else {
                C.add(card);
            }
        }

        Map<String, Integer> sizeOrder = new HashMap<>();
        String[] sizes = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "JOKER"};
        for (int i = 0; i < sizes.length; i++) {
            sizeOrder.put(sizes[i], i);
        }

        for (Map.Entry<String, List<Card>> entry : playsers.entrySet()) {
            List<Card> cards = entry.getValue();
            Collections.sort(cards, new Comparator<Card>() {
                @Override
                public int compare(Card o1, Card o2) {
                    int order1 = sizeOrder.getOrDefault(o1.getSize(), -1);
                    int order2 = sizeOrder.getOrDefault(o2.getSize(), -1);
                    return order2 - order1;
                }
            });
        }

        List<Card> last = Allcards.subList(Allcards.size()-3, Allcards.size());
        System.out.println("底牌是"+ last);
        C.addAll(last);
        for (Map.Entry<String, List<Card>> entry : playsers.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }
}
