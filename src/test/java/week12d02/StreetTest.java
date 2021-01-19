package week12d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreetTest {

    @Test
    public void lastSoldSite() {
        Street s = new Street();
        s.sellSite(new Site(0, 10, Fence.PERFECT));
        s.sellSite(new Site(0, 7, Fence.NEED_UPGRADE));
        s.sellSite(new Site(1, 12, Fence.NEED_UPGRADE));
        s.sellSite(new Site(0, 9, Fence.PERFECT));
        s.sellSite(new Site(0, 11, Fence.NO_FENCE));
        s.sellSite(new Site(1, 13, Fence.PERFECT));
        assertEquals(3, s.lastSoldSite());
    }

    @Test
    public void lastPlusOneSoldSite() {
        Street s = new Street();
        s.sellSite(new Site(0, 10, Fence.PERFECT));
        s.sellSite(new Site(0, 7, Fence.NEED_UPGRADE));
        s.sellSite(new Site(1, 12, Fence.NEED_UPGRADE));
        s.sellSite(new Site(0, 9, Fence.PERFECT));
        s.sellSite(new Site(0, 11, Fence.NO_FENCE));
        s.sellSite(new Site(1, 13, Fence.PERFECT));
        s.sellSite(new Site(0, 15, Fence.PERFECT));
        assertEquals(10, s.lastSoldSite());
        System.out.println(s.statOfFences().toString());
    }

    @Test
    public void StatOfSoldSite() {
        Street s = new Street();
        s.sellSite(new Site(0, 10, Fence.PERFECT));
        s.sellSite(new Site(0, 7, Fence.NEED_UPGRADE));
        s.sellSite(new Site(1, 12, Fence.NEED_UPGRADE));
        s.sellSite(new Site(0, 9, Fence.PERFECT));
        s.sellSite(new Site(0, 11, Fence.NO_FENCE));
        s.sellSite(new Site(1, 13, Fence.PERFECT));
        s.sellSite(new Site(0, 15, Fence.PERFECT));
        assertEquals(3, s.statOfFences().size());
        assertEquals("[PERFECT: 4 db, NEED_UPGRADE: 2 db, NO_FENCE: 1 db]", s.statOfFences().toString());
    }

    @Test
    public void StatOfSoldSite2() {
        Street s = new Street();
        s.sellSite(new Site(0, 10, Fence.PERFECT));
        s.sellSite(new Site(0, 7, Fence.NEED_UPGRADE));
        s.sellSite(new Site(1, 12, Fence.NEED_UPGRADE));
        s.sellSite(new Site(0, 9, Fence.PERFECT));
        s.sellSite(new Site(0, 11, Fence.NO_FENCE));
        s.sellSite(new Site(1, 13, Fence.PERFECT));
        s.sellSite(new Site(0, 15, Fence.PERFECT));
        assertEquals(3, s.statOfFences2().size());
        assertEquals("[PERFECT: 4 db, NEED_UPGRADE: 2 db, NO_FENCE: 1 db]", s.statOfFences2().toString());
    }
}