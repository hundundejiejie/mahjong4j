package org.mahjong4j.mahjong;

import java.util.ArrayList;

public class SanshokudohkoResolver implements MahjongResolver {
    final int HAN = MahjongYakuList.SANSHOKUDOKO.getKuisagari();

    boolean manzu;
    boolean pinzu;
    boolean sohzu;

    public static void main(String[] args) {
        SanshokudojunResolver it = new SanshokudojunResolver();

        MahjongTile shu[] = {
                MahjongTile.M2,
                MahjongTile.P2,
                MahjongTile.S2,
                MahjongTile.S3
        };

        if (it.isSanshokudojun(shu)) {
            System.out.println("True!!");
        } else {
            System.out.println("False...");
        }


    }

    public int howHan() {
        return HAN;
    }

    public boolean isSanshokudoko(MahjongTile[] kotsu) {
        //刻子が3つ以上ないと三色はありえない
        if (kotsu[2] == null) {
            return false;
        }

        //初期化
        manzu = false;
        pinzu = false;
        sohzu = false;

        //処理用の変数
        ArrayList<MahjongTile> categoryA = new ArrayList<MahjongTile>(0);
        ArrayList<MahjongTile> categoryB = new ArrayList<MahjongTile>(0);

        categoryA.add(kotsu[0]);

        for (int i = 1; i < kotsu.length && kotsu[i] != null; i++) {
            if (categoryA.get(0).getNumber() == kotsu[i].getNumber()) {
                categoryA.add(kotsu[i]);
            } else if (categoryB.size() == 0) {
                categoryB.add(kotsu[i]);
            } else if (categoryB.get(0).getNumber() == kotsu[i].getNumber()) {
                categoryB.add(kotsu[i]);
            } else {
                return false;
            }
        }


        if (categoryA.size() >= 3) {
            for (int k = 0; k < categoryA.size(); k++) {
                switch (categoryA.get(k).getType()) {
                    case MANZU:
                        manzu = true;
                        break;
                    case PINZU:
                        pinzu = true;
                        break;
                    case SOHZU:
                        sohzu = true;
                        break;

                    default:
                        break;
                }
            }
        } else if (categoryB.size() >= 3) {
            for (int k = 0; k < categoryB.size(); k++) {
                switch (categoryB.get(k).getType()) {
                    case MANZU:
                        manzu = true;
                        break;
                    case PINZU:
                        pinzu = true;
                        break;
                    case SOHZU:
                        sohzu = true;
                        break;

                    default:
                        break;
                }
            }

        }

        return manzu && pinzu && sohzu;
    }

}