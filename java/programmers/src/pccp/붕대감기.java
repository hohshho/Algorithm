package pccp;

public class 붕대감기 {
    class Solution {
        public int solution(int[] bandage, int health, int[][] attacks) {
            int answer = 0;
            int curTime = 0;
            int t = bandage[0];
            int x = bandage[1];
            int y = bandage[2];
            int curHealth = health;

            for(int[] attack : attacks){
                int attackTime = attack[0];
                int damage = attack[1];
                // 1. attack time기준 할 수 있는 붕대 모두 감고 attackTime으로 curTime갱신
                if(curTime + 1 < attackTime) {
                    int cnt = attackTime - curTime - 1;
                    curHealth += x * cnt;
                    if(cnt >= t) curHealth += y * (cnt / t);
                    if(curHealth > health) curHealth = health;
                }
                curTime = attackTime;

                // 2. attack
                curHealth -= damage;

                if(curHealth <= 0) break;
            }

            return curHealth <= 0 ? -1 : curHealth;
        }
    }
}
