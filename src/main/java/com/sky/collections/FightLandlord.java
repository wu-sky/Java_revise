package com.sky.collections;

import sun.security.util.Length;

import java.util.Random;

/**
 * @author：吴世凯 邮箱：
 * 日期：5/14/2020
 * 斗地主v1.0 实现基础的发牌功能
 * 斗地主v2.0 实现玩家到手的牌已经排好序
 * 斗地主v3.0 实现 gui
 * 斗地主v4.0 实现规则系统
 * 斗地主v5.0 实现玩家对战
 * 斗地主v6.0 实现ai
 * 斗地主v7.0 实现 VIP 和欢乐豆系统
 * 斗地主v8.0 实现 玩家大厅和一键加入系统
 */
public class FightLandlord {

    //1.定义花色数组
    static String[] colors = { "♦" , "♥", "♣", "♠" };
    //2.定义牌面数组
    static String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    //3.定义王
    static String[] kings = {"大🃏", "小🃏"};

    //定义玩家1
    static String[] player_sky_poker=  new String[20];
    static String[] player_land_poker= new String[20];
    static String[] player_sea_poker=  new String[20];


    static String[] pokerPool=new String[54];

    static {

        int index =(colors.length*numbers.length);

        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < numbers.length; j++) {

                pokerPool[--index]=colors[i]+numbers[j];
            }

        }
        pokerPool[pokerPool.length-2]=kings[0];
        pokerPool[pokerPool.length-1]=kings[1];

        for (int i = 0; i < pokerPool.length; i++) {
            System.out.println("pokerPool["+i+"+] = " + pokerPool[i]);
        }



    }


    public static void shuffle(){
        System.out.println("wash the card ");

        int times=pokerPool.length;
        //随机交换位置
        Random random1=new Random();
        Random random2=new Random();
        String temp="";
        for (int i = 0; i <times; i++) {
            //随机数范围
            int index1 = random1.nextInt(pokerPool.length - 1);
            int index2 = random2.nextInt(pokerPool.length - 1);

            temp=pokerPool[index2];

            pokerPool[index2]=pokerPool[index1];

            pokerPool[index1]=temp;

        }
        for (int i = 0; i < pokerPool.length; i++) {
            System.out.println("pokerPool["+i+"] = " + pokerPool[i]);
        }

    }


    public static void sendCard(){

        String [] [] players={player_land_poker, player_sea_poker ,player_sky_poker };

        Random random = new Random();

        for (int i = 0; i < 54; i++) {
            if (i<17){
                player_sky_poker[i]=pokerPool[i];
            }else if(17<=i&&i<34){
                player_land_poker[i-17]=pokerPool[i];

            }else if(34<=i&&i<51){

                player_sea_poker[i-17-17]=pokerPool[i];
            }


        }

        int luckyIndex = random.nextInt(3);
        for (int i = 2; i >=0; i--) {
           players[luckyIndex][players[luckyIndex].length-i-1]=pokerPool[pokerPool.length-i-1];
        }



        System.out.println("--------------player_sky_poker----------------");
        for (int i = 0; i < player_sky_poker.length; i++) {
            System.out.print(  player_sky_poker[i]+ "  ");
        }
        System.out.println("\n"+"--------------player_land_poker----------------");
        for (int i = 0; i < player_land_poker.length; i++) {
            System.out.print(  player_land_poker[i]+ "  ");
        }
        System.out.println("\n"+"--------------player_sea_poker----------------");
        for (int i = 0; i < player_sea_poker.length; i++) {
            System.out.print(  player_sea_poker[i]+ "  ");
        }





    }

    public static void main(String[] args) {
        shuffle();
        sendCard();
      /*    Random random=new Random();
      for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(54));


        }*/

    }









}
