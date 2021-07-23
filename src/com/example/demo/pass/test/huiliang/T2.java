package com.example.demo.pass.test.huiliang;

public class T2 {

    static class POINT{
        int x;
        int y;
        public POINT(int x,int y){
            this.x = x;
            this.y = y;
        }
    }


    private static boolean isInTriangle(POINT p, POINT a, POINT b, POINT c) {
        POINT AB, AC, AP;
        AB = new POINT(b.x - a.x, b.y - a.y);
        AC = new POINT(c.x - a.x, c.y - a.y);
        AP = new POINT(p.x - a.x, p.y - a.y);
        float dot00 = dotProduct(AC, AC);
        float dot01 = dotProduct(AC, AB);
        float dot02 = dotProduct(AC, AP);
        float dot11 = dotProduct(AB, AB);
        float dot12 = dotProduct(AB, AP);
        float inverDeno = 1 / (dot00 * dot11 - dot01 * dot01);
        // 计算重心坐标
        float u = (dot11 * dot02 - dot01 * dot12) * inverDeno;
        float v = (dot00 * dot12 - dot01 * dot02) * inverDeno;
        return (u >= 0) && (v >= 0) && (u + v < 1);
    }

    private static float dotProduct(POINT p1, POINT p2) {
        return p1.x * p2.x + p1.y * p2.y;
    }

}
