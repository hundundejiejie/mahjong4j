package org.mahjong4j.nosituation;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mahjong4j.Player;
import org.mahjong4j.Score;
import org.mahjong4j.hands.MahjongHands;
import org.mahjong4j.tile.MahjongTile;
import org.mahjong4j.yaku.normals.MahjongYakuEnum;
import org.mahjong4j.yaku.yakuman.MahjongYakumanEnum;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;
import static org.mahjong4j.tile.MahjongTile.M4;
import static org.mahjong4j.yaku.normals.MahjongYakuEnum.*;

/**
 * @author yu1ro
 */
public class PinfuTanyaoIpeikoTest {
    MahjongHands hands;
    Player player;

    @Before
    public void setUp() throws Exception {
        int[] tiles = {
            0, 2, 2, 2, 0, 0, 0, 0, 0,
            0, 0, 2, 0, 1, 1, 1, 0, 0,
            0, 0, 1, 1, 1, 0, 0, 0, 0,
            0, 0, 0, 0,
            0, 0, 0
        };
        MahjongTile last = M4;
        hands = new MahjongHands(tiles, last);
        player = new Player(hands);
        player.calculate();
    }

    @Test
    public void testGetYakumanList() throws Exception {
        List<MahjongYakumanEnum> actual = player.getYakumanList();

        assertEquals(0, actual.size());
    }

    @Test
    public void testGetNormalYakuListSize() throws Exception {
        List<MahjongYakuEnum> actual = player.getNormalYakuList();

        assertEquals(3, actual.size());
    }

    @Test
    public void testGetNormalYakuListItem() throws Exception {
        List<MahjongYakuEnum> actual = player.getNormalYakuList();

        assertThat(actual, hasItems(PINFU, TANYAO, IPEIKO));
    }

    @Test
    public void testGetFu() throws Exception {
        assertEquals(20, player.getFu());
    }

    @Test
    public void testGetScore() throws Exception {
        TestCase.assertEquals(Score.SCORE0, player.getScore());
    }
}