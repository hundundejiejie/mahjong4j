package org.mahjong4j.mahjong;

public class BakazeResolver implements MahjongResolver {
    final int HAN = MahjongYakuList.BAKAZE.getHan();

    MahjongTile bakaze;

    public BakazeResolver(MahjongTile bakaze) {
        this.bakaze = bakaze;
    }

    public int howHan() {
        return HAN;
    }

    public boolean isBakaze(MahjongTile[] kotsu) {
        for (int i = 0; i < kotsu.length && kotsu[i] != null; i++) {
            if (kotsu[i] == bakaze) {
                return true;
            }
        }
        return false;
    }
}